package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import Logica.Componente;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.text.NumberFormat;
import java.awt.FlowLayout;

public class Principal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	int horizontalListInd = 0;
	private final int PANELS_TO_SHOW = 4;
	private final int PANEL_WIDTH = 350;
	private final int PANEL_HEIGHT = 350;
	private final int PANEL_GAP = 10;
	
	/*
	 * Esto es para probar funcionalidades.
	 * Es temporal!
	 * */
	
	Componente tarjetaMadre = new TarjetaMadre("TM001", "ASUS", "ROG Strix B550-F", 189.99f, 40, 120, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
	Componente cpu = new MicroProcesador("CPU001", "Intel", "Core i7-11700K", 329.99f, 50, 150, 3.6f, "LGA1200", 8);
	Componente memoria = new Ram("RAM001", "Corsair", "Vengeance LPX", 79.99f, 100, 300, "16GB", "DDR4");
	Componente tarjetaGrafica = new GPU("GPU001", "NVIDIA", "GeForce RTX 3070", 499.99f, 30, 200, "Dedicada", 8.0f, 1.73f, "PCIe 4.0");
	Componente disco = new DiscoDuro("HDD001", "Western Digital", "Blue", 59.99f, 80, 250, 1000.0f, 150.0f, 130.0f, "HDD", "SATA-3");
	Componente cpu2 = new MicroProcesador("CPU002", "AMD", "Ryzen 7 5800X", 399.99f, 60, 180, 3.8f, "AM4", 8);
	Componente memoria2 = new Ram("RAM002", "G.Skill", "Trident Z RGB", 129.99f, 75, 250, "32GB", "DDR4");
	Componente tarjetaGrafica2 = new GPU("GPU002", "AMD", "Radeon RX 6800 XT", 649.99f, 25, 150, "Dedicada", 16.0f, 2.25f, "PCIe 4.0");
	Componente disco2 = new DiscoDuro("SSD001", "Samsung", "970 EVO Plus", 129.99f, 100, 300, 1000.0f, 3500.0f, 3300.0f, "SSD", "NVMe");
	Componente tarjetaMadre2 = new TarjetaMadre("TM002", "MSI", "MPG B550 Gaming Edge WiFi", 169.99f, 35, 140, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe", "PCIe 4.0")));
	private ArrayList<Componente> componentesMasFamosos = new ArrayList<>(Arrays.asList(cpu, memoria, tarjetaMadre, cpu2, tarjetaGrafica, disco, memoria2, tarjetaGrafica2, disco2, tarjetaMadre2));
	
	//
	
	private ArrayList<JPanel> componentes = getMasComprados(0, componentesMasFamosos);
	private JPanel panelComponentes;
	private JButton btnListarComponentes;
	private JButton btnRegComponentes;
	private JButton btnComputadoras;
	private JButton btnAdministracion;
	private JButton btnCliente;
	private JButton bttnOpciones;
	private JPanel panelComputadoras;
	private JButton btnComprarComputadora;
	private JButton btnComprarComponente;
	boolean pressed = false;
	
	private static final Color PrimaryC = new Color(0, 78, 137);
	private static final Color SecondaryC = new Color(90, 162, 232);
	private static final Color AccentColor = new Color(255, 133, 78); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color hoverEffectColor = new Color(220, 231, 242);
	
	private JScrollPane scrollPane;
	private JPanel innerPanel;
	private Timer scrollTimer;
	private int targetScrollValue;
	private static final int SCROLL_SPEED = 25;
	private Timer inertiaTimer;
	private int lastScrollValue;
	private int scrollVelocity;
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		setResizable(false);
		setBounds(100, 100, 1918, 991);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height);
		
		
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 5, 1914, 1040);
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(PrimaryC);
			panel_1.setBounds(0, 0, 356, 1040);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			scrollPane = new JScrollPane();
			scrollPane.setBounds(404, 13, 1450, 370);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			panel.add(scrollPane);

			innerPanel = new JPanel();
			innerPanel.setBorder(new EmptyBorder(0, 0, 0, 0));
			innerPanel.setLayout(new FlowLayout(FlowLayout.LEFT, PANEL_GAP, PANEL_GAP));
			innerPanel.setBackground(PrimaryC);
			scrollPane.setViewportView(innerPanel);
			
			panelComponentes = new JPanel();
			panelComponentes.setBackground(SecondaryC);
			panelComponentes.setBounds(344, 198, 332, 152);
			panelComponentes.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			panel.add(panelComponentes);
			
			panelComputadoras = new JPanel();
			panelComputadoras.setVisible(false);
			panelComputadoras.setBackground(SecondaryC);
			panelComputadoras.setBounds(343, 287, 332, 152);
			panelComputadoras.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			panel.add(panelComputadoras);
			panelComputadoras.setLayout(null);
			
			JTextField searchField = new JTextField("");
			searchField.setBackground(hoverEffectColor);
			searchField.setForeground(Color.black);
			searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			RoundedBorder roundedBorder = new RoundedBorder(Color.white, 1, 10);
			EmptyBorder emptyBorder = new EmptyBorder(0, 80, 0, 10);
			CompoundBorder compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);
			searchField.setBorder(compoundBorder);
			
			searchField.setBounds(12, 118, 332, 67);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(8, 6, 55, 55);
			
			ImageIcon originalIcon = new ImageIcon("C://Users//elias//git//Projecto-Final-POO//ProyectoFinalPOO//images//lupa.png");
			int labelWidth = lblNewLabel.getWidth();
			int labelHeight = lblNewLabel.getHeight();
			Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			
			lblNewLabel.setIcon(scaledIcon);
			searchField.add(lblNewLabel);
			panel_1.add(searchField);
			
			
			
			JButton componentesBttn = new JButton("Componentes");
			componentesBttn.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent arg0) {
					pressed = !pressed;
					if ( pressed ) {
						panelComponentes.setVisible(true);
						btnListarComponentes.setVisible(true);
						btnRegComponentes.setVisible(true);
					} else {
						panelComponentes.setVisible(false);
						btnListarComponentes.setVisible(false);
						btnRegComponentes.setVisible(false);
					}
				}
			});
			componentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(hoverEffectColor);
					componentesBttn.setForeground(Color.black);
					
					panelComponentes.setVisible(true);
					btnListarComponentes.setVisible(true);
					btnRegComponentes.setVisible(true);
					
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setForeground(Color.white);
					
					panelComponentes.setVisible(false);
					btnListarComponentes.setVisible(false);
					btnRegComponentes.setVisible(false);
				}
			});
			componentesBttn.setFocusPainted(false);
			componentesBttn.setBackground(ButtonColor);
			componentesBttn.setForeground(Color.white);	
			componentesBttn.setFont(new Font("Tahoma", Font.BOLD, 24));
			componentesBttn.setHorizontalAlignment(SwingConstants.LEADING);
			componentesBttn.setBounds(12, 198, 332, 76);
			componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			panel_1.add(componentesBttn);
			
			btnComputadoras = new JButton("Computadoras");
			btnComputadoras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(hoverEffectColor);
					btnComputadoras.setForeground(Color.black);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(hoverEffectColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					panelComputadoras.setVisible(true);
					btnComprarComponente.setVisible(true);
					btnComprarComputadora.setVisible(true);
				}
				public void mouseExited(MouseEvent arg0) {
					btnComputadoras.setBackground(ButtonColor);
					btnComputadoras.setForeground(Color.white);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					panelComputadoras.setVisible(false);
					btnComprarComponente.setVisible(false);
					btnComprarComputadora.setVisible(false);
				}
			});
			btnComputadoras.setBackground(ButtonColor);
			btnComputadoras.setForeground(Color.white);
			btnComputadoras.setHorizontalAlignment(SwingConstants.LEADING);
			btnComputadoras.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnComputadoras.setBounds(12, 287, 332, 76);
			panel_1.add(btnComputadoras);
			
			
			
			btnAdministracion = new JButton("Administracion");
			btnAdministracion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnAdministracion.setBackground(hoverEffectColor);
					btnAdministracion.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					btnAdministracion.setBackground(ButtonColor);
					btnAdministracion.setForeground(Color.white);
				}
			});
			btnAdministracion.setBackground(ButtonColor);
			btnAdministracion.setForeground(Color.white);
			btnAdministracion.setHorizontalAlignment(SwingConstants.LEADING);
			btnAdministracion.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnAdministracion.setBounds(12, 376, 332, 76);
			panel_1.add(btnAdministracion);
			
			btnCliente = new JButton("Cliente");
			btnCliente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnCliente.setBackground(hoverEffectColor);
					btnCliente.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					btnCliente.setBackground(ButtonColor);
					btnCliente.setForeground(Color.white);
					
				}
			});
			btnCliente.setBackground(ButtonColor);
			btnCliente.setForeground(Color.white);
			btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
			btnCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnCliente.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnCliente.setBounds(12, 465, 332, 76);
			panel_1.add(btnCliente);
			
			bttnOpciones = new JButton("Opciones");
			bttnOpciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnOpciones.setBackground(hoverEffectColor);
					bttnOpciones.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					
					bttnOpciones.setBackground(ButtonColor);
					bttnOpciones.setForeground(Color.white);
				}
			});
			bttnOpciones.setBackground(ButtonColor);
			bttnOpciones.setForeground(Color.white);
			bttnOpciones.setHorizontalAlignment(SwingConstants.LEADING);
			bttnOpciones.setFont(new Font("Tahoma", Font.BOLD, 24));
			bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			bttnOpciones.setBounds(12, 936, 332, 76);
			panel_1.add(bttnOpciones);
			
			JLabel techNexusLabel = new JLabel("TechNexus");
			Image img = new ImageIcon(this.getClass().getResource("/microchip.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			techNexusLabel.setIcon(new ImageIcon(scaledImg));
			techNexusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			techNexusLabel.setFont(new Font("Modern No. 20", Font.BOLD, 38));
			techNexusLabel.setForeground(hoverEffectColor);
			techNexusLabel.setBounds(12, 13, 329, 92);
			panel_1.add(techNexusLabel);
			
			
			

			btnRegComponentes = new JButton("Reg. componentes");
			btnRegComponentes.setFocusPainted(false);
			btnRegComponentes.setBounds(0, 17, 332, 59);
			btnRegComponentes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(hoverEffectColor);
					componentesBttn.setForeground(Color.black);
					btnRegComponentes.setBackground(hoverEffectColor);
					btnRegComponentes.setForeground(Color.black);
					btnRegComponentes.setBorder(BorderFactory.createLineBorder(hoverEffectColor));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setForeground(Color.white);
					btnRegComponentes.setBackground(SecondaryC);
					btnRegComponentes.setForeground(Color.white);
					btnRegComponentes.setBorder(BorderFactory.createLineBorder(SecondaryC));
				}
			});
			panelComponentes.setLayout(null);
			panelComponentes.add(btnRegComponentes);
			btnRegComponentes.setBackground(SecondaryC);
			btnRegComponentes.setForeground(Color.WHITE);
			btnRegComponentes.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnRegComponentes.setBorder(BorderFactory.createLineBorder(SecondaryC));

			btnListarComponentes = new JButton("List. componentes");
			btnListarComponentes.setFocusPainted(false);
			btnListarComponentes.setBounds(0, 76, 332, 59);
			btnListarComponentes.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(hoverEffectColor);
					componentesBttn.setForeground(Color.black);
					btnListarComponentes.setBackground(hoverEffectColor);
					btnListarComponentes.setForeground(Color.black);
					btnListarComponentes.setBorder(BorderFactory.createLineBorder(hoverEffectColor));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setForeground(Color.white);
					btnListarComponentes.setBackground(SecondaryC);
					btnListarComponentes.setForeground(Color.white);
					btnListarComponentes.setBorder(BorderFactory.createLineBorder(SecondaryC));
				}
			});
			panelComponentes.add(btnListarComponentes);
			btnListarComponentes.setBackground(SecondaryC);
			btnListarComponentes.setForeground(Color.WHITE);
			btnListarComponentes.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnListarComponentes.setBorder(BorderFactory.createLineBorder(SecondaryC));
			
			btnComputadoras = new JButton("Computadoras");
			btnComputadoras.setEnabled(false);
			btnComputadoras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(new Color(239, 239, 229));
					btnComputadoras.setForeground(Color.black);
					btnAdministracion.setVisible(false);
					panelComputadoras.setVisible(true);
					btnComprarComponente.setVisible(true);
					btnComprarComputadora.setVisible(true);
				}
				public void mouseExited(MouseEvent arg0) {
					btnComputadoras.setBackground(new Color(26, 101, 158));
					btnComputadoras.setForeground(Color.white);
					btnAdministracion.setVisible(true);
					panelComputadoras.setVisible(false);
					btnComprarComponente.setVisible(false);
					btnComprarComputadora.setVisible(false);
				}
			});
			btnComputadoras.setBackground(new Color(26, 101, 158));
			

			btnComprarComputadora = new JButton("Reg. Computadora");
			btnComprarComputadora.setBounds(0, 17, 332, 59);
			panelComputadoras.add(btnComprarComputadora);
			btnComprarComputadora.setBackground(SecondaryC);
			btnComprarComputadora.setForeground(Color.WHITE);
			btnComprarComputadora.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnComprarComputadora.setBorder(BorderFactory.createLineBorder(SecondaryC));

			btnComprarComponente = new JButton("List. Computadoras");
			btnComprarComponente.setBounds(0, 76, 332, 59);
			panelComputadoras.add(btnComprarComponente);
            btnComprarComponente.setBackground(SecondaryC);
			btnComprarComponente.setForeground(Color.WHITE);
			btnComprarComponente.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnComprarComponente.setBorder(BorderFactory.createLineBorder(SecondaryC));
			
			MouseAdapter mouseAdapterComp = new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        panelComputadoras.setVisible(true);
			        btnComprarComputadora.setVisible(true);
			        btnComprarComponente.setVisible(true);
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			    	if (!panelComputadoras.isShowing() || !btnComprarComponente.isShowing() || !btnComprarComputadora.isShowing()) {
			            // Si ninguno de estos componentes se esta mostrando, no se puede leer la posicion del mouse
			            panelComputadoras.setVisible(false);
			            btnComprarComputadora.setVisible(false);
			            btnComprarComponente.setVisible(false);
			            btnAdministracion.setVisible(true);
			        } else {

				        Point mousePosition = e.getPoint();
				        SwingUtilities.convertPointToScreen(mousePosition, (Component) e.getSource());
				        Point panelCompPosition = panelComputadoras.getLocationOnScreen();
				        Point btnComprarComponentePosition = btnComprarComponente.getLocationOnScreen();
				        Point btnComprarComputadoraPosition = btnComprarComputadora.getLocationOnScreen();

				        if (!isMouseOverComponent(mousePosition, panelCompPosition, panelComputadoras) &&
				            !isMouseOverComponent(mousePosition, btnComprarComponentePosition, btnComprarComponente) &&
				            !isMouseOverComponent(mousePosition, btnComprarComputadoraPosition, btnComprarComputadora)) {
				            panelComputadoras.setVisible(false);
				            btnComprarComputadora.setVisible(false);
				            btnComprarComponente.setVisible(false);
				            btnAdministracion.setVisible(true);
				        }
			        }
			    }
			};

			btnComprarComponente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Point offScreenPoint = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
				        MouseEvent mouseEvent = new MouseEvent(
				            btnComprarComponente, 
				            MouseEvent.MOUSE_EXITED, 
				            System.currentTimeMillis(), 
				            0, 
				            offScreenPoint.x, 
				            offScreenPoint.y, 
				            0, 
				            false
				        );

					mouseAdapterComp.mouseExited(mouseEvent);

					RegComponentes registro = new RegComponentes();
					registro.setModal(true);
					registro.setVisible(true);

				}
			});

			panelComputadoras.addMouseListener(mouseAdapterComp);
			btnComprarComponente.addMouseListener(mouseAdapterComp);
			btnComprarComputadora.addMouseListener(mouseAdapterComp);

			// Clase interna para manejar eventos de mouse
			MouseAdapter mouseAdapter = new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        panelComponentes.setVisible(true);
			        btnListarComponentes.setVisible(true);
			        btnRegComponentes.setVisible(true);
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			    	if (!panelComponentes.isShowing() || !btnRegComponentes.isShowing() || !btnListarComponentes.isShowing()) {
			            // Si ninguno de estos componentes se esta mostrando, no se puede leer la posicion del mouse
			            panelComponentes.setVisible(false);
			            btnListarComponentes.setVisible(false);
			            btnRegComponentes.setVisible(false);
			            btnComputadoras.setVisible(true);
			        } else {
			        	pressed = false;
				        Point mousePosition = e.getPoint();
				        SwingUtilities.convertPointToScreen(mousePosition, (Component) e.getSource());
				        Point panelPosition = panelComponentes.getLocationOnScreen();
				        Point btnRegPosition = btnRegComponentes.getLocationOnScreen();
				        Point btnListarPosition = btnListarComponentes.getLocationOnScreen();
				        
				        if (!isMouseOverComponent(mousePosition, panelPosition, panelComponentes) &&
				            !isMouseOverComponent(mousePosition, btnRegPosition, btnRegComponentes) &&
				            !isMouseOverComponent(mousePosition, btnListarPosition, btnListarComponentes)) {
				            panelComponentes.setVisible(false);
				            btnListarComponentes.setVisible(false);
				            btnRegComponentes.setVisible(false);
				            btnComputadoras.setVisible(true);
				        }
			        }
			    }
			};
			
			btnRegComponentes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					 Point offScreenPoint = new Point(Integer.MIN_VALUE, Integer.MIN_VALUE);
				        MouseEvent mouseEvent = new MouseEvent(
				            btnRegComponentes, 
				            MouseEvent.MOUSE_EXITED, 
				            System.currentTimeMillis(), 
				            0, 
				            offScreenPoint.x, 
				            offScreenPoint.y, 
				            0, 
				            false
				        );
						
					mouseAdapter.mouseExited(mouseEvent);
					
					RegComponentes registro = new RegComponentes();
					registro.setVisible(true);
				
				}
			});
			
			panelComponentes.addMouseListener(mouseAdapter);
			btnRegComponentes.addMouseListener(mouseAdapter);
			btnListarComponentes.addMouseListener(mouseAdapter);

			
			JPanel masCompradosPanel = new JPanel();
			masCompradosPanel.setBackground(PrimaryC);
			masCompradosPanel.setBounds(368, 13, 1523, 370);
			masCompradosPanel.setBorder(new RoundedBorder(PrimaryC, 1, 10));
			masCompradosPanel.setFocusable(true);
			panel.add(masCompradosPanel);
			masCompradosPanel.setLayout(null);
			panelComponentes.setVisible(false);
			btnListarComponentes.setVisible(false);
			btnRegComponentes.setVisible(false);
			
			displayHorizontalList(masCompradosPanel, componentes);
			
			componentes = getMasComprados(0, componentesMasFamosos);
			displayHorizontalList(innerPanel, componentes);

			// Agregar un MouseWheelListener para scroll horizontal
			

			scrollPane.addMouseWheelListener(new MouseWheelListener() {
			    @Override
			    public void mouseWheelMoved(MouseWheelEvent e) {
			        if (scrollTimer != null && scrollTimer.isRunning()) {
			            scrollTimer.stop();
			        }
			        if (inertiaTimer != null && inertiaTimer.isRunning()) {
			            inertiaTimer.stop();
			        }
			        
			        JScrollBar horizontalBar = scrollPane.getHorizontalScrollBar();
			        int delta = e.getWheelRotation() * 90;
			        targetScrollValue = horizontalBar.getValue() + delta;
			        targetScrollValue = Math.max(0, Math.min(targetScrollValue, horizontalBar.getMaximum()));
			        
			        startScrollAnimation(horizontalBar);
			        
			        // Iniciar el timer de inercia
			        lastScrollValue = horizontalBar.getValue();
			        scrollVelocity = delta;
			        startInertiaAnimation(horizontalBar);
			    }
			});
			
			
			/*
			 * Basicamente se iran agregando los paneles con el for, tengo que chequear lo del la posicion del panel,
			 * creo que lo mas eficiente seria crear el panel dentro del for y simplemente agregarlo*/
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(PrimaryC);
			panel_3.setBounds(368, 396, 1523, 644);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			
			
			
			
			

		}
	}
	
	private void startInertiaAnimation(final JScrollBar scrollBar) {
	    ActionListener inertiaAction = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int currentValue = scrollBar.getValue();
	            int diff = currentValue - lastScrollValue;
	            scrollVelocity = (scrollVelocity + diff) / 2; // Promedio para suavizar
	            
	            if (Math.abs(scrollVelocity) > 1) {
	                int newValue = currentValue + scrollVelocity;
	                newValue = Math.max(0, Math.min(newValue, scrollBar.getMaximum()));
	                scrollBar.setValue(newValue);
	                lastScrollValue = currentValue;
	            } else {
	                ((Timer)e.getSource()).stop();
	            }
	            
	            scrollVelocity *= 0.80; // Reducir la velocidad gradualmente
	        }
	    };
	    
	    inertiaTimer = new Timer(12, inertiaAction);
	    inertiaTimer.start();
	}
	
	private void startScrollAnimation(final JScrollBar scrollBar) {
	    ActionListener scrollAction = new ActionListener() {
	        @Override
	        public void actionPerformed(ActionEvent e) {
	            int currentValue = scrollBar.getValue();
	            int diff = targetScrollValue - currentValue;
	            int step = diff / 10; // Ajusta esto para cambiar la suavidad del deslizamiento
	            
	            if (Math.abs(diff) > SCROLL_SPEED) {
	                scrollBar.setValue(currentValue + step);
	            } else {
	                scrollBar.setValue(targetScrollValue);
	                ((Timer)e.getSource()).stop();
	            }
	        }
	    };
	    
	    scrollTimer = new Timer(16, scrollAction); // 16ms maso 60 FPS
	    scrollTimer.start();
	}
	
	private void displayHorizontalList(JPanel panel, ArrayList<JPanel> componentes) {
		innerPanel.removeAll();
	    for (JPanel comp : componentes) {
	        innerPanel.add(comp);
	    }
	    innerPanel.setPreferredSize(new Dimension(componentes.size() * (PANEL_WIDTH + PANEL_GAP), PANEL_HEIGHT));
	    scrollPane.revalidate();
	    scrollPane.repaint();
	}
	
	
	private ArrayList<JPanel> getMasComprados(int ind, ArrayList<Componente> componentesMasFamosos) {
		ArrayList<JPanel> componentes = new ArrayList<>();
				
		
		
		int posX = 10;
		for ( int i = ind; i < componentesMasFamosos.size(); i++ ) {
		//for ( Componente comp : componentesMasFamosos ) {
			JPanel newPanel = new JPanel();
			newPanel.setLayout(null);
			newPanel.setBorder(new RoundedBorder(Color.white, 1, 10));
			newPanel.setBackground(hoverEffectColor);
			newPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			
			componentes.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			JLabel icono = new JLabel();
			
			Image img = null;
			
			if ( componentesMasFamosos.get(i) instanceof MicroProcesador ) {
				img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
			} else if ( componentesMasFamosos.get(i) instanceof Ram ) {
				img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			} else if ( componentesMasFamosos.get(i) instanceof GPU ) {
				img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			} else if ( componentesMasFamosos.get(i) instanceof DiscoDuro ) {
				img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
			} else if ( componentesMasFamosos.get(i) instanceof TarjetaMadre ) {
				img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			}
			
			Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			icono.setIcon(new ImageIcon(scaledImg));
			icono.setBounds(20, 65, 150, 150);
			newPanel.add(icono);
			
			JLabel precioLabel = new JLabel();
			float precio = componentesMasFamosos.get(i).getPrecio();
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(precio)); // costo + "$" costo siendo un .getCosto del componente
			precioLabel.setHorizontalAlignment(SwingConstants.CENTER);
			precioLabel.setBounds(20, 235, 330, 25);
			precioLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
			newPanel.add(precioLabel);
			
			JLabel nombreComponente = new JLabel();
			nombreComponente.setText(componentesMasFamosos.get(i).getMarca() + componentesMasFamosos.get(i).getModelo());
			nombreComponente.setFont(new Font("Century Gothic", Font.BOLD, 25));
			nombreComponente.setBounds(20, 10, 330, 40);
			newPanel.add(nombreComponente);
			
			JTextPane descripcionPane = new JTextPane();
			descripcionPane.setText("Alto rendimiento y eficiencia energética para cargas de trabajo exigentes y multitarea."); 
			descripcionPane.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			descripcionPane.setBackground(Color.white);
			descripcionPane.setForeground(Color.black);
			
			//descripcionPane.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 1, 10), new EmptyBorder(10, 10, 10, 10)));
			//descripcion.setBorder(new EmptyBorder(10, 10, 10, 10));
			descripcionPane.setOpaque(false);
			descripcionPane.setBounds(185, 65, 150, 150);
			descripcionPane.setEditable(false);
			newPanel.add(descripcionPane);
			
			JButton bttnComprar = new JButton();
			bttnComprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnComprar.setBackground(AccentHoverColor);
					bttnComprar.setBorder(new RoundedBorder(new Color(247, 197, 159), 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnComprar.setBackground(AccentColor);
					bttnComprar.setBorder(new RoundedBorder(new Color(255, 149, 94), 1, 10));
				}
			});
			bttnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Este boton funciona", "", JOptionPane.INFORMATION_MESSAGE);
					/*
					 * Elias:
					 * 
					 * Aqui se abrira la ventana de compra del producto seleccionado.
					 * Hay que crear una ventana de compra donde se pueda ingresar el id del cliente
					 * (osea quien va a comprarlo) y que sea posible agregar la cantidad de productos que
					 * se quieran comprar.
					 * */
				}
			});
			bttnComprar.setFocusPainted(false);
			bttnComprar.setText("Compra YA!!");
			bttnComprar.setFont(new Font("Century Gothic", Font.BOLD, 20));
			bttnComprar.setBackground(AccentColor);
			bttnComprar.setForeground(Color.black);
			bttnComprar.setBorder(new RoundedBorder(new Color(255, 149, 94), 1, 10));
			bttnComprar.setBounds(15, 285, 320, 50);
			newPanel.add(bttnComprar);
			
			
		}
		return componentes;
	}
	
	private void cleanPanel(JPanel panel, ArrayList<JPanel> componentes) {
		for ( JPanel comp : componentes ) {
			panel.remove(comp);
		}
	    panel.revalidate();
	    panel.repaint();
	}

	// Método para verificar si el mouse está sobre el componente
	private boolean isMouseOverComponent(Point mousePosition, Point componentPosition, Component component) {
	    Rectangle bounds = new Rectangle(componentPosition, component.getSize());
	    return bounds.contains(mousePosition);
	}
}