package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Timer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Logica.AnimationType;
import Logica.Cliente;
import Logica.ComponentHolder;
import Logica.Componente;
import Logica.Computadora;
import Logica.DiscoDuro;
import Logica.ErrorType;
import Logica.Factura;
import Logica.FacturaComputadora;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.MoveToXY;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ComprarComputadora extends JDialog {

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
	
	private Timer timer;
	Cliente cliente;
	
	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		try {
			ComprarComputadora dialog = new ComprarComputadora(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComprarComputadora(Computadora pc) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComprarComponente.class.getResource("/carrito.png")));
		setTitle("Comprar Computadora");
		setResizable(false);
		setModal(true);
		setLocationRelativeTo(getParent());
		setBounds(100, 100, 873, 691);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
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
					JLabel clienticon = new JLabel("");
					clienticon.setBounds(44, 29, 235, 235);
					Image img = new ImageIcon(this.getClass().getResource("/cliente.png")).getImage();
					Image scaledImg = img.getScaledInstance(clienticon.getHeight(), clienticon.getWidth(), Image.SCALE_SMOOTH);
					clienticon.setIcon(new ImageIcon(scaledImg));
					panelIngresarCliente.add(clienticon);
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
				idTextField.setBorder(new CompoundBorder(new RoundedBorder(Color.WHITE, 1, 20), new EmptyBorder(0, 10, 0, 10)));
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
							PopUpError popUp = new PopUpError("El usuario no fue encontrado, desea crear uno nuevo?", ErrorType.CLIENT_MISSING, id);
							popUp.setLocationRelativeTo(contentPanel);
							popUp.setVisible(true);
						}
					}
				});
				btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
				btnNewButton.setBounds(91, 343, 141, 39);
				btnNewButton.setBorder(new RoundedBorder(Color.WHITE, 1, 20));
				btnNewButton.setBackground(Color.WHITE);
				panelIngresarCliente.add(btnNewButton);
				
				
			}
			
			JLabel PcElegidoTitulo = new JLabel("");
			PcElegidoTitulo.setText(pc.getId());
			PcElegidoTitulo.setFont(new Font("Centhury Gothic", Font.BOLD, 24));
			PcElegidoTitulo.setBounds(348, 266, 436, 55);
			panel.add(PcElegidoTitulo);
			
			JLabel pcElegidoPrecioLabel = new JLabel();
			pcElegidoPrecioLabel.setText(NumberFormat.getCurrencyInstance().format(pc.getPrecio()));
			pcElegidoPrecioLabel.setForeground(Color.BLACK);
			pcElegidoPrecioLabel.setFont(new Font("Centhury Gothic", Font.PLAIN, 24));
			pcElegidoPrecioLabel.setBounds(348,311,125,41);
			panel.add(pcElegidoPrecioLabel);
		
			JPanel panel1 = new JPanel();
			panel1.setBounds(335, 13, 508, 245);
			panel1.setBorder(new RoundedBorder(Color.white, 1, 20));
			panel1.setBackground(new Color(240, 240, 240));
			panel.add(panel1);
			panel1.setLayout(null);
			
			JLabel componenteIcon = new JLabel("");
			componenteIcon.setBounds(144, 12, 220, 220);
			Image img = new ImageIcon(this.getClass().getResource("/ordenador.png")).getImage();
			Image scaledImg = img.getScaledInstance(componenteIcon.getHeight(), componenteIcon.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon.setIcon(new ImageIcon(scaledImg));
			panel1.add(componenteIcon);
		
			JPanel pcPanel = new JPanel();
			pcPanel.setBackground(Color.WHITE);
			pcPanel.setBounds(323, 0, 532, 644);
			panel.add(pcPanel);
			pcPanel.setLayout(null);
			
			JLabel dispElegidoLabel = new JLabel("Disponibles:");
			dispElegidoLabel.setFont(new Font("Centhury Gothic", Font.BOLD, 24));
			dispElegidoLabel.setBounds(24, 353, 152, 41);
			pcPanel.add(dispElegidoLabel);
			
			JLabel cantDispLabel = new JLabel("");
			cantDispLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
			cantDispLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			cantDispLabel.setText(NumberFormat.getNumberInstance().format(pc.getCantDisponible()));
			cantDispLabel.setFont(new Font("Centhury Gothic", Font.BOLD, 24));
			cantDispLabel.setBounds(186, 353, 122, 41);
			pcPanel.add(cantDispLabel);
			
			JSpinner cantPcSpn = new JSpinner();
			cantPcSpn.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			cantPcSpn.setBounds(355, 355, 152, 41);
			pcPanel.add(cantPcSpn);
			MoveToXY cantPcSpnHide = new MoveToXY(cantPcSpn, -200, cantPcSpn.getY(), 0.8f, AnimationType.EASE_OUT);
			MoveToXY cantPcSpnShow = new MoveToXY(cantPcSpn, 355, cantPcSpn.getY(), 0.8f, AnimationType.EASE_IN);
			cantPcSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		
			JButton comprarBtn = new JButton("Comprar");
			comprarBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if ( cliente != null ) {
						int cantArticulos = Integer.parseInt(cantPcSpn.getValue().toString());
						
						Factura newFactura = Tienda.getInstance().makeFactura(null, 0, pc, cantArticulos, cliente);
						
						if ( newFactura != null ) {
							
							
							Computadora comp = Tienda.getInstance().searchComputadoraById(pc.getId());
							comp.setCantDisponible(comp.getCantDisponible() - cantArticulos );
							comp.setCantVendido(comp.getCantVendido() + cantArticulos);
							
							
							cliente.addFactura(newFactura);
							Tienda.getInstance().escribirArchivo();
							
							DisplayFacturaComputadora display = new DisplayFacturaComputadora((FacturaComputadora)newFactura);
							display.setVisible(true);
							
							//cliente.getCarrito().remove(componentHolder.getComponenteElegido());
							dispose();
						} else {
							PopUpError popUp = new PopUpError("Ocurrio un error al intentar crear la factura!", ErrorType.WARNING, null);
							popUp.setLocationRelativeTo(contentPanel);
							popUp.setVisible(true);
							
							//cliente.getCarrito().remove(componentHolder.getComponenteElegido());
						}
						
						
					} else if ( cliente == null ) {
						PopUpError popUp = new PopUpError("Debe ingresar un cliente antes de realizar la compra!", ErrorType.WARNING, null);
						popUp.setLocationRelativeTo(contentPanel);
						popUp.setVisible(true);
						
					}
				}
			});
			comprarBtn.setBounds(24, 508, 483, 55);
			pcPanel.add(comprarBtn);
			
			MoveToXY comprarBttnHide = new MoveToXY(comprarBtn, -500, comprarBtn.getY(), 0.8f, AnimationType.EASE_OUT);
			MoveToXY comprarBttnShow = new MoveToXY(comprarBtn, 24, comprarBtn.getY(), 0.8f, AnimationType.EASE_IN);
			comprarBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					comprarBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					comprarBtn.setBackground(hoverEffectColor);
					comprarBtn.setForeground(Color.WHITE);
				}
				public void mouseExited(MouseEvent e) {
					comprarBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					comprarBtn.setBackground(SecondaryC);
					comprarBtn.setForeground(Color.WHITE);
				}
			});
			comprarBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			comprarBtn.setBackground(SecondaryC);
			comprarBtn.setForeground(Color.WHITE);
			comprarBtn.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
			
			{
				JButton cancelBtn = new JButton("Cancelar");
				cancelBtn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
						cancelBtn.setForeground(hoverEffectColor);
						cancelBtn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
						cancelBtn.setForeground(SecondaryC);
						cancelBtn.setOpaque(false);
					}
				});
				cancelBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						dispose();
					}
				});
				cancelBtn.setBounds(24, 576, 483, 55);
				pcPanel.add(cancelBtn);
				cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				cancelBtn.setForeground(SecondaryC);
				cancelBtn.setBackground(new Color(248, 248, 248));
				cancelBtn.setOpaque(false);
				cancelBtn.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
				
			}
		}
	}

}
