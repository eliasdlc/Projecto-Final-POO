package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.Componente;
import Logica.Computadora;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.prefs.BackingStoreException;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ListComponentesPC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListComponentesPC dialog = new ListComponentesPC(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListComponentesPC(String IdComputadora) {
		setTitle("Componentes de Pc");
		setBounds(100, 100, 623, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		loadComponente(IdComputadora);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 605, 280);
			contentPanel.add(panel);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					table = new JTable();
					table.setDefaultEditor(Object.class, null);
					
					table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
					String headers[] = {"Id", "Marca", "Modelo", "Precio", "Descuento", "Tipo"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);					
					table.getTableHeader().setPreferredSize(new Dimension(10, 32));
					table.getTableHeader().setBackground(PrimaryC);
					table.getTableHeader().setForeground(Color.white);
					
					table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
					table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 15));
					table.setRowHeight(32);
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
		}
		{
			JPanel buttonPanel = new JPanel();
			buttonPanel.setBackground(Color.WHITE);
			buttonPanel.setBounds(0, 279, 605, 49);
			contentPanel.add(buttonPanel);
			buttonPanel.setLayout(null);
			
			JButton cerrarBttn = new JButton("Cerrar");
			cerrarBttn.setFocusPainted(false);
			cerrarBttn.setForeground(Color.white);
			cerrarBttn.setBackground(ButtonColor);
			cerrarBttn.setFont(new Font("Century Gothic", Font.BOLD, 16));
			cerrarBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			cerrarBttn.setBounds(239, 8, 127, 33);
			buttonPanel.add(cerrarBttn);
		}
		loadComponente(IdComputadora);
	}
	
	private void loadComponente(String IdComputadora) {
	    Computadora computadora = Tienda.getInstance().searchComputadoraById(IdComputadora);
	    if (computadora != null) {
	        ArrayList<Componente> aux = computadora.getComponentes();
	        model.setRowCount(0);
	        row = new Object[table.getColumnCount()];

	        
	        int diff = 10 - aux.size();
			
			for (int i = 0; i < aux.size() + diff; i++) {
				
				Componente comp = null;
							
				if ( i < aux.size() ) {
					comp = aux.get(i);
				}
				
				if ( comp == null ) {
					row[0] = " ";
					row[1] = " ";
					row[2] = " ";
					row[3] = " ";
					row[4] = " ";
					row[5] = " ";
				} else {
					row[0] = comp.getId();
		            row[1] = comp.getMarca();
		            row[2] = comp.getModelo();
		            row[3] = comp.getPrecio();
		            row[4] = comp.getDescuento() + "%";

		            String tipo = "";
		            if (comp instanceof DiscoDuro) {
		                tipo = "Disco Duro";
		            } else if (comp instanceof GPU) {
		                tipo = "GPU";
		            } else if (comp instanceof MicroProcesador) {
		                tipo = "Microprocesador";
		            } else if (comp instanceof Ram) {
		                tipo = "RAM";
		            } else {
		                tipo = "Tarjeta Madre";
		            }
		            row[5] = tipo;
				}
				
				model.addRow(row);
			}
	        
	    }
	}
}
