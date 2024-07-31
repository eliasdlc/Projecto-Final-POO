package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.Cliente;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class ListCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	private JTextField idtxt;
	private JButton searchBtn;
	private JButton invoiceBtn;
	private JButton cancelBtn;
	private static Object row[];
	private DefaultTableModel model;
	private String cod = "";
	private JButton cancelbtn;

	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color ThirdC = new Color(247, 251, 255);
	private static final Color AccentColor = new Color(247, 109, 71); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 136, 73);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(42, 145, 230);
	private static final Color ButtonBorderColor = new Color(42, 145, 230);
	private static final Color HoverEffectColor = new Color(3, 109, 195);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ListCliente dialog = new ListCliente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ListCliente() {
		setTitle("Listado de Clientes");
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
		
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int ind = table.getSelectedRow();
				if(ind >= 0) {
					cod = table.getValueAt(ind, 0).toString();
					invoiceBtn.setEnabled(true);
				}
			}
		});
		table.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		table.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		String headers[] = {"Id", "Nombre", "Telefono", "Email"};
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		scrollPane.setViewportView(table);
		
		table.getTableHeader().setPreferredSize(new Dimension(10, 40));
		table.getTableHeader().setBackground(PrimaryC);
		table.getTableHeader().setForeground(Color.white);
		
		table.getColumnModel().getColumn(0).setPreferredWidth(25);
		table.getColumnModel().getColumn(1).setPreferredWidth(75);
		table.getColumnModel().getColumn(2).setPreferredWidth(75); 
		
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));
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
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(PrimaryC);
		panel_1.setBounds(1118, 0, 213, 704);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		idtxt = new JTextField();
		idtxt.setBorder(new CompoundBorder( new RoundedBorder(PrimaryC, 1, 15), new EmptyBorder(0, 10, 0, 10) ));
		idtxt.setBounds(22, 13, 169, 40);
		panel_1.add(idtxt);
		idtxt.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idtxt.setColumns(10);
		
		searchBtn = new JButton("Buscar");
		searchBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				searchBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				searchBtn.setForeground(HoverEffectColor);
				searchBtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				searchBtn.setForeground(SecondaryC);
				searchBtn.setOpaque(true);
			}
		});
		searchBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(idtxt.getText().equalsIgnoreCase("")) {
					JOptionPane.showMessageDialog(null, "Error, Campo de Texto se encuentra vacio", "Error", JOptionPane.ERROR_MESSAGE);
				}
				else {
					String id = idtxt.getText();
					loadCliente(id);
				}
			}
		});
		searchBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		searchBtn.setForeground(SecondaryC);
		searchBtn.setBackground(new Color(248, 248, 248));
		searchBtn.setOpaque(true);
		searchBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		searchBtn.setBounds(22, 69, 169, 40);
		panel_1.add(searchBtn);
		
		invoiceBtn = new JButton("Facturas");
		invoiceBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				invoiceBtn.setBorder(new RoundedBorder(HoverEffectColor, 1, 20));
				invoiceBtn.setForeground(HoverEffectColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				invoiceBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				invoiceBtn.setForeground(SecondaryC);
			}
		});
		invoiceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Lista factura 
			}
		});
		invoiceBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		invoiceBtn.setForeground(SecondaryC);
		invoiceBtn.setBackground(new Color(248, 248, 248));
		invoiceBtn.setOpaque(true);
		invoiceBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		invoiceBtn.setBounds(11, 598, 190, 40);
		panel_1.add(invoiceBtn);
		
		cancelbtn = new JButton("Cancelar");
		cancelbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cancelbtn.setBackground(HoverEffectColor);
				cancelbtn.setOpaque(true);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cancelbtn.setBorder(new RoundedBorder(ThirdC, 1, 20));
				cancelbtn.setForeground(ThirdC);
				cancelbtn.setOpaque(false);
			}
		});
		cancelbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelbtn.setBorder(new RoundedBorder(ThirdC, 1, 20));
		cancelbtn.setForeground(ThirdC);
		cancelbtn.setBackground(ThirdC);
		cancelbtn.setOpaque(false);
		cancelbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		cancelbtn.setBounds(11, 651, 190, 40);
		panel_1.add(cancelbtn);
		
		loadCliente(null);
	}
	
	public void loadCliente(String id) {
		if(id == null) {
			ArrayList<Cliente> aux = Tienda.getInstance().getMisClientes();
			model.setRowCount(0);
			row = new Object[table.getColumnCount()];
			for(Cliente cli : aux) {
				row[0] = cli.getId();
				row[1] = cli.getNombre();
				row[2] = cli.getCorreo();
				row[3] = cli.getNumero();
				
				model.addRow(row);
			}
		}
		else {
			Cliente cliente = Tienda.getInstance().searchClienteById(id);
			if(cliente != null) {
				row[0] = cliente.getId();
				row[1] = cliente.getNombre();
				row[2] = cliente.getCorreo();
				row[3] = cliente.getNumero();
			}
			else {
				JOptionPane.showMessageDialog(null, "ID no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		invoiceBtn.setEnabled(false);
	}
}
