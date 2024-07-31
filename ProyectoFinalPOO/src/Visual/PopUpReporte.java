package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Logica.RoundedBorder;

import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpReporte extends JDialog {

	private final JPanel contentPanel = new JPanel();

	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopUpReporte dialog = new PopUpReporte();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopUpReporte() {
		setUndecorated(true);
		setBounds(100, 100, 450, 300);
		setModal(true);
		
		setLocationRelativeTo(getParent());
		
		int arcWidth = 20;
        int arcHeight = 20;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, arcHeight));
        
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setLayout(null);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(248, 248, 248));
		panel.setBounds(0, 0, 450, 300);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel line = new JPanel();
		line.setBackground(SecondaryC);
		line.setBounds(0, 0, 450, 10);
		panel.add(line);
		
		JLabel replbl = new JLabel("\u00BFQue reporte desea ver?");
		replbl.setFont(new Font("Century Gothic", Font.BOLD, 24));
		
		replbl.setBounds(62, 26, 313, 37);
		panel.add(replbl);
		
		JButton compBtn = new JButton("Componentes");
		compBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				compBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				compBtn.setBackground(hoverEffectColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				compBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				compBtn.setBackground(SecondaryC);
			}
		});
		compBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		compBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		compBtn.setBackground(SecondaryC);
		compBtn.setForeground(Color.WHITE);
		compBtn.setFocusPainted(false);
		compBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepComponente repComponente = new RepComponente();
				repComponente.setModal(true);
				repComponente.setVisible(true);
			}
		});
		compBtn.setBounds(250, 152, 148, 43);
		panel.add(compBtn);
		
		JButton pcbtn = new JButton("Computadoras");
		pcbtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		pcbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		pcbtn.setForeground(Color.WHITE);
		pcbtn.setBackground(SecondaryC);
		pcbtn.setFocusPainted(false);
		pcbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				RepComputadora repComputadora = new RepComputadora();
				repComputadora.setModal(true);
				repComputadora.setVisible(true);
			}
		});
		pcbtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pcbtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				pcbtn.setBackground(hoverEffectColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				pcbtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				pcbtn.setBackground(SecondaryC);
			}
		});
		pcbtn.setBounds(50, 152, 150, 43);
		panel.add(pcbtn);
		
		JButton cancelBtn = new JButton("Cancelar");
		cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		cancelBtn.setBackground(SecondaryC);
		cancelBtn.setForeground(Color.WHITE);
		cancelBtn.setFocusPainted(false);
		cancelBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		cancelBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				cancelBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				cancelBtn.setBackground(hoverEffectColor);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				cancelBtn.setBackground(SecondaryC);
			}
		});
		cancelBtn.setBounds(150, 223, 151, 43);
		panel.add(cancelBtn);
		
	}
}
