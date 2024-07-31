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

import Logica.Cliente;
import Logica.Factura;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListFactura extends JDialog {

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
			ListFactura dialog = new ListFactura(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListFactura(String id) {
		setTitle("Lista de Facturas");
		setBounds(100, 100, 623, 375);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			{
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setBounds(0, 23, 591, 247);
				panel.add(scrollPane);
				{
					model = new DefaultTableModel();
					table = new JTable();
					table.setDefaultEditor(Object.class, null);
					
					table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
					String headers[] = {"Id", "Fecha", "Sub Total", "Descuento", "Monto Total"};
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
			{
				JLabel idlbl = new JLabel("Facturas del Id: " + id);
				idlbl.setBounds(0, 0, 591, 23);
				idlbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
				panel.add(idlbl);
			}
			{
				JButton cerrarBttn = new JButton("Cerrar");
				cerrarBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						cerrarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						cerrarBttn.setBackground(hoverEffectColor);
					}
					@Override
					public void mouseExited(MouseEvent e) {
						cerrarBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
						cerrarBttn.setBackground(ButtonColor);
					}
				});
				cerrarBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cerrarBttn.setFocusPainted(false);
				cerrarBttn.setForeground(Color.white);
				cerrarBttn.setBackground(ButtonColor);
				cerrarBttn.setFont(new Font("Century Gothic", Font.BOLD, 16));
				cerrarBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
				cerrarBttn.setBounds(239, 275, 127, 33);
				panel.add(cerrarBttn);
			}
		}
		loadFactura(id);
	}
	
	public void loadFactura(String id) {
		Cliente cliente = Tienda.getInstance().searchClienteById(id);
		if(cliente != null) {
			ArrayList<Factura> aux = cliente.getMisFacturas();
			model.setRowCount(0);
			row = new Object[table.getColumnCount()];
			
			int diff = 10 - aux.size();
			
			for(int ind = 0; ind < aux.size() + diff; ind++) {
				Factura factura = null;
				
				if(ind < aux.size()) {
					factura = aux.get(ind);
				}
				
				if(factura == null) {
					row[0] = "";
					row[1] = "";
					row[2] = "";
					row[3] = "";
					row[4] = "";
				}
				else {
					row[0] = factura.getId();
					row[1] = factura.getFecha();
					row[2] = factura.getSubTotal();
					row[3] = factura.getDescuento() + "%";
					row[4] = factura.getMontoTotal();
				}
				
				model.addRow(row);
			}
		}
	}
}
