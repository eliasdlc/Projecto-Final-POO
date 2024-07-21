package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

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

public class ListComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static JTable table;
	private JTextField idtxt;
	private JButton cancelbtn;
	private static JButton deleteBtn;
	private static JButton updateBtn;
	private static JButton BuyBtn;
	private JComboBox filtercmb;
	private JButton searchBtn;
	private static Object row[];
	private static DefaultTableModel model;
	private String cod = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComponente dialog = new ListComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComponente() {
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
						updateBtn.setEnabled(true);
						deleteBtn.setEnabled(true);
						BuyBtn.setEnabled(true);
					}
				}
			});
			table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			String headers[] = {"Id", "Marca", "Modelo", "Precio", "Cant. Disponible", "Descuento", "Tipo"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			scrollPane.setViewportView(table);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(1118, 0, 199, 685);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			cancelbtn = new JButton("Cancelar");
			cancelbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelbtn.setBounds(42, 640, 115, 29);
			panel_1.add(cancelbtn);
			
			deleteBtn = new JButton("Eliminar");
			deleteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cod != null) {
						int option = JOptionPane.showConfirmDialog(null, "Esta segura de eliminar el componente seleccinado?");
						if(option == JOptionPane.YES_OPTION) {
							Tienda.getInstance().deleteComponente(cod);
							loadComponente(null);
							JOptionPane.showMessageDialog(null, "Eliminaci�n realizada correctamente", "Eliminaci�n", JOptionPane.INFORMATION_MESSAGE);
						}
					}
				}
			});
			deleteBtn.setBounds(42, 594, 115, 29);
			panel_1.add(deleteBtn);
			
			updateBtn = new JButton("Actualizar");
			updateBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(cod != null) {
						Componente componente = Tienda.getInstance().searchComponenteById(cod);
						if(componente != null) {
							//RegComponentes updateComponentes = new RegComponentes(componente);
							//updateComponentes.setModal(true);
							//updateComponentes.setVisible(true);
						}
					}
				}
			});
			updateBtn.setBounds(42, 549, 115, 29);
			panel_1.add(updateBtn);
			
			idtxt = new JTextField();
			idtxt.setBounds(15, 16, 169, 29);
			panel_1.add(idtxt);
			idtxt.setColumns(10);
			
			searchBtn = new JButton("Buscar");
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
			searchBtn.setBounds(42, 58, 115, 29);
			panel_1.add(searchBtn);
			
			filtercmb = new JComboBox();
			filtercmb.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String tipo = new String(filtercmb.getSelectedItem().toString());
					loadFilter(tipo);
				}
			});
			filtercmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Disco Duro", "GPU", "Micro Procesador", "RAM", "Tarjeta Madre"}));
			filtercmb.setBounds(15, 103, 169, 29);
			panel_1.add(filtercmb);
			
			BuyBtn = new JButton("Comprar");
			BuyBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Logica para comprar
				}
			});
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
					tipo = "Microprocesador";
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
					tipo = "Microprocesador";
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
		updateBtn.setEnabled(false);
		BuyBtn.setEnabled(false);
	}
	
	public static void loadFilter(String tipo) {
		ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
		model.setRowCount(0);
		row = new Object[table.getColumnCount()];
		boolean valido = true;
		
		for(Componente comp : aux) {
			if(tipo.equalsIgnoreCase("Disco Duro")) {
				if(!(comp instanceof DiscoDuro)) {
					valido = false;
				}
			} else if(tipo.equalsIgnoreCase("GPU")) {
				if(!(comp instanceof GPU)) {
					valido = false;
				}
			} else if(tipo.equalsIgnoreCase("Microprocesador")) {
				if(!(comp instanceof MicroProcesador)) {
					valido = false;
				}
			} else if(tipo.equalsIgnoreCase("RAM")) {
				if(!(comp instanceof Ram)) {
					valido = false;
				}
			} else if(tipo.equalsIgnoreCase("Tarjeta Madre")) {
				if(comp instanceof DiscoDuro || comp instanceof GPU
					|| comp instanceof MicroProcesador || comp instanceof Ram) {
					valido = false;
				}
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
			
			deleteBtn.setEnabled(false);
			updateBtn.setEnabled(false);
			BuyBtn.setEnabled(false);
		}
	}
}
