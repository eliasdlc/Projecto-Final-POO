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

import Logica.AnimationType;
import Logica.Componente;
import Logica.MoveToXY;
import Logica.RoundedBorder;
import Logica.WindowResizer;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JSpinner;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class ComprarComponente extends JDialog {

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
	
	private Componente componenteElegido;
	private Timer timer;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			ComprarComponente dialog = new ComprarComponente(null, null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public ComprarComponente(Componente componente1, Componente componente2) {
		setIconImage(Toolkit.getDefaultToolkit().getImage(ComprarComponente.class.getResource("/carrito.png")));
		setTitle("Comprar Componente");
		setBounds(100, 100, 873, 691); //873 original width
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		{
			JPanel panel = new JPanel();
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
			
				JButton elegirBttn1 = new JButton("Elegir");
                elegirBttn1.setVisible(false);
				elegirBttn1.setBounds(348, 708, 483, 55);
				MoveToXY elegirBttn1Hide = new MoveToXY(elegirBttn1, elegirBttn1.getX(), 708, 0.8f, AnimationType.EASE_IN_OUT);
				MoveToXY elegirBttn1Show = new MoveToXY(elegirBttn1, elegirBttn1.getX(), 508, 0.8f, AnimationType.EASE_IN);
				elegirBttn1.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						elegirBttn1.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						elegirBttn1.setBackground(hoverEffectColor);
						elegirBttn1.setForeground(Color.WHITE);
					}
					public void mouseExited(MouseEvent arg0) {
						elegirBttn1.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						elegirBttn1.setBackground(SecondaryC);
						elegirBttn1.setForeground(Color.WHITE);
					}
				});
				elegirBttn1.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				elegirBttn1.setBackground(SecondaryC);
				elegirBttn1.setForeground(Color.WHITE);
				elegirBttn1.setFont(new Font("Century Gothic", Font.BOLD, 18));
				
				panel.add(elegirBttn1);
				
				
				JButton comprarBttn = new JButton("Comprar");
				comprarBttn.setBounds(348, 440, 483, 55);
				MoveToXY comprarBttnHide = new MoveToXY(comprarBttn, -200, comprarBttn.getY(), 0.8f, AnimationType.EASE_IN_OUT);
				MoveToXY comprarBttnShow = new MoveToXY(comprarBttn, 348, comprarBttn.getY(), 0.8f, AnimationType.EASE_IN_OUT);
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
			
			
				JButton compararBttn = new JButton("Comparar");
				compararBttn.setBounds(348, 508, 483, 55);
				MoveToXY compararBttnHide = new MoveToXY(compararBttn, -200, compararBttn.getY(), 0.8f, AnimationType.EASE_IN_OUT);
				MoveToXY compararBttnShow = new MoveToXY(compararBttn, 348, compararBttn.getY(), 0.8f, AnimationType.EASE_IN_OUT);
				compararBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						compararBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						//compararBttn.setBackground(new Color(248, 248, 248));
						compararBttn.setForeground(hoverEffectColor);
						compararBttn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						compararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						compararBttn.setForeground(SecondaryC);
						compararBttn.setOpaque(false);
					}
				});
				compararBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				compararBttn.setForeground(SecondaryC);
				compararBttn.setBackground(new Color(248, 248, 248));
				compararBttn.setOpaque(false);
				compararBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				
				panel.add(compararBttn);
			
			
			{
				JButton cancelarBttn = new JButton("Cancelar");
				cancelarBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelarBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent e) {
						cancelarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
						//compararBttn.setBackground(new Color(248, 248, 248));
						cancelarBttn.setForeground(hoverEffectColor);
						cancelarBttn.setOpaque(true);
					}
					public void mouseExited(MouseEvent e) {
						cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
						cancelarBttn.setForeground(SecondaryC);
						cancelarBttn.setOpaque(false);
					}
				});
				cancelarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
				cancelarBttn.setForeground(SecondaryC);
				cancelarBttn.setBackground(new Color(248, 248, 248));
				cancelarBttn.setOpaque(false);
				cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
				cancelarBttn.setBounds(348, 576, 483, 55);
				panel.add(cancelarBttn);
			}
			
			JSpinner cantComponentesSpn = new JSpinner();
			cantComponentesSpn.setBounds(348, 365, 215, 41);
			MoveToXY cantComponentesSpnHide = new MoveToXY(cantComponentesSpn, -200, cantComponentesSpn.getY(), 0.8f, AnimationType.EASE_OUT);
			MoveToXY cantComponentesSpnShow = new MoveToXY(cantComponentesSpn, 348, cantComponentesSpn.getY(), 0.8f, AnimationType.EASE_IN);
			cantComponentesSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
			panel.add(cantComponentesSpn);
			
			JLabel lblNewLabel = new JLabel("Intel Core i7-14700K");
			lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 24));
			lblNewLabel.setBounds(348, 266, 436, 55);
			panel.add(lblNewLabel);
			
			JLabel label = new JLabel("$159.99");
			label.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			label.setBounds(348, 311, 436, 41);
			panel.add(label);
			
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(335, 13, 508, 245);
			panel_1.setBorder(new RoundedBorder(Color.white, 1, 10));
			panel_1.setBackground(new Color(240, 240, 240));
			panel.add(panel_1);
			panel_1.setLayout(null);
			
			JLabel componenteIcon1 = new JLabel("");
			componenteIcon1.setBounds(144, 13, 220, 220);
			panel_1.add(componenteIcon1);
			Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
			Image scaledImg = img.getScaledInstance(componenteIcon1.getHeight(), componenteIcon1.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon1.setIcon(new ImageIcon(scaledImg));
			
			JTextPane textPaneComp1 = new JTextPane();
			textPaneComp1.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			textPaneComp1.setBounds(348, 365, 483, 130);
			textPaneComp1.setOpaque(false);
			panel.add(textPaneComp1);
			
			
			JPanel componente1Panel = new JPanel();
			componente1Panel.setBackground(Color.WHITE);
			componente1Panel.setBounds(323, 0, 532, 644);
			panel.add(componente1Panel);
			
			JPanel componente2Panel = new JPanel();
			componente2Panel.setVisible(false);
			componente2Panel.setBounds(323, 0, 532, 644);
			MoveToXY componente2PanelShow = new MoveToXY(componente2Panel, 855, componente2Panel.getY(), 0.8f, AnimationType.EASE_IN);
			MoveToXY componente2PanelHide = new MoveToXY(componente2Panel, 323, componente2Panel.getY(), 0.8f, AnimationType.EASE_OUT);
			panel.add(componente2Panel);
			componente2Panel.setLayout(null);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBounds(12, 13, 508, 245);
			panel_2.setLayout(null);
			panel_2.setBorder(new RoundedBorder(Color.white, 1, 10));
			panel_2.setBackground(Color.WHITE);
			
			componente2Panel.add(panel_2);
			
			
			JLabel componenteIcon2 = new JLabel("");
			componenteIcon2.setBounds(144, 12, 220, 220);
			panel_2.add(componenteIcon2);
			Image img2 = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
			Image scaledImg2 = img2.getScaledInstance(componenteIcon2.getHeight(), componenteIcon2.getWidth(), Image.SCALE_SMOOTH);
			componenteIcon2.setIcon(new ImageIcon(scaledImg2));
			
			
			JButton elegirBttn2 = new JButton("Elegir");
			elegirBttn2.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent arg0) {
					elegirBttn2.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
					elegirBttn2.setBackground(hoverEffectColor);
					elegirBttn2.setForeground(Color.WHITE);
				}
				public void mouseExited(MouseEvent arg0) {
					elegirBttn2.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					elegirBttn2.setBackground(SecondaryC);
					elegirBttn2.setForeground(Color.WHITE);
				}
			});
			elegirBttn2.setForeground(Color.WHITE);
			elegirBttn2.setFont(new Font("Century Gothic", Font.BOLD, 18));
			elegirBttn2.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			elegirBttn2.setBackground(new Color(3, 104, 196));
			elegirBttn2.setBounds(24, 508, 483, 55);
			componente2Panel.add(elegirBttn2);
			
			JButton cambiarBttn = new JButton("Cambiar");
			cambiarBttn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					cambiarBttn.setBorder(new RoundedBorder(hoverEffectColor, 1, 10));
					//compararBttn.setBackground(new Color(248, 248, 248));
					cambiarBttn.setForeground(hoverEffectColor);
					cambiarBttn.setOpaque(true);
				}
				public void mouseExited(MouseEvent e) {
					cambiarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
					cambiarBttn.setForeground(SecondaryC);
					cambiarBttn.setOpaque(false);
				}
			});
			cambiarBttn.setOpaque(false);
			cambiarBttn.setForeground(new Color(3, 104, 196));
			cambiarBttn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			cambiarBttn.setBorder(new RoundedBorder(SecondaryC, 1, 10));
			cambiarBttn.setBackground(new Color(248, 248, 248));
			cambiarBttn.setBounds(24, 576, 483, 55);
			componente2Panel.add(cambiarBttn);
			
			JTextPane textPaneComp2 = new JTextPane();
			textPaneComp2.setFont(new Font("Century Gothic", Font.PLAIN, 18));
			textPaneComp2.setBounds(24, 365, 483, 130);
			textPaneComp2.setOpaque(false);
			componente2Panel.add(textPaneComp2);
			
			JLabel label_1 = new JLabel("$499.99");
			label_1.setFont(new Font("Century Gothic", Font.PLAIN, 24));
			label_1.setBounds(22, 311, 436, 41);
			componente2Panel.add(label_1);
			
			JLabel label_2 = new JLabel("NVIDIA GeForce RTX 3070");
			label_2.setFont(new Font("Century Gothic", Font.BOLD, 24));
			label_2.setBounds(22, 266, 436, 55);
			componente2Panel.add(label_2);
			
			
			compararBttn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					componente2Panel.setVisible(true);
					elegirBttn1.setVisible(true);
					
					
					componente2PanelShow.start();
					cantComponentesSpnHide.start();
					comprarBttnHide.start();
					elegirBttn1Show.start();
					compararBttnHide.start();
					WindowResizer windowResizerShow = new WindowResizer( (JDialog) SwingUtilities.getWindowAncestor(elegirBttn1),
							1406, 691, 0.8f, AnimationType.EASE_IN);
					windowResizerShow.start();
					
					timer = new Timer(1000, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			            	cantComponentesSpn.setVisible(false);
							comprarBttn.setVisible(false);
							compararBttn.setVisible(false);
			                ((Timer)e.getSource()).stop();
			            }
			        });
			        timer.setRepeats(false);
			        timer.start();
					
				}
			});
			elegirBttn1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					componenteElegido = componente1;
					cantComponentesSpn.setVisible(true);
					comprarBttn.setVisible(true);
					compararBttn.setVisible(true);
					componente2PanelHide.start();
					elegirBttn1Hide.start();
					cantComponentesSpnShow.start();
					comprarBttnShow.start();
					compararBttnShow.start();
					
					WindowResizer windowResizerHide = new WindowResizer( (JDialog) SwingUtilities.getWindowAncestor(elegirBttn1),
							873, 691, 0.8f, AnimationType.EASE_OUT);
					
					windowResizerHide.start();
					
					timer = new Timer(1000, new ActionListener() {
			            @Override
			            public void actionPerformed(ActionEvent e) {
			                componente2Panel.setVisible(false);
			                elegirBttn1.setVisible(false);
			                ((Timer)e.getSource()).stop();
			            }
			        });
			        timer.setRepeats(false);
			        timer.start();
					
				}
			});
			
		}
		
	}
}
