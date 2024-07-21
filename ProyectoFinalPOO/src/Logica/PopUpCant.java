package Logica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.geom.RoundRectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeListener;

import Visual.ListComponente;

import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpCant extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
	private JTextField quantitytxt;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopUpCant dialog = new PopUpCant(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopUpCant(Componente comp) {
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		int arcWidth = 20;
		int arcHeight = 20;
		setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));

		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
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
			
			JLabel addIcon = new JLabel();
			addIcon.setBounds(18, 32, 113, 113);
			Image img = new ImageIcon(this.getClass().getResource("/agregar.png")).getImage();
			Image scaledImg = img.getScaledInstance(addIcon.getHeight(), addIcon.getWidth(), Image.SCALE_SMOOTH);
			addIcon.setIcon(new ImageIcon(scaledImg));
			
			panel.add(addIcon);
			
			JLabel lblNewLabel = new JLabel("Pedir Componentes");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
			lblNewLabel.setBounds(148, 51, 272, 26);
			panel.add(lblNewLabel);
			
			JLabel lblNewLabel_1 = new JLabel("\u00BFQu\u00E9 Cantidad desea pedir?");
			lblNewLabel_1.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
			lblNewLabel_1.setBounds(148, 123, 272, 20);
			panel.add(lblNewLabel_1);
			
			JButton addbtn = new JButton("Pedir");
			addbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					addbtn.setBackground(hoverEffectColor);
					addbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					addbtn.setBackground(SecondaryC);
					addbtn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				}
			});
			addbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//Logica para operacion 
					//ListComponente.loadComponente(null);
				}
			});
			addbtn.setForeground(Color.WHITE);
			addbtn.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
			addbtn.setBackground(SecondaryC);
			addbtn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			addbtn.setFocusPainted(false);
			addbtn.setBounds(73, 237, 115, 29);
			panel.add(addbtn);
			
			JSpinner quantityspn = new JSpinner();
			quantityspn.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					int cant = (Integer) quantityspn.getValue();
					quantitytxt.setText(String.valueOf(cant));
				}
			});
			quantityspn.setModel(new SpinnerNumberModel(new Integer(0), new Integer(0), null, new Integer(1)));
			quantityspn.setBounds(88, 159, 92, 45);
			panel.add(quantityspn);
			
			quantitytxt = new JTextField();
			quantitytxt.setHorizontalAlignment(SwingConstants.CENTER);
			quantitytxt.setEditable(false);
			quantitytxt.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
			quantitytxt.setText("0");
			quantitytxt.setBounds(268, 159, 92, 45);
			panel.add(quantitytxt);
			quantitytxt.setColumns(10);
			
			JButton cancelbtn = new JButton("Cancelar");
			cancelbtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cancelbtn.setBackground(hoverEffectColor);
					cancelbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
				}
				@Override
				public void mouseExited(MouseEvent e) {
					cancelbtn.setBackground(SecondaryC);
					cancelbtn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				}
			});
			cancelbtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelbtn.setForeground(Color.WHITE);
			cancelbtn.setFont(new Font("Centhury Gothic", Font.BOLD, 18));
			cancelbtn.setBackground(SecondaryC);
			cancelbtn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			cancelbtn.setFocusPainted(false);
			cancelbtn.setBounds(261, 237, 115, 29);
			panel.add(cancelbtn);
		}
	}

}
