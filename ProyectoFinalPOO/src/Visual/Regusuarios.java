package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import Logica.AnimationType;
import Logica.MoveToXY;
import Logica.RoundedBorder;
import Logica.Tienda;
import Logica.Usuarios;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.SwingConstants;
import javax.swing.JScrollPane;

public class Regusuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNombre;
	private JTextField txtTelefono;
	private JTextField txtDireccion;
	private JTextField txtCorreo;
	
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
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private JTextField txtUsuario;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Regusuarios dialog = new Regusuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Regusuarios() {
		setBounds(100, 100, 624, 515);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		contentPanel.setBackground(PrimaryC);
		
		JLabel lblNewLabel = new JLabel("Nombre: ");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel.setBounds(28, 66, 105, 22);
		contentPanel.add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.setBounds(145, 70, 116, 22);
		contentPanel.add(txtNombre);
		txtNombre.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Telefono: ");
		lblNewLabel_1.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_1.setBounds(280, 70, 116, 22);
		contentPanel.add(lblNewLabel_1);
		
		txtTelefono = new JTextField();
		txtTelefono.setBounds(408, 70, 116, 22);
		contentPanel.add(txtTelefono);
		txtTelefono.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Direccion:");
		lblNewLabel_2.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_2.setBounds(28, 122, 106, 22);
		contentPanel.add(lblNewLabel_2);
		
		txtDireccion = new JTextField();
		txtDireccion.setBounds(145, 125, 378, 25);
		contentPanel.add(txtDireccion);
		txtDireccion.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Correo: ");
		lblNewLabel_3.setFont(new Font("Dialog", Font.BOLD, 22));
		lblNewLabel_3.setBounds(28, 187, 91, 26);
		contentPanel.add(lblNewLabel_3);
		
		txtCorreo = new JTextField();
		txtCorreo.setBounds(145, 193, 211, 22);
		contentPanel.add(txtCorreo);
		txtCorreo.setColumns(10);
		
		JLabel lblNewLabel_7 = new JLabel("Registro de Usuarios");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setForeground(Color.WHITE);
		lblNewLabel_7.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel_7.setBounds(0, 0, 606, 48);
		contentPanel.add(lblNewLabel_7);
		
		JLabel label = new JLabel("_____________________________");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(0, 5, 606, 48);
		contentPanel.add(label);
		
		JPanel panel = new JPanel();
		panel.setBounds(28, 226, 543, 154);
		contentPanel.add(panel);
		panel.setLayout(null);
		panel.setBackground(SecondaryC);
		
		JLabel label_1 = new JLabel("Usuario: ");
		label_1.setFont(new Font("Dialog", Font.BOLD, 22));
		label_1.setBounds(12, 13, 108, 22);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("Contrase\u00F1a:");
		label_2.setFont(new Font("Dialog", Font.BOLD, 22));
		label_2.setBounds(12, 42, 148, 25);
		panel.add(label_2);
		
		JLabel lblConfirmarContrasea = new JLabel("Confirmar");
		lblConfirmarContrasea.setFont(new Font("Dialog", Font.BOLD, 22));
		lblConfirmarContrasea.setBounds(12, 80, 108, 29);
		panel.add(lblConfirmarContrasea);
		
		txtUsuario = new JTextField();
		txtUsuario.setColumns(10);
		txtUsuario.setBounds(155, 17, 148, 22);
		panel.add(txtUsuario);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(155, 47, 148, 22);
		panel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(155, 100, 148, 22);
		panel.add(passwordField_1);
		
		JLabel lblContrasea = new JLabel("contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Dialog", Font.BOLD, 22));
		lblContrasea.setBounds(12, 111, 127, 29);
		panel.add(lblContrasea);
		
		JButton btnRegistrar = new JButton("Registrar");
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(completado() && passwordField.getText().equals(passwordField_1.getText())) {
					Usuarios usuario = new Usuarios(txtUsuario.getText(), passwordField.getText(), txtNombre.getText(), txtDireccion.getText(), txtTelefono.getText(), txtCorreo.getText());
					Tienda.getInstance().insertarUsuario(usuario);
					Tienda.getInstance().escribirArchivo(usuario);
					dispose();
				}else {
					System.out.println("algo no completo o contrasena no coinciden");
				}
			}
		});
		btnRegistrar.setOpaque(true);
		btnRegistrar.setForeground(new Color(247, 251, 255));
		btnRegistrar.setFont(new Font("Dialog", Font.BOLD, 22));
		btnRegistrar.setFocusPainted(false);
		btnRegistrar.setBorder(new RoundedBorder(PrimaryC, 2, 15));
		btnRegistrar.setBackground(new Color(3, 88, 157));
		btnRegistrar.setBounds(181, 393, 232, 56);
		contentPanel.add(btnRegistrar);
		
		MouseListener primaryBttnListenerLogInBttn = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRegistrar.setBackground(HoverEffectColor);
				btnRegistrar.setBorder(new RoundedBorder(HoverEffectColor, 2, 15));
			}
			public void mouseExited(MouseEvent arg0) {
				btnRegistrar.setBackground(PrimaryC);
				btnRegistrar.setBorder(new RoundedBorder(PrimaryC, 2, 15));
			}
		};
		
		MouseListener secondaryBttnListenerLogInBttn = new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				btnRegistrar.setBorder(new RoundedBorder(new Color(85, 85, 85), 2, 15));
				btnRegistrar.setBackground(new Color(85, 85, 85));
			}
			public void mouseExited(MouseEvent arg0) {
				btnRegistrar.setBorder(new RoundedBorder(SecondaryBttnC, 2, 15));
				btnRegistrar.setBackground(SecondaryBttnC);
			}
		};
	}
	public boolean completado() {
		Boolean todoCompleto = false;
		if (!(txtCorreo.getText().isEmpty()) && !(txtDireccion.getText().isEmpty()) && !(txtNombre.getText().isEmpty()) && !(txtTelefono.getText().isEmpty()) && !(txtUsuario.getText().isEmpty()) && !(passwordField.getText().isEmpty())) {
			todoCompleto = true;
		}
		return todoCompleto;
	}
}
