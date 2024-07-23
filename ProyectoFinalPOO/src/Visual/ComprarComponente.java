package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Logica.AnimationType;
import Logica.Cliente;
import Logica.Componente;
import Logica.DiscoDuro;
import Logica.ErrorType;
import Logica.Factura;
import Logica.FacturaComponente;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.MoveToXY;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;
import Logica.WindowResizer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.SwingConstants;

public class ComprarComponente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
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
	private JTextField idTextField;
	
	private Componente componenteElegido;
	private Componente componenteASeleccinar;
	private Componente componenteSeleccionado;

	private Timer timer;
	Cliente cliente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComprarComponente dialog = new ComprarComponente(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComprarComponente(Componente componente1, Componente componente2) {
		componenteSeleccionado = componente1;
		componenteASeleccinar = componente2;
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComprarComponente.class.getResource("/carrito.png")));
		setTitle("Comprar Componente");
		setResizable(false);
		setBounds(100, 100, 873, 691); //873 original width
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		componenteElegido = componente1;
		
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 1388, 644);
			contentPanel.add(panel);
			panel.setLayout(null);
			{
				JPanel panelIngresarCliente = new JPanel();
				panelIngresarCliente.setBackground(PrimaryC);
				panelIngresarCliente.setBounds(0, 0, 323, 644);
				panel.add(panelIngresarCliente);
				panelIngresarCliente.setLayout(null);
				{
					JLabel clientIcon = new JLabel("");
					clientIcon.setBounds(44, 29, 235, 235);
					Image img = new ImageIcon(this.getClass().getResource("/cliente.png")).getImage();
					Image scaledImg = img.getScaledInstance(clientIcon.getHeight(), clientIcon.getWidth(), Image.SCALE_SMOOTH);
					clientIcon.setIcon(new ImageIcon(scaledImg));
					panelIngresarCliente.add(clientIcon);
				}
				
				JLabel nombreLabel = new JLabel("Nombre");
				nombreLabel.setVisible(false);
				nombreLabel.setForeground(Color.WHITE);
				nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
				nombreLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
				nombreLabel.setBounds(12, 395, 299, 39);
				panelIngresarCliente.add(nombreLabel);
				
				JLabel nombreText = new JLabel("nombre del nombre");
				nombreText.setVisible(false);
				nombreText.setHorizontalAlignment(SwingConstants.CENTER);
				nombreText.setForeground(Color.WHITE);
				nombreText.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				nombreText.setBounds(12, 429, 299, 39);
				panelIngresarCliente.add(nombreText);
				
				JLabel CorreoLabel = new JLabel("Correo");
				CorreoLabel.setVisible(false);
				CorreoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				CorreoLabel.setForeground(Color.WHITE);
				CorreoLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
				CorreoLabel.setBounds(12, 481, 299, 39);
				panelIngresarCliente.add(CorreoLabel);
				
				JLabel correoText = new JLabel("usuario123@gmail.com");
				correoText.setVisible(false);
				correoText.setHorizontalAlignment(SwingConstants.CENTER);
				correoText.setForeground(Color.WHITE);
				correoText.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				correoText.setBounds(12, 515, 299, 39);
				panelIngresarCliente.add(correoText);
				
				idTextField = new JTextField();
				idTextField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				idTextField.setBounds(44, 291, 235, 39);
				idTextField.setBorder(new CompoundBorder(new RoundedBorder(Color.WHITE, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				idTextField.setBackground(Color.WHITE);
				panelIngresarCliente.add(idTextField);
				idTextField.setColumns(10);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id = idTextField.getText();
						cliente = Tienda.getInstance().searchClienteById(id);
						
						if ( cliente != null ) {
							nombreText.setText(cliente.getNombre());
							correoText.setText(cliente.getCorreo());
							
							nombreLabel.setVisible(true);
							nombreText.setVisible(true);
							CorreoLabel.setVisible(true);
							correoText.setVisible(true);
						} else if ( cliente == null ) {
							PopUpError popUp = new PopUpError("El usuario no fue encontrado, desea crear uno nuevo?", ErrorType.CLIENT_MISSING);
							popUp.setLocationRelativeTo(contentPanel);
							popUp.setVisible(true);
						}
					}
				});
				btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
				btnNewButton.setBounds(91, 343, 141, 39);
				btnNewButton.setBorder(new RoundedBorder(Color.WHITE, 1, 10));
				btnNewButton.setBackground(Color.WHITE);
				panelIngresarCliente.add(btnNewButton);
				
				
			}
			
				JButton elegirBttn1 = new JButton("Elegir");
                elegirBttn1.setVisible(false);
				elegirBttn1.setBounds(348, 708, 483, 55);
				MoveToXY elegirBttn1Hide = new MoveToXY(elegirBttn1, elegirBttn1.getX(), 708, 0.8f, AnimationType.EASE_IN_OUT);
				MoveToXY elegirBttn1Show = new MoveToXY(elegirBttn1, elegirBttn1.getX(), 508, 0.8f, AnimationType.EASE_IN);
				elegirBttn1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						elegirBttn1.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						elegirBttn1.setBackground(hoverEffectColor);
						elegirBttn1.setForeground(Color.WHITE);
					}
					public void mouseExited(MouseEvent arg0) {
						elegirBttn1.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						elegirBttn1.setBackground(SecondaryC);
						elegirBttn1.setForeground(Color.WHITE);
					}
				});
				elegirBttn1.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				elegirBttn1.setBackground(SecondaryC);
				elegirBttn1.setForeground(Color.WHITE);
				elegirBttn1.setFont(new Font("Century Gothic", Font.BOLD, 18));
				
				panel.add(elegirBttn1);
			
			JLabel lblNewLabel = new JLabel("Intel Core i7-14700K");
			lblNewLabel.setText(componenteElegido.getMarca() + " " + componenteElegido.getModelo());
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			lblNewLabel.setBounds(348, 266, 436, 55);
			panel.add(lblNewLabel);
			
			JLabel precioLabel = new JLabel("$159.99");
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(componenteElegido.getPrecio()));
			precioLabel.setForeground(Color.BLACK);
			precioLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			precioLabel.setBounds(348, 311, 125, 41);
			panel.add(precioLabel);
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(335, 13, 508, 245);
			panel_1.setBorder(new RoundedBorder(Color.white, 1, 10));
			panel_1.setBackground(new Color(240, 240, 240));
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel componenteIcon1 = new JLabel("");
			componenteIcon1.setBounds(144, 13, 220, 220);
			Image img = null;
			
			if ( componenteElegido instanceof MicroProcesador ) {
				img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
			} else if ( componenteElegido instanceof Ram ) {
				img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			} else if ( componenteElegido instanceof GPU ) {
				img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			} else if ( componenteElegido instanceof DiscoDuro ) {
				img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
			} else if ( componenteElegido instanceof TarjetaMadre ) {
				img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			}
			
			Image scaledImg = img.getScaledInstance(componenteIcon1.getHeight(), componenteIcon1.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon1.setIcon(new ImageIcon(scaledImg));
			panel_1.add(componenteIcon1);
			
			JTextPane textPaneComp1 = new JTextPane();
			textPaneComp1.setBounds(-150, 365, 483, 130);
			MoveToXY textPaneComp1Hide = new MoveToXY(textPaneComp1, -150, textPaneComp1.getY(), 0.8f, AnimationType.EASE_OUT);
			MoveToXY textPaneComp1Show = new MoveToXY(textPaneComp1, 348, textPaneComp1.getY(), 0.8f, AnimationType.EASE_IN);
			textPaneComp1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			textPaneComp1.setOpaque(false);
			panel.add(textPaneComp1);
			
			
			
			
			JPanel componente1Panel = new JPanel();
			componente1Panel.setBackground(Color.WHITE);
			componente1Panel.setBounds(323, 0, 532, 644);
			panel.add(componente1Panel);
			componente1Panel.setLayout(null);
			
			JLabel disponible1Label = new JLabel("Disponibles:");
			disponible1Label.setFont(new Font("Century Gothic", Font.BOLD, 24));
			disponible1Label.setBounds(24, 353, 152, 41);
			componente1Panel.add(disponible1Label);
			
			JLabel cantDisponibles1Label = new JLabel("");
			cantDisponibles1Label.setBorder(new EmptyBorder(0, 10, 0, 10));
			cantDisponibles1Label.setHorizontalAlignment(SwingConstants.TRAILING);
			cantDisponibles1Label.setText(NumberFormat.getNumberInstance().format(componenteElegido.getCantDisponible()));
			cantDisponibles1Label.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			cantDisponibles1Label.setBounds(188, 353, 122, 41);
			componente1Panel.add(cantDisponibles1Label);
			
			
			JButton comprarBttn = new JButton("Comprar");
			comprarBttn.setBounds(24, 440, 483, 55);
			componente1Panel.add(comprarBttn);
			
			MoveToXY comprarBttnHide = new MoveToXY(comprarBttn, -500, comprarBttn.getY(), 0.8f, AnimationType.EASE_OUT);
			MoveToXY comprarBttnShow = new MoveToXY(comprarBttn, 24, comprarBttn.getY(), 0.8f, AnimationType.EASE_IN);
			comprarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					comprarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
					comprarBttn.setBackground(hoverEffectColor);
					comprarBttn.setForeground(Color.WHITE);
				}
				public void mouseExited(MouseEvent arg0) {
					comprarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					comprarBttn.setBackground(SecondaryC);
					comprarBttn.setForeground(Color.WHITE);
				}
			});
			comprarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			comprarBttn.setBackground(SecondaryC);
			comprarBttn.setForeground(Color.WHITE);
			comprarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			
				JButton compararBttn = new JButton("Comparar");
				compararBttn.setBounds(24, 508, 483, 55);
				componente1Panel.add(compararBttn);
				MoveToXY compararBttnHide = new MoveToXY(compararBttn, -500, compararBttn.getY(), 0.8f, AnimationType.EASE_OUT);
				MoveToXY compararBttnShow = new MoveToXY(compararBttn, 24, compararBttn.getY(), 0.8f, AnimationType.EASE_IN);
				compararBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						compararBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						//compararBttn.setBackground(new Color(248, 248, 248));
						compararBttn.setForeground(hoverEffectColor);
						compararBttn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						compararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						compararBttn.setForeground(SecondaryC);
						compararBttn.setOpaque(false);
					}
				});
				compararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				compararBttn.setForeground(SecondaryC);
				compararBttn.setBackground(new Color(248, 248, 248));
				compararBttn.setOpaque(false);
				compararBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				
				
				{
					JButton cancelarBttn = new JButton("Cancelar");
					cancelarBttn.setBounds(24, 576, 483, 55);
					componente1Panel.add(cancelarBttn);
					cancelarBttn.addActionListener(new ActionListener() {
						public void actionPerformed(ActionEvent arg0) {
							dispose();
						}
					});
					cancelarBttn.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent e) {
							cancelarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
							//compararBttn.setBackground(new Color(248, 248, 248));
							cancelarBttn.setForeground(hoverEffectColor);
							cancelarBttn.setOpaque(true);
						}
						public void mouseExited(MouseEvent e) {
							cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
							cancelarBttn.setForeground(SecondaryC);
							cancelarBttn.setOpaque(false);
						}
					});
					cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					cancelarBttn.setForeground(SecondaryC);
					cancelarBttn.setBackground(new Color(248, 248, 248));
					cancelarBttn.setOpaque(false);
					cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				}
				
				JSpinner cantComponentesSpn = new JSpinner();
				cantComponentesSpn.setBounds(355, 355, 152, 41);
				componente1Panel.add(cantComponentesSpn);
				MoveToXY cantComponentesSpnHide = new MoveToXY(cantComponentesSpn, -200, cantComponentesSpn.getY(), 0.8f, AnimationType.EASE_OUT);
				MoveToXY cantComponentesSpnShow = new MoveToXY(cantComponentesSpn, 355, cantComponentesSpn.getY(), 0.8f, AnimationType.EASE_IN);
				cantComponentesSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				
				
				
				comprarBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						if ( cliente != null ) {
							Tienda.getInstance();
							int[] cantArticulos = {Integer.parseInt(cantComponentesSpn.getValue().toString())};
							Factura newFactura = new FacturaComponente(cliente.getId(), "C-" + Tienda.getCodFactura(), 
									componenteElegido.getPrecio(), cantArticulos, new ArrayList<Componente>(Arrays.asList(componenteElegido)));
							
							Tienda.getInstance().insertarFactura(newFactura);
							cliente.addFactura(newFactura);
							dispose();
						} else if ( cliente == null ) {
							PopUpError popUp = new PopUpError("Debe ingresar un cliente antes de realizar la compra!", ErrorType.WARNING);
							popUp.setLocationRelativeTo(contentPanel);
							popUp.setVisible(true);
							
						}
					}
				});
				
			
			JPanel componente2Panel = new JPanel();
			componente2Panel.setVisible(false);
			componente2Panel.setBounds(323, 0, 532, 644);
			MoveToXY componente2PanelShow = new MoveToXY(componente2Panel, 855, componente2Panel.getY(), 0.8f, AnimationType.EASE_IN);
			MoveToXY componente2PanelHide = new MoveToXY(componente2Panel, 323, componente2Panel.getY(), 0.8f, AnimationType.EASE_OUT);
			panel.add(componente2Panel);
			componente2Panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 13, 508, 245);
			panel_2.setLayout(null);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 10));
			panel_2.setBackground(Color.WHITE);
			
			componente2Panel.add(panel_2);
			
			
			JLabel componenteIcon2 = new JLabel("");
			componenteIcon2.setBounds(144, 12, 220, 220);
			Image img2 = null;
			
			if ( componente2 instanceof MicroProcesador ) {
				img2 = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
			} else if ( componente2 instanceof Ram ) {
				img2 = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			} else if ( componente2 instanceof GPU ) {
				img2 = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			} else if ( componente2 instanceof DiscoDuro ) {
				img2 = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
			} else if ( componente2 instanceof TarjetaMadre ) {
				img2 = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			}
			
			Image scaledImg2 = img2.getScaledInstance(componenteIcon2.getHeight(), componenteIcon2.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon2.setIcon(new ImageIcon(scaledImg2));
			panel_2.add(componenteIcon2);
			
			compararBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					componente2Panel.setVisible(true);
					elegirBttn1.setVisible(true);
					
					textPaneComp1Show.start();
					componente2PanelShow.start();
					cantComponentesSpnHide.start();
					comprarBttnHide.start();
					elegirBttn1Show.start();
					compararBttnHide.start();
					WindowResizer windowResizerShow = new WindowResizer( (JDialog) SwingUtilities.getWindowAncestor(elegirBttn1),
							1406, 691, 0.8f, AnimationType.EASE_IN);
					windowResizerShow.start();
					
					timer = new Timer(1000, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	cantComponentesSpn.setVisible(false);
							comprarBttn.setVisible(false);
							compararBttn.setVisible(false);
			                ((Timer)e.getSource()).stop();
			            }
			        });
			        timer.setRepeats(false);
			        timer.start();
					
				}
			});
			
			JButton elegirBttn2 = new JButton("Elegir");
			
			elegirBttn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					elegirBttn2.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
					elegirBttn2.setBackground(hoverEffectColor);
					elegirBttn2.setForeground(Color.WHITE);
				}
				public void mouseExited(MouseEvent arg0) {
					elegirBttn2.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					elegirBttn2.setBackground(SecondaryC);
					elegirBttn2.setForeground(Color.WHITE);
				}
			});
			elegirBttn2.setForeground(Color.WHITE);
			elegirBttn2.setFont(new Font("Century Gothic", Font.BOLD, 18));
			elegirBttn2.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			elegirBttn2.setBackground(new Color(3, 104, 196));
			elegirBttn2.setBounds(24, 508, 483, 55);
			componente2Panel.add(elegirBttn2);
			
			JButton cambiarBttn = new JButton("Cambiar");
			cambiarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cambiarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
					//compararBttn.setBackground(new Color(248, 248, 248));
					cambiarBttn.setForeground(hoverEffectColor);
					cambiarBttn.setOpaque(true);
				}
				public void mouseExited(MouseEvent e) {
					cambiarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					cambiarBttn.setForeground(SecondaryC);
					cambiarBttn.setOpaque(false);
				}
			});
			cambiarBttn.setOpaque(false);
			cambiarBttn.setForeground(new Color(3, 104, 196));
			cambiarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			cambiarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			cambiarBttn.setBackground(new Color(248, 248, 248));
			cambiarBttn.setBounds(24, 576, 483, 55);
			componente2Panel.add(cambiarBttn);
			
			JTextPane textPaneComp2 = new JTextPane();
			textPaneComp2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			textPaneComp2.setBounds(24, 365, 483, 130);
			textPaneComp2.setOpaque(false);
			componente2Panel.add(textPaneComp2);
			
			JLabel label_1 = new JLabel("$499.99");
			label_1.setText(NumberFormat.getCurrencyInstance().format(componente2.getPrecio()));
			label_1.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			label_1.setBounds(22, 311, 436, 41);
			componente2Panel.add(label_1);
			
			JLabel label_2 = new JLabel("NVIDIA GeForce RTX 3070");
			label_2.setText(componente2.getMarca() + " " + componente2.getModelo());
			label_2.setFont(new Font("Century Gothic", Font.BOLD, 24));
			label_2.setBounds(22, 266, 436, 55);
			componente2Panel.add(label_2);
			
			JLabel disponible2Label = new JLabel("Disponibles:");
			disponible2Label.setFont(new Font("Century Gothic", Font.BOLD, 24));
			disponible2Label.setBounds(24, 353, 152, 41);
			componente2Panel.add(disponible2Label);
			
			JLabel cantDisponibles2Label = new JLabel("");
			cantDisponibles2Label.setBorder(new EmptyBorder(0, 10, 0, 10));
			cantDisponibles2Label.setHorizontalAlignment(SwingConstants.TRAILING);
			cantDisponibles2Label.setText(NumberFormat.getNumberInstance().format(componente2.getCantDisponible()));
			cantDisponibles2Label.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			cantDisponibles2Label.setBounds(188, 353, 122, 41);
			componente2Panel.add(cantDisponibles2Label);
			
			elegirBttn2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					componente2PanelHide.start();
					componenteElegido = componente2;
					componenteASeleccinar = componente1;
					updateComponentes(lblNewLabel, precioLabel, componenteIcon1, componenteIcon1, label_2, cantDisponibles2Label, label_1, componenteIcon2);
				}
			});
			elegirBttn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					componenteElegido = componente1;
					cantComponentesSpn.setVisible(true);
					comprarBttn.setVisible(true);
					compararBttn.setVisible(true);
					textPaneComp1Hide.start();
					componente2PanelHide.start();
					elegirBttn1Hide.start();
					cantComponentesSpnShow.start();
					comprarBttnShow.start();
					compararBttnShow.start();
					
					WindowResizer windowResizerHide = new WindowResizer( (JDialog) SwingUtilities.getWindowAncestor(elegirBttn1),
							873, 691, 0.8f, AnimationType.EASE_OUT);
					
					windowResizerHide.start();
					
					timer = new Timer(1000, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                componente2Panel.setVisible(false);
			                elegirBttn1.setVisible(false);
			                ((Timer)e.getSource()).stop();
			            }
			        });
			        timer.setRepeats(false);
			        timer.start();
					
				}
			});
			
			/*if ( false ) {
				precioLabel.setForeground(Color.LIGHT_GRAY);
				JLabel ofertaLabel = new JLabel("$119.99");
				ofertaLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
				ofertaLabel.setBounds(167, 311, 125, 41);
				componente1Panel.add(ofertaLabel);
			}*/
			
			
		}
		
		
		
	}
	private void updateComponentes(JLabel lblNewLabel, JLabel cantDisponibles1Label, JLabel precioLabel, JLabel componenteIcon1, JLabel label_2,
			JLabel cantDisponibles2Label, JLabel label_1, JLabel componenteIcon2) {
		lblNewLabel.setText(componenteElegido.getMarca() + " " + componenteElegido.getModelo());
		cantDisponibles1Label.setText(NumberFormat.getNumberInstance().format(componenteElegido.getCantDisponible()));
		precioLabel.setText(NumberFormat.getCurrencyInstance().format(componenteElegido.getPrecio()));
		
		Image img = null;
		
		if ( componenteElegido instanceof MicroProcesador ) {
			img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
		} else if ( componenteElegido instanceof Ram ) {
			img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
		} else if ( componenteElegido instanceof GPU ) {
			img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
		} else if ( componenteElegido instanceof DiscoDuro ) {
			img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
		} else if ( componenteElegido instanceof TarjetaMadre ) {
			img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
		}
		
		Image scaledImg = img.getScaledInstance(componenteIcon1.getHeight(), componenteIcon1.getWidth(), Image.SCALE_SMOOTH);
		componenteIcon1.setIcon(new ImageIcon(scaledImg));
		
		
		label_2.setText(componenteASeleccinar.getMarca() + " " + componenteASeleccinar.getModelo());
		cantDisponibles2Label.setText(NumberFormat.getNumberInstance().format(componenteASeleccinar.getCantDisponible()));
		label_1.setText(NumberFormat.getCurrencyInstance().format(componenteASeleccinar.getPrecio()));
		
		Image img2 = null;
		
		if ( componenteASeleccinar instanceof MicroProcesador ) {
			img2 = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
		} else if ( componenteASeleccinar instanceof Ram ) {
			img2 = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
		} else if ( componenteASeleccinar instanceof GPU ) {
			img2 = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
		} else if ( componenteASeleccinar instanceof DiscoDuro ) {
			img2 = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
		} else if ( componenteASeleccinar instanceof TarjetaMadre ) {
			img2 = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
		}
		
		Image scaledImg2 = img2.getScaledInstance(componenteIcon2.getHeight(), componenteIcon2.getWidth(), Image.SCALE_SMOOTH);
		componenteIcon2.setIcon(new ImageIcon(scaledImg2));
	}
}
