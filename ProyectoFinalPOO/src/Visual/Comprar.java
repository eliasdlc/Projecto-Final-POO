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

import Logica.RoundedBorder;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Comprar extends JDialog {

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Comprar dialog = new Comprar();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Comprar() {
		setBounds(100, 100, 873, 691);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 0, 855, 644);
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
				
				idTextField = new JTextField();
				idTextField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				idTextField.setBounds(44, 291, 235, 39);
				idTextField.setBorder(new CompoundBorder(new RoundedBorder(Color.WHITE, 1, 10), new EmptyBorder(0, 10, 0, 10)));
				idTextField.setBackground(Color.WHITE);
				panelIngresarCliente.add(idTextField);
				idTextField.setColumns(10);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
				btnNewButton.setBounds(91, 343, 141, 39);
				btnNewButton.setBorder(new RoundedBorder(Color.WHITE, 1, 10));
				btnNewButton.setBackground(Color.WHITE);
				panelIngresarCliente.add(btnNewButton);
			}
			{
				JButton comprarBttn = new JButton("Comprar");
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
				comprarBttn.setBounds(348, 440, 483, 55);
				panel.add(comprarBttn);
			}
			{
				JButton CompararBttn = new JButton("Comparar");
				CompararBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						CompararBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						//CompararBttn.setBackground(new Color(248, 248, 248));
						CompararBttn.setForeground(hoverEffectColor);
						CompararBttn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						CompararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						CompararBttn.setForeground(SecondaryC);
						CompararBttn.setOpaque(false);
					}
				});
				CompararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				CompararBttn.setForeground(SecondaryC);
				CompararBttn.setBackground(new Color(248, 248, 248));
				CompararBttn.setOpaque(false);
				CompararBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				CompararBttn.setBounds(348, 508, 483, 55);
				panel.add(CompararBttn);
			}
			{
				JButton cancelarBttn = new JButton("Cancelar");
				cancelarBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						cancelarBttn.setBorder(new RoundedBorder(new Color(248, 248, 248), 1, 10));
						cancelarBttn.setBackground(new Color(248, 248, 248));
						cancelarBttn.setForeground(hoverEffectColor);
						cancelarBttn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						cancelarBttn.setBorder(new EmptyBorder(0, 0, 0, 0));
						cancelarBttn.setBackground(Color.WHITE);
						cancelarBttn.setForeground(SecondaryC);
						cancelarBttn.setOpaque(false);
					}
				});
				cancelarBttn.setBorder(new EmptyBorder(0, 0, 0, 0));
				cancelarBttn.setBackground(Color.WHITE);
				cancelarBttn.setForeground(SecondaryC);
				cancelarBttn.setOpaque(false);
				cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				cancelarBttn.setBounds(348, 576, 483, 55);
				panel.add(cancelarBttn);
			}
			
			JSpinner spinner = new JSpinner();
			spinner.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			spinner.setBounds(348, 365, 215, 41);
			panel.add(spinner);
			
			JLabel lblNewLabel = new JLabel("Intel Core i7-14700K");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			lblNewLabel.setBounds(348, 266, 436, 55);
			panel.add(lblNewLabel);
			
			JLabel label = new JLabel("$159.99");
			label.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			label.setBounds(348, 311, 436, 41);
			panel.add(label);
			
			JLabel componenteIcon = new JLabel("");
			componenteIcon.setBounds(348, 32, 220, 220);
			Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			Image scaledImg = img.getScaledInstance(componenteIcon.getHeight(), componenteIcon.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon.setIcon(new ImageIcon(scaledImg));
			panel.add(componenteIcon);
		}
	}
}
