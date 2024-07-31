package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.Componente;
import Logica.DiscoDuro;
import Logica.Factura;
import Logica.FacturaComponente;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DisplayFacturaComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable elementosCompradosTable;
	private static Object row[];
	private static DefaultTableModel model;
	private String cod = "";
	
	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color AccentColor = new Color(255, 133, 78); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color hoverEffectColor = new Color(4, 130, 233);
	private JLabel valSubtotalLabel;
	private JLabel valDescuentoLabel;
	private JLabel valTotalLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DisplayFacturaComponente dialog = new DisplayFacturaComponente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DisplayFacturaComponente(Factura factura) {
		setBounds(100, 100, 789, 900);
		setModal(true);
		setLocationRelativeTo(getParent());
		setResizable(false);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JLabel logoIcono = new JLabel("");
			logoIcono.setBounds(189, 195, 140, 140);
			panel.add(logoIcono);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(12, 319, 737, 354);
			panel.add(panel_1);
			panel_1.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			panel_1.add(scrollPane, BorderLayout.CENTER);
			
			
			
			elementosCompradosTable = new JTable();
			scrollPane.setViewportView(elementosCompradosTable);
			elementosCompradosTable.setBackground(Color.LIGHT_GRAY);
			
			model = new DefaultTableModel();
			elementosCompradosTable.setDefaultEditor(Object.class, null);
			elementosCompradosTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			String headers[] = {"Articulo", "Cantidad", "Precio", "Total"};
			model.setColumnIdentifiers(headers);
			elementosCompradosTable.setModel(model);
			
			elementosCompradosTable.getTableHeader().setPreferredSize(new Dimension(10, 40));
			elementosCompradosTable.getTableHeader().setBackground(PrimaryC);
			elementosCompradosTable.getTableHeader().setForeground(Color.white);
			elementosCompradosTable.getTableHeader().setBorder(new RoundedBorder(PrimaryC, 1, 20));
			
			elementosCompradosTable.getColumnModel().getColumn(0).setPreferredWidth(200); // Columna "Articulo"
			elementosCompradosTable.getColumnModel().getColumn(1).setPreferredWidth(75); // Columna "Cantidad"
			elementosCompradosTable.getColumnModel().getColumn(2).setPreferredWidth(75); // Columna "Precio"
			elementosCompradosTable.getColumnModel().getColumn(2).setPreferredWidth(100); // Columna "Total"

			
			elementosCompradosTable.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			elementosCompradosTable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
			elementosCompradosTable.setRowHeight(30);
			elementosCompradosTable.setBorder(new RoundedBorder(Color.white, 1, 20));
			
			elementosCompradosTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			    @Override
			    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			        if (!isSelected) {
			            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
			            elementosCompradosTable.setGridColor(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
			        }
			        return c;
			    }
			});
			
			scrollPane.setViewportView(elementosCompradosTable);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(12, 686, 737, 144);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(Color.WHITE);
			panel_3.setBounds(12, 13, 737, 316);
			panel_3.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel.add(panel_3);
			panel_3.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("FACTURA");
			lblNewLabel.setForeground(PrimaryC);
			lblNewLabel.setBounds(12, 144, 298, 53);
			panel_3.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 38));
			
			JLabel fechaLabel = new JLabel("");
			fechaLabel.setBounds(12, 205, 240, 37);
			panel_3.add(fechaLabel);
			
			Date fecha = new Date();
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
			String fechaFormateada = formatoFecha.format(fecha);
			
			fechaLabel.setText("Fecha: " + fechaFormateada);
			fechaLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			
			JLabel idLabel = new JLabel("");
			idLabel.setBounds(12, 241, 240, 37);
			panel_3.add(idLabel);
			idLabel.setText("ID: " + factura.getId());
			idLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			{
				JLabel lblInformacionCliente = new JLabel("Informacion Cliente");
				lblInformacionCliente.setForeground(PrimaryC);
				lblInformacionCliente.setBounds(501, 144, 224, 37);
				panel_3.add(lblInformacionCliente);
				lblInformacionCliente.setHorizontalAlignment(SwingConstants.TRAILING);
				lblInformacionCliente.setFont(new Font("Century Gothic", Font.BOLD, 20));
			}
			{
				JLabel nombreClientLabel = new JLabel("");
				nombreClientLabel.setBounds(501, 190, 224, 37);
				panel_3.add(nombreClientLabel);
				nombreClientLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				String nombreClient = Tienda.getInstance().searchClienteById(factura.getIdCliente()).getNombre();
				nombreClientLabel.setText("Nombre: " + nombreClient);
				nombreClientLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			}
			{
				JLabel clientIdLabel = new JLabel("");
				clientIdLabel.setBounds(501, 230, 224, 37);
				panel_3.add(clientIdLabel);
				clientIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				clientIdLabel.setText("ID: " + factura.getIdCliente());
				clientIdLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			}
			
			JLabel lblTechNexus = new JLabel("Tech Nexus");
			lblTechNexus.setForeground(PrimaryC);
			lblTechNexus.setFont(new Font("Century Gothic", Font.BOLD, 44));
			lblTechNexus.setBounds(12, 37, 298, 53);
			panel_3.add(lblTechNexus);
			
			JLabel lblGraciasPorSu = new JLabel("Gracias por su compra!");
			lblGraciasPorSu.setHorizontalAlignment(SwingConstants.CENTER);
			lblGraciasPorSu.setFont(new Font("Century Gothic", Font.BOLD, 24));
			lblGraciasPorSu.setBounds(12, 13, 356, 34);
			panel_2.add(lblGraciasPorSu);
			
			JPanel panel_4 = new JPanel();
			panel_4.setBounds(380, 0, 357, 144);
			panel_4.setBorder(new RoundedBorder(PrimaryC, 1, 20));
			panel_4.setBackground(PrimaryC);
			panel_2.add(panel_4);
			panel_4.setLayout(null);
			
			valSubtotalLabel = new JLabel("");
			valSubtotalLabel.setBounds(203, 13, 127, 23);
			panel_4.add(valSubtotalLabel);
			valSubtotalLabel.setForeground(Color.WHITE);
			valSubtotalLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			valSubtotalLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			
			
			
			valDescuentoLabel = new JLabel("");
			valDescuentoLabel.setBounds(203, 49, 127, 23);
			panel_4.add(valDescuentoLabel);
			valDescuentoLabel.setForeground(Color.WHITE);
			valDescuentoLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			valDescuentoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			
			JLabel descuentoLabel = new JLabel("Descuento");
			descuentoLabel.setBounds(43, 49, 127, 23);
			panel_4.add(descuentoLabel);
			descuentoLabel.setForeground(Color.WHITE);
			descuentoLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			JLabel subtotalLabel = new JLabel("Sub Total");
			subtotalLabel.setBounds(43, 13, 127, 23);
			panel_4.add(subtotalLabel);
			subtotalLabel.setForeground(Color.WHITE);
			subtotalLabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			JLabel lblNewLabel_1 = new JLabel("___________________________________________________");
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(0, 69, 357, 16);
			panel_4.add(lblNewLabel_1);
			
			JLabel totalLabel = new JLabel("Total");
			totalLabel.setForeground(Color.WHITE);
			totalLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
			totalLabel.setBounds(43, 98, 127, 23);
			panel_4.add(totalLabel);
			
			valTotalLabel = new JLabel("");
			valTotalLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			valTotalLabel.setForeground(Color.WHITE);
			valTotalLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			valTotalLabel.setBounds(203, 98, 127, 23);
			panel_4.add(valTotalLabel);
			
			JButton cerrarBttn = new JButton("Cerrar");
			cerrarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					cerrarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					cerrarBttn.setBackground(hoverEffectColor);
				}
				public void mouseExited(MouseEvent arg0) {
					cerrarBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
					cerrarBttn.setBackground(PrimaryC);
				}
			});
			cerrarBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cerrarBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
			cerrarBttn.setFocusPainted(false);
			cerrarBttn.setBackground(PrimaryC);
			cerrarBttn.setForeground(Color.white);
			cerrarBttn.setFont(new Font("Century Gothic", Font.BOLD, 22));
			cerrarBttn.setBounds(12, 88, 356, 43);
			panel_2.add(cerrarBttn);
			
			loadArticulos((FacturaComponente)factura);
		}
		
	}
	
	public void loadArticulos(FacturaComponente factura) {
		model.setRowCount(0);
		row = new Object[elementosCompradosTable.getColumnCount()];
		
		ArrayList<Componente> aux = factura.getCarrito();
		
		int diff = 10 - aux.size();
		float subTotal = 0;
		
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
			} else {
				int cantArticulos = factura.getCantArticulos()[i]; 
				float precio = comp.getPrecio();
				row[0] = comp.getMarca() + " " + comp.getModelo();
				row[1] = cantArticulos;
				row[2] = NumberFormat.getCurrencyInstance().format(precio);
				row[3] = NumberFormat.getCurrencyInstance().format(comp.getPrecio() * factura.getCantArticulos()[i]); 
			}
			
			valSubtotalLabel.setText(NumberFormat.getCurrencyInstance().format(factura.getSubTotal()));
			valDescuentoLabel.setText(NumberFormat.getCurrencyInstance().format((factura.getDescuento() / 100) * factura.getSubTotal()));
			valTotalLabel.setText(NumberFormat.getCurrencyInstance().format(factura.getMontoTotal()));
		
			model.addRow(row);
		}
			
	}
}
