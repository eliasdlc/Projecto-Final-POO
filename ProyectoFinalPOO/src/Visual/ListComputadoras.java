package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Computadora;
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
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
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
					updatebtn.setEnabled(true);
					deletebtn.setEnabled(true);
					buyBtn.setEnabled(true);
					compbtn.setEnabled(true);
				}
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String headers[] = {"Id", "Precio", "Cant. Disponible","Tipo"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(1118, 0, 199, 685);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		idtxt = new JTextField();
		idtxt.setBounds(13, 16, 169, 29);
		panel_1.add(idtxt);
		idtxt.setColumns(10);
		
		searchbtn = new JButton("Buscar");
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
		searchbtn.setBounds(40, 58, 115, 29);
		panel_1.add(searchbtn);
		
		filtercmb = new JComboBox();
		filtercmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = filtercmb.getSelectedItem().toString();
				loadFilter(tipo);
			}
		});
		filtercmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Gaming", "Oficina", "Universidad"}));
		filtercmb.setBounds(13, 103, 169, 29);
		panel_1.add(filtercmb);
		
		buyBtn = new JButton("Comprar");
		buyBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//logica para comprar
			}
		});
		buyBtn.setBounds(40, 148, 115, 29);
		panel_1.add(buyBtn);
		
		updatebtn = new JButton("Actualizar");
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
		updatebtn.setBounds(42, 549, 115, 29);
		panel_1.add(updatebtn);
		
		deletebtn = new JButton("Eliminar");
		deletebtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(cod != null) {
					int option = JOptionPane.showConfirmDialog(null, "Esta seguro que desea eliminar la computadora seleccionada?");
					if(option == JOptionPane.YES_OPTION) {
						Tienda.getInstance().deleteComputadora(cod);
						loadComputadora(null);
						JOptionPane.showMessageDialog(null, "Eliminaci�n realizada correctamente", "Eliminaci�n", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		deletebtn.setBounds(42, 594, 115, 29);
		panel_1.add(deletebtn);
		
		cancelbtn = new JButton("Cancelar");
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelbtn.setBounds(42, 640, 115, 29);
		panel_1.add(cancelbtn);
		
		compbtn = new JButton("Componentes");
		compbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ListComponentesPC listComponentes = new ListComponentesPC(cod);
				listComponentes.setModal(true);
				listComponentes.setVisible(true);
			}
		});
		compbtn.setBounds(28, 193, 139, 29);
		panel_1.add(compbtn);
		
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
		boolean valido = true;
		
		for(Computadora computadora : aux) {
			if(!(computadora.getTipo().equalsIgnoreCase(tipo))) {
				valido = false;
			}
			
			if(valido) {
				row[0] = computadora.getId();
				row[1] = computadora.getPrecio();
				row[2] = computadora.getCantDisponible();
				row[3] = computadora.getTipo();
				
				model.addRow(row);
			}
		}
		
		deletebtn.setEnabled(false);
		compbtn.setEnabled(false);
		updatebtn.setEnabled(false);
		buyBtn.setEnabled(false);
	}
}
