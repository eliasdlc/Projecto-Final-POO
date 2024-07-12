package Visual;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;

import Logica.RoundedBorder;

import java.awt.Color;
import java.awt.Component;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import java.awt.Font;


import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
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
	private JPanel panelComponentes;
	private JButton btnListarComponentes;
	private JButton btnRegComponentes;
	private JButton btnComputadoras;
	private JButton btnAdministracion;
	private JButton btnCliente;
	private JButton bttnOpciones;

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
		setBounds(100, 100, 1918, 991);
		
		dim = getToolkit().getScreenSize();
		setSize(dim.width, dim.height);
		
		
		
		setLocationRelativeTo(null);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
			panel.setBounds(0, 5, 1914, 1040);
			panel.setBackground(Color.WHITE);
			contentPanel.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(new Color(0, 78, 137));
			panel_1.setBounds(0, 0, 430, 1040);
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			
			
			
			
			JTextField searchField = new JTextField("");
			searchField.setBackground(new Color(239, 239, 229));
			searchField.setForeground(Color.black);
			searchField.setFont(new Font("Tahoma", Font.PLAIN, 18));
			RoundedBorder roundedBorder = new RoundedBorder(Color.white, 1, 10);
			EmptyBorder emptyBorder = new EmptyBorder(0, 80, 0, 10);
			CompoundBorder compoundBorder = new CompoundBorder(roundedBorder, emptyBorder);
			searchField.setBorder(compoundBorder);
			
			searchField.setBounds(12, 118, 404, 67);
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(8, 6, 55, 55);
			ImageIcon originalIcon = new ImageIcon("C://Users//elias//git//Projecto-Final-POO//ProyectoFinalPOO//images//lupa.png");
			int labelWidth = lblNewLabel.getWidth();
			int labelHeight = lblNewLabel.getHeight();
			Image scaledImage = originalIcon.getImage().getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
			ImageIcon scaledIcon = new ImageIcon(scaledImage);
			
			lblNewLabel.setIcon(scaledIcon);
			searchField.add(lblNewLabel);
			panel_1.add(searchField);
			
			JButton componentesBttn = new JButton("Componentes");
			componentesBttn.setEnabled(false);
			componentesBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					componentesBttn.setBackground(new Color(239, 239, 229));
					componentesBttn.setForeground(Color.black);
					panelComponentes.setVisible(true);
					btnListarComponentes.setVisible(true);
					btnRegComponentes.setVisible(true);
					btnComputadoras.setVisible(false);
				}
				public void mouseExited(MouseEvent arg0) {
					componentesBttn.setBackground(new Color(26, 101, 158));
					componentesBttn.setForeground(Color.white);
					panelComponentes.setVisible(false);
		            btnListarComponentes.setVisible(false);
		            btnRegComponentes.setVisible(false);
		            btnComputadoras.setVisible(true);
				}
			});
			componentesBttn.setBackground(new Color(26, 101, 158));
			componentesBttn.setForeground(Color.white);	
			componentesBttn.setFont(new Font("Tahoma", Font.BOLD, 24));
			componentesBttn.setHorizontalAlignment(SwingConstants.LEADING);
			componentesBttn.setBounds(12, 198, 404, 76);
			
			
			componentesBttn.setBorder(new CompoundBorder(new RoundedBorder(new Color(3, 104, 196), 1, 10), new EmptyBorder(0, 10, 0, 10)));
			panel_1.add(componentesBttn);
			
			btnComputadoras = new JButton("Computadoras");
			btnComputadoras.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnComputadoras.setBackground(new Color(239, 239, 229));
					btnComputadoras.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					btnComputadoras.setBackground(new Color(26, 101, 158));
					btnComputadoras.setForeground(Color.white);
				}
			});
			btnComputadoras.setBackground(new Color(26, 101, 158));
			btnComputadoras.setForeground(Color.white);
			btnComputadoras.setHorizontalAlignment(SwingConstants.LEADING);
			btnComputadoras.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnComputadoras.setBorder(new CompoundBorder(new RoundedBorder(new Color(3, 104, 196), 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnComputadoras.setBounds(12, 287, 404, 76);
			panel_1.add(btnComputadoras);
			
			btnAdministracion = new JButton("Administracion");
			btnAdministracion.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnAdministracion.setBackground(new Color(239, 239, 229));
					btnAdministracion.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					btnAdministracion.setBackground(new Color(26, 101, 158));
					btnAdministracion.setForeground(Color.white);
				}
			});
			btnAdministracion.setBackground(new Color(26, 101, 158));
			btnAdministracion.setForeground(Color.white);
			btnAdministracion.setHorizontalAlignment(SwingConstants.LEADING);
			btnAdministracion.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnAdministracion.setBorder(new CompoundBorder(new RoundedBorder(new Color(3, 104, 196), 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnAdministracion.setBounds(12, 376, 404, 76);
			panel_1.add(btnAdministracion);
			
			btnCliente = new JButton("Cliente");
			btnCliente.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					btnCliente.setBackground(new Color(239, 239, 229));
					btnCliente.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					btnCliente.setBackground(new Color(26, 101, 158));
					btnCliente.setForeground(Color.white);
					
				}
			});
			btnCliente.setBackground(new Color(26, 101, 158));
			btnCliente.setForeground(Color.white);
			btnCliente.setHorizontalAlignment(SwingConstants.LEADING);
			btnCliente.setFont(new Font("Tahoma", Font.BOLD, 24));
			btnCliente.setBorder(new CompoundBorder(new RoundedBorder(new Color(3, 104, 196), 1, 10), new EmptyBorder(0, 10, 0, 10)));
			btnCliente.setBounds(12, 465, 404, 76);
			panel_1.add(btnCliente);
			
			bttnOpciones = new JButton("Opciones");
			bttnOpciones.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnOpciones.setBackground(new Color(239, 239, 229));
					bttnOpciones.setForeground(Color.black);
				}
				public void mouseExited(MouseEvent arg0) {
					
					bttnOpciones.setBackground(new Color(26, 101, 158));
					bttnOpciones.setForeground(Color.white);
				}
			});
			bttnOpciones.setBackground(new Color(26, 101, 158));
			bttnOpciones.setForeground(Color.white);
			bttnOpciones.setHorizontalAlignment(SwingConstants.LEADING);
			bttnOpciones.setFont(new Font("Tahoma", Font.BOLD, 24));
			bttnOpciones.setBorder(new CompoundBorder(new RoundedBorder(new Color(3, 104, 196), 1, 10), new EmptyBorder(0, 10, 0, 10)));
			bttnOpciones.setBounds(12, 936, 404, 76);
			panel_1.add(bttnOpciones);
			
			JLabel techNexusLabel = new JLabel("TechNexus");
			Image img = new ImageIcon(this.getClass().getResource("/microchip.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			Image scaledImg = img.getScaledInstance(60, 60, Image.SCALE_SMOOTH);
			techNexusLabel.setIcon(new ImageIcon(scaledImg));
			techNexusLabel.setHorizontalAlignment(SwingConstants.CENTER);
			techNexusLabel.setFont(new Font("Modern No. 20", Font.BOLD, 38));
			techNexusLabel.setForeground(new Color(239, 239, 229));
			techNexusLabel.setBounds(12, 13, 404, 92);
			panel_1.add(techNexusLabel);
			
			panelComponentes = new JPanel();
			panelComponentes.setBounds(12, 273, 404, 97);
			panel_1.add(panelComponentes);
			panelComponentes.setLayout(null);

			btnRegComponentes = new JButton("Reg. componentes");
			btnRegComponentes.setBounds(0, -2, 404, 52);
			panelComponentes.add(btnRegComponentes);
			btnRegComponentes.setBackground(new Color(0, 54, 50));
			btnRegComponentes.setForeground(Color.WHITE);
			btnRegComponentes.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnRegComponentes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			btnListarComponentes = new JButton("List. componentes");
			btnListarComponentes.setBounds(0, 47, 404, 50);
			panelComponentes.add(btnListarComponentes);
			btnListarComponentes.setBackground(new Color(0, 54, 50));
			btnListarComponentes.setForeground(Color.WHITE);
			btnListarComponentes.setFont(new Font("Tahoma", Font.BOLD, 20));
			btnListarComponentes.setBorder(BorderFactory.createLineBorder(Color.BLACK));

			// Clase interna para manejar eventos de mouse
			MouseAdapter mouseAdapter = new MouseAdapter() {
			    @Override
			    public void mouseEntered(MouseEvent e) {
			        panelComponentes.setVisible(true);
			        btnListarComponentes.setVisible(true);
			        btnRegComponentes.setVisible(true);
			        btnComputadoras.setVisible(false);
			    }

			    @Override
			    public void mouseExited(MouseEvent e) {
			        Point mousePosition = e.getPoint();
			        SwingUtilities.convertPointToScreen(mousePosition, (Component) e.getSource());

			        Point panelPosition = panelComponentes.getLocationOnScreen();
			        Point btnRegPosition = btnRegComponentes.getLocationOnScreen();
			        Point btnListarPosition = btnListarComponentes.getLocationOnScreen();

			        if (!isMouseOverComponent(mousePosition, panelPosition, panelComponentes) &&
			            !isMouseOverComponent(mousePosition, btnRegPosition, btnRegComponentes) &&
			            !isMouseOverComponent(mousePosition, btnListarPosition, btnListarComponentes)) {
			            panelComponentes.setVisible(false);
			            btnListarComponentes.setVisible(false);
			            btnRegComponentes.setVisible(false);
			            btnComputadoras.setVisible(true);
			        }
			    }
			};

			panelComponentes.addMouseListener(mouseAdapter);
			btnRegComponentes.addMouseListener(mouseAdapter);
			btnListarComponentes.addMouseListener(mouseAdapter);

			
			JPanel masCompradosPanel = new JPanel();
			masCompradosPanel.setBackground(new Color(0, 78, 137));
			masCompradosPanel.setBounds(442, 13, 1449, 370);
			masCompradosPanel.setFocusable(true);
			panel.add(masCompradosPanel);
			masCompradosPanel.setLayout(null);
			
			
			
			JButton nextBttn = new JButton(">");
			nextBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ( horizontalListInd < PANELS_TO_SHOW - 4 ) {
						horizontalListInd ++;
						cleanPanel(masCompradosPanel, componentes);
						componentes = getMasComprados(horizontalListInd);
						displayHorizontalList(masCompradosPanel, componentes);
					}
					
				}
			});
			nextBttn.setBackground(Color.WHITE);
			nextBttn.setFont(new Font("Tahoma", Font.BOLD, 34));
			nextBttn.setBounds(1403, 0, 48, 370);
			nextBttn.setOpaque(false);
			nextBttn.setFocusPainted(false);
			nextBttn.setBorder(new EmptyBorder(0, 0, 0, 0));
			masCompradosPanel.add(nextBttn);
			panelComponentes.setVisible(false);
			btnListarComponentes.setVisible(false);
			btnRegComponentes.setVisible(false);
			
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
			prevBttn.setBounds(0, 0, 46, 370);
			masCompradosPanel.add(prevBttn);
			
			displayHorizontalList(masCompradosPanel, componentes);
			
			
			
			
			/*
			 * Basicamente se iran agregando los paneles con el for, tengo que chequear lo del la posicion del panel,
			 * creo que lo mas eficiente seria crear el panel dentro del for y simplemente agregarlo*/
			
			JPanel panel_3 = new JPanel();
			panel_3.setBackground(new Color(0, 78, 137));
			panel_3.setBounds(442, 396, 1449, 644);
			panel.add(panel_3);
			panel_3.setLayout(new BorderLayout(0, 0));
			
			
			
			

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
			newPanel.setLayout(null);
			newPanel.setBorder(new RoundedBorder(Color.white, 1, 10));
			newPanel.setBackground(new Color(239, 239, 229));
			newPanel.setBounds(posX, PANEL_GAP, PANEL_WIDTH, PANEL_HEIGHT);
			componentes.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			JLabel icono = new JLabel();
			Image img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			icono.setIcon(new ImageIcon(scaledImg));
			icono.setBounds(30, 30, 150, 150);
			newPanel.add(icono);
			
			JLabel precio = new JLabel();
			precio.setText("1200$"); // costo + "$" costo siendo un .getCosto del componente
			precio.setHorizontalAlignment(SwingConstants.CENTER);
			precio.setBounds(28, 200, icono.getWidth(), 25);
			precio.setFont(new Font("Century Gothic", Font.BOLD, 20));
			newPanel.add(precio);
			
			JTextPane descripcion = new JTextPane();
			descripcion.setText("Aqui irá la descripcion del producto corespondiente"); 
			descripcion.setFont(new Font("Century Gothic", Font.PLAIN, 15));
			descripcion.setBackground(Color.white);
			descripcion.setForeground(Color.black);
			//descripcion.setBorder(new RoundedBorder(Color.black, 1, 10));
			descripcion.setOpaque(false);
			descripcion.setBounds(200, 30, 120, 200);
			descripcion.setEditable(false);
			newPanel.add(descripcion);
			
			JButton bttnComprar = new JButton();
			bttnComprar.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					bttnComprar.setBackground(new Color(247, 197, 159));
					bttnComprar.setBorder(new RoundedBorder(new Color(247, 197, 159), 1, 10));
				}
				public void mouseExited(MouseEvent arg0) {
					bttnComprar.setBackground(new Color(255, 149, 94));
					bttnComprar.setBorder(new RoundedBorder(new Color(255, 149, 94), 1, 10));
				}
			});
			bttnComprar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JOptionPane.showMessageDialog(null, "Este boton funciona", "", JOptionPane.INFORMATION_MESSAGE);
					/*
					 * Elias:
					 * 
					 * Aqui se abrira la ventana de compra del producto seleccionado.
					 * Hay que crear una ventana de compra donde se pueda ingresar el id del cliente
					 * (osea quien va a comprarlo) y que sea posible agregar la cantidad de productos que
					 * se quieran comprar.
					 * */
				}
			});
			bttnComprar.setFocusPainted(false);
			bttnComprar.setText("Compra YA!!");
			bttnComprar.setFont(new Font("Century Gothic", Font.BOLD, 20));
			bttnComprar.setBackground(new Color(255, 149, 94));
			bttnComprar.setForeground(Color.black);
			bttnComprar.setBorder(new RoundedBorder(new Color(255, 149, 94), 1, 10));
			bttnComprar.setBounds(25, 280, 300, 50);
			newPanel.add(bttnComprar);
			
			
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

	// Método para verificar si el mouse está sobre el componente
	private boolean isMouseOverComponent(Point mousePosition, Point componentPosition, Component component) {
	    Rectangle bounds = new Rectangle(componentPosition, component.getSize());
	    return bounds.contains(mousePosition);
	}
}