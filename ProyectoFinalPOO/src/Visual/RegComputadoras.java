package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.RoundedBorder;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RegComputadoras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color AccentColor = new Color(255, 133, 78); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
	
	private static Object row[];
	private static DefaultTableModel model;
	private String cod = "";
	private JRadioButton ramRadioBttn;
	private JRadioButton tarjetaMadreRadioBttn;
	private JRadioButton microProcesadorRadioBttn;
	private JRadioButton discoDuroRadioBttn;
	private JRadioButton gpuRadioBttn;
	private JTable table_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComputadoras dialog = new RegComputadoras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComputadoras() {
		setBounds(100, 100, 1214, 819);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel infoGeneralPanel = new JPanel();
		infoGeneralPanel.setBounds(12, 13, 1162, 241);
		panel.add(infoGeneralPanel);

		

		/*if ( cBxSelector.getSelectedItem().toString().equalsIgnoreCase("Revistas") ){
			headers = new String[]{"Codigo", "Titulo", "Materia", "Numero", "Fecha", "Estado"};
		} else if ( cBxSelector.getSelectedItem().toString().equalsIgnoreCase("Articulos") ){
			headers = new String[]{"Codigo", "Titulo", "Materia", "Arbitro", "Estado"};
		} else if ( cBxSelector.getSelectedItem().toString().equalsIgnoreCase("Libros") ){
			headers = new String[]{"Codigo", "Titulo", "Materia", "Autor", "Editorial", "Estado"};
		} else {
			headers = new String[]{"Codigo", "Titulo", "Materia", "Estado"};
		}*/
		/*modelo.setColumnIdentifiers(headers);
		table.setModel(modelo);
		loadPublicaciones(lasPublicaciones);*/
		
		
		

		

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(12, 267, 1162, 482);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel listadoPanel = new JPanel();
		listadoPanel.setBounds(270, 13, 880, 456);
		panel_1.add(listadoPanel);
		listadoPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		listadoPanel.add(scrollPane, BorderLayout.CENTER);
		
		String[] headers = {"ID", "Nombre", "Espacio", "Tipo Memoria"};
		
		table = new JTable();
		table.setBackground(Color.LIGHT_GRAY);
		model.setColumnIdentifiers(headers);
		model = new DefaultTableModel();
		table.setDefaultEditor(Object.class, null);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				/*int ind = table.getSelectedRow();
				if(ind >= 0) {
					cod = table.getValueAt(ind, 0).toString();
					requestBtn.setEnabled(true);
					deleteBtn.setEnabled(true);
					BuyBtn.setEnabled(true);
				}*/
			}
		});
		table.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		
		table.getTableHeader().setPreferredSize(new Dimension(10, 40));
		table.getTableHeader().setBackground(PrimaryC);
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setBorder(new RoundedBorder(PrimaryC, 1, 20));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(200); // Columna "Articulo"
		table.getColumnModel().getColumn(1).setPreferredWidth(75); // Columna "Cantidad"
		table.getColumnModel().getColumn(2).setPreferredWidth(75); // Columna "Precio"
		table.getColumnModel().getColumn(2).setPreferredWidth(100); // Columna "Total"

		
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
		//elementosCompradosTable.getTableHeader().setBorder(new EmptyBorder(0, 0, 0, 0));
		
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
		
		
		
		
		gpuRadioBttn = new JRadioButton("GPU");
		gpuRadioBttn.setBounds(8, 381, 257, 53);
		panel_1.add(gpuRadioBttn);
		gpuRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramRadioBttn.setSelected(false);
				tarjetaMadreRadioBttn.setSelected(false);
				microProcesadorRadioBttn.setSelected(false);
				discoDuroRadioBttn.setSelected(false);
				gpuRadioBttn.setSelected(true);
			}
		});
		gpuRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		discoDuroRadioBttn = new JRadioButton("Disco Duro");
		discoDuroRadioBttn.setBounds(8, 288, 257, 53);
		panel_1.add(discoDuroRadioBttn);
		discoDuroRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramRadioBttn.setSelected(false);
				tarjetaMadreRadioBttn.setSelected(false);
				microProcesadorRadioBttn.setSelected(false);
				discoDuroRadioBttn.setSelected(true);
				gpuRadioBttn.setSelected(false);
			}
		});
		discoDuroRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		microProcesadorRadioBttn = new JRadioButton("Mircro Procesador");
		microProcesadorRadioBttn.setBounds(8, 195, 257, 53);
		panel_1.add(microProcesadorRadioBttn);
		microProcesadorRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramRadioBttn.setSelected(false);
				tarjetaMadreRadioBttn.setSelected(false);
				microProcesadorRadioBttn.setSelected(true);
				discoDuroRadioBttn.setSelected(false);
				gpuRadioBttn.setSelected(false);
			}
		});
		microProcesadorRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		tarjetaMadreRadioBttn = new JRadioButton("Tarjeta Madre");
		tarjetaMadreRadioBttn.setBounds(8, 102, 257, 53);
		panel_1.add(tarjetaMadreRadioBttn);
		tarjetaMadreRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramRadioBttn.setSelected(false);
				tarjetaMadreRadioBttn.setSelected(true);
				microProcesadorRadioBttn.setSelected(false);
				discoDuroRadioBttn.setSelected(false);
				gpuRadioBttn.setSelected(false);
				
				//headers = new String[] {"ID", "Nombre", "Tipo Socket", "Tipo RAM", "Tipo GPU", "Tipo Disco Duro"};
			}
		});
		tarjetaMadreRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		ramRadioBttn = new JRadioButton("RAM");
		ramRadioBttn.setBounds(8, 9, 257, 53);
		panel_1.add(ramRadioBttn);
		ramRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ramRadioBttn.setSelected(true);
				tarjetaMadreRadioBttn.setSelected(false);
				microProcesadorRadioBttn.setSelected(false);
				discoDuroRadioBttn.setSelected(false);
				gpuRadioBttn.setSelected(false);
				
				//headers = new String[] {"ID", "Nombre", "Espacio", "Tipo Memoria"};
			}
		});
		ramRadioBttn.setSelected(true);
		ramRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		/*JScrollPane scrollPane = new JScrollPane();
		listadoPanel.add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		
		
		scrollPane.setViewportView(table);*/
	}
	
	private void loadComponente(String[] headers) {
		ramRadioBttn.setSelected(true);
		tarjetaMadreRadioBttn.setSelected(false);
		microProcesadorRadioBttn.setSelected(false);
		discoDuroRadioBttn.setSelected(false);
		gpuRadioBttn.setSelected(false);
		if ( ramRadioBttn.isSelected() ) {
			headers = new String[] {"ID", "Nombre", "Espacio", "Tipo Memoria"};
		} //else if
	}
}
