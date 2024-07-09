package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import com.jgoodies.forms.factories.DefaultComponentFactory;
import javax.swing.SwingConstants;

public class LogIn extends JDialog {

	private final JPanel contentPanel = new JPanel();

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
		setBounds(100, 100, 480, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 0, 462, 553);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("___________");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setForeground(new Color(14, 43, 57));
		lblNewLabel.setBounds(231, 39, 219, 45);
		panel.add(lblNewLabel);
		
		JLabel label = new JLabel("___________");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 30));
		label.setBounds(12, 39, 219, 45);
		panel.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("Log In");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(69, 39, 105, 32);
		panel.add(lblNewLabel_1);
		
		JLabel lblSingIn = new JLabel("Sing In");
		lblSingIn.setHorizontalAlignment(SwingConstants.CENTER);
		lblSingIn.setForeground(new Color(14, 43, 57));
		lblSingIn.setFont(new Font("Dubai Medium", Font.PLAIN, 30));
		lblSingIn.setBounds(272, 39, 105, 32);
		panel.add(lblSingIn);
		
		JLabel label_1 = new JLabel("______________________");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_1.setBounds(107, 145, 293, 45);
		panel.add(label_1);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblUsername.setBounds(12, 153, 98, 32);
		panel.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Dubai Medium", Font.PLAIN, 20));
		lblPassword.setBounds(12, 235, 98, 32);
		panel.add(lblPassword);
		
		JLabel label_3 = new JLabel("______________________");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Tahoma", Font.BOLD, 20));
		label_3.setBounds(107, 227, 301, 45);
		panel.add(label_3);
		
		JButton btnNewButton = new JButton("Iniciar sesion");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFont(new Font("Dubai Medium", Font.BOLD, 22));
		btnNewButton.setBounds(122, 312, 219, 56);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/user32px.png")));
		lblNewLabel_2.setBounds(400, 158, 32, 32);
		panel.add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/eye-crossed32px.png")));
		label_2.setBounds(400, 235, 32, 32);
		panel.add(label_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon(LogIn.class.getResource("/Imagenes/Purple Bliss.jpg")));
		lblNewLabel_3.setBounds(0, 0, 462, 553);
		panel.add(lblNewLabel_3);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{getContentPane(), lblNewLabel, contentPanel}));
	}
}
