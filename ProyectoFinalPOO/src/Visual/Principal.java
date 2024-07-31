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

import Logica.AnimationType;
import Logica.Cliente;
import Logica.Componente;
import Logica.Computadora;
import Logica.DiscoDuro;
import Logica.ErrorType;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.MoveToXY;
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
import javax.sound.midi.SysexMessage;
import javax.swing.ImageIcon;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;

import javax.swing.ScrollPaneConstants;

public class Principal extends JFrame {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	int horizontalListInd = 0;
	private final int PANELS_TO_SHOW = 4;
	private final int PANEL_WIDTH = 350;
	private final int PANEL_HEIGHT = 350;
	private final int PANEL_GAP = 24;
	
	
	private ArrayList<Componente> componentesMasFamosos = new ArrayList<>();
	private ArrayList<Computadora> computadorasMasVendidas = new ArrayList<>();
	
	private ArrayList<JPanel> componentes = new ArrayList<>();
	private ArrayList<JPanel> computadoras = new ArrayList<>();
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
	private JButton regUsuarioBttn;
	private JButton regClienteBttn;
	private JButton listarClientesBttn;
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
	private Timer updateTimer;
	
	private boolean menuCompuAbierto = false;
	private boolean menuCompoAbierto = false;
	private boolean menuAdminAbierto = false;
	private boolean menuClientAbierto = false;
	private JButton btnActualizar;
	private JPanel innerPanel2;
	private JPanel panelAdministracion;
	private JPanel panelClientes;
	private JLabel label;
	private JPanel panel_2;
	private JButton componentesBttn;

	public static Socket sfd;
	public static ObjectOutputStream sld;
	private JButton reporteBtn;
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
		
		componentesMasFamosos = Tienda.getInstance().getListComponentesMasVendidos();
		componentes = makeCompMasCompradosPanels(0, componentesMasFamosos);
		
		computadorasMasVendidas = Tienda.getInstance().getListComputadorasMasVendidas();
		computadoras = makePcMasCompradosPanels(0, computadorasMasVendidas);
		
		Cliente newCliente = new Cliente("C-1", "Elias De La Cruz", "eliasdlc2005@gmail.com", "", "", "");
		Tienda.getInstance().insertarCliente(newCliente);
		
		
		
		dim = getToolkit().getScreenSize();
		setSize(1933, 1080);
		
