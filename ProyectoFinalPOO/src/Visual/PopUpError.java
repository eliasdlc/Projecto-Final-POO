package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.Componente;
import Logica.ErrorType;
import Logica.RoundedBorder;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpError extends JDialog {

	private final JPanel contentPanel = new JPanel();
	
	private static final Color PrimaryC = new Color(167, 34, 34);
	private static final Color hoverEffectColor = new Color(243, 49, 49);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopUpError dialog = new PopUpError(null, ErrorType.CLIENT_MISSING, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopUpError(String mensaje, ErrorType errorType, String id) {
		setUndecorated(true);
		setBounds(100, 100, 450, 282);
		setModal(true);
		setLocationRelativeTo(getParent());
		
		int arcWidth = 20;
        int arcHeight = 20;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(247, 247, 247));
			panel.setBounds(0, 0, 450, 282);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel line = new JPanel();
			line.setBackground(PrimaryC);
			line.setBounds(0, 0, 450, 10);
			panel.add(line);
			
			JLabel addIcon = new JLabel("");
			addIcon.setBounds(18, 32, 113, 113);
			Image img = new ImageIcon(this.getClass().getResource("/exclamacion.png")).getImage();
			Image scaledImg = img.getScaledInstance(addIcon.getHeight(), addIcon.getWidth(), Image.SCALE_SMOOTH);
			addIcon.setIcon(new ImageIcon(scaledImg));
			
			panel.add(addIcon);
			
			JLabel lblNewLabel = new JLabel("Se ha cometido un error!");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
			lblNewLabel.setBounds(148, 51, 277, 26);
			panel.add(lblNewLabel);
			
			JTextPane mensajeTextPane = new JTextPane();
			mensajeTextPane.setBorder(new EmptyBorder(0,0,0,0));
			mensajeTextPane.setFont(new Font("Century Gothic", Font.PLAIN, 16));
			mensajeTextPane.setBounds(148, 90, 277, 99);
			mensajeTextPane.setEditable(false);
			mensajeTextPane.setOpaque(false);
			panel.add(mensajeTextPane);
			
			JButton okBttn = new JButton("OK");
			okBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					okBttn.setBackground(hoverEffectColor);
					okBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					okBttn.setBackground(PrimaryC);
					okBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
				}
			});
			
			okBttn.setForeground(Color.WHITE);
			okBttn.setFont(new Font("Century Gothic", Font.BOLD, 26));
			okBttn.setBackground(PrimaryC);
			okBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
			okBttn.setFocusPainted(false);
			okBttn.setBounds(132, 210, 188, 54); 
			
			panel.add(okBttn);
			
			JButton cancelarBttn = new JButton("Cancelar");
			cancelarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					cancelarBttn.setForeground(hoverEffectColor);
					cancelarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				}
				public void mouseExited(MouseEvent arg0) {
					cancelarBttn.setForeground(PrimaryC);
					cancelarBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
				}
			});
			cancelarBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelarBttn.setForeground(PrimaryC);
			cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 26));
			cancelarBttn.setFocusPainted(false);
			cancelarBttn.setBorder(new RoundedBorder(PrimaryC, 1, 20));
			cancelarBttn.setBackground(Color.white);
			cancelarBttn.setOpaque(false);
			cancelarBttn.setBounds(237, 210, 188, 54);
			panel.add(cancelarBttn);
			
			if ( errorType == ErrorType.CLIENT_MISSING ) {
				okBttn.setBounds(24, 210, 188, 54);
				cancelarBttn.setVisible(true);
				lblNewLabel.setText("El cliente no existe!");
				mensajeTextPane.setText(mensaje);
				okBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
						PopUpRegCliente regCliente = new PopUpRegCliente(id);
						regCliente.setModal(true);
						regCliente.setVisible(true);
					}
				});
			} else if ( errorType == ErrorType.WARNING ) {
				okBttn.setBounds(131, 210, 188, 54);
				cancelarBttn.setVisible(false);
				lblNewLabel.setText("Se ha cometido un error!");
				mensajeTextPane.setText(mensaje);
				okBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
			}
		}
	}
}
