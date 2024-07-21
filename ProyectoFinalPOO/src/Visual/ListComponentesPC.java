package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Logica.Componente;
import Logica.Computadora;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class ListComponentesPC extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private DefaultTableModel model;
	private Object row[];
	private JButton cancelButton;

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
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(new BorderLayout(0, 0));
			{
				JScrollPane scrollPane = new JScrollPane();
				panel.add(scrollPane, BorderLayout.CENTER);
				{
					model = new DefaultTableModel();
					table = new JTable();
					table.setDefaultEditor(Object.class, null);
					
					String headers[] = {"Id", "Marca", "Modelo", "Precio", "Descuento", "Tipo"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setActionCommand("Cancelar");
				buttonPane.add(cancelButton);
			}
		}
		loadComponente(IdComputadora);
	}
	
	public void loadComponente(String IdComputadora) {
	    Computadora computadora = Tienda.getInstance().searchComputadoraById(IdComputadora);
	    if (computadora != null) {
	        ArrayList<Componente> comp = computadora.getComponentes();
	        model.setRowCount(0);
	        row = new Object[table.getColumnCount()];

	        for (Componente componente : comp) {
	            row[0] = componente.getId();
	            row[1] = componente.getMarca();
	            row[2] = componente.getModelo();
	            row[3] = componente.getPrecio();
	            row[4] = componente.getDescuento() + "%";

	            String tipo = "";
	            if (componente instanceof DiscoDuro) {
	                tipo = "Disco Duro";
	            } else if (componente instanceof GPU) {
	                tipo = "GPU";
	            } else if (componente instanceof MicroProcesador) {
	                tipo = "Microprocesador";
	            } else if (componente instanceof Ram) {
	                tipo = "RAM";
	            } else {
	                tipo = "Tarjeta Madre";
	            }
	            row[5] = tipo;

	            model.addRow(row);
	        }
	    }
	}
}
