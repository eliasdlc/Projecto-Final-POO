package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Logica.RoundedBorder;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Principal extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private Dimension dim;
	int horizontalListInd = 0;
	private final int PANELS_TO_SHOW = 4;
	private final int PANEL_WIDTH = 350;
	private final int PANEL_HEIGHT = 350;
	private final int PANEL_GAP = 10;
	private ArrayList<JPanel> componentes = getMasComprados(0);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Principal dialog = new Principal();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Principal() {
		setResizable(false);
		setBounds(100, 100, 400, 100);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height);
		
		
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(Color.LIGHT_GRAY);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.GRAY);
			panel_1.setBounds(0, 0, 430, 1035);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			
			
			
			
			JTextField searchField = new JTextField("Buscar");
			searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			RoundedBorder roundedBorder = new RoundedBorder(Color.black, 1, 65);
			EmptyBorder emptyBorder = new EmptyBorder(0, 80, 0, 10);
			CompoundBorder compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);
			searchField.setBorder(compoundBorder);
			
			searchField.setBounds(12, 13, 404, 67);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(8, 6, 55, 55);
			ImageIcon originalIcon = new ImageIcon("C:\\Users\\elias\\Desktop\\POO Java Projects\\Biblioteca\\images\\userPNG.png");
			int labelWidth = lblNewLabel.getWidth();
			int labelHeight = lblNewLabel.getHeight();
			Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			
			lblNewLabel.setIcon(scaledIcon);
			searchField.add(lblNewLabel);
			panel_1.add(searchField);
			
			JButton componentesBttn = new JButton("Componentes");
			componentesBttn.setBackground(Color.WHITE);
			componentesBttn.setFont(new Font("Tahoma", Font.BOLD, 24));
			componentesBttn.setHorizontalAlignment(SwingConstants.LEADING);
			componentesBttn.setBounds(12, 198, 404, 76);
			
			
			componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 3, 65), new EmptyBorder(0, 10, 0, 10)));
			panel_1.add(componentesBttn);
			
			JButton btnComputadoras = new JButton("Computadoras");
			btnComputadoras.setHorizontalAlignment(SwingConstants.LEADING);
			btnComputadoras.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 3, 65), new EmptyBorder(0, 10, 0, 10)));
			btnComputadoras.setBackground(Color.WHITE);
			btnComputadoras.setBounds(12, 287, 404, 76);
			panel_1.add(btnComputadoras);
			
			JButton btnAdministracion = new JButton("Administracion");
			btnAdministracion.setHorizontalAlignment(SwingConstants.LEADING);
			btnAdministracion.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 3, 65), new EmptyBorder(0, 10, 0, 10)));
			btnAdministracion.setBackground(Color.WHITE);
			btnAdministracion.setBounds(12, 376, 404, 76);
			panel_1.add(btnAdministracion);
			
			JButton btnCliente = new JButton("Cliente");
			btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
			btnCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnCliente.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 3, 65), new EmptyBorder(0, 10, 0, 10)));
			btnCliente.setBackground(Color.WHITE);
			btnCliente.setBounds(12, 465, 404, 76);
			panel_1.add(btnCliente);
			
			JButton button_3 = new JButton("Componentes");
			button_3.setHorizontalAlignment(SwingConstants.LEADING);
			button_3.setFont(new Font("Tahoma", Font.BOLD, 24));
			button_3.setBorder(new CompoundBorder(new RoundedBorder(Color.white, 3, 65), new EmptyBorder(0, 10, 0, 10)));
			button_3.setBackground(Color.WHITE);
			button_3.setBounds(12, 946, 404, 76);
			panel_1.add(button_3);
			
			JPanel masCompradosPanel = new JPanel();
			masCompradosPanel.setBounds(442, 13, 1450, 370);
			masCompradosPanel.setFocusable(true);
			panel.add(masCompradosPanel);
			masCompradosPanel.setLayout(null);
			
			
			
			JButton nextBttn = new JButton(">");
			nextBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ( horizontalListInd < PANELS_TO_SHOW-1 ) {
						horizontalListInd ++;
						cleanPanel(masCompradosPanel, componentes);
						componentes = getMasComprados(horizontalListInd);
						displayHorizontalList(masCompradosPanel, componentes);
					}
					
				}
			});
			nextBttn.setBackground(Color.WHITE);
			nextBttn.setFont(new Font("Tahoma", Font.BOLD, 34));
			nextBttn.setBounds(1341, 0, 109, 370);
			nextBttn.setOpaque(false);
			nextBttn.setFocusPainted(false);
			nextBttn.setBorder(new EmptyBorder(0, 0, 0, 0));
			masCompradosPanel.add(nextBttn);
			
			JButton prevBttn = new JButton("<");
			prevBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ( horizontalListInd > 0 ) {
						horizontalListInd --;
						cleanPanel(masCompradosPanel, componentes);
						componentes = getMasComprados(horizontalListInd);
						displayHorizontalList(masCompradosPanel, componentes);
					}
				}
			});
			prevBttn.setOpaque(false);
			prevBttn.setFont(new Font("Tahoma", Font.BOLD, 34));
			prevBttn.setFocusPainted(false);
			prevBttn.setBorder(new EmptyBorder(0, 0, 0, 0));
			prevBttn.setBackground(Color.WHITE);
			prevBttn.setBounds(0, 0, 109, 370);
			masCompradosPanel.add(prevBttn);
			
			displayHorizontalList(masCompradosPanel, componentes);
			
			
			
			
			/*
			 * Basicamente se iran agregando los paneles con el for, tengo que chequear lo del la posicion del panel,
			 * creo que lo mas eficiente seria crear el panel dentro del for y simplemente agregarlo*/
			
			JPanel panel_3 = new JPanel();
			panel_3.setBounds(442, 396, 1450, 626);
			panel.add(panel_3);
			
			
			

			
			
		}
	}
	
	private void displayHorizontalList(JPanel panel, ArrayList<JPanel> componentes) {
		for ( JPanel comp : componentes ) {
			panel.add(comp);
			
		}
	}
	
	
	private ArrayList<JPanel> getMasComprados(int ind) {
		ArrayList<JPanel> componentes = new ArrayList<>();
		int posX = 10;
		for ( int i = ind; i < PANELS_TO_SHOW; i++ ) {
			JPanel newPanel = new JPanel();
			newPanel.setBackground(Color.GRAY);
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			newPanel.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					System.out.println("componente");
				}
			});
			componentes.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
		}
		return componentes;
		
	}
	
	private void cleanPanel(JPanel panel, ArrayList<JPanel> componentes) {
		for ( JPanel comp : componentes ) {
			panel.remove(comp);
		}
	    panel.revalidate();
	    panel.repaint();
	}
}
