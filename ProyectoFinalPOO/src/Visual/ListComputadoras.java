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

import Logica.Computadora;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListComputadoras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idtxt;
	private JTable table;
	private JButton updatebtn;
	private JButton deletebtn;
	private JButton cancelbtn;
	private JButton buyBtn;
	private JButton searchbtn;
	private String cod = "";
	private static Object row[];
	private static DefaultTableModel model;
	private JComboBox filtercmb;
	private JButton compbtn;

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
	private JPanel panel_2;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComputadoras dialog = new ListComputadoras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComputadoras() {
		setTitle("Listado de Computadoras");
		setBounds(100, 100, 1349, 751);
		setModal(true);
		setLocationRelativeTo(getParent());
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1331, 704);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 1116, 704);
		panel.add(scrollPane);
		
		model = new DefaultTableModel();
		table = new JTable();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ind = table.getSelectedRow();
				if(ind >= 0) {
					cod = table.getValueAt(ind, 0).toString();
					updatebtn.setEnabled(true);
					deletebtn.setEnabled(true);
					buyBtn.setEnabled(true);
					compbtn.setEnabled(true);
				}
			}
		});
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String headers[] = {"Id", "Precio", "Cant. Disponible","Tipo"};
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(PrimaryC);
		panel_1.setBounds(1118, 0, 213, 704);	
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		updatebtn = new JButton("Actualizar");
		updatebtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		updatebtn.setBackground(new Color(248, 248, 248));
		updatebtn.setForeground(SecondaryC);
		updatebtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		updatebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod != null) {
					Computadora pc = Tienda.getInstance().searchComputadoraById(cod);
					if(pc != null) {
						//RegComputadora updateComputadora = new RegComputadora(pc);
						//updatecomputadora.setModal(true);
						//updateComputadora.setVisible(true);
					}
				}
			}
		});
		updatebtn.setBounds(11, 545, 190, 40);
		panel_1.add(updatebtn);
		
		deletebtn = new JButton("Eliminar");
		deletebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deletebtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				deletebtn.setForeground(HoverEffectColor);
				deletebtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				deletebtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				deletebtn.setForeground(SecondaryC);
				deletebtn.setOpaque(true);
			}
		});
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod != null) {
					int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la computadora seleccionada?");
					if(option == JOptionPane.YES_OPTION) {
						Tienda.getInstance().deleteComputadora(cod);
						loadComputadora(null);
						JOptionPane.showMessageDialog(null, "Se elimino la computadora exitosamente!", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
						
					}
				}
			}
		});
		deletebtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		deletebtn.setForeground(SecondaryC);
		deletebtn.setBackground(new Color(248, 248, 248));
		deletebtn.setOpaque(true);
		deletebtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		deletebtn.setBounds(11, 598, 190, 40);
		panel_1.add(deletebtn);
		
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
		cancelbtn.setBackground(new Color(248, 248, 248));
		cancelbtn.setOpaque(false);
		cancelbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		cancelbtn.setBounds(11, 651, 190, 40);
		panel_1.add(cancelbtn);
		
		panel_2 = new JPanel();
		panel_2.setBackground(PrimaryC);
		panel_2.setBounds(0, 0, 213, 274);
		panel_1.add(panel_2);
		panel_2.setLayout(null);
		
		idtxt = new JTextField();
		idtxt.setBorder(new CompoundBorder( new RoundedBorder(PrimaryC, 1, 15), new EmptyBorder(0, 10, 0, 10) ));
		idtxt.setBounds(11, 12, 190, 40);
		panel_2.add(idtxt);
		idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idtxt.setColumns(10);
		
		searchbtn = new JButton("Buscar");
		searchbtn.setBounds(22, 64, 169, 40);
		panel_2.add(searchbtn);
		searchbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchbtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				searchbtn.setForeground(HoverEffectColor);
				searchbtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				searchbtn.setForeground(SecondaryC);
				searchbtn.setOpaque(true);
			}
		});
		searchbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idtxt.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Error, Campo de texto vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
				String id = idtxt.getText();
				loadComputadora(id);
				}
			}
		});
		searchbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		searchbtn.setForeground(SecondaryC);
		searchbtn.setBackground(new Color(248, 248, 248));
		searchbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		searchbtn.setOpaque(true);
		
		filtercmb = new JComboBox();
		filtercmb.setBounds(11, 116, 190, 40);
		panel_2.add(filtercmb);
		filtercmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = filtercmb.getSelectedItem().toString();
				loadFilter(tipo);
			}
		});
		filtercmb.setBackground(new Color(248, 248, 248));
		filtercmb.setForeground(SecondaryC);
		filtercmb.setBorder(new RoundedBorder(PrimaryC, 1, 20));
		filtercmb.setFont(new Font("Century Gothic", Font.BOLD, 18));
		filtercmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Gaming", "Oficina", "Universidad"}));
		
		buyBtn = new JButton("Comprar");
		buyBtn.setBounds(22, 168, 169, 40);
		panel_2.add(buyBtn);
		buyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buyBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				buyBtn.setForeground(HoverEffectColor);
				buyBtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				buyBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				buyBtn.setForeground(SecondaryC);
				buyBtn.setOpaque(true);
			}
		});
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod != null) {
					Computadora pc = Tienda.getInstance().searchComputadoraById(cod);
					if(pc != null) {
						ComprarComputadora comprarPc = new ComprarComputadora(pc);
						comprarPc.setModal(true);
						comprarPc.addWindowListener(new java.awt.event.WindowAdapter() {
			                @Override
			                public void windowClosed(java.awt.event.WindowEvent windowEvent) {
			                    loadComputadora(null);
			                }
			            });
						
						comprarPc.setVisible(true);
					}
				}
			}
		});
		buyBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		buyBtn.setBackground(new Color(248, 248, 248));
		buyBtn.setForeground(SecondaryC);
		buyBtn.setOpaque(true);
		buyBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		compbtn = new JButton("Componentes");
		compbtn.setBounds(22, 220, 169, 40);
		panel_2.add(compbtn);
		compbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				compbtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				compbtn.setForeground(HoverEffectColor);
				compbtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				compbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				compbtn.setForeground(SecondaryC);
				compbtn.setOpaque(true);
			}
		});
		compbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListComponentesPC listComponentes = new ListComponentesPC(cod);
				listComponentes.setModal(true);
				listComponentes.setVisible(true);
			}
		});
		compbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		compbtn.setBackground(new Color(248, 248, 248));
		compbtn.setForeground(SecondaryC);
		compbtn.setOpaque(true);
		compbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		loadComputadora(null);
	}

	public void loadComputadora(String id) {
		if(id == null) {
			ArrayList<Computadora> aux = Tienda.getInstance().getMisComputadoras();
			model.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for(Computadora computadora : aux) {
				row[0] = computadora.getId();
				row[1] = computadora.getPrecio();
				row[2] = computadora.getCantDisponible();
				row[3] = computadora.getTipo();
				
				model.addRow(row);
			}
		}
		else {
			Computadora computadora = Tienda.getInstance().searchComputadoraById(id);
			if(computadora != null) {
				row[0] = computadora.getId();
				row[1] = computadora.getPrecio();
				row[2] = computadora.getCantDisponible();
				row[3] = computadora.getTipo();
			}
			else {
				JOptionPane.showMessageDialog(null, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
		deletebtn.setEnabled(false);
		compbtn.setEnabled(false);
		updatebtn.setEnabled(false);
		buyBtn.setEnabled(false);
	}
	
	public void loadFilter(String tipo) {
		ArrayList<Computadora> aux = Tienda.getInstance().getMisComputadoras();
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		boolean valido = false;
		
		if(!(tipo.equalsIgnoreCase("<Seleccione>"))) {
			for(Computadora computadora : aux) {
				if(computadora.getTipo().equalsIgnoreCase(tipo)) {
					valido = true;
				}
				
				if(valido) {
					row[0] = computadora.getId();
					row[1] = computadora.getPrecio();
					row[2] = computadora.getCantDisponible();
					row[3] = computadora.getTipo();
					
					model.addRow(row);
				}
			}
		}
		else {
			loadComputadora(null);
		}
		
		deletebtn.setEnabled(false);
		compbtn.setEnabled(false);
		updatebtn.setEnabled(false);
		buyBtn.setEnabled(false);
	}
}
