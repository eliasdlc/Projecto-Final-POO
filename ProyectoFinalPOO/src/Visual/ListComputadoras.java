package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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

	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
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
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		String headers[] = {"Id", "Precio", "Cant. Disponible","Tipo"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SecondaryC);
		panel_1.setBounds(1118, 0, 199, 685);	
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		idtxt = new JTextField();
		idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idtxt.setBounds(13, 16, 169, 29);
		panel_1.add(idtxt);
		idtxt.setColumns(10);
		
		searchbtn = new JButton("Buscar");
		searchbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				searchbtn.setForeground(hoverEffectColor);
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
		searchbtn.setBounds(40, 58, 115, 29);
		panel_1.add(searchbtn);
		
		filtercmb = new JComboBox();
		filtercmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = filtercmb.getSelectedItem().toString();
				loadFilter(tipo);
			}
		});
		filtercmb.setBackground(new Color(248, 248, 248));
		filtercmb.setForeground(SecondaryC);
		filtercmb.setFont(new Font("Century Gothic", Font.BOLD, 18));
		filtercmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Gaming", "Oficina", "Universidad"}));
		filtercmb.setBounds(13, 103, 169, 29);
		panel_1.add(filtercmb);
		
		buyBtn = new JButton("Comprar");
		buyBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				buyBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				buyBtn.setForeground(hoverEffectColor);
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
		deletebtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				deletebtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				deletebtn.setForeground(hoverEffectColor);
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
						JOptionPane.showMessageDialog(null, "Eliminaci�n realizada correctamente", "Eliminaci�n", JOptionPane.INFORMATION_MESSAGE);
					}
				}
			}
		});
		deletebtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		deletebtn.setForeground(SecondaryC);
		deletebtn.setBackground(new Color(248, 248, 248));
		deletebtn.setOpaque(true);
		deletebtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		deletebtn.setBounds(42, 594, 115, 29);
		panel_1.add(deletebtn);
		
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
		
		compbtn = new JButton("Componentes");
		compbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				compbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				compbtn.setForeground(hoverEffectColor);
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
