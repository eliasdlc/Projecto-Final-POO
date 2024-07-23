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

import Logica.AnimationType;
import Logica.Componente;
import Logica.DiscoDuro;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.MoveToXY;
import Logica.PanelHoverEffect;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JFrame;
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
import java.awt.GridLayout;

public class Principal extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	int horizontalListInd = 0;
	private final int PANELS_TO_SHOW = 4;
	private final int PANEL_WIDTH = 350;
	private final int PANEL_HEIGHT = 350;
	private final int PANEL_GAP = 24;
	
	/*
	 * Esto es para probar funcionalidades.
	 * Es temporal!
	 * */
	
	Componente tarjetaMadre = new TarjetaMadre("TM001", "ASUS", "ROG Strix B550-F", 189.99f, 40, 120, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
	Componente cpu = new MicroProcesador("CPU001", "Intel", "Core i7-11700K", 329.99f, 50, 150, 3.6f, "LGA1200", 8);
	Componente memoria = new Ram("RAM001", "Corsair", "Vengeance LPX", 79.99f, 100, 300, "16GB", "DDR4");
	Componente tarjetaGrafica = new GPU("GPU001", "NVIDIA", "GeForce RTX 3070", 499.99f, 30, 200, "Dedicada", 8.0f, 1.73f, "PCIe 4.0");
	Componente disco = new DiscoDuro("HDD001", "Western Digital", "Blue", 59.99f, 80, 250, 1000.0f, 150.0f, 130.0f, "HDD", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
	Componente cpu2 = new MicroProcesador("CPU002", "AMD", "Ryzen 7 5800X", 399.99f, 60, 180, 3.8f, "AM4", 8);
	Componente memoria2 = new Ram("RAM002", "G.Skill", "Trident Z RGB", 129.99f, 75, 250, "32GB", "DDR4");
	Componente tarjetaGrafica2 = new GPU("GPU002", "AMD", "Radeon RX 6800 XT", 649.99f, 25, 150, "Dedicada", 16.0f, 2.25f, "PCIe 4.0");
	Componente disco2 = new DiscoDuro("SSD001", "Samsung", "970 EVO Plus", 129.99f, 100, 300, 1000.0f, 3500.0f, 3300.0f, "SSD", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
	Componente tarjetaMadre2 = new TarjetaMadre("TM002", "MSI", "MPG B550 Gaming Edge WiFi", 169.99f, 35, 140, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe", "PCIe 4.0")));
	private ArrayList<Componente> componentesMasFamosos = new ArrayList<>(Arrays.asList(cpu, memoria, tarjetaMadre, cpu2, tarjetaGrafica, disco, memoria2, tarjetaGrafica2, disco2, tarjetaMadre2));
	
	//
	
	private ArrayList<JPanel> componentes = getMasComprados(0, componentesMasFamosos);
	private JPanel panelComponentes;
	private JButton listarComponentesBttn;
	private JButton regComponentesBttn;
	private JButton btnComputadoras;
	private JButton btnAdministracion;
	private JButton btnCliente;
	private JButton bttnOpciones;
	private JPanel panelComputadoras;
	private JButton regComputadorasBttn;
	private JButton listarComputadorasBttn;
	boolean pressed = false;
	
	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(213, 234, 255);
	private static final Color ThirdC = new Color(247, 251, 255);
	private static final Color AccentColor = new Color(247, 109, 71); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 136, 73);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(42, 145, 230);
	private static final Color ButtonBorderColor = new Color(42, 145, 230);
	private static final Color HoverEffevtColor = new Color(71, 168, 247);
	
	private JScrollPane scrollPane;
	private JPanel innerPanel;
	private Timer scrollTimer;
	private int targetScrollValue;
	private static final int SCROLL_SPEED = 25;
	private Timer inertiaTimer;
	private int lastScrollValue;
	private int scrollVelocity;
	
	private boolean menuCompuAbierto = false;
	private boolean menuCompoAbierto = false;
	private boolean menuAdminAbierto = false;
	private boolean menuClientAbierto = false;
	private boolean menuOpcAbierto = false;

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
		
		Tienda.getInstance().setMisComponentes(componentesMasFamosos);
		
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
			panel_1.setBackground(SecondaryC);
			panel_1.setBounds(0, 0, 356, 1040);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			panelComponentes = new JPanel();
			panelComponentes.setBounds(0, 198, 344, 152);
			MoveToXY panelComponentesHide = new MoveToXY(panelComponentes, 0, panelComponentes.getY(), 0.5f, AnimationType.EASE_OUT);
			MoveToXY panelComponentesShow = new MoveToXY(panelComponentes, 332, panelComponentes.getY(), 0.5f, AnimationType.EASE_IN);
			panelComponentes.setBackground(ButtonColor);
			panelComponentes.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			panel.add(panelComponentes);
			
			panelComputadoras = new JPanel();
			panelComputadoras.setBounds(0, 287, 344, 152);
			MoveToXY panelComputadorasHide = new MoveToXY(panelComputadoras, 0, panelComputadoras.getY(), 0.5f, AnimationType.EASE_OUT);
			MoveToXY panelComputadorasShow = new MoveToXY(panelComputadoras, 332, panelComputadoras.getY(), 0.5f, AnimationType.EASE_IN);
			panelComputadoras.setVisible(false);
			panelComputadoras.setBackground(ButtonColor);
			panelComputadoras.setLayout(null);
			panelComputadoras.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			panel.add(panelComputadoras);
			
			
			panel.setComponentZOrder(panel_1, 0);
			panel.setComponentZOrder(panelComponentes, 1);
			panel.setComponentZOrder(panelComputadoras, 1);
			
			JPanel masCompradosPanel = new JPanel();
			masCompradosPanel.setBackground(PrimaryC);
			masCompradosPanel.setBounds(354, 0, 1560, 1040);
			masCompradosPanel.setBorder(new RoundedBorder(PrimaryC, 1, 10));
			masCompradosPanel.setFocusable(true);
			panel.add(masCompradosPanel);
			masCompradosPanel.setLayout(null);
			
			/*JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 12, 1536, 374);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 10));
			panel_2.setBackground(Color.white);
			masCompradosPanel.add(panel_2);*/
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new RoundedBorder(Color.white, 1, 10));
			scrollPane.setBounds(12, 12, 1536, 400);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			masCompradosPanel.add(scrollPane);

			innerPanel = new JPanel();
			innerPanel.setBorder(new RoundedBorder(PrimaryC, 1, 10));
			innerPanel.setBackground(PrimaryC);
			scrollPane.setViewportView(innerPanel);
			
			
			
			JTextField searchField = new JTextField("");
			searchField.setBackground(ThirdC);
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
			componentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(HoverEffevtColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
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
			
			regComponentesBttn = new JButton("Reg. Componente");
			regComponentesBttn.setBounds(24, 0, 320, 76);
			regComponentesBttn.setBackground(ButtonColor);
			regComponentesBttn.setForeground(Color.WHITE);
			regComponentesBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			regComponentesBttn.setFocusPainted(false);
			regComponentesBttn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        RegComponentes registro = new RegComponentes();
			        registro.setVisible(true);
			        cerrarMenuComponentes(panelComponentesHide);
			    }
			});
			regComponentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(HoverEffevtColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					regComponentesBttn.setBackground(HoverEffevtColor);
					regComponentesBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setForeground(Color.white);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					regComponentesBttn.setBackground(ButtonColor);
					regComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
				}
			});
			panelComponentes.setLayout(null);
			panelComponentes.add(regComponentesBttn);
			

			listarComponentesBttn = new JButton("List. Componente");
			listarComponentesBttn.setBounds(24, 76, 320, 76);
			listarComponentesBttn.setBackground(ButtonColor);
			listarComponentesBttn.setForeground(Color.WHITE);
			listarComponentesBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			listarComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			listarComponentesBttn.setFocusPainted(false);
			listarComponentesBttn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        ListComponentes listado = new ListComponentes();
			        listado.setVisible(true);
			        cerrarMenuComponentes(panelComponentesHide);
			    }
			});
			listarComponentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(HoverEffevtColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					listarComponentesBttn.setBackground(HoverEffevtColor);
					listarComponentesBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					listarComponentesBttn.setBackground(ButtonColor);
					listarComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
				}
			});
			panelComponentes.add(listarComponentesBttn);
			
			panelComponentes.setVisible(false);
		    regComponentesBttn.setVisible(false);
		    listarComponentesBttn.setVisible(false);
						
			componentesBttn.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if ( !menuCompoAbierto ) {
						// Abrir el menu
				        abrirMenuComponentes(panelComponentesShow, panelComputadorasHide);
					} else {
						cerrarMenuComponentes(panelComponentesHide);
					}
					
				}
			});
			
			btnComputadoras = new JButton("Computadoras");
			btnComputadoras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(HoverEffevtColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnComputadoras.setBackground(ButtonColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));

				}
			});
			btnComputadoras.setBackground(ButtonColor);
			btnComputadoras.setFocusPainted(false);
			btnComputadoras.setForeground(Color.white);
			btnComputadoras.setHorizontalAlignment(SwingConstants.LEADING);
			btnComputadoras.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnComputadoras.setBounds(12, 287, 332, 76);
			panel_1.add(btnComputadoras);
			
			regComputadorasBttn = new JButton("Reg. Computadora");
			regComputadorasBttn.setBounds(24, 0, 320, 76);
			regComputadorasBttn.setBackground(ButtonColor);
			regComputadorasBttn.setForeground(Color.WHITE);
			regComputadorasBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			regComputadorasBttn.setFocusPainted(false);
			/*regComputadorasBttn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        // Abrir la ventana de registro de computadoras
			        RegComputadora regComputadora = new RegComputadora();
			        regComputadora.setVisible(true);
			        // Opcional: cerrar el menú después de abrir la ventana
			        cerrarMenuComputadoras();
			    }
			});*/
			regComputadorasBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(HoverEffevtColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					regComputadorasBttn.setBackground(HoverEffevtColor);
					regComputadorasBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					regComputadorasBttn.setBackground(ButtonColor);
					regComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
				}
			});
			panelComputadoras.setLayout(null);
			panelComputadoras.add(regComputadorasBttn);
			

			listarComputadorasBttn = new JButton("List. Computadora");
			listarComputadorasBttn.setBounds(24, 76, 320, 76);
			listarComputadorasBttn.setBackground(ButtonColor);
			listarComputadorasBttn.setForeground(Color.WHITE);
			listarComputadorasBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			listarComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
			listarComputadorasBttn.setFocusPainted(false);
			listarComputadorasBttn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        ListComputadoras listComputadoras = new ListComputadoras();
			        listComputadoras.setVisible(true);
			        cerrarMenuComputadoras(panelComponentesHide);
			    }
			});
			listarComputadorasBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(HoverEffevtColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					listarComputadorasBttn.setBackground(HoverEffevtColor);
					listarComputadorasBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					/*btnComputadoras.setBackground(ButtonColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));*/
					listarComputadorasBttn.setBackground(ButtonColor);
					listarComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 10));
				}
			});
			panelComputadoras.add(listarComputadorasBttn);

			panelComputadoras.setVisible(false);
			regComputadorasBttn.setVisible(false);
		    listarComputadorasBttn.setVisible(false);
			
			btnComputadoras.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					if ( !menuCompuAbierto ) {
						// Abrir el menu
						abrirMenuComputadoras(panelComputadorasShow, panelComponentesHide);
					} else {
						cerrarMenuComputadoras(panelComputadorasHide);
					}
					
				}
			});
			
			
			
			btnAdministracion = new JButton("Administracion");
			btnAdministracion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnAdministracion.setBackground(HoverEffevtColor);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnAdministracion.setBackground(ButtonColor);
					btnAdministracion.setForeground(Color.white);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
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
					btnCliente.setBackground(HoverEffevtColor);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnCliente.setBackground(ButtonColor);
					btnCliente.setForeground(Color.white);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
					
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
					bttnOpciones.setBackground(HoverEffevtColor);
					bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnOpciones.setBackground(ButtonColor);
					bttnOpciones.setForeground(Color.white);
					bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				}
			});
			bttnOpciones.setBackground(ButtonColor);
			bttnOpciones.setForeground(Color.white);
			bttnOpciones.setHorizontalAlignment(SwingConstants.LEADING);
			bttnOpciones.setFont(new Font("Tahoma", Font.BOLD, 24));
			bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 10), new EmptyBorder(0, 10, 0, 10)));
			bttnOpciones.setBounds(12, 936, 332, 76);
			panel_1.add(bttnOpciones);
			
			JLabel techNexusLabel = new JLabel("Tech Nexus");
			/*Image img = new ImageIcon(this.getClass().getResource("/microchip.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			techNexusLabel.setIcon(new ImageIcon(scaledImg));*/
			techNexusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			techNexusLabel.setFont(new Font("Modern No. 20", Font.BOLD, 38));
			techNexusLabel.setForeground(PrimaryC);
			techNexusLabel.setBounds(12, 13, 329, 92);
			panel_1.add(techNexusLabel);
		
			
			
			displayHorizontalList(masCompradosPanel, componentes);
			
			componentes = getMasComprados(0, componentesMasFamosos);
			displayHorizontalList(innerPanel, componentes);
			innerPanel.setLayout(null);
			
			

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
			
			/*JPanel panel_3 = new JPanel();
			panel_3.setBackground(PrimaryC);
			panel_3.setBounds(368, 429, 1523, 611);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));*/
			
			
			
			
			
			

		}
	}
	
	private void abrirMenuComponentes(MoveToXY panelComponentesShow, MoveToXY panelComputadorasHide) {
		panelComponentes.setVisible(true);
	    listarComponentesBttn.setVisible(true);
	    regComponentesBttn.setVisible(true);
	    panelComponentesShow.start();
	    panelComputadorasHide.start();
	    menuCompoAbierto = true;
	    menuCompuAbierto = false;
	}

	private void cerrarMenuComponentes(MoveToXY panelComponentesHide) {
		panelComponentesHide.start();
		
		Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelComponentes.setVisible(false);
        	    regComponentesBttn.setVisible(false);
        	    listarComponentesBttn.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
		
	    
		menuCompoAbierto = false;
	}
	
	private void abrirMenuComputadoras(MoveToXY panelComputadorasShow, MoveToXY panelComponentesHide) {
	    panelComputadoras.setVisible(true);
	    regComponentesBttn.setVisible(true);
	    listarComponentesBttn.setVisible(true);
	    panelComputadorasShow.start();
	    panelComponentesHide.start();
	    menuCompuAbierto = true;
	    menuCompoAbierto = false;
	}

	private void cerrarMenuComputadoras(MoveToXY panelComputadorasHide) {
	    panelComputadorasHide.start();
	    Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelComputadoras.setVisible(false);
        	    regComponentesBttn.setVisible(false);
        	    listarComponentesBttn.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
	    menuCompuAbierto = false;
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
				
		
		
		int posX = PANEL_GAP;
		for ( int i = ind; i < componentesMasFamosos.size(); i++ ) {
			final int[] posXHolder = { posX };
			final int index = i;
			
			JPanel newPanel = new JPanel();			

			newPanel.setLayout(null);
			newPanel.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			newPanel.setBackground(SecondaryC);
			newPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			
			componentes.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			posXHolder[0] = posX;
			JLabel icono = new JLabel();
			icono.setBounds(20, 65, 150, 150);
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
			
			newPanel.add(icono);
			
			JLabel precioLabel = new JLabel();
			float precio = componentesMasFamosos.get(i).getPrecio();
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(precio)); // costo + "$" costo siendo un .getCosto del componente
			precioLabel.setHorizontalAlignment(SwingConstants.CENTER);
			precioLabel.setBounds(20, 245, 330, 25);
			precioLabel.setForeground(Color.black);
			precioLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
			newPanel.add(precioLabel);
			
			
			
			JLabel nombreComponente = new JLabel();
			nombreComponente.setHorizontalAlignment(SwingConstants.CENTER);
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
					bttnComprar.setBorder(new RoundedBorder(AccentHoverColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnComprar.setBackground(AccentColor);
					bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 10));
				}
			});
			bttnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ComprarComponente comprar = new ComprarComponente(componentesMasFamosos.get(index), Tienda.getInstance().getMisComponentes().get(1));
					comprar.setVisible(true);
				}
			});
			bttnComprar.setFocusPainted(false);
			bttnComprar.setText("Compra YA!!");
			bttnComprar.setFont(new Font("Century Gothic", Font.BOLD, 20));
			bttnComprar.setBackground(AccentColor);
			bttnComprar.setForeground(Color.white);
			bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 10));
			bttnComprar.setBounds(15, 285, 320, 50);
			newPanel.add(bttnComprar);
			
			JPanel precioPanel = new JPanel();
			precioPanel.setBounds(15, 230, 320, 100);
			precioPanel.setBackground(ThirdC);
			precioPanel.setBorder(new RoundedBorder(ThirdC, 1, 10));
			newPanel.add(precioPanel);
			
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