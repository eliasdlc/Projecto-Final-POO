package Visual;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;

public class LogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField nombreField;
	private JPasswordField passwordField;
	private JLabel logInLineLabel;
	private JLabel logInLabel;
	private JLabel singInLabel;
	private JLabel singInLineLabel;

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
		setBounds(100, 100, 512, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(46, 49, 55));
		panel.setBounds(0, 0, 494, 553);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		singInLineLabel = new JLabel("___________");
		singInLineLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		singInLineLabel.setForeground(new Color(84, 93, 106));
		singInLineLabel.setBounds(263, 39, 219, 45);
		panel.add(singInLineLabel);
		
		logInLineLabel = new JLabel("___________");
		logInLineLabel.setForeground(Color.WHITE);
		logInLineLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		logInLineLabel.setBounds(12, 39, 219, 45);
		panel.add(logInLineLabel);
		
		logInLabel = new JLabel("Log In");
		logInLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				logInLabel.setBounds(69, 28, 105, 32);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInLabel.setBounds(69, 39, 105, 32);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				logInLabel.setForeground(Color.WHITE);
				logInLineLabel.setForeground(Color.WHITE);
				singInLabel.setForeground(new Color(84, 93, 106));
				singInLineLabel.setForeground(new Color(84, 93, 106));
			}
			
		});
		logInLabel.setForeground(Color.WHITE);
		logInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		logInLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		logInLabel.setBounds(69, 39, 105, 32);
		panel.add(logInLabel);
		
		singInLabel = new JLabel("Sing In");
		singInLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				singInLabel.setBounds(320, 28, 105, 32);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				singInLabel.setBounds(320, 39, 105, 32);
			}
			@Override
			public void mousePressed(MouseEvent e) {
				singInLabel.setForeground(Color.WHITE);
				singInLineLabel.setForeground(Color.WHITE);
				logInLabel.setForeground(new Color(84, 93, 106));
				logInLineLabel.setForeground(new Color(84, 93, 106));
			}
			
		});
		singInLabel.setHorizontalAlignment(SwingConstants.CENTER);
		singInLabel.setForeground(new Color(84, 93, 106));
		singInLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		singInLabel.setBounds(320, 39, 105, 32);
		panel.add(singInLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblUsername.setBounds(21, 144, 119, 45);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblPassword.setBounds(21, 227, 119, 45);
		panel.add(lblPassword);
		
		JButton logInBttn = new JButton("Iniciar sesion");
		logInBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				logInBttn.setBackground(new Color(4, 235, 155));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				logInBttn.setBackground(new Color(4, 197, 130));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		logInBttn.setBackground(new Color(4, 197, 130));
		logInBttn.setForeground(Color.white);
		logInBttn.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		logInBttn.setBounds(131, 331, 232, 56);
		//btnNewButton.setBorder(new RoundedBorder(10)); 
		logInBttn.setOpaque(true);
		logInBttn.setFocusPainted(false);
		logInBttn.setBorderPainted(false);
		logInBttn.setContentAreaFilled(true);
		panel.add(logInBttn);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/user32px.png")));
		lblNewLabel_2.setBounds(439, 144, 32, 45);
		panel.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/eye-crossed32px.png")));
		label_2.setBounds(437, 227, 32, 45);
		panel.add(label_2);
		
		Border border = BorderFactory.createEmptyBorder(5, 5, 5, 5);
		
		nombreField = new JTextField();
		nombreField.setBackground(new Color(84, 93, 106));
		nombreField.setForeground(Color.white);
		nombreField.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		//nombreField.setOpaque(false);

		nombreField.setBorder(border);
		nombreField.setBounds(152, 145, 272, 45);
		panel.add(nombreField);
		nombreField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(84, 93, 106));
		passwordField.setForeground(Color.white);
		passwordField.setFont(new Font("Dubai Medium", Font.PLAIN, 22));
		//passwordField.setOpaque(false);
		passwordField.setBorder(border);
		passwordField.setColumns(10);
		passwordField.setBounds(153, 226, 272, 45);
		panel.add(passwordField);
		
		JLabel olvidasteLabel = new JLabel("\u00BFOlvidaste tu contrase\u00F1a?");
		olvidasteLabel.setForeground(new Color(84, 93, 106));
		olvidasteLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				olvidasteLabel.setForeground(Color.white);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				olvidasteLabel.setForeground(new Color(84, 93, 106));
			}
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		olvidasteLabel.setHorizontalAlignment(SwingConstants.CENTER);
		olvidasteLabel.setFont(new Font("Dubai Medium", Font.PLAIN, 15));
		olvidasteLabel.setBounds(159, 400, 176, 25);
		panel.add(olvidasteLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(22, 145, 131, 45);
		panel_1.setBackground(new Color(84, 93, 106));
		panel.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(84, 93, 106));
		panel_2.setBounds(22, 226, 131, 45);
		panel.add(panel_2);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), singInLineLabel, contentPanel}));
	}
}
