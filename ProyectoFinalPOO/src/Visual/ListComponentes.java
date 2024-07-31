package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.SecondaryLoop;

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
import Logica.JRadioButtonTableModel;
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
import java.util.List;
import java.util.stream.Collectors;

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
	private static JRadioButtonTableModel model;
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
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 1331, 704);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new EmptyBorder(0,0,0,0));
			scrollPane.setBounds(0, 0, 1116, 685);
			panel.add(scrollPane);
			
			
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
			String headers[] = {" ", "Id", "Marca", "Modelo", "Precio", "Cant. Disponible", "Descuento", "Tipo"};
			model = new JRadioButtonTableModel(headers, 0);
			model.setColumnIdentifiers(headers);
			//JRadioButtonTableModel model = new JRadioButtonTableModel(headers, 0);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			table.getTableHeader().setPreferredSize(new Dimension(10, 40));
			table.getTableHeader().setBackground(PrimaryC);
			table.getTableHeader().setForeground(Color.white);
			
			table.getColumnModel().getColumn(0).setPreferredWidth(5);
			table.getColumnModel().getColumn(1).setPreferredWidth(25);
			table.getColumnModel().getColumn(2).setPreferredWidth(75); 
			table.getColumnModel().getColumn(3).setPreferredWidth(75); 
			table.getColumnModel().getColumn(4).setPreferredWidth(130);
			table.getColumnModel().getColumn(5).setPreferredWidth(130); 
			table.getColumnModel().getColumn(7).setPreferredWidth(130);

			
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
			
			deleteBtn = new JButton("Eliminar");
			deleteBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					deleteBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
					deleteBtn.setForeground(HoverEffectColor);
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
						int option = JOptionPane.showConfirmDialog(null, "Esta seguro\\a de eliminar el componente seleccinado?");
						if(option == JOptionPane.YES_OPTION) {
							Tienda.getInstance().deleteComponente(cod);
							loadComponente(null);
							JOptionPane.showMessageDialog(null, "Se elimino el componente exitosamente!", "Eliminar", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			deleteBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			deleteBtn.setForeground(SecondaryC);
			deleteBtn.setBackground(ThirdC);
			deleteBtn.setOpaque(true);
			deleteBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			deleteBtn.setBounds(11, 598, 190, 40);
			panel_1.add(deleteBtn);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(PrimaryC);
			panel_2.setBounds(0, 0, 213, 287);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			requestBtn = new JButton("Pedir");
			requestBtn.setBounds(22, 225, 169, 40);
			panel_2.add(requestBtn);
			requestBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					requestBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
					requestBtn.setForeground(HoverEffectColor);
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
							PopUpCant aux = new PopUpCant(componente, null);
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
			
			BuyBtn = new JButton("Comprar");
			BuyBtn.setBounds(22, 172, 169, 40);
			panel_2.add(BuyBtn);
			BuyBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					BuyBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
					BuyBtn.setForeground(HoverEffectColor);
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
					
					ArrayList<Componente> selectedComponents = getSelectedComponents();

			        if (selectedComponents.size() > 1) {
			            ComprarComponentes comprarComponentes = new ComprarComponentes(selectedComponents);
			            comprarComponentes.setModal(true);
			            comprarComponentes.setVisible(true);
			        } else if (selectedComponents.size() == 1) {
			            Componente componente = selectedComponents.get(0);
			            String cod = componente.getId();

			            if (cod != null) {
			                Componente comp = Tienda.getInstance().searchComponenteById(cod);
			                Componente compCompare = Tienda.getInstance().getMisComponentes().get(1);
			                if (comp != null) {
			                    ComprarComponente comprar = new ComprarComponente(comp, compCompare);
			                    comprar.setModal(true);
			                    comprar.setVisible(true);
			                }
			            }
			        } else {
			            JOptionPane.showMessageDialog(null, "Por favor seleccione al menos un componente.", "Error", JOptionPane.ERROR_MESSAGE);
			        }
				}
			});
			BuyBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			BuyBtn.setForeground(SecondaryC);
			BuyBtn.setBackground(new Color(248, 248, 248));
			BuyBtn.setOpaque(true);
			BuyBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			filtercmb = new JComboBox();
			filtercmb.setBounds(11, 119, 190, 40);
			panel_2.add(filtercmb);
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
			
			searchBtn = new JButton("Buscar");
			searchBtn.setBounds(22, 66, 169, 40);
			panel_2.add(searchBtn);
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
						loadComponente(id);
					}
				}
			});
			searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			searchBtn.setForeground(SecondaryC);
			searchBtn.setBackground(new Color(248, 248, 248));
			searchBtn.setOpaque(true);
			searchBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			idtxt = new JTextField();
			idtxt.setBorder(new CompoundBorder( new RoundedBorder(PrimaryC, 1, 15), new EmptyBorder(0, 10, 0, 10) ));
			idtxt.setBounds(22, 13, 169, 40);
			panel_2.add(idtxt);
			idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			idtxt.setColumns(10);
		}
		loadComponente(null);
	}
	
	private static ArrayList<Componente> getSelectedComponents() {
	    ArrayList<Componente> selectedComponents = new ArrayList<>();
	    ArrayList<Componente> allComponents = Tienda.getInstance().getMisComponentes();
	    
	    for (int i = 0; i < model.getRowCount(); i++) {
	        Boolean isSelected = (Boolean) model.getValueAt(i, 0);
	        if (isSelected) {
	            String id = (String) model.getValueAt(i, 1);
	            for (Componente comp : allComponents) {
	            	
	                if (comp.getId().equals(id)) {
	                    selectedComponents.add(comp);
	                    break;
	                }
	            }
	        }
	    }
	    return selectedComponents;
	}

	
	public static void loadComponente(String id) {
	    if (id == null) {
	        ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
	        model.setRowCount(0);
	        row = new Object[table.getColumnCount()];
	        for (Componente comp : aux) {
	            row[0] = false; // Default unselected
	            row[1] = comp.getId();
	            row[2] = comp.getMarca();
	            row[3] = comp.getModelo();
	            row[4] = comp.getPrecio();
	            row[5] = comp.getCantDisponible();
	            row[6] = comp.getDescuento() + "%";

	            String tipo = "";
	            if (comp instanceof DiscoDuro) {
	                tipo = "Disco Duro";
	            } else if (comp instanceof GPU) {
	                tipo = "GPU";
	            } else if (comp instanceof MicroProcesador) {
	                tipo = "MicroProcesador";
	            } else if (comp instanceof Ram) {
	                tipo = "RAM";
	            } else {
	                tipo = "Tarjeta Madre";
	            }

	            row[7] = tipo;

	            model.addRow(row);
	        }
	    } else {
	        Componente componente = Tienda.getInstance().searchComponenteById(id);
	        if (componente != null) {
	            row[0] = false; // Default unselected
	            row[1] = componente.getId();
	            row[2] = componente.getMarca();
	            row[3] = componente.getModelo();
	            row[4] = componente.getPrecio();
	            row[5] = componente.getCantDisponible();
	            row[6] = componente.getDescuento() + "%";

	            String tipo = "";
	            if (componente instanceof DiscoDuro) {
	                tipo = "Disco Duro";
	            } else if (componente instanceof GPU) {
	                tipo = "GPU";
	            } else if (componente instanceof MicroProcesador) {
	                tipo = "MicroProcesador";
	            } else if (componente instanceof Ram) {
	                tipo = "RAM";
	            } else {
	                tipo = "Tarjeta Madre";
	            }

	            row[7] = tipo;
	            model.addRow(row);
	        } else {
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

	    if (!tipo.equalsIgnoreCase("<Seleccione>")) {
	        for (Componente comp : aux) {
	            valido = false;

	            if (tipo.equalsIgnoreCase("Disco Duro") && comp instanceof DiscoDuro) {
	                valido = true;
	            } else if (tipo.equalsIgnoreCase("GPU") && comp instanceof GPU) {
	                valido = true;
	            } else if (tipo.equalsIgnoreCase("MicroProcesador") && comp instanceof MicroProcesador) {
	                valido = true;
	            } else if (tipo.equalsIgnoreCase("RAM") && comp instanceof Ram) {
	                valido = true;
	            } else if (tipo.equalsIgnoreCase("Tarjeta Madre") && comp instanceof TarjetaMadre) {
	                valido = true;
	            }

	            if (valido) {
	                row[0] = false; // Default unselected
	                row[1] = comp.getId();
	                row[2] = comp.getMarca();
	                row[3] = comp.getModelo();
	                row[4] = comp.getPrecio();
	                row[5] = comp.getCantDisponible();
	                row[6] = comp.getDescuento() + "%";
	                row[7] = tipo;

	                model.addRow(row);
	            }
	        }
	    } else {
	        loadComponente(null);
	    }

	    deleteBtn.setEnabled(false);
	    requestBtn.setEnabled(false);
	    BuyBtn.setEnabled(false);
	}

}
