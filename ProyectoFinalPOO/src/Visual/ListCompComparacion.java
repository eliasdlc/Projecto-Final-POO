package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.Componente;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTextField;

public class ListCompComparacion extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private Object row[];
	private DefaultTableModel model;
	private String cod = "";

	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color ThirdC = new Color(247, 251, 255);
	private static final Color AccentColor = new Color(247, 109, 71); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 136, 73);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(42, 145, 230);
	private static final Color ButtonBorderColor = new Color(42, 145, 230);
	private static final Color HoverEffectColor = new Color(3, 109, 195);
	private JTextField idtxt;
	private JButton searchBtn;
	private JButton cancelbtn;
	private JButton decideBtn;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCompComparacion dialog = new ListCompComparacion(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCompComparacion(Componente componente1) {
		setBounds(100, 100, 1349, 751);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 0, 1116, 685);
				panel.add(scrollPane);
				{
					model = new DefaultTableModel();
					table = new JTable();
					table.setDefaultEditor(Object.class, null);
					table.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseClicked(MouseEvent e) {
							int ind = table.getSelectedRow();
							if(ind >= 0) {
								cod = table.getValueAt(ind, 0).toString();
								decideBtn.setEnabled(true);
							}
						}
					});
					table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
					table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					String headers[] = {"Id", "Marca", "Modelo", "Precio", "Cant. Disponible", "Descuento", "Tipo"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					scrollPane.setViewportView(table);
					
					table.getTableHeader().setPreferredSize(new Dimension(10, 40));
					table.getTableHeader().setBackground(PrimaryC);
					table.getTableHeader().setForeground(Color.white);
					
					table.getColumnModel().getColumn(0).setPreferredWidth(25);
					table.getColumnModel().getColumn(1).setPreferredWidth(75);
					table.getColumnModel().getColumn(2).setPreferredWidth(75); 
					
					

					
					table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
					table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
					table.setRowHeight(30);
					table.setBorder(new RoundedBorder(Color.white, 1, 20));
					
					table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
					    @Override
					    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
					        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
					        if (!isSelected) {
					            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
					            table.setGridColor(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
					        }
					        return c;
					    }
					});
					
					scrollPane.setViewportView(table);
				}
			}
			{
				JPanel panel_1 = new JPanel();
				panel_1.setBackground(PrimaryC);
				panel_1.setBounds(1118, 0, 213, 704);
				panel.add(panel_1);
				panel_1.setLayout(null);
				{
					idtxt = new JTextField();
					idtxt.setBorder(new CompoundBorder( new RoundedBorder(PrimaryC, 1, 15), new EmptyBorder(0, 10, 0, 10) ));
					idtxt.setBounds(22, 13, 169, 40);
					panel_1.add(idtxt);
					idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
					idtxt.setColumns(10);
				}
				{
					searchBtn = new JButton("Buscar");
					searchBtn.setBounds(22, 66, 169, 40);
					panel_1.add(searchBtn);
					searchBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							searchBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
							searchBtn.setForeground(HoverEffectColor);
							searchBtn.setOpaque(true);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
							searchBtn.setForeground(SecondaryC);
							searchBtn.setOpaque(true);
						}
					});
					searchBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(idtxt.getText().equalsIgnoreCase("")) {
								JOptionPane.showMessageDialog(null, "Error, Campo de Texto se encuentra vacio", "Error", JOptionPane.ERROR_MESSAGE);
							}
							else {
								String id = idtxt.getText();
								loadComponente(id, componente1);
							}
						}
					});
					searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					searchBtn.setForeground(SecondaryC);
					searchBtn.setBackground(new Color(248, 248, 248));
					searchBtn.setOpaque(true);
					searchBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				}
				{
					decideBtn = new JButton("Elegir");
					decideBtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							decideBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
							decideBtn.setForeground(HoverEffectColor);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							decideBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
							decideBtn.setForeground(SecondaryC);

						}
					});
					decideBtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							if(cod != null) {
								Componente componente2 = Tienda.getInstance().searchComponenteById(cod);
								ComprarComponente comprar = new ComprarComponente(componente1, componente2);
								comprar.setModal(true);
								comprar.setVisible(true);
								dispose();
							}
						}
					});
					decideBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					decideBtn.setForeground(SecondaryC);
					decideBtn.setBackground(new Color(248, 248, 248));
					decideBtn.setOpaque(true);
					decideBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
					decideBtn.setBounds(37, 549, 190, 40);
					panel_1.add(decideBtn);
				}
				{
					cancelbtn = new JButton("Cancelar");
					cancelbtn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							cancelbtn.setBackground(HoverEffectColor);
							cancelbtn.setOpaque(true);
						}
						@Override
						public void mouseExited(MouseEvent e) {
							cancelbtn.setBorder(new RoundedBorder(ThirdC, 1, 20));
							cancelbtn.setForeground(ThirdC);
							cancelbtn.setOpaque(false);
						}
					});
					cancelbtn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent e) {
							dispose();
						}
					});
					cancelbtn.setBorder(new RoundedBorder(ThirdC, 1, 20));
					cancelbtn.setForeground(ThirdC);
					cancelbtn.setBackground(ThirdC);
					cancelbtn.setOpaque(false);
					cancelbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
					cancelbtn.setBounds(11, 651, 190, 40);
					panel_1.add(cancelbtn);
				}
			}
		}
		loadComponente(null, componente1);
	}

	public void loadComponente(String id, Componente comp) {
		boolean valido = false;
		String tipo = "";
		if(id == null) {
			ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
			valido = false;
			model.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for(Componente comp1 : aux) {
				if(comp1 instanceof DiscoDuro && comp instanceof DiscoDuro) {
					valido = true;
					tipo = "Disco Duro";
				}
				else if(comp1 instanceof GPU && comp instanceof GPU) {
					valido = true;
					tipo = "GPU";
				}
				else if(comp1 instanceof MicroProcesador && comp instanceof MicroProcesador) {
					valido = true;
					tipo = "Microprocesador";
				}
				else if(comp1 instanceof Ram && comp instanceof Ram) {
					valido = true;
					tipo = "RAM";
				}
				else if(comp1 instanceof TarjetaMadre && comp instanceof TarjetaMadre) {
					valido = true;
					tipo = "Tarjeta Madre";
				}
				
				if(valido) {
					row[0] = comp1.getId();
					row[1] = comp1.getMarca();
					row[2] = comp1.getModelo();
					row[3] = comp1.getPrecio();
					row[4] = comp1.getCantDisponible();
					row[5] = comp1.getDescuento() + "%";
					row[6] = tipo;
					
					model.addRow(row);
				}
			}
		}
		else {
			Componente comp1 = Tienda.getInstance().searchComponenteById(id);
			if(comp1 != null) {
				if(comp1 instanceof DiscoDuro && comp instanceof DiscoDuro) {
					valido = true;
					tipo = "Disco Duro";
				}
				else if(comp1 instanceof GPU && comp instanceof GPU) {
					valido = true;
					tipo = "GPU";
				}
				else if(comp1 instanceof MicroProcesador && comp instanceof MicroProcesador) {
					valido = true;
					tipo = "Microprocesador";
				}
				else if(comp1 instanceof Ram && comp instanceof Ram) {
					valido = true;
					tipo = "RAM";
				}
				else if(comp1 instanceof TarjetaMadre && comp instanceof TarjetaMadre) {
					valido = true;
					tipo = "Tarjeta Madre";
				}
				
				if(valido) {
					row[0] = comp1.getId();
					row[1] = comp1.getMarca();
					row[2] = comp1.getModelo();
					row[3] = comp1.getPrecio();
					row[4] = comp1.getCantDisponible();
					row[5] = comp1.getDescuento() + "%";
					row[6] = tipo;
					
					model.addRow(row);
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		decideBtn.setEnabled(false);
	}
}
