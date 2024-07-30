package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SecondaryLoop;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Componente;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;

import javax.swing.BoxLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JSpinner;
import javax.swing.JLabel;

public class ListComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JTextField idtxt;
	private JButton cancelbtn;
	private static JButton deleteBtn;
	private static JButton requestBtn;
	private static JButton BuyBtn;
	private JComboBox filtercmb;
	private JButton searchBtn;
	private static Object row[];
	private static DefaultTableModel model;
	private String cod = "";

	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComponentes dialog = new ListComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComponentes() {
		setTitle("Listado de Componentes");
		setBounds(100, 100, 1349, 751);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBounds(0, 0, 1116, 685);
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
						requestBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						BuyBtn.setEnabled(true);
					}
				}
			});
			table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			String headers[] = {"Id", "Marca", "Modelo", "Precio", "Cant. Disponible", "Descuento", "Tipo"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(SecondaryC);
			panel_1.setBounds(1118, 0, 199, 685);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			cancelbtn = new JButton("Cancelar");
			cancelbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cancelbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					cancelbtn.setForeground(hoverEffectColor);
					cancelbtn.setOpaque(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cancelbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					cancelbtn.setForeground(SecondaryC);
					cancelbtn.setOpaque(true);
				}
			});
			cancelbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			cancelbtn.setForeground(SecondaryC);
			cancelbtn.setBackground(new Color(248, 248, 248));
			cancelbtn.setOpaque(true);
			cancelbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			cancelbtn.setBounds(42, 640, 115, 29);
			panel_1.add(cancelbtn);
			
			deleteBtn = new JButton("Eliminar");
			deleteBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					deleteBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					deleteBtn.setForeground(hoverEffectColor);
					deleteBtn.setOpaque(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					deleteBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					deleteBtn.setForeground(SecondaryC);
					deleteBtn.setOpaque(true);
				}
			});
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cod != null) {
						int option = JOptionPane.showConfirmDialog(null, "Esta segura de eliminar el componente seleccinado?");
						if(option == JOptionPane.YES_OPTION) {
							Tienda.getInstance().deleteComponente(cod);
							loadComponente(null);
							JOptionPane.showMessageDialog(null, "Eliminación realizada correctamente", "Eliminación", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			deleteBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			deleteBtn.setForeground(SecondaryC);
			deleteBtn.setBackground(new Color(248, 248, 248));
			deleteBtn.setOpaque(true);
			deleteBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			deleteBtn.setBounds(42, 594, 115, 29);
			panel_1.add(deleteBtn);
			
			requestBtn = new JButton("Pedir");
			requestBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					requestBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					requestBtn.setForeground(hoverEffectColor);
					requestBtn.setOpaque(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					requestBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					requestBtn.setForeground(SecondaryC);
					requestBtn.setOpaque(true);
				}
			});
			requestBtn.setEnabled(false);
			requestBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cod != null) {
						Componente componente = Tienda.getInstance().searchComponenteById(cod);
						if(componente != null) {
							PopUpCant aux = new PopUpCant(componente);
							aux.setModal(true);
							aux.setVisible(true);
						}
					}
				}
			});
			requestBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			requestBtn.setForeground(SecondaryC);
			requestBtn.setBackground(new Color(248, 248, 248));
			requestBtn.setOpaque(true);
			requestBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			requestBtn.setBounds(42, 193, 115, 29);
			panel_1.add(requestBtn);
			
			idtxt = new JTextField();
			idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			idtxt.setBounds(15, 16, 169, 29);
			panel_1.add(idtxt);
			idtxt.setColumns(10);
			
			searchBtn = new JButton("Buscar");
			searchBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					searchBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					searchBtn.setForeground(hoverEffectColor);
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
						loadComponente(id);
					}
				}
			});
			searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			searchBtn.setForeground(SecondaryC);
			searchBtn.setBackground(new Color(248, 248, 248));
			searchBtn.setOpaque(true);
			searchBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			searchBtn.setBounds(42, 58, 115, 29);
			panel_1.add(searchBtn);
			
			filtercmb = new JComboBox();
			filtercmb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tipo = new String(filtercmb.getSelectedItem().toString());
					loadFilter(tipo);
				}
			});
			filtercmb.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			filtercmb.setForeground(SecondaryC);
			filtercmb.setFont(new Font("Century Gothic", Font.BOLD, 18));
			filtercmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Disco Duro", "GPU", "MicroProcesador", "RAM", "Tarjeta Madre"}));
			filtercmb.setBounds(15, 103, 169, 29);
			panel_1.add(filtercmb);
			
			BuyBtn = new JButton("Comprar");
			BuyBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BuyBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					BuyBtn.setForeground(hoverEffectColor);
					BuyBtn.setOpaque(true);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					BuyBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					BuyBtn.setForeground(SecondaryC);
					BuyBtn.setOpaque(true);
				}
			});
			BuyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cod != null) {
						Componente comp = Tienda.getInstance().searchComponenteById(cod);
						if(comp != null) {
							ComprarComponente comprar = new ComprarComponente(comp, null);
							comprar.setModal(true);
							comprar.setVisible(true);
						}
					}
				}
			});
			BuyBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			BuyBtn.setForeground(SecondaryC);
			BuyBtn.setBackground(new Color(248, 248, 248));
			BuyBtn.setOpaque(true);
			BuyBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			BuyBtn.setBounds(42, 148, 115, 29);
			panel_1.add(BuyBtn);
		}
		loadComponente(null);
	}
	
	public static void loadComponente(String id) {
		if(id == null) {
			ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
			model.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for(Componente comp : aux) {
				row[0] = comp.getId();
				row[1] = comp.getMarca();
				row[2] = comp.getModelo();
				row[3] = comp.getPrecio();
				row[4] = comp.getCantDisponible();
				row[5] = comp.getDescuento() + "%";
				
				String tipo = "";
				if(comp instanceof DiscoDuro) {
					tipo = "Disco Duro";
				} else if(comp instanceof GPU) {
					tipo = "GPU";
				} else if(comp instanceof MicroProcesador) {
					tipo = "MicroProcesador";
				} else if(comp instanceof Ram) {
					tipo = "RAM";
				} else {
					tipo = "Tarjeta Madre";
				}
				
				row[6] = tipo;
				
				model.addRow(row);
			}
		}
		else {
			Componente componente = Tienda.getInstance().searchComponenteById(id);
			if(componente != null) {
				row[0] = componente.getId();
				row[1] = componente.getMarca();
				row[2] = componente.getModelo();
				row[3] = componente.getPrecio();
				row[4] = componente.getCantDisponible();
				row[5] = componente.getDescuento() + "%";
				
				String tipo = "";
				if(componente instanceof DiscoDuro) {
					tipo = "Disco Duro";
				} else if(componente instanceof GPU) {
					tipo = "GPU";
				} else if(componente instanceof MicroProcesador) {
					tipo = "MicroProcesador";
				} else if(componente instanceof Ram) {
					tipo = "RAM";
				} else {
					tipo = "Tarjeta Madre";
				}
				
				row[6] = tipo;
			}
			else {
				JOptionPane.showMessageDialog(null, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		deleteBtn.setEnabled(false);
		BuyBtn.setEnabled(false);
	}
	
	public static void loadFilter(String tipo) {
		ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		boolean valido = false;
		
		if(!(tipo.equalsIgnoreCase("<Seleccione>"))) {
				for(Componente comp : aux) {
					valido = false;
					
					if(tipo.equalsIgnoreCase("Disco Duro") && comp instanceof DiscoDuro) {
					    valido = true;
					} else if(tipo.equalsIgnoreCase("GPU") && comp instanceof GPU) {
					    valido = true;
					} else if(tipo.equalsIgnoreCase("MicroProcesador") && comp instanceof MicroProcesador) {
					    valido = true;
					} else if(tipo.equalsIgnoreCase("RAM") && comp instanceof Ram) {
					    valido = true;
					} else if(tipo.equalsIgnoreCase("Tarjeta Madre") && comp instanceof TarjetaMadre) {
					    valido = true;
					}
					
				
				if(valido) {
					row[0] = comp.getId();
					row[1] = comp.getMarca();
					row[2] = comp.getModelo();
					row[3] = comp.getPrecio();
					row[4] = comp.getCantDisponible();
					row[5] = comp.getDescuento() + "%";
					row[6] = tipo;
				
					model.addRow(row);
				}
			}
		}
		else {
			loadComponente(null);
		}
			
			deleteBtn.setEnabled(false);
			requestBtn.setEnabled(false);
			BuyBtn.setEnabled(false);
	}
}
