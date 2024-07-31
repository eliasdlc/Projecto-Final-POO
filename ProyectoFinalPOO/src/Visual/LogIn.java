package Visual;



import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import Logica.AnimationType;
import Logica.ErrorType;
import Logica.MoveToXY;
import Logica.RoundedBorder;
import Logica.Tienda;
import Logica.Usuarios;

import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JDesktopPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreField;
	private JPasswordField passwordField;
	private JLabel logInLineLabel;
	private JLabel logInLabel;
	public String usuario;
	private String password;
	private ArrayList<Usuarios> usuarios;
	
	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color ThirdC = new Color(247, 251, 255);
	private static final Color SecondaryBttnC = new Color(57, 57, 57);
	private static final Color AccentColor = new Color(255, 133, 78); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color HoverEffectColor = new Color(3, 135, 255);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LogIn dialog = new LogIn();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LogIn() {
		
		Tienda.getInstance().cargarArchivo();
		
		setBounds(100, 100, 512, 500);
		setLocationRelativeTo(null);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(SecondaryC);
		panel.setBounds(0, 0, 494, 453);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		logInLineLabel = new JLabel("________________________");
		logInLineLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logInLineLabel.setForeground(ThirdC);
		logInLineLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		logInLineLabel.setBounds(12, 39, 470, 45);
		panel.add(logInLineLabel);
		
		logInLabel = new JLabel("Log In");
		logInLabel.setBounds(127, 27, 239, 45);
		MoveToXY logInShow = new MoveToXY(logInLabel, logInLabel.getX(), logInLabel.getY()-15, 0.4f, AnimationType.EASE_IN_OUT);
		MoveToXY logInHide = new MoveToXY(logInLabel, logInLabel.getX(), 27, 0.4f, AnimationType.EASE_IN_OUT);
		logInLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logInShow.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInHide.start();
			}
			@Override
			public void mousePressed(MouseEvent e) {
				logInLabel.setForeground(ThirdC);
				logInLineLabel.setForeground(ThirdC);
			}
			
		});
		logInLabel.setForeground(ThirdC);
		logInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logInLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		
		panel.add(logInLabel);
		
		JLabel lblUsername = new JLabel("Usuario");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(ThirdC);
		lblUsername.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblUsername.setBounds(21, 144, 131, 45);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Contrase\u00F1a");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(ThirdC);
		lblPassword.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblPassword.setBounds(21, 227, 131, 45);
		panel.add(lblPassword);
		
		JButton logInBttn = new JButton("Iniciar sesion");
		logInBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				usuario = nombreField.getText();
				password = passwordField.getText();
				if (inicioSession()) {
					Principal principal = new Principal();
					dispose();
					principal.setVisible(true);
				}else {
					PopUpError popUp = new PopUpError("El usuario no esta registrado", ErrorType.WARNING, null);
					popUp.setLocationRelativeTo(contentPanel);
					popUp.setVisible(true);
				}
				
			}
		});
		
		MouseListener primaryBttnListenerLogInBttn = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logInBttn.setBackground(HoverEffectColor);
				logInBttn.setBorder(new RoundedBorder(HoverEffectColor, 2, 15));
			}
			public void mouseExited(MouseEvent arg0) {
				logInBttn.setBackground(PrimaryC);
				logInBttn.setBorder(new RoundedBorder(PrimaryC, 2, 15));
			}
		};
		
		MouseListener secondaryBttnListenerLogInBttn = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logInBttn.setBorder(new RoundedBorder(new Color(85, 85, 85), 2, 15));
				logInBttn.setBackground(new Color(85, 85, 85));
			}
			public void mouseExited(MouseEvent arg0) {
				logInBttn.setBorder(new RoundedBorder(SecondaryBttnC, 2, 15));
				logInBttn.setBackground(SecondaryBttnC);
			}
		};
		
		
		logInBttn.setBounds(131, 331, 232, 56);
		
		MoveToXY logInBttnShow = new MoveToXY(logInBttn, 131, logInBttn.getY(), 0.6f, AnimationType.EASE_IN_OUT);
		MoveToXY logInBttnHide = new MoveToXY(logInBttn, -655, logInBttn.getY(), 0.6f, AnimationType.EASE_IN_OUT);
		logInBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logInBttn.setBackground(HoverEffectColor);
				logInBttn.setBorder(new RoundedBorder(HoverEffectColor, 2, 15));

			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInBttn.setBackground(PrimaryC);
				logInBttn.setBorder(new RoundedBorder(PrimaryC, 2, 15));

			}
		});
		logInBttn.setBorder(new RoundedBorder(PrimaryC, 2, 15));
		logInBttn.setBackground(PrimaryC);
		logInBttn.setForeground(ThirdC);
		logInBttn.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		
		logInBttn.setOpaque(true);
		logInBttn.setFocusPainted(false);
		panel.add(logInBttn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		//lblNewLabel_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/user32px.png")));
		lblNewLabel_2.setBounds(439, 144, 32, 45);
		panel.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("");
		//label_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/eye-crossed32px.png")));
		label_2.setBounds(437, 227, 32, 45);
		panel.add(label_2);
		
		Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		nombreField = new JTextField();
		nombreField.setBackground(PrimaryC);
		nombreField.setForeground(ThirdC);
		nombreField.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		//nombreField.setOpaque(false);

		nombreField.setBorder(border);
		nombreField.setBounds(152, 145, 319, 45);
		
		//nombreField.setBorder(new RoundedBorder(PrimaryC, 5, 15));
		nombreField.setOpaque(true);
		
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(PrimaryC);
		passwordField.setForeground(ThirdC);
		passwordField.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		//passwordField.setOpaque(false);
		passwordField.setBorder(border);
		passwordField.setColumns(10);
		passwordField.setBounds(153, 226, 319, 45);
		panel.add(passwordField);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 145, 131, 45);
		panel_1.setBackground(PrimaryC);
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(PrimaryC);
		panel_2.setBounds(22, 226, 131, 45);
		panel.add(panel_2);
		
		logInLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logInShow.start();
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInHide.start();
			}
		});
	}
	
	private boolean inicioSession() {
		Boolean existe = false;
		if (usuario.equals("admin") && password.equals("admin")) {
			Tienda.getInstance().setPermisoAdministrado(true);
			existe = true;
		}else {
			usuarios = Tienda.getInstance().getMisUsuarios();
			for (Usuarios usuarios2 : usuarios) {
				if (usuario.equals(usuarios2.getUsuario()) && password.equals(usuarios2.getPassword())) {
					existe = true;
				}
			}
			
		}
		return existe;
	}
	
}
