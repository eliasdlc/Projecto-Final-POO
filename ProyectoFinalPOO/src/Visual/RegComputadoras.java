package Visual;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import Logica.AnimationType;
import Logica.Componente;
import Logica.Computadora;
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

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.Timer;
import javax.swing.JRadioButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.UIManager;

public class RegComputadoras extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;
	
	private static final Color PrimaryC = new Color(3, 88, 157);
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color ThirdC = new Color(247, 251, 255);
	private static final Color AccentColor = new Color(255, 133, 78); //255, 150, 95
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color HoverEffectColor = new Color(3, 135, 255);
	
	private static Object row[];
	private static DefaultTableModel model;
	private String cod = "";
	String headers[] = {"ID", "Nombre", "Espacio", "Tipo Memoria"};
	private JRadioButton ramRadioBttn;
	private JRadioButton tarjetaMadreRadioBttn;
	private JRadioButton microProcesadorRadioBttn;
	private JRadioButton discoDuroRadioBttn;
	private JRadioButton gpuRadioBttn;
	private JTable table_1;
	private JPanel selector;
	private JButton registrarBttn;
	private JButton cancelarBttn;
	private JLabel lblNewLabel;
	private JLabel lblPrecio;
	private JLabel lblTipo;
	private JTextField tipoTextField;
	private JTextField idTextField;
	private JPanel stepsPanel;
	private JLabel step1;
	private JLabel step2;
	private JLabel step3;
	private JLabel step4;
	private JLabel step5;
	
	private int[] activeStepList = new int[5];
	private int currentStep = 0;
	private ArrayList<JLabel> stepsList = new ArrayList<>();
	private ArrayList<JRadioButton> buttonsList = new ArrayList<>();
	private ArrayList<Componente> componentesPc = new ArrayList<>(Arrays.asList(null, null, null, null, null));
	
	private JLabel descripcionPasoLabel;
	private JSpinner precioSpn;
	private JLabel lblComponentesSeleccionados;
	private JPanel gpuPanel;
	private JPanel discoDuroPanel;
	private JPanel microProcesadorPanel;
	private JPanel ramPanel;
	private JPanel tarjetaMadrePanel;
	private JLabel tarjetaMadreId;
	private JLabel tarjetaMadreNombre;
	private JLabel ramId;
	private JLabel ramNombre;
	private JLabel label_3;
	private JLabel label_4;
	private JLabel microProcesadorId;
	private JLabel microProcesadorNombre;
	private JLabel label_7;
	private JLabel label_8;
	private JLabel discoDuroId;
	private JLabel discoDuroNombre;
	private JLabel label_11;
	private JLabel label_12;
	private JLabel gpuId;
	private JLabel gpuNombre;
	private JLabel label_15;
	private JLabel label_16;
	private JLabel notSelectedLabel;
	private JButton quitar1;
	private JButton quitar2;
	private JButton quitar3;
	private JButton quitar4;
	private JButton quitar;
	private JSpinner cantidadSpn;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComputadoras dialog = new RegComputadoras();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComputadoras() {
		setBounds(100, 100, 1590, 819);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		activeStepList[0] = 1;
		
		ArrayList<Componente> listaComponentes0 = new ArrayList<>();
		Componente tarjetaMadre = new TarjetaMadre("TM001", "ASUS", "ROG Strix B550-F", 189.99f, 40, 120, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
		Componente cpu = new MicroProcesador("CPU001", "Intel", "Core i7-11700K", 329.99f, 50, 150, 3.6f, "LGA1200", 8);
		Componente memoria = new Ram("RAM001", "Corsair", "Vengeance LPX", 79.99f, 100, 300, "16GB", "DDR4");
		Componente tarjetaGrafica = new GPU("GPU001", "NVIDIA", "GeForce RTX 3070", 499.99f, 30, 200, "Dedicada", 8.0f, 1.73f, "PCIe 4.0");
		Componente disco = new DiscoDuro("HDD001", "Western Digital", "Blue", 59.99f, 80, 250, 1000.0f, "TB", 150.0f, 130.0f, "HDD", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
		Componente cpu2 = new MicroProcesador("CPU002", "AMD", "Ryzen 7 5800X", 399.99f, 60, 180, 3.8f, "AM4", 8);
		Componente memoria2 = new Ram("RAM002", "G.Skill", "Trident Z RGB", 129.99f, 75, 250, "32GB", "DDR4");
		Componente tarjetaGrafica2 = new GPU("GPU002", "AMD", "Radeon RX 6800 XT", 649.99f, 25, 150, "Dedicada", 16.0f, 2.25f, "PCIe 4.0");
		Componente disco2 = new DiscoDuro("SSD001", "Samsung", "970 EVO Plus", 129.99f, 100, 300, 1000.0f, "TB", 3500.0f, 3300.0f, "SSD", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe")));
		Componente tarjetaMadre2 = new TarjetaMadre("TM002", "MSI", "MPG B550 Gaming Edge WiFi", 169.99f, 35, 140, "AM4", "DDR4", "", new ArrayList<>(Arrays.asList("SATA-3", "M.2 NVMe", "PCIe 4.0")));
		
		Tienda.getInstance().insertarComponente(tarjetaMadre);
		Tienda.getInstance().insertarComponente(cpu);
		Tienda.getInstance().insertarComponente(memoria);
		Tienda.getInstance().insertarComponente(tarjetaGrafica);
		Tienda.getInstance().insertarComponente(disco);
		Tienda.getInstance().insertarComponente(cpu2);
		Tienda.getInstance().insertarComponente(memoria2);
		Tienda.getInstance().insertarComponente(tarjetaGrafica2);
		Tienda.getInstance().insertarComponente(disco2);
		Tienda.getInstance().insertarComponente(tarjetaMadre2);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1572, 772);
		panel.setBackground(PrimaryC);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel infoGeneralPanel = new JPanel();
		infoGeneralPanel.setBorder(new RoundedBorder(new Color(240, 240, 240), 1, 20));
		infoGeneralPanel.setBounds(12, 13, 1197, 247);
		panel.add(infoGeneralPanel);
		infoGeneralPanel.setLayout(null);
		Image img = new ImageIcon(this.getClass().getResource("/ordenador.png")).getImage();
		
		stepsPanel = new JPanel();
		stepsPanel.setBackground(Color.white);
		stepsPanel.setBorder(new RoundedBorder(Color.white, 1, 20));
		stepsPanel.setBounds(12, 13, 1173, 131);
		infoGeneralPanel.add(stepsPanel);
		stepsPanel.setLayout(null);
		
		step1 = new JLabel();
		step1.setForeground(Color.WHITE);
		step1.setFont(new Font("Century Gothic", Font.BOLD, 24));
		step1.setHorizontalAlignment(SwingConstants.CENTER);
		step1.setText("1");
		step1.setBackground(HoverEffectColor);
		step1.setBorder(new RoundedBorder(HoverEffectColor, 1, 100));
		step1.setOpaque(true);
		step1.setBounds(244, 13, 60, 60);
		stepsList.add(step1);
		
		step2 = new JLabel();
		step2.setText("2");
		step2.setOpaque(true);
		step2.setHorizontalAlignment(SwingConstants.CENTER);
		step2.setForeground(Color.WHITE);
		step2.setFont(new Font("Century Gothic", Font.BOLD, 24));
		step2.setBorder(new RoundedBorder(PrimaryC, 1, 100));
		step2.setBackground(new Color(3, 88, 157));
		step2.setBounds(400, 13, 60, 60);
		stepsList.add(step2);
		
		step3 = new JLabel();
		step3.setText("3");
		step3.setOpaque(true);
		step3.setHorizontalAlignment(SwingConstants.CENTER);
		step3.setForeground(Color.WHITE);
		step3.setFont(new Font("Century Gothic", Font.BOLD, 24));
		step3.setBorder(new RoundedBorder(PrimaryC, 1, 100));
		step3.setBackground(new Color(3, 88, 157));
		step3.setBounds(556, 13, 60, 60);
		stepsList.add(step3);
		
		step4 = new JLabel();
		step4.setText("4");
		step4.setOpaque(true);
		step4.setHorizontalAlignment(SwingConstants.CENTER);
		step4.setForeground(Color.WHITE);
		step4.setFont(new Font("Century Gothic", Font.BOLD, 24));
		step4.setBorder(new RoundedBorder(PrimaryC, 1, 100));
		step4.setBackground(new Color(3, 88, 157));
		step4.setBounds(712, 13, 60, 60);
		stepsList.add(step4);	
		
		step5 = new JLabel();
		step5.setText("5");
		step5.setOpaque(true);
		step5.setHorizontalAlignment(SwingConstants.CENTER);
		step5.setForeground(Color.WHITE);
		step5.setFont(new Font("Century Gothic", Font.BOLD, 24));
		step5.setBorder(new RoundedBorder(PrimaryC, 1, 100));
		step5.setBackground(new Color(3, 88, 157));
		step5.setBounds(868, 13, 60, 60);
		stepsList.add(step5);
		
		for ( JLabel step : stepsList ) {
			stepsPanel.add(step);
		}
		
		
		JLabel line = new JLabel("_______________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________________");
		line.setHorizontalAlignment(SwingConstants.CENTER);
		line.setFont(new Font("Tahoma", Font.BOLD, 18));
		line.setForeground(PrimaryC);
		line.setBounds(244, 13, 684, 48);
		stepsPanel.add(line);
		
		descripcionPasoLabel = new JLabel("Paso 1: Elegir Tarjeta Madre.");
		descripcionPasoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		descripcionPasoLabel.setHorizontalAlignment(SwingConstants.CENTER);
		descripcionPasoLabel.setBounds(158, 86, 857, 32);
		stepsPanel.add(descripcionPasoLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 150, 1173, 84);
		infoGeneralPanel.add(panel_2);
		panel_2.setLayout(null);
		
		cantidadSpn = new JSpinner();
		cantidadSpn.setModel(new SpinnerNumberModel(new Integer(1), new Integer(1), null, new Integer(1)));
		cantidadSpn.setBounds(995, 25, 144, 33);
		panel_2.add(cantidadSpn);
		cantidadSpn.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setBounds(846, 25, 119, 33);
		panel_2.add(lblCantidad);
		lblCantidad.setFont(new Font("Century Gothic", Font.BOLD, 22));
		
		tipoTextField = new JTextField();
		tipoTextField.setBounds(672, 25, 144, 33);
		panel_2.add(tipoTextField);
		tipoTextField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		tipoTextField.setColumns(10);
		
		lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(577, 25, 65, 33);
		panel_2.add(lblTipo);
		lblTipo.setFont(new Font("Century Gothic", Font.BOLD, 22));
		
		precioSpn = new JSpinner();
		precioSpn.setBounds(403, 25, 144, 33);
		panel_2.add(precioSpn);
		precioSpn.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(1)));
		precioSpn.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		lblPrecio = new JLabel("Precio:");
		lblPrecio.setBounds(293, 25, 80, 33);
		panel_2.add(lblPrecio);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD, 22));
		
		idTextField = new JTextField();
		idTextField.setBounds(119, 25, 144, 33);
		panel_2.add(idTextField);
		idTextField.setText("PC-" + Tienda.getInstance().getCodComputadora());
		idTextField.setEditable(false);
		idTextField.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		idTextField.setColumns(10);
		
		lblNewLabel = new JLabel("ID:");
		lblNewLabel.setBounds(30, 25, 59, 33);
		panel_2.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
		

		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new RoundedBorder(new Color(240, 240, 240), 1, 20));
		panel_1.setBounds(12, 267, 1197, 435);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel listadoPanel = new JPanel();
		listadoPanel.setBackground(Color.WHITE);
		listadoPanel.setBounds(304, 13, 881, 409);
		panel_1.add(listadoPanel);
		listadoPanel.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBorder(new EmptyBorder(0,0,0,0));
		scrollPane.setBorder(new RoundedBorder(Color.white, 1, 20));
		
		
		
		scrollPane.getViewport().setBackground(Color.white);

		scrollPane.setBackground(Color.white);
		listadoPanel.add(scrollPane, BorderLayout.CENTER);
				
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				int index = table.getSelectedRow();
				if (index >= 0) {
					cod = table.getValueAt(index, 0).toString();
					System.out.println(cod);
					Componente comp = Tienda.getInstance().searchComponenteById(cod);
					
					
					
					if (comp instanceof TarjetaMadre) {
				        tarjetaMadrePanel.setVisible(true);
				        notSelectedLabel.setVisible(false);
				        tarjetaMadreId.setText(comp.getId());
				        tarjetaMadreNombre.setText(comp.getMarca() + " " + comp.getModelo());
				        
				        componentesPc.set(0, comp);
				    } else if (comp instanceof Ram && tarjetaMadrePanel.isVisible()) {
				        ramPanel.setVisible(true);
				        ramId.setText(comp.getId());
				        ramNombre.setText(comp.getMarca() + " " + comp.getModelo());
				        
				        componentesPc.set(1, comp);
				    } else if (comp instanceof MicroProcesador && tarjetaMadrePanel.isVisible() && ramPanel.isVisible()) {
				        microProcesadorPanel.setVisible(true);
				        microProcesadorId.setText(comp.getId());
				        microProcesadorNombre.setText(comp.getMarca() + " " + comp.getModelo());
				        componentesPc.set(2, comp);
				    } else if (comp instanceof DiscoDuro && tarjetaMadrePanel.isVisible() && ramPanel.isVisible() && microProcesadorPanel.isVisible()) {
				        discoDuroPanel.setVisible(true);
				        discoDuroId.setText(comp.getId());
				        discoDuroNombre.setText(comp.getMarca() + " " + comp.getModelo());
				        componentesPc.set(3, comp);
				    } else if (comp instanceof GPU && tarjetaMadrePanel.isVisible() && ramPanel.isVisible() && microProcesadorPanel.isVisible() && discoDuroPanel.isVisible()) {
				        gpuPanel.setVisible(true);
				        gpuId.setText(comp.getId());
				        gpuNombre.setText(comp.getMarca() + " " + comp.getModelo());
				        componentesPc.set(4, comp);
				    }
					
					if ( currentStep == 1 && !tarjetaMadrePanel.isVisible() ) {
						descripcionPasoLabel.setText("Primero debe agregar la Tarjeta Madre!");
					    descripcionPasoLabel.setForeground(new Color(167, 34, 34));
					} else if ( currentStep == 2 && !ramPanel.isVisible() ) {
						descripcionPasoLabel.setText("Primero debe agregar la RAM!");
					    descripcionPasoLabel.setForeground(new Color(167, 34, 34));
					} else if ( currentStep == 3 && !microProcesadorPanel.isVisible() ) {
						descripcionPasoLabel.setText("Primero debe agregar el Micro Procesador!");
					    descripcionPasoLabel.setForeground(new Color(167, 34, 34));
					} else if ( currentStep == 4 && !discoDuroPanel.isVisible() ) {
						descripcionPasoLabel.setText("Primero debe agregar el Disco Duro!");
					    descripcionPasoLabel.setForeground(new Color(167, 34, 34));
					}

					
					String componentes = String.join(", ", componentesPc.toString());
					System.out.println(componentes);
					
					if ( currentStep < 4 ) {
						activeStepList[currentStep] = 0;
						currentStep ++;
						activeStepList[currentStep] = 1;
						updateSelection(buttonsList.get(currentStep));
						loadArticulos();
						loadComponente(headers);
						loadStep();
					}
					
				}
			}
		});
		table.setBackground(Color.white);
		table.setDragEnabled(false);
		model = new DefaultTableModel();
		table.setDefaultEditor(Object.class, null);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		model.setColumnIdentifiers(headers);
		table.setModel(model);
		
		table.getTableHeader().setPreferredSize(new Dimension(10, 40));
		table.getTableHeader().setBackground(PrimaryC);
		table.getTableHeader().setForeground(Color.white);
		table.getTableHeader().setBorder(new RoundedBorder(PrimaryC, 1, 20));
		
		table.getColumnModel().getColumn(0).setPreferredWidth(50);
		table.getColumnModel().getColumn(1).setPreferredWidth(200); 
		table.getColumnModel().getColumn(2).setPreferredWidth(50); 
		table.getColumnModel().getColumn(3).setPreferredWidth(100);

		
		table.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		table.getTableHeader().setFont(new Font("Century Gothic", Font.BOLD, 18));		
		table.setRowHeight(25);
		table.setBorder(new RoundedBorder(Color.white, 1, 20));
		
		table.setDefaultRenderer(Object.class, new DefaultTableCellRenderer() {
		    @Override
		    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		        Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
		        if (!isSelected) {
		            c.setBackground(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
		            table.setGridColor(row % 2 == 0 ? new Color(240, 240, 240) : Color.WHITE);
		            
		        }
		        return c;
		    }
		});
		
		scrollPane.setViewportView(table);
		
		
		tarjetaMadreRadioBttn = new JRadioButton("Tarjeta Madre");
		tarjetaMadreRadioBttn.setSelected(true);
		tarjetaMadreRadioBttn.setHorizontalAlignment(SwingConstants.CENTER);
		tarjetaMadreRadioBttn.setForeground(Color.WHITE);
		tarjetaMadreRadioBttn.setFocusPainted(false);
		tarjetaMadreRadioBttn.setOpaque(false);
		tarjetaMadreRadioBttn.setBounds(8, 28, 284, 53);
		buttonsList.add(tarjetaMadreRadioBttn);
		tarjetaMadreRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activeStepList[currentStep] = 0;
				currentStep = 0;
				activeStepList[currentStep] = 1;				
				updateSelection(tarjetaMadreRadioBttn);
		        loadArticulos();
				loadComponente(headers);
				loadStep();
			}
		});
		tarjetaMadreRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		ramRadioBttn = new JRadioButton("RAM");
		ramRadioBttn.setHorizontalAlignment(SwingConstants.CENTER);
		ramRadioBttn.setForeground(Color.BLACK);
		ramRadioBttn.setFocusPainted(false);
		ramRadioBttn.setOpaque(false);
		ramRadioBttn.setBounds(8, 109, 284, 53);
		buttonsList.add(ramRadioBttn);
		ramRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activeStepList[currentStep] = 0;
				currentStep = 1;
				activeStepList[currentStep] = 1;
				updateSelection(ramRadioBttn);
		        loadArticulos();
				loadComponente(headers);
				loadStep();
			}
		});
		ramRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		microProcesadorRadioBttn = new JRadioButton("Mircro Procesador");
		microProcesadorRadioBttn.setHorizontalAlignment(SwingConstants.CENTER);
		microProcesadorRadioBttn.setFocusPainted(false);
		microProcesadorRadioBttn.setOpaque(false);
		microProcesadorRadioBttn.setBounds(8, 190, 284, 53);
		buttonsList.add(microProcesadorRadioBttn);
		microProcesadorRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activeStepList[currentStep] = 0;
				currentStep = 2;
				activeStepList[currentStep] = 1;
				updateSelection(microProcesadorRadioBttn);
		        loadArticulos();
				loadComponente(headers);
				loadStep();
			}
		});
		microProcesadorRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		discoDuroRadioBttn = new JRadioButton("Disco Duro");
		discoDuroRadioBttn.setHorizontalAlignment(SwingConstants.CENTER);
		discoDuroRadioBttn.setFocusPainted(false);
		discoDuroRadioBttn.setOpaque(false);
		discoDuroRadioBttn.setBounds(8, 271, 284, 53);
		buttonsList.add(discoDuroRadioBttn);
		discoDuroRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activeStepList[currentStep] = 0;
				currentStep = 3;
				activeStepList[currentStep] = 1;
				updateSelection(discoDuroRadioBttn);
		        loadArticulos();
				loadComponente(headers);
				loadStep();
			}
		});
		discoDuroRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		gpuRadioBttn = new JRadioButton("GPU");
		gpuRadioBttn.setHorizontalAlignment(SwingConstants.CENTER);
		gpuRadioBttn.setFocusPainted(false);
		gpuRadioBttn.setOpaque(false);
		gpuRadioBttn.setBounds(8, 352, 284, 53);
		buttonsList.add(gpuRadioBttn);
		gpuRadioBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				activeStepList[currentStep] = 0;
				currentStep = 4;
				activeStepList[currentStep] = 1;
				updateSelection(gpuRadioBttn);
		        loadArticulos();
				loadComponente(headers);
				loadStep();
			}
		});
		gpuRadioBttn.setFont(new Font("Century Gothic", Font.PLAIN, 24));
		
		for ( JRadioButton button : buttonsList ) {
			panel_1.add(button);
		}
		
		
		selector = new JPanel();
		selector.setBackground(PrimaryC);
		selector.setBorder(new RoundedBorder(PrimaryC, 1, 20));
		selector.setBounds(12, 28, 280, 53);
		panel_1.add(selector);
		
		cancelarBttn = new JButton("Cancelar");
		cancelarBttn.setFocusPainted(false);
		cancelarBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		cancelarBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				cancelarBttn.setBackground(new Color(167, 34, 34));
				cancelarBttn.setForeground(Color.white);
				cancelarBttn.setBorder(new RoundedBorder(new Color(167, 34, 34), 1, 20));
			}
			public void mouseExited(MouseEvent arg0) {
				cancelarBttn.setBackground(ThirdC);
				cancelarBttn.setForeground(Color.black);
				cancelarBttn.setBorder(new RoundedBorder(ThirdC, 1, 20));
			}
		});
		cancelarBttn.setBackground(ThirdC);
		cancelarBttn.setBorder(new RoundedBorder(ThirdC, 1, 20));
		cancelarBttn.setFont(new Font("Century Gothic", Font.BOLD, 22));
		cancelarBttn.setBounds(1024, 715, 185, 44);
		panel.add(cancelarBttn);
		
		registrarBttn = new JButton("Registrar");
		registrarBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String id = idTextField.getText();
				Float precio = Float.parseFloat(precioSpn.getValue().toString());
				String tipo = tipoTextField.getText();
				int cantidad = Integer.parseInt(cantidadSpn.getValue().toString());
				
				if ( !tarjetaMadrePanel.isVisible() || !ramPanel.isVisible() || !microProcesadorPanel.isVisible() || !discoDuroPanel.isVisible() || !gpuPanel.isVisible() ) {
					PopUpError error = new PopUpError("Debe seleccionar cada tipo de componentes correspondiente antes de registrar la computadora!", ErrorType.WARNING);
					error.setVisible(true);
				} else if ( precio == 1f && tipo.isEmpty() ) {
					PopUpError error = new PopUpError("Debe llenar todos los espacios antes de registrar la computadora!", ErrorType.WARNING);
					error.setVisible(true);
				} else {
					Computadora newComputer = new Computadora(id, componentesPc, precio, cantidad, tipo);
					Tienda.getInstance().insertarComputadora(newComputer);
					PopUp newPopUp = new PopUp("La computadora " + newComputer.getId() + " fue creada exitosamente!");
					newPopUp.setVisible(true);
					clean();
					activeStepList[currentStep] = 0;
					currentStep = 0;
					activeStepList[currentStep] = 1;
					updateSelection(buttonsList.get(currentStep));
					loadArticulos();
					loadComponente(headers);
					loadStep();
				}
				
				
			}
		});
		registrarBttn.setFocusPainted(false);
		registrarBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				registrarBttn.setBackground(new Color(11, 182, 72));
				registrarBttn.setForeground(Color.white);
				registrarBttn.setBorder(new RoundedBorder(new Color(11, 182, 72), 1, 20));
			}
			public void mouseExited(MouseEvent arg0) {
				registrarBttn.setBackground(ThirdC);
				registrarBttn.setForeground(Color.black);
				registrarBttn.setBorder(new RoundedBorder(ThirdC, 1, 20));
			}
		});
		registrarBttn.setBackground(ThirdC);
		registrarBttn.setBorder(new RoundedBorder(ThirdC, 1, 20));
		registrarBttn.setFont(new Font("Century Gothic", Font.BOLD, 22));
		registrarBttn.setBounds(827, 715, 185, 44);
		panel.add(registrarBttn);
		
		JButton btnAtras = new JButton("Atras");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if ( currentStep > 0 ) {
					activeStepList[currentStep] = 0;
					currentStep --;
					activeStepList[currentStep] = 1;
					updateSelection(buttonsList.get(currentStep));
					loadArticulos();
					loadComponente(headers);
					loadStep();
				}
				
			}
		});
		btnAtras.setFont(new Font("Century Gothic", Font.BOLD, 22));
		btnAtras.setFocusPainted(false);
		btnAtras.setBorder(new RoundedBorder(ThirdC, 1, 20));
		btnAtras.setBackground(new Color(247, 251, 255));
		btnAtras.setBounds(12, 715, 150, 44);
		panel.add(btnAtras);
		
		JPanel componentesPcPanel = new JPanel();
		componentesPcPanel.setBounds(1215, 13, 345, 746);
		componentesPcPanel.setBorder(new RoundedBorder(new Color(240, 240, 240), 1, 20));
		panel.add(componentesPcPanel);
		componentesPcPanel.setLayout(null);
		
		RoundedBorder roundedBorder = new RoundedBorder(Color.WHITE, 1, 20);
		
		lblComponentesSeleccionados = new JLabel("Componentes Seleccionados");
		lblComponentesSeleccionados.setHorizontalAlignment(SwingConstants.CENTER);
		lblComponentesSeleccionados.setBounds(12, 6, 321, 41);
		lblComponentesSeleccionados.setFont(new Font("Century Gothic", Font.BOLD, 22));
		componentesPcPanel.add(lblComponentesSeleccionados);
		
		gpuPanel = new JPanel();
		gpuPanel.setVisible(false);
		TitledBorder titledBorder = new TitledBorder(new CompoundBorder(), "GPU", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 16), new Color(0, 0, 0));
		gpuPanel.setBorder(new CompoundBorder(roundedBorder, titledBorder));
		gpuPanel.setBackground(Color.WHITE);
		gpuPanel.setBounds(12, 608, 321, 125);
		componentesPcPanel.add(gpuPanel);
		gpuPanel.setLayout(null);
		
		gpuId = new JLabel("New label");
		gpuId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gpuId.setBounds(91, 37, 192, 25);
		gpuPanel.add(gpuId);
		
		gpuNombre = new JLabel("New label");
		gpuNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		gpuNombre.setBounds(91, 87, 218, 25);
		gpuPanel.add(gpuNombre);
		
		label_15 = new JLabel("Nombre:");
		label_15.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_15.setBounds(12, 87, 93, 25);
		gpuPanel.add(label_15);
		
		label_16 = new JLabel("ID:");
		label_16.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_16.setBounds(12, 37, 93, 25);
		gpuPanel.add(label_16);
		
		quitar4 = new JButton("X");
		quitar4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = 4;
				Componente comp = componentesPc.get(index);

				gpuPanel.setVisible(false);
				componentesPc.set(index, null);
				String componentes = String.join(", ", componentesPc.toString());
				System.out.println(componentes);
			}
		});
		quitar4.setBackground(Color.WHITE);
		quitar4.setBorder(new EmptyBorder(0,0,0,0));
		quitar4.setOpaque(false);
		quitar4.setFocusPainted(false);
		quitar4.setHorizontalAlignment(SwingConstants.CENTER);
		quitar4.setForeground(Color.RED);
		quitar4.setFont(new Font("Century Gothic", Font.BOLD, 18));
		quitar4.setBounds(283, 0, 38, 38);
		gpuPanel.add(quitar4);
		
		discoDuroPanel = new JPanel();
		discoDuroPanel.setVisible(false);
		TitledBorder titledBorder1 = new TitledBorder(new CompoundBorder(), "Disco Duro", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 16), new Color(0, 0, 0));
		discoDuroPanel.setBorder(new CompoundBorder(roundedBorder, titledBorder1));
		discoDuroPanel.setBackground(Color.WHITE);
		discoDuroPanel.setBounds(12, 470, 321, 125);
		componentesPcPanel.add(discoDuroPanel);
		discoDuroPanel.setLayout(null);
		
		discoDuroId = new JLabel("New label");
		discoDuroId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		discoDuroId.setBounds(91, 37, 192, 25);
		discoDuroPanel.add(discoDuroId);
		
		discoDuroNombre = new JLabel("New label");
		discoDuroNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		discoDuroNombre.setBounds(91, 87, 218, 25);
		discoDuroPanel.add(discoDuroNombre);
		
		label_11 = new JLabel("Nombre:");
		label_11.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_11.setBounds(12, 87, 93, 25);
		discoDuroPanel.add(label_11);
		
		label_12 = new JLabel("ID:");
		label_12.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_12.setBounds(12, 37, 93, 25);
		discoDuroPanel.add(label_12);
		
		quitar3 = new JButton("X");
		quitar3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = 3;
				Componente comp = componentesPc.get(index);

				if (  !gpuPanel.isVisible() ) {
					discoDuroPanel.setVisible(false);
					componentesPc.set(index, null);
					String componentes = String.join(", ", componentesPc.toString());
					System.out.println(componentes);
				}
			}
		});
		quitar3.setBackground(Color.WHITE);
		quitar3.setBorder(new EmptyBorder(0,0,0,0));
		quitar3.setOpaque(false);
		quitar3.setFocusPainted(false);
		quitar3.setHorizontalAlignment(SwingConstants.CENTER);
		quitar3.setForeground(Color.RED);
		quitar3.setFont(new Font("Century Gothic", Font.BOLD, 18));
		quitar3.setBounds(283, 0, 38, 38);
		discoDuroPanel.add(quitar3);
		
		microProcesadorPanel = new JPanel();
		microProcesadorPanel.setVisible(false);
		TitledBorder titledBorder2 = new TitledBorder(new CompoundBorder(), "Mirco Procesador", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 16), new Color(0, 0, 0));
		microProcesadorPanel.setBorder(new CompoundBorder(roundedBorder, titledBorder2));
		microProcesadorPanel.setBackground(Color.WHITE);
		microProcesadorPanel.setBounds(12, 332, 321, 125);
		componentesPcPanel.add(microProcesadorPanel);
		microProcesadorPanel.setLayout(null);
		
		microProcesadorId = new JLabel("New label");
		microProcesadorId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		microProcesadorId.setBounds(91, 37, 192, 25);
		microProcesadorPanel.add(microProcesadorId);
		
		microProcesadorNombre = new JLabel("New label");
		microProcesadorNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		microProcesadorNombre.setBounds(91, 87, 218, 25);
		microProcesadorPanel.add(microProcesadorNombre);
		
		label_7 = new JLabel("Nombre:");
		label_7.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_7.setBounds(12, 87, 93, 25);
		microProcesadorPanel.add(label_7);
		
		label_8 = new JLabel("ID:");
		label_8.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_8.setBounds(12, 37, 93, 25);
		microProcesadorPanel.add(label_8);
		
		quitar2 = new JButton("X");
		quitar2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = 2;
				Componente comp = componentesPc.get(index);

				if ( !discoDuroPanel.isVisible() && !gpuPanel.isVisible() ) {
					microProcesadorPanel.setVisible(false);
					componentesPc.set(index, null);
					String componentes = String.join(", ", componentesPc.toString());
					System.out.println(componentes);
				}
			}
		});
		quitar2.setBackground(Color.WHITE);
		quitar2.setBorder(new EmptyBorder(0,0,0,0));
		quitar2.setOpaque(false);
		quitar2.setFocusPainted(false);
		quitar2.setHorizontalAlignment(SwingConstants.CENTER);
		quitar2.setForeground(Color.RED);
		quitar2.setFont(new Font("Century Gothic", Font.BOLD, 18));
		quitar2.setBounds(283, 0, 38, 38);
		microProcesadorPanel.add(quitar2);
		
		ramPanel = new JPanel();
		ramPanel.setVisible(false);
		TitledBorder titledBorder3 = new TitledBorder(new CompoundBorder(), "RAM", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 16), new Color(0, 0, 0));
		ramPanel.setBorder(new CompoundBorder(roundedBorder, titledBorder3));
		ramPanel.setBackground(Color.WHITE);
		ramPanel.setBounds(12, 194, 321, 125);
		componentesPcPanel.add(ramPanel);
		ramPanel.setLayout(null);
		
		ramId = new JLabel("New label");
		ramId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ramId.setBounds(91, 37, 192, 25);
		ramPanel.add(ramId);
		
		ramNombre = new JLabel("New label");
		ramNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		ramNombre.setBounds(91, 87, 218, 25);
		ramPanel.add(ramNombre);
		
		label_3 = new JLabel("Nombre:");
		label_3.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_3.setBounds(12, 87, 93, 25);
		ramPanel.add(label_3);
		
		label_4 = new JLabel("ID:");
		label_4.setFont(new Font("Century Gothic", Font.BOLD, 16));
		label_4.setBounds(12, 37, 93, 25);
		ramPanel.add(label_4);
		
		quitar1 = new JButton("X");
		quitar1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = 1;
				Componente comp = componentesPc.get(index);

				if (  !microProcesadorPanel.isVisible() && !discoDuroPanel.isVisible() && !gpuPanel.isVisible() ) {
					ramPanel.setVisible(false);
					componentesPc.set(index, null);
					String componentes = String.join(", ", componentesPc.toString());
					System.out.println(componentes);
				}
			}
		});
		quitar1.setBackground(Color.WHITE);
		quitar1.setBorder(new EmptyBorder(0,0,0,0));
		quitar1.setOpaque(false);
		quitar1.setFocusPainted(false);
		quitar1.setHorizontalAlignment(SwingConstants.CENTER);
		quitar1.setForeground(Color.RED);
		quitar1.setFont(new Font("Century Gothic", Font.BOLD, 18));
		quitar1.setBounds(283, 0, 38, 38);
		ramPanel.add(quitar1);
		
		tarjetaMadrePanel = new JPanel();
		tarjetaMadrePanel.setVisible(false);
		TitledBorder titledBorder4 = new TitledBorder(new CompoundBorder(), "Tarjeta Madre", TitledBorder.CENTER, TitledBorder.TOP, new Font("Century Gothic", Font.PLAIN, 16), new Color(0, 0, 0));
		tarjetaMadrePanel.setBorder(new CompoundBorder(roundedBorder, titledBorder4));
		tarjetaMadrePanel.setBackground(Color.WHITE);
		tarjetaMadrePanel.setBounds(12, 56, 321, 125);
		componentesPcPanel.add(tarjetaMadrePanel);
		tarjetaMadrePanel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNewLabel_1.setBounds(12, 37, 93, 25);
		tarjetaMadrePanel.add(lblNewLabel_1);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Century Gothic", Font.BOLD, 16));
		lblNombre.setBounds(12, 87, 93, 25);
		tarjetaMadrePanel.add(lblNombre);
		
		tarjetaMadreId = new JLabel("New label");
		tarjetaMadreId.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tarjetaMadreId.setBounds(91, 38, 192, 25);
		tarjetaMadrePanel.add(tarjetaMadreId);
		
		tarjetaMadreNombre = new JLabel("New label");
		tarjetaMadreNombre.setFont(new Font("Century Gothic", Font.PLAIN, 14));
		tarjetaMadreNombre.setBounds(91, 88, 218, 25);
		tarjetaMadrePanel.add(tarjetaMadreNombre);
		
		quitar = new JButton("X");
		quitar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				int index = 0;
				Componente comp = componentesPc.get(index);

				if (  !ramPanel.isVisible() && !microProcesadorPanel.isVisible() && !discoDuroPanel.isVisible() && !gpuPanel.isVisible() ) {
					tarjetaMadrePanel.setVisible(false);
					notSelectedLabel.setVisible(true);
					componentesPc.set(index, null);
					String componentes = String.join(", ", componentesPc.toString());
					System.out.println(componentes);
				}
			}
		});
		quitar.setBackground(Color.WHITE);
		quitar.setBorder(new EmptyBorder(0,0,0,0));
		quitar.setOpaque(false);
		quitar.setFocusPainted(false);
		quitar.setForeground(Color.RED);
		quitar.setFont(new Font("Century Gothic", Font.BOLD, 18));
		quitar.setHorizontalAlignment(SwingConstants.CENTER);
		quitar.setBounds(283, 0, 38, 38);
		tarjetaMadrePanel.add(quitar);
		
		notSelectedLabel = new JLabel("No se han seleccionado componentes.");
		notSelectedLabel.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		notSelectedLabel.setHorizontalAlignment(SwingConstants.CENTER);
		notSelectedLabel.setBounds(12, 359, 321, 28);
		componentesPcPanel.add(notSelectedLabel);
		
		loadComponente(headers);
	}
	
	private void clean() {
		idTextField.setText("PC-" + Tienda.getInstance().getCodComputadora());;
		precioSpn.setValue(1);
		tipoTextField.setText("");
		cantidadSpn.setValue(1);
		
		tarjetaMadrePanel.setVisible(false);
		ramPanel.setVisible(false);
		microProcesadorPanel.setVisible(false);
		discoDuroPanel.setVisible(false);
		gpuPanel.setVisible(false);

	}
	
	private void updateSelection(JRadioButton selectedButton) {
		ramRadioBttn.setSelected(false);
		tarjetaMadreRadioBttn.setSelected(false);
		microProcesadorRadioBttn.setSelected(false);
		discoDuroRadioBttn.setSelected(false);
		gpuRadioBttn.setSelected(false);
		
		selectedButton.setSelected(true);
		
		MoveToXY mover = new MoveToXY(selector, selector.getX(), selectedButton.getY(), 0.8f, AnimationType.EASE_IN_OUT);
		mover.start();
		
		gpuRadioBttn.setForeground(Color.black);
		discoDuroRadioBttn.setForeground(Color.black);
		microProcesadorRadioBttn.setForeground(Color.black);
		tarjetaMadreRadioBttn.setForeground(Color.black);
		ramRadioBttn.setForeground(Color.black);
		
		Timer timer = new Timer(500, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				selectedButton.setForeground(Color.white);
				((Timer)e.getSource()).stop();
			}
		});
		timer.setRepeats(false);
		timer.start();
	}
	
	protected void loadStep() {
		
		for ( int i = 0; i < stepsList.size(); i++ ) {
			stepsList.get(i).setBackground(PrimaryC);
			stepsList.get(i).setBorder(new RoundedBorder(PrimaryC, 1, 100));
			if ( i == currentStep ) {
				stepsList.get(i).setBackground(HoverEffectColor);
				stepsList.get(i).setBorder(new RoundedBorder(HoverEffectColor, 1, 100));
				
				descripcionPasoLabel.setForeground(Color.black);
				switch(i) {
				case 0:
					descripcionPasoLabel.setText("Paso 1: Elegir Tarjeta Madre.");
					break;
				case 1:
					descripcionPasoLabel.setText("Paso 2: Elegir RAM.");
					break;
				case 2:
					descripcionPasoLabel.setText("Paso 3: Elegir Micro Procesador.");
					break;
				case 3:
					descripcionPasoLabel.setText("Paso 4: Elegir Disco Duro.");
					break;
				case 4:
					descripcionPasoLabel.setText("Paso 5: Elegir GPU.");
					break;
				}
			}

		}
		
		
		
	}

	private void loadComponente(String[] headers) {
		
		if ( tarjetaMadreRadioBttn.isSelected() || currentStep == 0 ) {
			headers = new String[] {"ID", "Nombre", "Tipo Socket", "Tipo RAM", "Tipo GPU", "Tipo Disco Duro"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(150); 
			table.getColumnModel().getColumn(2).setPreferredWidth(50); 
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(50); 
			table.getColumnModel().getColumn(5).setPreferredWidth(100);

		} else if ( ramRadioBttn.isSelected() || currentStep == 1 ){
			headers = new String[] {"ID", "Nombre", "Espacio", "Tipo Memoria"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(50);
			table.getColumnModel().getColumn(1).setPreferredWidth(200); 
			table.getColumnModel().getColumn(2).setPreferredWidth(50); 
			table.getColumnModel().getColumn(3).setPreferredWidth(100);
		} else if ( microProcesadorRadioBttn.isSelected() || currentStep == 2 ){
			headers = new String[] {"ID", "Nombre", "Velocidad", "Tipo Conexion", "Nucleos"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(150); 
			table.getColumnModel().getColumn(2).setPreferredWidth(50); 
			table.getColumnModel().getColumn(3).setPreferredWidth(50);
			table.getColumnModel().getColumn(4).setPreferredWidth(50); 
		} else if ( discoDuroRadioBttn.isSelected() || currentStep == 3 ){
			headers = new String[] {"ID", "Nombre", "Alamacenamiento", "Tipo Disco", "Conexiones", "Velocidad"};
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(150); 
			table.getColumnModel().getColumn(2).setPreferredWidth(100); 
			table.getColumnModel().getColumn(3).setPreferredWidth(30);
			table.getColumnModel().getColumn(4).setPreferredWidth(50); 
			table.getColumnModel().getColumn(5).setPreferredWidth(50);
		} else if ( gpuRadioBttn.isSelected() || currentStep == 4 ){
			headers = new String[] {"ID", "Nombre", "Tipo GPU", "Tipo Conexion", "VRAM", "Velocidad"};
			
			model.setColumnIdentifiers(headers);
			table.setModel(model);
			table.getColumnModel().getColumn(0).setPreferredWidth(30);
			table.getColumnModel().getColumn(1).setPreferredWidth(150); 
			table.getColumnModel().getColumn(2).setPreferredWidth(100); 
			table.getColumnModel().getColumn(3).setPreferredWidth(75);
			table.getColumnModel().getColumn(4).setPreferredWidth(30); 
			table.getColumnModel().getColumn(5).setPreferredWidth(40);
		} 
		
		loadArticulos();
	}
	
	private int getColumnCountForComponent(Componente comp) {
	    if (comp instanceof Ram && ramRadioBttn.isSelected()) {
	        return 4;
	    } else if (comp instanceof TarjetaMadre && tarjetaMadreRadioBttn.isSelected()) {
	        return 6;
	    } else if (comp instanceof MicroProcesador && microProcesadorRadioBttn.isSelected()) {
	        return 5;
	    } else if (comp instanceof DiscoDuro && discoDuroRadioBttn.isSelected()) {
	        return 6;
	    } else if (comp instanceof GPU && gpuRadioBttn.isSelected()) {
	        return 6;
	    }
	    return 0;
	}
	
	
	public void loadArticulos() {
	    model.setRowCount(0);
	    ArrayList<Componente> aux = Tienda.getInstance().getMisComponentes();
	    
	    for (Componente comp : aux) {
	        int columnCount = getColumnCountForComponent(comp);
	        Object[] row = new Object[columnCount];
	        
	        if (comp instanceof Ram && ramRadioBttn.isSelected()) {
	            Ram ram = (Ram) comp;
	            row[0] = ram.getId();
	            row[1] = ram.getMarca() + " " + ram.getModelo();
	            row[2] = ram.getMemoria();
	            row[3] = ram.getTipoMemoria();
	            model.addRow(row);
	        } else if (comp instanceof TarjetaMadre && tarjetaMadreRadioBttn.isSelected()) {
	            TarjetaMadre tarjMadre = (TarjetaMadre) comp;
	            String tipoDiscoDuro = String.join(", ", tarjMadre.getTipoDiscoDuro());
	            row[0] = tarjMadre.getId();
	            row[1] = tarjMadre.getMarca() + " " + tarjMadre.getModelo();
	            row[2] = tarjMadre.getConectionSocket();
	            row[3] = tarjMadre.getTipoRam();
	            row[4] = tarjMadre.getConectionGPU();
	            row[5] = tipoDiscoDuro;
	            model.addRow(row);
	        } else if (comp instanceof MicroProcesador && microProcesadorRadioBttn.isSelected()) {
	            MicroProcesador microProcesador = (MicroProcesador) comp;
	            row[0] = microProcesador.getId();
	            row[1] = microProcesador.getMarca() + " " + microProcesador.getModelo();
	            row[2] = microProcesador.getVelocidad() + " GHz";
	            row[3] = microProcesador.getTipoConexion();
	            row[4] = microProcesador.getCantNucleo();
	            model.addRow(row);
	        } else if (comp instanceof DiscoDuro && discoDuroRadioBttn.isSelected()) {
	            DiscoDuro discoDuro = (DiscoDuro) comp;
	            String tipoConexiones = String.join(", ", discoDuro.getTipoConexiones());
	            row[0] = discoDuro.getId();
	            row[1] = discoDuro.getMarca() + " " + discoDuro.getModelo();
	            row[2] = discoDuro.getAlmacenamiento() + " " + discoDuro.getAlmTipo();
	            row[3] = discoDuro.getTipo();
	            row[4] = tipoConexiones;
	            row[5] = discoDuro.getVelEscritura() + "MB/s  /  " +  discoDuro.getVelLectura() + "MB/s";
	            model.addRow(row);
	        } else if (comp instanceof GPU && gpuRadioBttn.isSelected()) {
	            GPU gpu = (GPU) comp;
	            row[0] = gpu.getId();
	            row[1] = gpu.getMarca() + " " + gpu.getModelo();
	            row[2] = gpu.getTipo();
	            row[3] = gpu.getTipoConexion();
	            row[4] = gpu.getRAM() + " MB";
	            row[5] = gpu.getVelocidad() + " GHz";
	            model.addRow(row);
	        }
	    }
	    
	    /*int rowsToAdd = Math.max(0, 14 - model.getRowCount());
	    for (int i = 0; i < rowsToAdd; i++) {
	        Object[] emptyRow = new Object[table.getColumnCount()];
	        for (int j = 0; j < emptyRow.length; j++) {
	            emptyRow[j] = "";
	        }
	        model.addRow(emptyRow);
	    }*/
	}
}
