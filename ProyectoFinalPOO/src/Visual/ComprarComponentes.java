package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;

import Logica.AnimationType;
import Logica.Cliente;
import Logica.ComponentHolder;
import Logica.Componente;
import Logica.DiscoDuro;
import Logica.ErrorType;
import Logica.Factura;
import Logica.FacturaComponente;
import Logica.GPU;
import Logica.MicroProcesador;
import Logica.MoveToXY;
import Logica.Ram;
import Logica.RoundedBorder;
import Logica.TarjetaMadre;
import Logica.Tienda;
import Logica.WindowResizer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import javax.swing.SpinnerNumberModel;

public class ComprarComponentes extends JDialog {

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
	
	private int currentIndex = 0;
    private ArrayList<JPanel> componentesPanels = new ArrayList<>();
    private ArrayList<Componente> componentesElegidos;
    private JPanel currentPanel;
    private int[] cantidadesSeleccionadas;
	
	private final int PANEL_WIDTH = 532;
	private final int PANEL_HEIGHT = 644;
	private final int PANEL_GAP = 0;
	

	private Timer timer;
	Cliente cliente;
	private JPanel innerPanel;
	private JButton btnAnterior;
	private JButton siguienteBttn;
	private JPanel panel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComprarComponentes dialog = new ComprarComponentes(new ArrayList<>());
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComprarComponentes(ArrayList<Componente> componentes) {
		this.componentesElegidos = componentes;
		this.cantidadesSeleccionadas = new int[componentes.size()];
		Arrays.fill(this.cantidadesSeleccionadas, 1);
		System.out.println("a " + cantidadesSeleccionadas.length);

		
		componentesPanels = writeComponentes(componentes);
		currentPanel = componentesPanels.get(0);
		
		
		
		
		setModal(true);
		setLocationRelativeTo(getParent());
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComprarComponente.class.getResource("/carrito.png")));
		setTitle("Comprar Componente");
		setResizable(false);
		setBounds(100, 100, 873, 691); //873 original width
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		
		{
			panel = new JPanel();
			panel.setBackground(Color.WHITE);
			panel.setBounds(0, 0, 1388, 644);
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
				
				JLabel nombreLabel = new JLabel("Nombre");
				nombreLabel.setVisible(false);
				nombreLabel.setForeground(Color.WHITE);
				nombreLabel.setHorizontalAlignment(SwingConstants.CENTER);
				nombreLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
				nombreLabel.setBounds(12, 395, 299, 39);
				panelIngresarCliente.add(nombreLabel);
				
				JLabel nombreText = new JLabel("nombre del nombre");
				nombreText.setVisible(false);
				nombreText.setHorizontalAlignment(SwingConstants.CENTER);
				nombreText.setForeground(Color.WHITE);
				nombreText.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				nombreText.setBounds(12, 429, 299, 39);
				panelIngresarCliente.add(nombreText);
				
				JLabel CorreoLabel = new JLabel("Correo");
				CorreoLabel.setVisible(false);
				CorreoLabel.setHorizontalAlignment(SwingConstants.CENTER);
				CorreoLabel.setForeground(Color.WHITE);
				CorreoLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
				CorreoLabel.setBounds(12, 481, 299, 39);
				panelIngresarCliente.add(CorreoLabel);
				
				JLabel correoText = new JLabel("usuario123@gmail.com");
				correoText.setVisible(false);
				correoText.setHorizontalAlignment(SwingConstants.CENTER);
				correoText.setForeground(Color.WHITE);
				correoText.setFont(new Font("Century Gothic", Font.PLAIN, 20));
				correoText.setBounds(12, 515, 299, 39);
				panelIngresarCliente.add(correoText);
				
				idTextField = new JTextField();
				idTextField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
				idTextField.setBounds(44, 291, 235, 39);
				idTextField.setBorder(new CompoundBorder(new RoundedBorder(Color.WHITE, 1, 20), new EmptyBorder(0, 10, 0, 10)));
				idTextField.setBackground(Color.WHITE);
				panelIngresarCliente.add(idTextField);
				idTextField.setColumns(10);
				
				JButton btnNewButton = new JButton("Buscar");
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						String id = idTextField.getText();
						cliente = Tienda.getInstance().searchClienteById(id);
						
						if ( cliente != null ) {
							nombreText.setText(cliente.getNombre());
							correoText.setText(cliente.getCorreo());
							
							nombreLabel.setVisible(true);
							nombreText.setVisible(true);
							CorreoLabel.setVisible(true);
							correoText.setVisible(true);
						} else if ( cliente == null ) {
							PopUpError popUp = new PopUpError("El usuario no fue encontrado, desea crear uno nuevo?", ErrorType.CLIENT_MISSING, null);
							popUp.setLocationRelativeTo(contentPanel);
							popUp.setVisible(true);
						}
					}
				});
				btnNewButton.setFont(new Font("Century Gothic", Font.BOLD, 20));
				btnNewButton.setBounds(91, 343, 141, 39);
				btnNewButton.setBorder(new RoundedBorder(Color.WHITE, 1, 20));
				btnNewButton.setBackground(Color.WHITE);
				panelIngresarCliente.add(btnNewButton);
				
				
			}
			
			
			
			
			innerPanel = new JPanel();
			innerPanel.setBackground(Color.WHITE);
			innerPanel.setBounds(323, 0, 532, 413);
			innerPanel.setLayout(null);  // Cambia a BorderLayout
			panel.add(innerPanel);
			
			innerPanel.add(currentPanel);
			innerPanel.revalidate();
			innerPanel.repaint();

		}
		
		
		
		JPanel panelButtons = new JPanel();
		panelButtons.setBackground(Color.WHITE);
		panelButtons.setBounds(323, 413, 532, 231);
		panel.add(panelButtons);
		panelButtons.setLayout(null);
		panel.setComponentZOrder(panelButtons, 0);
		
		componentesPanels = writeComponentes(componentes);
        currentPanel = componentesPanels.get(0);
        innerPanel.add(currentPanel);
        
		//displayComponentList(componentesPanels, innerPanel);
		
		
		
		
		JButton comprarBttn = new JButton("Comprar");
		comprarBttn.setBounds(24, 27, 483, 55);
		panelButtons.add(comprarBttn);
		comprarBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				comprarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
				comprarBttn.setBackground(hoverEffectColor);
				comprarBttn.setForeground(Color.WHITE);
			}
			public void mouseExited(MouseEvent arg0) {
				comprarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
				comprarBttn.setBackground(SecondaryC);
				comprarBttn.setForeground(Color.WHITE);
			}
		});
		comprarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
		comprarBttn.setBackground(SecondaryC);
		comprarBttn.setForeground(Color.WHITE);
		comprarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
		
		
			siguienteBttn = new JButton("Siguiente");
			siguienteBttn.setBounds(278, 95, 230, 55);
			panelButtons.add(siguienteBttn);
			siguienteBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					siguienteBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					//compararBttn.setBackground(new Color(248, 248, 248));
					siguienteBttn.setForeground(hoverEffectColor);
					siguienteBttn.setOpaque(true);
				}
				public void mouseExited(MouseEvent e) {
					siguienteBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					siguienteBttn.setForeground(SecondaryC);
					siguienteBttn.setOpaque(false);
				}
			});
			siguienteBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			siguienteBttn.setForeground(SecondaryC);
			siguienteBttn.setBackground(new Color(248, 248, 248));
			siguienteBttn.setOpaque(false);
			siguienteBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			btnAnterior = new JButton("Anterior");
			btnAnterior.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ( currentIndex >= 0) {
						showPreviousComponent();
					}
				}
			});
			btnAnterior.setBounds(24, 95, 230, 55);
			panelButtons.add(btnAnterior);
			btnAnterior.setOpaque(false);
			btnAnterior.setForeground(new Color(3, 104, 196));
			btnAnterior.setFont(new Font("Century Gothic", Font.BOLD, 18));
			btnAnterior.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			btnAnterior.setBackground(new Color(248, 248, 248));
			
			updateButtonVisibility();
			
			JButton cancelarBttn = new JButton("Cancelar");
			cancelarBttn.setBounds(24, 163, 483, 55);
			panelButtons.add(cancelarBttn);
			cancelarBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					dispose();
				}
			});
			cancelarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cancelarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					cancelarBttn.setForeground(hoverEffectColor);
					cancelarBttn.setOpaque(true);
				}
				public void mouseExited(MouseEvent e) {
					cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					cancelarBttn.setForeground(SecondaryC);
					cancelarBttn.setOpaque(false);
				}
			});
			cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			cancelarBttn.setForeground(SecondaryC);
			cancelarBttn.setBackground(new Color(248, 248, 248));
			cancelarBttn.setOpaque(false);
			cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			
			siguienteBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					if ( currentIndex < componentesPanels.size()-1 ) {
						showNextComponent();
					}
					
					
				}
			});
		
		comprarBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( cliente != null ) {
				
				Factura newFactura = Tienda.getInstance().makeFactura(componentesElegidos, cantidadesSeleccionadas, null, 0, cliente);
				
				if ( newFactura != null ) {
					
					Tienda.getInstance().escribirArchivo();
					cliente.addFactura(newFactura);
					cliente.setCarrito(((FacturaComponente)newFactura).getCarrito());
					
					DisplayFacturaComponente display = new DisplayFacturaComponente(newFactura);
					display.setVisible(true);
					
					dispose();
				} else {
					PopUpError popUp = new PopUpError("Ocurrio un error al intentar crear la factura!", ErrorType.WARNING, null);
					popUp.setLocationRelativeTo(contentPanel);
					popUp.setVisible(true);
					
				}
				
				
			} else if ( cliente == null ) {
				PopUpError popUp = new PopUpError("Debe ingresar un cliente antes de realizar la compra!", ErrorType.WARNING, null);
				popUp.setLocationRelativeTo(contentPanel);
				popUp.setVisible(true);
				
			}
				
			}
		});
		
		
		
		
	}
	
	private void updateDisplayedComponent() {
	    if (currentIndex >= 0 && currentIndex < componentesPanels.size()) {
	        innerPanel.removeAll();
	        currentPanel = componentesPanels.get(currentIndex);
	        innerPanel.add(currentPanel);

	        Componente compActual = componentesElegidos.get(currentIndex);
	        JSpinner spinner = (JSpinner) currentPanel.getComponent(currentPanel.getComponentCount() - 1);
	        spinner.setValue(cantidadesSeleccionadas[currentIndex] > 0 ? cantidadesSeleccionadas[currentIndex] : 1);

	        innerPanel.revalidate();
	        innerPanel.repaint();
	    }
	}
	
	private void updateButtonVisibility() {
	    btnAnterior.setEnabled(currentIndex > 0);
	    siguienteBttn.setEnabled(currentIndex < componentesPanels.size() - 1);
	}

	private void showNextComponent() {
	    if (currentIndex < componentesPanels.size() - 1) {
	        saveCurrentComponentQuantity();
	        currentIndex++;
	        updateDisplayedComponent();
	        updateButtonVisibility();
	    }
	}

	private void showPreviousComponent() {
	    if (currentIndex > 0) {
	        saveCurrentComponentQuantity();
	        currentIndex--;
	        updateDisplayedComponent();
	        updateButtonVisibility();
	    }
	}
	
	private void saveCurrentComponentQuantity() {
		if (currentIndex >= 0 && currentIndex < componentesPanels.size()) {
	        JPanel currentPanel = componentesPanels.get(currentIndex);
	        JSpinner spinner = (JSpinner) currentPanel.getComponent(currentPanel.getComponentCount() - 1);
	        
	        int cantidad = (Integer) spinner.getValue();
	        Componente comp = componentesElegidos.get(currentIndex);
	        
	        comp.setCantSeleccionado(cantidad);
	        cantidadesSeleccionadas[currentIndex] = cantidad;
	        
	        System.out.println("Componente " + comp.getModelo() + " actualizado. Cantidad seleccionada: " + cantidad);
		}
    }
	
	private ArrayList<JPanel> writeComponentes(ArrayList<Componente> componentesElegidos) {
		ArrayList<JPanel> componentes = new ArrayList<>();
		
		
		int posX = PANEL_GAP;
		for ( int i = 0; i < componentesElegidos.size(); i++ ) {
			final int[] posXHolder = { posX };
			final int index = i;
			
			Componente comp = componentesElegidos.get(i);
			
			JPanel newPanel = new JPanel();			

			newPanel.setLayout(null);
			newPanel.setBackground(Color.white);
			newPanel.setPreferredSize(new Dimension(PANEL_WIDTH, PANEL_HEIGHT));
			newPanel.setBounds(0, 0, PANEL_WIDTH, PANEL_HEIGHT);
			
			componentesPanels.add(newPanel);
			posX += PANEL_WIDTH + PANEL_GAP;
			posXHolder[0] = posX;
			
			JPanel iconPanel = new JPanel();
			iconPanel.setLayout(null);
			iconPanel.setBackground(new Color(240,240,240));
			iconPanel.setBorder(new RoundedBorder(new Color(240,240,240), 1, 20));
			iconPanel.setBounds(12, 12, 508, 245);
			
			newPanel.add(iconPanel);
			
			JLabel icono = new JLabel();
			int iconWidth = 150;
			int iconHeight = 150;

			// Obtener las dimensiones de iconPanel
			int panelWidth = iconPanel.getWidth();
			int panelHeight = iconPanel.getHeight();

			// Calcular la posición x e y para centrar icono en iconPanel
			int x = (panelWidth - iconWidth) / 2;
			int y = (panelHeight - iconHeight) / 2;

			icono.setBounds(x, y, iconWidth, iconHeight);
			Image img = null;
			
			if ( comp instanceof MicroProcesador ) {
				img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
			} else if ( comp instanceof Ram ) {
				img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			} else if ( comp instanceof GPU ) {
				img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			} else if ( comp instanceof DiscoDuro ) {
				img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
			} else if ( comp instanceof TarjetaMadre ) {
				img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage(); // aqui ira una imagen generica segun el instance off del producto
			}
			
			Image scaledImg = img.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			icono.setIcon(new ImageIcon(scaledImg));
			
			iconPanel.add(icono);
			
			JLabel tituloLabel = new JLabel("Intel Core i7-14700K");
			tituloLabel.setText(comp.getMarca() + " " + comp.getModelo());
			tituloLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			tituloLabel.setBounds(24, 266, 436, 55);
			newPanel.add(tituloLabel);
			
			JLabel precioLabel = new JLabel("$159.99");
			precioLabel.setText(NumberFormat.getCurrencyInstance().format(comp.getPrecio()));
			precioLabel.setForeground(Color.BLACK);
			precioLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			precioLabel.setBounds(24, 311, 125, 41);
			newPanel.add(precioLabel);
			
			
			JLabel disponibleLabel = new JLabel("Disponibles:");
			disponibleLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			disponibleLabel.setBounds(24, 353, 152, 41);
			newPanel.add(disponibleLabel);
			
			JLabel cantDisponiblesLabel = new JLabel("");
			cantDisponiblesLabel.setBorder(new EmptyBorder(0, 10, 0, 10));
			cantDisponiblesLabel.setHorizontalAlignment(SwingConstants.TRAILING);
			cantDisponiblesLabel.setText(NumberFormat.getNumberInstance().format(comp.getCantDisponible()));
			cantDisponiblesLabel.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			cantDisponiblesLabel.setBounds(188, 353, 122, 41);
			newPanel.add(cantDisponiblesLabel);
			
			
			JSpinner cantComponentesSpn = new JSpinner();
			cantComponentesSpn.addChangeListener(new ChangeListener() {
			    public void stateChanged(ChangeEvent e) {
			        cantidadesSeleccionadas[index] = (Integer) cantComponentesSpn.getValue();
			    }
			});
			cantComponentesSpn.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), new Integer(comp.getCantDisponible()), new Integer(1)));
			cantComponentesSpn.setBounds(355, 355, 152, 41);
			cantComponentesSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			cantComponentesSpn.setName("spinner_" + i);
			newPanel.add(cantComponentesSpn);
			
			componentes.add(newPanel);
			
		}
		return componentes;
	}
}
