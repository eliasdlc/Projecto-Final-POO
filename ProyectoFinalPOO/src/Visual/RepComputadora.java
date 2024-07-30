package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Logica.Computadora;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RepComputadora extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
	
	DefaultPieDataset data = new DefaultPieDataset();
	private JPanel panel;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RepComputadora dialog = new RepComputadora();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RepComputadora() {
		setTitle("Reporte de Computadoras");
		setResizable(false);
		setBounds(100, 100, 900, 486);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(SecondaryC);
		panel.setBounds(0, 0, 686, 440);
		contentPanel.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(SecondaryC);
		panel_1.setBounds(685, 0, 193, 440);
		contentPanel.add(panel_1);
		panel.setLayout(null);
		panel_1.setLayout(null);
		
		JComboBox filterCmb = new JComboBox<>();
		filterCmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = filterCmb.getSelectedItem().toString();
				loadDatos(tipo);
			}
		});
		filterCmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Todos", "Gaming", "Oficina", "Universidad"}));
		filterCmb.setFont(new Font("Century Gothic", Font.BOLD, 14));
		filterCmb.setBounds(12, 16, 163, 26);
		panel_1.add(filterCmb);
		
		JButton returnBtn = new JButton("Retornar");
		returnBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				returnBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				returnBtn.setForeground(hoverEffectColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				returnBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				returnBtn.setForeground(SecondaryC);
			}
		});
		returnBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		returnBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		returnBtn.setForeground(SecondaryC);
		returnBtn.setBackground(new Color(248, 248, 248));
		returnBtn.setOpaque(true);
		returnBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		returnBtn.setBounds(35, 395, 115, 29);
		panel_1.add(returnBtn);
	}

	public void loadDatos(String tipo) {
		data.clear();
		
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		panel.setLayout(new BorderLayout());
		
		int game = 0;
		int office = 0;
		int college = 0;
		
		ArrayList<Computadora> aux = Tienda.getInstance().getMisComputadoras();
		boolean valido = false;
		if(!(tipo.equalsIgnoreCase("<Seleccione>"))) {
			if(!(tipo.equalsIgnoreCase("Todos"))) {
				for(Computadora pc : aux) {
					if(tipo.equalsIgnoreCase("Gaming") && pc.getTipo().equalsIgnoreCase("Gaming")) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("Oficina") && pc.getTipo().equalsIgnoreCase("Oficina")) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("Universidad") && pc.getTipo().equalsIgnoreCase("Universidad")) {
						valido = true;
					}
					
					if(valido) {
						data.setValue(pc.getId(), pc.getCantVendido());
					}
				}
			}
			else if(tipo.equalsIgnoreCase("Todos")) {
				for(Computadora pc : aux) {
					if(pc.getTipo().equalsIgnoreCase("Gaming")) {
						game += pc.getCantVendido();
					}
					else if(pc.getTipo().equalsIgnoreCase("Oficina")) {
						office += pc.getCantVendido();
					}
					else if(pc.getTipo().equalsIgnoreCase("Universidad")) {
						college += pc.getCantVendido();
					}
				}
				data.setValue("Gaming", game);
				data.setValue("Oficina", office);
				data.setValue("Universidad", college);
			}
			JFreeChart chart = ChartFactory.createPieChart(
					"Reporte de Venta de: " + tipo,
					data,
					true,
					true,
					false);
			chart.setBackgroundPaint(SecondaryC);
			chart.getTitle().setFont(new Font("Century Gothic", Font.BOLD, 20));
		
			ChartPanel chartpanel = new ChartPanel(chart);
			panel.add(chartpanel, BorderLayout.CENTER);
			panel.revalidate();
		}
		
	}
}
