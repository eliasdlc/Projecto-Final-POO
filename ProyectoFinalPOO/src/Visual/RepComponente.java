package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;

import Logica.Componente;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class RepComponente extends JDialog {

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
			RepComponente dialog = new RepComponente();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RepComponente() {
		setTitle("Reporte de Componentes");
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
		panel_1.setLayout(null);
		
		JComboBox filterCmb = new JComboBox();
		filterCmb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String tipo = filterCmb.getSelectedItem().toString();
				loadDatos(tipo);
			}
		});
		filterCmb.setFont(new Font("Century Gothic", Font.BOLD, 14));
		filterCmb.setModel(new DefaultComboBoxModel(new String[] {"<Seleccione>", "Todos", "Disco Duro", "GPU", "Microprocesador", "RAM", "Tarjeta Madre"}));
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
		
		int hardDisk = 0;
		int gpu = 0;
		int ram = 0;
		int processor = 0;
		int motherboard = 0;
		
		ArrayList<Componente> componente = Tienda.getInstance().getMisComponentes();
		boolean valido = false;
		if(!(tipo.equalsIgnoreCase("<Seleccione>"))) {
			if(!(tipo.equalsIgnoreCase("Todos"))) {
				for(Componente comp : componente) {
					if(tipo.equalsIgnoreCase("Disco Duro") && comp instanceof DiscoDuro) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("GPU") && comp instanceof GPU) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("Microprocesador") && comp instanceof MicroProcesador) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("RAM") && comp instanceof Ram) {
						valido = true;
					}
					else if(tipo.equalsIgnoreCase("Tarjeta Madre") && comp instanceof TarjetaMadre) {
						valido = true;
					}
					
					if(valido) {
						data.setValue(comp.getMarca() + "" + comp.getModelo(), comp.getCantVendidos());
					}
				}
			}
			else if(tipo.equalsIgnoreCase("Todos")) {
				for(Componente comp : componente) {
					if(comp instanceof DiscoDuro) {
						hardDisk += comp.getCantVendidos();
					}
					else if(comp instanceof GPU) {
						gpu += comp.getCantVendidos();
					}
					else if(comp instanceof MicroProcesador) {
						processor += comp.getCantVendidos();
					}
					else if(comp instanceof Ram) {
						ram += comp.getCantVendidos();
					}
					else if(comp instanceof TarjetaMadre) {
						motherboard += comp.getCantVendidos();
					}
				}
				data.setValue("Disco Duro", hardDisk);
				data.setValue("GPU", gpu);
				data.setValue("Microprocesador", processor);
				data.setValue("RAM", ram);
				data.setValue("Tarjeta Madre", motherboard);
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