		/*for (Componente comp : componentesMasFamosos) {
			Tienda.getInstance().insertarComponente(comp);
		}*/
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 1914, 1045);
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
			panelComponentes.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			panel.add(panelComponentes);
			
			panelComputadoras = new JPanel();
			panelComputadoras.setBounds(0, 287, 344, 152);
			MoveToXY panelComputadorasHide = new MoveToXY(panelComputadoras, 0, panelComputadoras.getY(), 0.5f, AnimationType.EASE_OUT);
			MoveToXY panelComputadorasShow = new MoveToXY(panelComputadoras, 332, panelComputadoras.getY(), 0.5f, AnimationType.EASE_IN);
			panelComputadoras.setVisible(false);
			panelComputadoras.setBackground(ButtonColor);
			panelComputadoras.setLayout(null);
			panelComputadoras.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			panel.add(panelComputadoras);
			
			
			panelAdministracion = new JPanel();
			panelAdministracion.setBounds(0, 376, 344, 152);
			MoveToXY panelAdminHide = new MoveToXY(panelAdministracion, 0, panelAdministracion.getY(), 0.5f, AnimationType.EASE_OUT);
			MoveToXY panelAdminShow = new MoveToXY(panelAdministracion, 332, panelAdministracion.getY(), 0.5f, AnimationType.EASE_IN);
			panelAdministracion.setVisible(false);
			panelAdministracion.setBackground(ButtonColor);
			panelAdministracion.setLayout(null);
			panelAdministracion.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			panel.add(panelAdministracion);
			
			panelClientes = new JPanel();
			panelClientes.setBounds(0, 465, 344, 152);
			MoveToXY panelClientesHide = new MoveToXY(panelClientes, 0, panelClientes.getY(), 0.5f, AnimationType.EASE_OUT);
			MoveToXY panelClientesShow = new MoveToXY(panelClientes, 332, panelClientes.getY(), 0.5f, AnimationType.EASE_IN);
			panelClientes.setVisible(false);
			panelClientes.setBackground(ButtonColor);
			panelClientes.setLayout(null);
			panelClientes.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			panel.add(panelClientes);
			
			
			panel.setComponentZOrder(panel_1, 0);
			panel.setComponentZOrder(panelComponentes, 1);
			panel.setComponentZOrder(panelComputadoras, 1);
			panel.setComponentZOrder(panelClientes, 1);
			
			JPanel masCompradosPanel = new JPanel();
			masCompradosPanel.setBackground(PrimaryC);
			masCompradosPanel.setBounds(354, 0, 1574, 1040);
			masCompradosPanel.setFocusable(true);
			panel.add(masCompradosPanel);
			masCompradosPanel.setLayout(null);
			
			
			
			scrollPane = new JScrollPane();
			scrollPane.setBorder(new EmptyBorder(0,0,0,0));
			scrollPane.setBounds(12, 56, 1536, 400);
			scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			masCompradosPanel.add(scrollPane);

			innerPanel = new JPanel();
			innerPanel.setLayout(null);
			innerPanel.setBorder(new EmptyBorder(0,0,0,0));
			innerPanel.setBackground(PrimaryC);
			scrollPane.setViewportView(innerPanel);
			RoundedBorder roundedBorder = new RoundedBorder(Color.white, 1, 20);
			EmptyBorder emptyBorder = new EmptyBorder(0, 80, 0, 10);
			CompoundBorder compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);		
			
			componentesBttn = new JButton("Componentes");
			componentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(HoverEffevtColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
			});
			componentesBttn.setFocusPainted(false);
			componentesBttn.setBackground(ButtonColor);
			componentesBttn.setForeground(Color.white);	
			componentesBttn.setFont(new Font("Tahoma", Font.BOLD, 24));
			componentesBttn.setHorizontalAlignment(SwingConstants.LEADING);
			componentesBttn.setBounds(12, 191, 332, 76);
			componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
			panel_1.add(componentesBttn);
			
			regComponentesBttn = new JButton("Reg. Componente");
			regComponentesBttn.setBounds(24, 0, 320, 76);
			regComponentesBttn.setBackground(ButtonColor);
			regComponentesBttn.setForeground(Color.WHITE);
			regComponentesBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
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
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					regComponentesBttn.setBackground(HoverEffevtColor);
					regComponentesBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setForeground(Color.white);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					regComponentesBttn.setBackground(ButtonColor);
					regComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			panelComponentes.setLayout(null);
			panelComponentes.add(regComponentesBttn);
			

			listarComponentesBttn = new JButton("List. Componente");
			listarComponentesBttn.setBounds(24, 76, 320, 76);
			listarComponentesBttn.setBackground(ButtonColor);
			listarComponentesBttn.setForeground(Color.WHITE);
			listarComponentesBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			listarComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
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
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					listarComponentesBttn.setBackground(HoverEffevtColor);
					listarComponentesBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(ButtonColor);
					componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					listarComponentesBttn.setBackground(ButtonColor);
					listarComponentesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
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
				        abrirMenuComponentes(panelComponentesShow, panelComputadorasHide, panelClientesHide, panelAdminHide);
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
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnComputadoras.setBackground(ButtonColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));

				}
			});
			btnComputadoras.setBackground(ButtonColor);
			btnComputadoras.setFocusPainted(false);
			btnComputadoras.setForeground(Color.white);
			btnComputadoras.setHorizontalAlignment(SwingConstants.LEADING);
			btnComputadoras.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
			btnComputadoras.setBounds(12, 280, 332, 76);
			panel_1.add(btnComputadoras);
			
			regComputadorasBttn = new JButton("Reg. Computadora");
			regComputadorasBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					RegComputadora registro = new RegComputadora();
					registro.setVisible(true);
				}
			});
			regComputadorasBttn.setBounds(24, 0, 320, 76);
			regComputadorasBttn.setBackground(ButtonColor);
			regComputadorasBttn.setForeground(Color.WHITE);
			regComputadorasBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			regComputadorasBttn.setFocusPainted(false);
			regComputadorasBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(HoverEffevtColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					regComputadorasBttn.setBackground(HoverEffevtColor);
					regComputadorasBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					regComputadorasBttn.setBackground(ButtonColor);
					regComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			panelComputadoras.setLayout(null);
			panelComputadoras.add(regComputadorasBttn);
			

			listarComputadorasBttn = new JButton("List. Computadora");
			listarComputadorasBttn.setBounds(24, 76, 320, 76);
			listarComputadorasBttn.setBackground(ButtonColor);
			listarComputadorasBttn.setForeground(Color.WHITE);
			listarComputadorasBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			listarComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
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
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					listarComputadorasBttn.setBackground(HoverEffevtColor);
					listarComputadorasBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					/*btnComputadoras.setBackground(ButtonColor);
					btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));*/
					listarComputadorasBttn.setBackground(ButtonColor);
					listarComputadorasBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
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
						abrirMenuComputadoras(panelComputadorasShow, panelComponentesHide, panelClientesHide, panelAdminHide);
					} else {
						cerrarMenuComputadoras(panelComputadorasHide);
					}
					
				}
			});
			
			
			
			btnAdministracion = new JButton("Administracion");
			btnAdministracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if (Tienda.getInstance().getPermisoAdministrado()) {
						if ( !menuAdminAbierto ) {
							abrirMenuAdmin(panelAdminShow, panelClientesHide, panelComponentesHide, panelComputadorasHide);
						} else {
							cerrarMenuAdmin(panelAdminHide);
						}
					}else {
						PopUpError popUp = new PopUpError("No tienes permiso de administrador para acceder", ErrorType.WARNING, null);
						popUp.setLocationRelativeTo(contentPanel);
						popUp.setVisible(true);
					}
				}
			});
			btnAdministracion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnAdministracion.setBackground(HoverEffevtColor);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnAdministracion.setBackground(ButtonColor);
					btnAdministracion.setForeground(Color.white);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
			});
			btnAdministracion.setBackground(ButtonColor);
			btnAdministracion.setForeground(Color.white);
			btnAdministracion.setHorizontalAlignment(SwingConstants.LEADING);
			btnAdministracion.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
			btnAdministracion.setBounds(12, 369, 332, 76);
			panel_1.add(btnAdministracion);
			

			regUsuarioBttn = new JButton("Reg. Usuario");
			regUsuarioBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						Regusuarios regusuarios = new Regusuarios();
						regusuarios.setVisible(true);
					}
				});
			
			regUsuarioBttn.setBounds(24, 0, 320, 76);
			regUsuarioBttn.setBackground(ButtonColor);
			regUsuarioBttn.setForeground(Color.WHITE);
			regUsuarioBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regUsuarioBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			regUsuarioBttn.setFocusPainted(false);
			regUsuarioBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnAdministracion.setBackground(HoverEffevtColor);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					regUsuarioBttn.setBackground(HoverEffevtColor);
					regUsuarioBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					regUsuarioBttn.setBackground(ButtonColor);
					regUsuarioBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			panelAdministracion.add(regUsuarioBttn);
			
			reporteBtn = new JButton("Rep. Ventas");
			reporteBtn.setBackground(ButtonColor);
			reporteBtn.setForeground(Color.WHITE);
			reporteBtn.setFont(new Font("Tahoma", Font.BOLD, 20));
			reporteBtn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			reporteBtn.setFocusPainted(false);
			reporteBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					btnAdministracion.setBackground(HoverEffevtColor);
					btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					reporteBtn.setBackground(HoverEffevtColor);
					reporteBtn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					reporteBtn.setBackground(ButtonColor);
					reporteBtn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			reporteBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					PopUpReporte reporte = new PopUpReporte();
					reporte.setModal(true);
					reporte.setVisible(true);
				}
			});
			reporteBtn.setBounds(24, 76, 320, 76);
			panelAdministracion.add(reporteBtn);
			
			
			
			btnCliente = new JButton("Cliente");
			btnCliente.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ( !menuClientAbierto ) {
						abrirMenuCliente(panelClientesShow, panelComponentesHide, panelComputadorasHide, panelAdminHide);
					} else {
						cerrarMenuComputadoras(panelClientesHide);
					}
				}
			});
			btnCliente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnCliente.setBackground(HoverEffevtColor);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					btnCliente.setBackground(ButtonColor);
					btnCliente.setForeground(Color.white);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					
				}
			});
			btnCliente.setBackground(ButtonColor);
			btnCliente.setForeground(Color.white);
			btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
			btnCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnCliente.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
			btnCliente.setBounds(12, 458, 332, 76);
			panel_1.add(btnCliente);
			
			regClienteBttn = new JButton("Reg. Cliente");
			regClienteBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
						PopUpRegCliente regCliente = new PopUpRegCliente(null);
						regCliente.setModal(true);
						regCliente.setVisible(true);
					}
				});
			
			regClienteBttn.setBounds(24, 0, 320, 76);
			regClienteBttn.setBackground(ButtonColor);
			regClienteBttn.setForeground(Color.WHITE);
			regClienteBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			regClienteBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			regClienteBttn.setFocusPainted(false);
			regClienteBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnCliente.setBackground(HoverEffevtColor);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					regClienteBttn.setBackground(HoverEffevtColor);
					regClienteBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					regClienteBttn.setBackground(ButtonColor);
					regClienteBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			panelClientes.add(regClienteBttn);
			
			
			listarClientesBttn = new JButton("List. Cliente");
			listarClientesBttn.setBounds(24, 76, 320, 76);
			listarClientesBttn.setBackground(ButtonColor);
			listarClientesBttn.setForeground(Color.WHITE);
			listarClientesBttn.setFont(new Font("Tahoma", Font.BOLD, 20));
			listarClientesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
			listarClientesBttn.setFocusPainted(false);
			listarClientesBttn.addActionListener(new ActionListener() {
			    @Override
			    public void actionPerformed(ActionEvent e) {
			        ListCliente lista = new ListCliente();
			        lista.setModal(true);
			        lista.setVisible(true);
			    }
			});
			listarClientesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnCliente.setBackground(HoverEffevtColor);
					btnCliente.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
					listarClientesBttn.setBackground(HoverEffevtColor);
					listarClientesBttn.setBorder(new RoundedBorder(HoverEffevtColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					listarClientesBttn.setBackground(ButtonColor);
					listarClientesBttn.setBorder(new RoundedBorder(ButtonColor, 1, 20));
				}
			});
			panelClientes.add(listarClientesBttn);
			
			
			bttnOpciones = new JButton("Respaldo");
			bttnOpciones.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				    Socket sfd = null;
				    ObjectOutputStream sld = null;

				    try {
				        sfd = new Socket("127.0.0.1", 7001);
				        sld = new ObjectOutputStream(sfd.getOutputStream());

				        String filePath = "objetos.dat";

				        try (FileInputStream fileInputStream = new FileInputStream(filePath);
				             BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
				             DataOutputStream dataOutputStream = new DataOutputStream(sld)) {

				            dataOutputStream.writeUTF(new File(filePath).getName());
				            dataOutputStream.flush();

				            byte[] buffer = new byte[4096];
				            int bytesRead;
				            while ((bytesRead = bufferedInputStream.read(buffer)) != -1) {
				                dataOutputStream.write(buffer, 0, bytesRead);
				                dataOutputStream.flush(); 
				            }

				            System.out.println("Archivo enviado exitosamente!");

				        } catch (IOException e1) {
				            e1.printStackTrace();
				        }
				    } catch (UnknownHostException uhe) {
				        System.out.println("No se puede acceder al servidor");
				        System.exit(1);
				    } catch (IOException ioe) {
				        System.out.println("1Comunicacion rechazada");
				        System.exit(1);
				    } finally {
				        try {
				            if (sld != null) {
				                sld.close();
				            }
				            if (sfd != null) {
				                sfd.close();
				            }
				        } catch (IOException ioe) {
				            ioe.printStackTrace();
				        }
				    }
				}

			});
			bttnOpciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnOpciones.setBackground(HoverEffevtColor);
					bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(HoverEffevtColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnOpciones.setBackground(ButtonColor);
					bttnOpciones.setForeground(Color.white);
					bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				}
			});
			bttnOpciones.setBackground(ButtonColor);
			bttnOpciones.setForeground(Color.white);
			bttnOpciones.setHorizontalAlignment(SwingConstants.LEADING);
			bttnOpciones.setFont(new Font("Tahoma", Font.BOLD, 24));
			bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
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
			Date fecha = new Date();
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy", new Locale("es", "ES"));
			String fechaFormateada = formatoFecha.format(fecha);
			
			panel_2 = new JPanel();
			panel_2.setBounds(12, 118, 332, 60);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel_2.setBackground(Color.white);
			panel_1.add(panel_2);
			panel_2.setLayout(null);
			
			label = new JLabel("");
			label.setBounds(7, 14, 317, 32);
			panel_2.add(label);
			
			label.setText("Hoy es " + fechaFormateada);
			label.setHorizontalAlignment(SwingConstants.CENTER);
			label.setForeground(Color.black);
			label.setFont(new Font("Century Gothic", Font.PLAIN, 25));
			
			
			JScrollPane scrollPane_1 = new JScrollPane();
			scrollPane_1.setBorder(new EmptyBorder(0,0,0,0));
			scrollPane_1.setBounds(12, 520, 1536, 400);
			scrollPane_1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
			scrollPane_1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER);
			masCompradosPanel.add(scrollPane_1);
			
			innerPanel2 = new JPanel();
			innerPanel2.setLayout(null);
			innerPanel2.setPreferredSize(new Dimension(0, 350));
			innerPanel2.setBorder(new EmptyBorder(0,0,0,0));
			innerPanel2.setBackground(new Color(3, 88, 157));
			scrollPane_1.setViewportView(innerPanel2);
			
			btnActualizar = new JButton("Actualizar");
			btnActualizar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					updateMostFamousComponents();
				}
			});
			btnActualizar.setForeground(Color.WHITE);
			btnActualizar.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnActualizar.setBorder(new CompoundBorder(new RoundedBorder(ButtonBorderColor, 1, 20), new EmptyBorder(0, 10, 0, 10)));
			btnActualizar.setBackground(new Color(42, 145, 230));
			btnActualizar.setBounds(1216, 936, 332, 76);
			masCompradosPanel.add(btnActualizar);
			
			JLabel lblNewLabel_1 = new JLabel("Computadoras Mas Vendidas");
			lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
			lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 32));
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBounds(477, 469, 607, 38);
			masCompradosPanel.add(lblNewLabel_1);
			
			JLabel lblComponentesMasVendidas = new JLabel("Componentes Mas Vendidas");
			lblComponentesMasVendidas.setHorizontalAlignment(SwingConstants.CENTER);
			lblComponentesMasVendidas.setForeground(Color.WHITE);
			lblComponentesMasVendidas.setFont(new Font("Century Gothic", Font.BOLD, 32));
			lblComponentesMasVendidas.setBounds(477, 5, 607, 38);
			masCompradosPanel.add(lblComponentesMasVendidas);
			
			

			// Agregar un MouseWheelListener para scroll horizontal
			

			addScrollWheelListener(scrollPane);
			addScrollWheelListener(scrollPane_1);
			
			componentesMasFamosos = Tienda.getInstance().getListComponentesMasVendidos();
			componentes = makeCompMasCompradosPanels(0, componentesMasFamosos);
			displayHorizontalList(componentes, innerPanel);
			
			computadorasMasVendidas = Tienda.getInstance().getListComputadorasMasVendidas();
			computadoras = makePcMasCompradosPanels(0, computadorasMasVendidas);
			displayHorizontalList(computadoras, innerPanel2);
			
			updateMostFamousComponents();
		}
	}
	
	@Override
    public void dispose() {
        if (updateTimer != null && updateTimer.isRunning()) {
            updateTimer.stop();
        }
        super.dispose();
    }
	
	private void updateMostFamousComponents() {
	    int currentScrollPosition = scrollPane.getHorizontalScrollBar().getValue();

	    componentesMasFamosos = Tienda.getInstance().getListComponentesMasVendidos();
	    componentes = makeCompMasCompradosPanels(0, componentesMasFamosos);
	    displayHorizontalList(componentes, innerPanel);

	    SwingUtilities.invokeLater(() -> {
	        scrollPane.getHorizontalScrollBar().setValue(currentScrollPosition);
	    });
	}
	
	private void addScrollWheelListener(JScrollPane scrollPane) {
	    scrollPane.addMouseWheelListener(new MouseWheelListener() {
	        @Override
	        public void mouseWheelMoved(MouseWheelEvent e) {
	            // Verificar si el mouse está sobre este ScrollPane
	            if (isMouseOverComponent(scrollPane, e.getPoint())) {
	                handleScrollEvent(scrollPane, e);
	            }
	        }
	    });
	}

	private boolean isMouseOverComponent(JScrollPane scrollPane, Point point) {
	    Rectangle bounds = scrollPane.getBounds();
	    Point containerPoint = SwingUtilities.convertPoint(scrollPane, point, scrollPane.getParent());
	    return bounds.contains(containerPoint);
	}

	private void handleScrollEvent(JScrollPane scrollPane, MouseWheelEvent e) {
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
	
	private void abrirMenuAdmin(MoveToXY panelAdminShow, MoveToXY panelClientesHide, MoveToXY panelComputadorasHide, MoveToXY panelComponentesHide) {
		regUsuarioBttn.setVisible(true);
		reporteBtn.setVisible(true);
		panelAdministracion.setVisible(true);
		panelAdminShow.start();
		cerrarMenuCliente(panelClientesHide);
		cerrarMenuComputadoras(panelComputadorasHide);
		cerrarMenuComponentes(panelComponentesHide);
		menuAdminAbierto = true;
		menuCompoAbierto = false;
		menuCompuAbierto = false;
		menuClientAbierto = false;
	}
	
	private void cerrarMenuAdmin(MoveToXY panelAdminHide) {
		menuAdminAbierto = false;
		panelAdminHide.start();
		
		Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelAdministracion.setVisible(false);
            	regUsuarioBttn.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
		
        
	}
	
	private void abrirMenuCliente(MoveToXY panelClientesShow, MoveToXY panelComputadorasHide, MoveToXY panelComponentesHide, MoveToXY panelAdminHide) {
		regClienteBttn.setVisible(true);
		listarClientesBttn.setVisible(true);
		panelClientes.setVisible(true);
		panelClientesShow.start();
		cerrarMenuComputadoras(panelComputadorasHide);
		cerrarMenuComponentes(panelComponentesHide);
		cerrarMenuAdmin(panelAdminHide);
		menuCompoAbierto = false;
		menuCompuAbierto = false;
		menuAdminAbierto = false;
		menuClientAbierto = true;
	}
	
	private void cerrarMenuCliente(MoveToXY panelClientesHide) {
		menuClientAbierto = false;
		panelClientesHide.start();
		
		Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelClientes.setVisible(false);
            	regClienteBttn.setVisible(false);
            	listarClientesBttn.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
		
	}
	
	private void abrirMenuComponentes(MoveToXY panelComponentesShow, MoveToXY panelComputadorasHide, MoveToXY panelClientesHide, MoveToXY panelAdminHide) {
		panelComponentes.setVisible(true);
	    listarComponentesBttn.setVisible(true);
	    regComponentesBttn.setVisible(true);
	    panelComponentesShow.start();
	    cerrarMenuComputadoras(panelComputadorasHide);
	    cerrarMenuCliente(panelClientesHide);
	    cerrarMenuAdmin(panelAdminHide);
	    menuCompoAbierto = true;
	    menuCompuAbierto = false;
	    menuAdminAbierto = false;
	    menuClientAbierto = false;
	}

	private void cerrarMenuComponentes(MoveToXY panelComponentesHide) {
		menuCompoAbierto = false;
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
		
	    
		
	}
	
	private void abrirMenuComputadoras(MoveToXY panelComputadorasShow, MoveToXY panelComponentesHide, MoveToXY panelClientesHide, MoveToXY panelAdminHide) {
	    panelComputadoras.setVisible(true);
	    regComputadorasBttn.setVisible(true);
	    listarComputadorasBttn.setVisible(true);
	    panelComputadorasShow.start();
	    cerrarMenuComponentes(panelComponentesHide);
	    cerrarMenuCliente(panelClientesHide);
	    cerrarMenuAdmin(panelAdminHide);
	    menuCompuAbierto = true;
	    menuCompoAbierto = false;
	    menuAdminAbierto = false;
	    menuClientAbierto = false;
	}

	private void cerrarMenuComputadoras(MoveToXY panelComputadorasHide) {
		menuCompuAbierto = false;
		panelComputadorasHide.start();
	    Timer timer = new Timer(750, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	panelComputadoras.setVisible(false);
        	    regComputadorasBttn.setVisible(false);
        	    listarComputadorasBttn.setVisible(false);
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(false);
        timer.start();
	    
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
	
	private void displayHorizontalList(ArrayList<JPanel> paneles, JPanel innerPanel) {
	    innerPanel.removeAll();
	    for (JPanel comp : paneles) {
	        innerPanel.add(comp);
	    }
	    innerPanel.setPreferredSize(new Dimension(componentes.size() * (PANEL_WIDTH + PANEL_GAP), PANEL_HEIGHT));
	    
	    // Actualizar el panel sin cambiar la posición del scroll
	    innerPanel.revalidate();
	    innerPanel.repaint();
	}
	
	private ArrayList<JPanel> makeCompMasCompradosPanels(int ind, ArrayList<Componente> componentesMasFamosos) {
		ArrayList<JPanel> componentes = new ArrayList<>();
				
		
		
		int posX = PANEL_GAP;
		for ( int i = ind; i < componentesMasFamosos.size(); i++ ) {
			final int[] posXHolder = { posX };
			final int index = i;
			
			Componente comp = componentesMasFamosos.get(i);
			
			JPanel newPanel = new JPanel();			

			newPanel.setLayout(null);
			newPanel.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			newPanel.setBackground(SecondaryC);
			newPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			
			componentes.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			posXHolder[0] = posX;
			JLabel icono = new JLabel();
			icono.setBounds(20, 65, 150, 150);
			Image img = null;
			
			if ( comp instanceof MicroProcesador ) {
				img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
			} else if ( comp instanceof Ram ) {
				img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			} else if ( comp instanceof GPU ) {
				img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			} else if ( comp instanceof DiscoDuro ) {
				img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
			} else if ( comp instanceof TarjetaMadre ) {
				img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			}
			
			Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			icono.setIcon(new ImageIcon(scaledImg));
			
			newPanel.add(icono);
			
			JLabel precioLabel = new JLabel();
			float precio = comp.getPrecio();
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(precio)); // costo + "$" costo siendo un .getCosto del componente
			precioLabel.setHorizontalAlignment(SwingConstants.CENTER);
			precioLabel.setBounds(20, 245, 330, 25);
			precioLabel.setForeground(Color.black);
			precioLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
			newPanel.add(precioLabel);
			
			
			
			JLabel nombreComponente = new JLabel();
			nombreComponente.setHorizontalAlignment(SwingConstants.CENTER);
			nombreComponente.setText(comp.getMarca() + comp.getModelo());
			nombreComponente.setFont(new Font("Century Gothic", Font.BOLD, 25));
			nombreComponente.setBounds(20, 10, 330, 40);
			newPanel.add(nombreComponente);
			
			JTextPane descripcionPane = new JTextPane();
			if (comp instanceof MicroProcesador) {
			    descripcionPane.setText( "Tiene una velocidad de " + ((MicroProcesador) comp).getVelocidad() + "GHz, con " + ((MicroProcesador) comp).getCantNucleo() + " nucleos."
			    		+ " y tiene una conexion de tipo " + ((MicroProcesador) comp).getTipoConexion());
			} else if (comp instanceof Ram) {
			    descripcionPane.setText("Tiene un almacenamiento de " + ((Ram) comp).getMemoria() + " de tipo " + ((Ram) comp).getTipoMemoria());
			} else if (comp instanceof GPU) {
			    descripcionPane.setText("Este es un tipo de GPU " + ((GPU) comp).getTipo().toLowerCase() + ", su velocidad es de " + ((GPU) comp).getVelocidad() + 
			    		"GHz, posee " + ((GPU) comp).getRAM() + "MB" + " de memoria. Su conexion es " + ((GPU) comp).getTipoConexion());
			} else if (comp instanceof DiscoDuro) {
			    descripcionPane.setText("Alamcenamiento de " + ((DiscoDuro) comp).getAlmacenamiento() + ((DiscoDuro) comp).getAlmTipo() + 
			    		" su velocidad de escritura es " + (int)((DiscoDuro) comp).getVelEscritura() + "MB/s" + " y su velocidad de lectura es " + 
			    		(int)((DiscoDuro) comp).getVelLectura() + "MB/s");
			} else if (comp instanceof TarjetaMadre) {
			    descripcionPane.setText("Conexion GPU: " + ((TarjetaMadre) comp).getConectionGPU() + "Conexion Micro Procesador: " + ((TarjetaMadre) comp).getConectionSocket()
			    		+ "Conexion RAM: " + ((TarjetaMadre) comp).getTipoRam());
			} else {
			    descripcionPane.setText("Descripción genérica.");
			}
			descripcionPane.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			descripcionPane.setBackground(Color.white);
			descripcionPane.setForeground(Color.black);
			descripcionPane.setOpaque(false);
			descripcionPane.setBounds(185, 65, 150, 150);
			descripcionPane.setEditable(false);
			newPanel.add(descripcionPane);
			
			JButton bttnComprar = new JButton();
			bttnComprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnComprar.setBackground(AccentHoverColor);
					bttnComprar.setBorder(new RoundedBorder(AccentHoverColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnComprar.setBackground(AccentColor);
					bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 20));
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
			bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 20));
			bttnComprar.setBounds(15, 285, 320, 50);
			newPanel.add(bttnComprar);
			
			JPanel precioPanel = new JPanel();
			precioPanel.setBounds(15, 230, 320, 100);
			precioPanel.setBackground(ThirdC);
			precioPanel.setBorder(new RoundedBorder(ThirdC, 1, 20));
			newPanel.add(precioPanel);
			
		}
		return componentes;
	}
	
	/*private void cleanPanel(JPanel panel, ArrayList<JPanel> componentes) {
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
	}*/
	
	private ArrayList<JPanel> makePcMasCompradosPanels(int ind, ArrayList<Computadora> computadorasMasVendidas) {
		ArrayList<JPanel> computadorasPanels = new ArrayList<>();
				
		
		
		int posX = PANEL_GAP;
		for ( int i = ind; i < computadorasMasVendidas.size(); i++ ) {
			final int[] posXHolder = { posX };
			final int index = i;
			
			JPanel newPanel = new JPanel();			

			newPanel.setLayout(null);
			newPanel.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			newPanel.setBackground(SecondaryC);
			newPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			
			computadorasPanels.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			posXHolder[0] = posX;
			JLabel icono = new JLabel();
			icono.setBounds(20, 65, 150, 150);
			Image img = new ImageIcon(this.getClass().getResource("/ordenador.png")).getImage();;
			Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			icono.setIcon(new ImageIcon(scaledImg));
			
			newPanel.add(icono);
			
			JLabel precioLabel = new JLabel();
			float precio = computadorasMasVendidas.get(i).getPrecio();
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(precio));
			precioLabel.setHorizontalAlignment(SwingConstants.CENTER);
			precioLabel.setBounds(20, 245, 330, 25);
			precioLabel.setForeground(Color.black);
			precioLabel.setFont(new Font("Century Gothic", Font.BOLD, 25));
			newPanel.add(precioLabel);
			
			
			
			JLabel nombreComponente = new JLabel();
			nombreComponente.setHorizontalAlignment(SwingConstants.CENTER);
			nombreComponente.setText(computadorasMasVendidas.get(i).getTipo());
			nombreComponente.setFont(new Font("Century Gothic", Font.BOLD, 25));
			nombreComponente.setBounds(20, 10, 330, 40);
			newPanel.add(nombreComponente);
			
			JTextPane descripcionPane = new JTextPane();
			descripcionPane.setText("Alto rendimiento y eficiencia energética para cargas de trabajo exigentes y multitarea."); 
			descripcionPane.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			descripcionPane.setBackground(Color.white);
			descripcionPane.setForeground(Color.black);
			descripcionPane.setOpaque(false);
			descripcionPane.setBounds(185, 65, 150, 150);
			descripcionPane.setEditable(false);
			newPanel.add(descripcionPane);
			
			JButton bttnComprar = new JButton();
			bttnComprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnComprar.setBackground(AccentHoverColor);
					bttnComprar.setBorder(new RoundedBorder(AccentHoverColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnComprar.setBackground(AccentColor);
					bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 20));
				}
			});
			bttnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					ComprarComputadora comprar = new ComprarComputadora(computadorasMasVendidas.get(index));
					comprar.setVisible(true);
				}
			});
			bttnComprar.setFocusPainted(false);
			bttnComprar.setText("Compra YA!!");
			bttnComprar.setFont(new Font("Century Gothic", Font.BOLD, 20));
			bttnComprar.setBackground(AccentColor);
			bttnComprar.setForeground(Color.white);
			bttnComprar.setBorder(new RoundedBorder(AccentColor, 1, 20));
			bttnComprar.setBounds(15, 285, 320, 50);
			newPanel.add(bttnComprar);
			
			JPanel precioPanel = new JPanel();
			precioPanel.setBounds(15, 230, 320, 100);
			precioPanel.setBackground(ThirdC);
			precioPanel.setBorder(new RoundedBorder(ThirdC, 1, 20));
			newPanel.add(precioPanel);
			
		}
		return computadorasPanels;
	}
}