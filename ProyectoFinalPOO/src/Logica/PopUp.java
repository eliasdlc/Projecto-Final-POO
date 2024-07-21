package Logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUp extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopUp dialog = new PopUp(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopUp(Componente comp) {
		setUndecorated(true);
		setBounds(100, 100, 450, 282);
		setModal(true);
		
		int arcWidth = 20;
        int arcHeight = 20;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 450, 282);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel line = new JPanel();
			line.setBackground(SecondaryC);
			line.setBounds(0, 0, 450, 10);
			panel.add(line);
			
			JLabel addIcon = new JLabel("");
			addIcon.setBounds(18, 32, 113, 113);
			Image img = new ImageIcon(this.getClass().getResource("/agregar.png")).getImage();
			Image scaledImg = img.getScaledInstance(addIcon.getHeight(), addIcon.getWidth(), Image.SCALE_SMOOTH);
			addIcon.setIcon(new ImageIcon(scaledImg));
			
			panel.add(addIcon);
			
			JLabel lblNewLabel = new JLabel("Componente agregado");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
			lblNewLabel.setBounds(148, 51, 272, 26);
			panel.add(lblNewLabel);
			
			JTextPane textPane = new JTextPane();
			textPane.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			textPane.setBounds(150, 90, 243, 74);
			textPane.setEditable(false);
			textPane.setText("El componente " + comp.getId() + " Fue agregado exitosamente!");
			textPane.setOpaque(false);
			panel.add(textPane);
			
			JButton okBttn = new JButton("OK");
			okBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					okBttn.setBackground(hoverEffectColor);
					okBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					okBttn.setBackground(SecondaryC);
					okBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				}
			});
			okBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			okBttn.setForeground(Color.WHITE);
			okBttn.setFont(new Font("Century Gothic", Font.BOLD, 26));
			okBttn.setBackground(SecondaryC);
			okBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			okBttn.setFocusPainted(false);
			okBttn.setBounds(131, 193, 188, 54);
			panel.add(okBttn);
		}
	}
}
