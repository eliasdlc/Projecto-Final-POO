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
import Logica.Computadora;
import Logica.DiscoDuro;
import Logica.Factura;
import Logica.FacturaComponente;
import Logica.FacturaComputadora;
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

public class DisplayFacturaComputadora extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable componentesPcTable;
	private static Object row[];
	private static DefaultTableModel model;
	private static DefaultTableModel modelPc;
	private static Object rowPc[];
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
	private JTable computadoraTable;
	private JLabel valDescuentoLabel;
	private JLabel valSubtotalLabel;
	private JLabel valTotalLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DisplayFacturaComputadora dialog = new DisplayFacturaComputadora(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DisplayFacturaComputadora(FacturaComputadora factura) {
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
			
			JPanel componentesPcPanel = new JPanel();
			componentesPcPanel.setBounds(12, 456, 737, 217);
			panel.add(componentesPcPanel);
			componentesPcPanel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane = new JScrollPane();
			scrollPane.setBorder(new EmptyBorder(0, 0, 0, 0));
			componentesPcPanel.add(scrollPane, BorderLayout.CENTER);
			
			
			
			componentesPcTable = new JTable();
			scrollPane.setViewportView(componentesPcTable);
			componentesPcTable.setBackground(Color.LIGHT_GRAY);
			
			model = new DefaultTableModel();
			componentesPcTable.setDefaultEditor(Object.class, null);
			componentesPcTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			String headers[] = {"Componentes", "Info", "Precio", "Descuento"};
			model.setColumnIdentifiers(headers);
			componentesPcTable.setModel(model);
			
			componentesPcTable.getTableHeader().setPreferredSize(new Dimension(10, 40));
			componentesPcTable.getTableHeader().setBackground(PrimaryC);
			componentesPcTable.getTableHeader().setForeground(Color.white);
			componentesPcTable.getTableHeader().setBorder(new RoundedBorder(PrimaryC, 1, 20));
			
			componentesPcTable.getColumnModel().getColumn(0).setPreferredWidth(200); // Columna "Articulo"
			componentesPcTable.getColumnModel().getColumn(1).setPreferredWidth(75); // Columna "Cantidad"
			componentesPcTable.getColumnModel().getColumn(2).setPreferredWidth(75);
			componentesPcTable.getColumnModel().getColumn(3).setPreferredWidth(50);
			
			componentesPcTable.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			componentesPcTable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
			componentesPcTable.setRowHeight(30);
			componentesPcTable.setBorder(new RoundedBorder(Color.white, 1, 20));
			
			componentesPcTable.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
			    @Override
			    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
			        if (!isSelected) {
			            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
			            componentesPcTable.setGridColor(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
			        }
			        return c;
			    }
			});
			
			scrollPane.setViewportView(componentesPcTable);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(Color.WHITE);
			panel_2.setBounds(12, 686, 737, 144);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JPanel infoGeneralPanel = new JPanel();
			infoGeneralPanel.setBackground(Color.WHITE);
			infoGeneralPanel.setBounds(12, 13, 737, 360);
			infoGeneralPanel.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel.add(infoGeneralPanel);
			infoGeneralPanel.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("FACTURA");
			lblNewLabel.setForeground(PrimaryC);
			lblNewLabel.setBounds(12, 156, 298, 53);
			infoGeneralPanel.add(lblNewLabel);
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 38));
			
			JLabel fechaLabel = new JLabel("");
			fechaLabel.setBounds(12, 217, 240, 37);
			infoGeneralPanel.add(fechaLabel);
			
			Date fecha = factura.getFecha();
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
			String fechaFormateada = formatoFecha.format(fecha);
			
			fechaLabel.setText("Fecha: " + fechaFormateada);
			fechaLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			
			JLabel idLabel = new JLabel("");
			idLabel.setBounds(12, 253, 240, 37);
			infoGeneralPanel.add(idLabel);
			idLabel.setText("ID: " + factura.getId());
			idLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			{
				JLabel lblInformacionCliente = new JLabel("Informacion Cliente");
				lblInformacionCliente.setForeground(PrimaryC);
				lblInformacionCliente.setBounds(501, 156, 224, 37);
				infoGeneralPanel.add(lblInformacionCliente);
				lblInformacionCliente.setHorizontalAlignment(SwingConstants.TRAILING);
				lblInformacionCliente.setFont(new Font("Century Gothic", Font.BOLD, 20));
			}
			{
				JLabel nombreClientLabel = new JLabel("");
				nombreClientLabel.setBounds(501, 202, 224, 37);
				infoGeneralPanel.add(nombreClientLabel);
				nombreClientLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				String nombreClient = Tienda.getInstance().searchClienteById(factura.getIdCliente()).getNombre();
				nombreClientLabel.setText("Nombre: " + nombreClient);
				nombreClientLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			}
			{
				JLabel clientIdLabel = new JLabel("");
				clientIdLabel.setBounds(501, 242, 224, 37);
				infoGeneralPanel.add(clientIdLabel);
				clientIdLabel.setHorizontalAlignment(SwingConstants.TRAILING);
				clientIdLabel.setText("ID: " + factura.getIdCliente());
				clientIdLabel.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			}
			
			JLabel lblTechNexus = new JLabel("Tech Nexus");
			lblTechNexus.setForeground(PrimaryC);
			lblTechNexus.setFont(new Font("Century Gothic", Font.BOLD, 44));
			lblTechNexus.setBounds(12, 37, 298, 53);
			infoGeneralPanel.add(lblTechNexus);
			
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
			
			JPanel computadoraPanel = new JPanel();
			computadoraPanel.setBounds(12, 374, 737, 82);
			panel.add(computadoraPanel);
			computadoraPanel.setLayout(new BorderLayout(0, 0));
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(new EmptyBorder(0,0,0,0));
			computadoraPanel.add(scrollPane_1, BorderLayout.CENTER);
			
			computadoraTable = new JTable();
			//scrollPane_1.setViewportView(computadoraTable);
			
			
			modelPc = new DefaultTableModel();
			computadoraTable.setDefaultEditor(Object.class, null);
			computadoraTable.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
			String headersPc[] = {"ID", "Tipo", "Cantidad", "Precio"};
			modelPc.setColumnIdentifiers(headersPc);
			computadoraTable.setModel(modelPc);
			
			computadoraTable.getTableHeader().setPreferredSize(new Dimension(10, 40));
			computadoraTable.getTableHeader().setBackground(PrimaryC);
			computadoraTable.getTableHeader().setForeground(Color.white);
			computadoraTable.getTableHeader().setBorder(new RoundedBorder(PrimaryC, 1, 20));
			
			computadoraTable.getColumnModel().getColumn(0).setPreferredWidth(30);
			computadoraTable.getColumnModel().getColumn(1).setPreferredWidth(100); 
			computadoraTable.getColumnModel().getColumn(2).setPreferredWidth(30); 
			computadoraTable.getColumnModel().getColumn(3).setPreferredWidth(75);
			
			computadoraTable.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			computadoraTable.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 20));
			computadoraTable.setRowHeight(40);
			computadoraTable.setBorder(new RoundedBorder(Color.white, 1, 20));
			computadoraTable.setBackground(Color.white);
			computadoraTable.setGridColor(Color.white);
			
			scrollPane_1.setViewportView(computadoraTable);
			
			loadArticulos(factura);
			loadComputadora(factura);
		}
		
	}
	
	private void loadComputadora(FacturaComputadora factura) {
		modelPc.setRowCount(0);
		rowPc = new Object[computadoraTable.getColumnCount()];
		
		Computadora pc = Tienda.getInstance().searchComputadoraById(factura.getIdComputadora());
		
		rowPc[0] = factura.getIdComputadora();
		rowPc[1] = pc.getTipo();
		rowPc[2] = factura.getCantidad();
		rowPc[3] = NumberFormat.getCurrencyInstance().format(factura.getMontoTotal());
		
		modelPc.addRow(rowPc);
	}
	
	private void loadArticulos(FacturaComputadora factura) {
		model.setRowCount(0);
		row = new Object[componentesPcTable.getColumnCount()];
		
		ArrayList<Componente> aux = factura.getComponentesPc();//Tienda.getInstance().searchClienteById(factura.getIdCliente()).getCarrito();
		
		int diff = 5 - aux.size();
		float subTotal = 0;
		float descuentoTotal = 0;
		int cantArticulos = 0;
		
		for(Componente comp : aux ) {
			cantArticulos += comp.getCantSeleccionado();
		}
		
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
				float precio = comp.getPrecio();
				float descuento = comp.getDescuento();

				row[0] = comp.getMarca() + " " + comp.getModelo();

				if ( comp instanceof TarjetaMadre ) {
					row[1] = "Socket: " + ((TarjetaMadre) comp).getConectionSocket();
				} else if ( comp instanceof Ram ) {
					row[1] = ((Ram) comp).getMemoria() + " " + ((Ram) comp).getTipoMemoria();
				} else if ( comp instanceof MicroProcesador ) {
					row[1] = "Nucleos: " + ((MicroProcesador) comp).getCantNucleo();
				} else if ( comp instanceof DiscoDuro ) {
					float almacenamiento = ((DiscoDuro) comp).getAlmacenamiento();
					
					if (((DiscoDuro) comp).getAlmTipo().equals("TB")) {
				        almacenamiento /= 1000;
				    }
					row[1] = almacenamiento + " " + ((DiscoDuro) comp).getAlmTipo();
					
					
				} else if ( comp instanceof GPU ) {
					row[1] = ((GPU) comp).getVelocidad() + "Ghz";
				}
				
				row[2] = NumberFormat.getCurrencyInstance().format(precio);
				row[3] = descuento + "%";
			}

			valSubtotalLabel.setText(NumberFormat.getCurrencyInstance().format(factura.getSubTotal()));
			valDescuentoLabel.setText(NumberFormat.getCurrencyInstance().format((factura.getDescuento() / 100) * factura.getSubTotal()));
			valTotalLabel.setText(NumberFormat.getCurrencyInstance().format(factura.getMontoTotal()));
		
			model.addRow(row);
		}
			
	}
}
