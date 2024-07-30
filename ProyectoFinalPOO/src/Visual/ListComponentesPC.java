package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

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
	private JButton cancelButton;

	private static final Color SecondaryC = new Color(3, 104, 196);
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
					
					table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
					String headers[] = {"Id", "Marca", "Modelo", "Precio", "Descuento", "Tipo"};
					model.setColumnIdentifiers(headers);
					table.setModel(model);
					scrollPane.setViewportView(table);
				}
			}
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(SecondaryC);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						cancelButton.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
						cancelButton.setForeground(hoverEffectColor);
						cancelButton.setOpaque(true);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						cancelButton.setBorder(new RoundedBorder(SecondaryC, 1, 20));
						cancelButton.setForeground(SecondaryC);
						cancelButton.setOpaque(true);
					}
				});
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelButton.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				cancelButton.setForeground(SecondaryC);
				cancelButton.setBackground(new Color(248, 248, 248));
				cancelButton.setOpaque(true);
				cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 18));
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
