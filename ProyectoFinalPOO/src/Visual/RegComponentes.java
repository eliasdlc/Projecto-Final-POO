package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.Format;
import java.text.NumberFormat;
import java.util.ArrayList;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Logica.*;
/*import Logica.Ram;
import Logica.RoundedBorder;*/

import javax.swing.border.CompoundBorder;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatterFactory;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JRadioButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BoxLayout;
import java.awt.CardLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JToggleButton;

public class RegComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField idTextField;
	private JTextField marcaTextField;
	private JTextField modeloTextField;
	private JLabel memoriaTypeLabel;
	private JLabel memoriaLabel;
	private JComboBox medidaMemoriaCbx;
	private JSpinner cantMemoriaSpn;
	private JComboBox memoriaTypeCbx;
	private JLabel velocidadLabel;
	private JSpinner velocidadSpn;
	private JComboBox tipoConexionCbx;
	private JSpinner nucleosSpn;
	private JButton cancelButton;
	private JButton regBttn;
	
	private static final Color PrimaryC = new Color(0, 78, 137);
	private static final Color SecondaryC = new Color(90, 162, 232);
	private static final Color AccentColor = new Color(255, 133, 78);
	private static final Color AccentHoverColor = new Color(255, 188, 94);
	private static final Color BGC = new Color(236, 240, 241);
	private static final Color TextColor = new Color(52, 73, 94);
	private static final Color WTextColor = new Color(255, 255, 255);
	private static final Color ButtonColor = new Color(21, 96, 169);
	private static final Color ButtonBorderColor = new Color(21, 96, 169);
	private static final Color hoverEffectColor = new Color(220, 231, 242);
	
	private JLabel almacenamientoLabel;
	private JLabel discoTipoConexionLabel;
	private JLabel tipoDiscoLabel;
	private JLabel velEscrituraLabel;
	private JLabel velLecturaLabel;
	private JSpinner almacenamientoSpn;
	private JComboBox discoMedidaCbx;
	private JSpinner velEscrituraSpn;
	private JSpinner velLecturaSpn;
	private JComboBox medidaEscrituraCbx;
	private JComboBox medidaLecturaCbx;
	private JToggleButton hddToggleBttn;
	private JToggleButton ssdToggleBttn;
	private JLabel nucleosLabel;
	private JLabel medidaVelocidadLabel;
	private JLabel tipoConexionLabel;
	private JCheckBox ideCheckBox;
	private JCheckBox sataCheckBox;
	private JCheckBox sata2CheckBox;
	private JCheckBox sata3CheckBox;
	private JCheckBox m2SataCheckBox;
	private JCheckBox eSataCheckBox;
	private JButton abrirListaBttn;
	private JPanel conexionDiscoDuroPanel;
	private JLabel tipoSocketLabel;
	private JLabel tipoRamLabel;
	private JComboBox RamTypeCbx;
	private JComboBox socketTypeCbx;
	private JLabel conexionDiscoDuroLabel;
	private JLabel conectionGPULabel;
	private JComboBox conectionGPUCbx;
	private JLabel tipoGPULabel;
	private JLabel vramLabel;
	private JLabel velocidadGPULabel;
	private JLabel tipoConexionGPULabel;
	private JTextField tipoGPUtxtField;
	private JComboBox tipoConexionGPUcbx;
	private JSpinner vramSpn;
	private JSpinner velocidadGPUspn;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			RegComponentes dialog = new RegComponentes();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public RegComponentes() {
		
		setBounds(100, 100, 1263, 806);
		getContentPane().setLayout(null);
		contentPanel.setBounds(0, 0, 1245, 710);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1245, 710);
		panel.setBackground(new Color(3, 104, 196));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JPanel generalInfoPanel = new JPanel();
		generalInfoPanel.setBackground(new Color(2, 78, 137));
		generalInfoPanel.setBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10));
		
		generalInfoPanel.setBounds(7, 24, 1232, 224);
		panel.add(generalInfoPanel);
		generalInfoPanel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblNewLabel.setBounds(266, 63, 118, 28);
		generalInfoPanel.add(lblNewLabel);
		
		idTextField = new JTextField();
		idTextField.setText("C-" + Tienda.getInstance().getCodComponente());
		idTextField.setEditable(false);
		idTextField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		idTextField.setBounds(384, 63, 185, 28);
		generalInfoPanel.add(idTextField);
		idTextField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setForeground(Color.BLACK);
		lblMarca.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblMarca.setBounds(266, 129, 118, 28);
		generalInfoPanel.add(lblMarca);
		
		marcaTextField = new JTextField();
		marcaTextField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		marcaTextField.setColumns(10);
		marcaTextField.setBounds(384, 129, 353, 28);
		generalInfoPanel.add(marcaTextField);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setForeground(Color.BLACK);
		lblModelo.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblModelo.setBounds(791, 129, 118, 28);
		generalInfoPanel.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setForeground(Color.BLACK);
		lblPrecio.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblPrecio.setBounds(596, 63, 118, 28);
		generalInfoPanel.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setForeground(Color.BLACK);
		lblCantidad.setFont(new Font("Century Gothic", Font.BOLD, 22));
		lblCantidad.setBounds(925, 63, 118, 28);
		generalInfoPanel.add(lblCantidad);
		
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		JSpinner precioSpn = new JSpinner();
		precioSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		precioSpn.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(10)));

		
		
		precioSpn.setBounds(714, 63, 185, 28);
		generalInfoPanel.add(precioSpn);
		
		JSpinner cantidadSpn = new JSpinner();
		cantidadSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cantidadSpn.setBounds(1055, 63, 142, 28);
		generalInfoPanel.add(cantidadSpn);
		
		modeloTextField = new JTextField();
		modeloTextField.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		modeloTextField.setColumns(10);
		modeloTextField.setBounds(921, 129, 276, 28);
		generalInfoPanel.add(modeloTextField);
		
		
		JPanel infoGeneralPanel = new JPanel();
		RoundedBorder roundedBorder = new RoundedBorder(new Color(240, 240, 240), 1, 10);
		TitledBorder titledBorder = new TitledBorder(new CompoundBorder(), "Informacion General", TitledBorder.CENTER, TitledBorder.TOP, null, Color.black);
		titledBorder.setTitleFont(new Font("Century Gothic", Font.PLAIN, 15));

		infoGeneralPanel.setBorder(new CompoundBorder(roundedBorder,titledBorder));
		infoGeneralPanel.setBounds(253, 13, 967, 198);
		generalInfoPanel.add(infoGeneralPanel);
		
		JPanel ComponentIconPanel = new JPanel();
		ComponentIconPanel.setBorder(new RoundedBorder(new Color(240, 240, 240), 1, 10));
		ComponentIconPanel.setBounds(12, 13, 229, 198);
		generalInfoPanel.add(ComponentIconPanel);
		ComponentIconPanel.setLayout(null);
		
		JLabel componentIcon = new JLabel("");
		componentIcon.setBounds(29, 11, 170, 170);
		ComponentIconPanel.add(componentIcon);
		Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
		Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
		componentIcon.setIcon(new ImageIcon(scaledImg));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 78, 137));
		panel_2.setBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10));
		panel_2.setBounds(7, 261, 1232, 439);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel componentInfoPanel = new JPanel();
		TitledBorder titledBorder2 = new TitledBorder(new CompoundBorder(), "Informacion de RAM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		titledBorder2.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
		componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), titledBorder2));
		componentInfoPanel.setBounds(356, 13, 864, 413);
		panel_2.add(componentInfoPanel);
		componentInfoPanel.setLayout(null);
		
		conexionDiscoDuroPanel = new JPanel();
		conexionDiscoDuroPanel.setBounds(500, 139, 206, 177);
		conexionDiscoDuroPanel.setBackground(new Color(255, 255, 255));
		conexionDiscoDuroPanel.setBorder(new RoundedBorder(new Color(255, 255, 255), 1, 10));
		conexionDiscoDuroPanel.setLayout(new GridLayout(0, 2));
		
		conexionDiscoDuroPanel.setVisible(false);
		componentInfoPanel.add(conexionDiscoDuroPanel);
		
		ideCheckBox = new JCheckBox("IDE");
		ideCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		ideCheckBox.setOpaque(false);
		sataCheckBox = new JCheckBox("SATA");
		sataCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		sataCheckBox.setOpaque(false);
        sata2CheckBox = new JCheckBox("SATA-2");
        sata2CheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        sata2CheckBox.setOpaque(false);
        sata3CheckBox = new JCheckBox("SATA-3");
        sata3CheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        sata3CheckBox.setOpaque(false);
        m2SataCheckBox = new JCheckBox("M.2 SATA");
        m2SataCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        m2SataCheckBox.setOpaque(false);
        eSataCheckBox = new JCheckBox("eSATA");
        eSataCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        eSataCheckBox.setOpaque(false);
        
        conexionDiscoDuroPanel.add(ideCheckBox);
        conexionDiscoDuroPanel.add(sataCheckBox);
        conexionDiscoDuroPanel.add(sata2CheckBox);
        conexionDiscoDuroPanel.add(sata3CheckBox);
        conexionDiscoDuroPanel.add(m2SataCheckBox);
        conexionDiscoDuroPanel.add(eSataCheckBox);
		
		memoriaLabel = new JLabel("Memoria:");
		memoriaLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		memoriaLabel.setBounds(29, 35, 177, 28);
		componentInfoPanel.add(memoriaLabel);
		
		memoriaTypeLabel = new JLabel("Tipo Memoria:");
		memoriaTypeLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		memoriaTypeLabel.setBounds(29, 88, 177, 28);
		componentInfoPanel.add(memoriaTypeLabel);
		
		memoriaTypeCbx = new JComboBox();
		memoriaTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		memoriaTypeCbx.setBackground(Color.WHITE);
		memoriaTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		memoriaTypeCbx.setBounds(234, 88, 177, 28);
		componentInfoPanel.add(memoriaTypeCbx);
		
		
		
		cantMemoriaSpn = new JSpinner();
		cantMemoriaSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		cantMemoriaSpn.setBounds(234, 35, 177, 28);
		componentInfoPanel.add(cantMemoriaSpn);
		
		medidaMemoriaCbx = new JComboBox();
		medidaMemoriaCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = medidaMemoriaCbx.getSelectedItem().toString();
				
				if ( item.equals("MB") ) {
					int gbValue = ((Integer)cantMemoriaSpn.getValue());
					int mbValue = gbValue * 1024;
					
					cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(mbValue), new Integer(16), null, new Integer(16)));
					cantMemoriaSpn.setValue(mbValue);
					
				} else if ( item.equals("GB") ) {
					int mbValue = ((Integer)cantMemoriaSpn.getValue());
					int gbValue = mbValue / 1024;
					
					cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(gbValue), new Integer(2), null, new Integer(2)));
					cantMemoriaSpn.setValue(gbValue);
					
				}
			}
		});
		medidaMemoriaCbx.setBackground(Color.WHITE);
		medidaMemoriaCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		medidaMemoriaCbx.setModel(new DefaultComboBoxModel(new String[] {"GB", "MB"}));
		medidaMemoriaCbx.setBounds(423, 36, 60, 28);
		componentInfoPanel.add(medidaMemoriaCbx);
		
		velocidadLabel = new JLabel("Velocidad:");
		velocidadLabel.setVisible(false);
		velocidadLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		velocidadLabel.setBounds(29, 35, 177, 28);
		componentInfoPanel.add(velocidadLabel);
		
		tipoConexionLabel = new JLabel("Tipo Conexion:");
		tipoConexionLabel.setVisible(false);
		tipoConexionLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoConexionLabel.setBounds(29, 88, 177, 28);
		componentInfoPanel.add(tipoConexionLabel);
		
		nucleosLabel = new JLabel("Nucleos:");
		nucleosLabel.setVisible(false);
		nucleosLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		nucleosLabel.setBounds(29, 144, 177, 28);
		componentInfoPanel.add(nucleosLabel);
		
		tipoConexionCbx = new JComboBox();
		tipoConexionCbx.setBackground(Color.WHITE);
		tipoConexionCbx.setModel(new DefaultComboBoxModel(new String[] {"LGA 1151", "LGA 1200", "AM4", "TR4", "sTRX4"}));
		tipoConexionCbx.setVisible(false);
		tipoConexionCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tipoConexionCbx.setBounds(234, 88, 177, 28);
		componentInfoPanel.add(tipoConexionCbx);
		
		medidaVelocidadLabel = new JLabel();
		medidaVelocidadLabel.setText("GHz");
		medidaVelocidadLabel.setFont(new Font("Century Gothic", Font.BOLD, 20));
		medidaVelocidadLabel.setBounds(423, 35, 60, 28);
		componentInfoPanel.add(medidaVelocidadLabel);
		
		velocidadSpn = new JSpinner();
		velocidadSpn.setModel(new SpinnerNumberModel(new Float(0.5), new Float(0.5), null, new Float(0.5)));
		velocidadSpn.setVisible(false);
		velocidadSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		velocidadSpn.setBounds(234, 35, 177, 28);
		componentInfoPanel.add(velocidadSpn);
		
		nucleosSpn = new JSpinner();
		nucleosSpn.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		nucleosSpn.setVisible(false);
		nucleosSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		nucleosSpn.setBounds(234, 144, 177, 28);
		componentInfoPanel.add(nucleosSpn);
		
		tipoSocketLabel = new JLabel("Tipo Socket:");
		tipoSocketLabel.setVisible(false);
		tipoSocketLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoSocketLabel.setBounds(29, 35, 177, 28);
		componentInfoPanel.add(tipoSocketLabel);
		
		tipoRamLabel = new JLabel("Tipo RAM:");
		tipoRamLabel.setVisible(false);
		tipoRamLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoRamLabel.setBounds(29, 88, 177, 28);
		componentInfoPanel.add(tipoRamLabel);
		
		RamTypeCbx = new JComboBox();
		RamTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		RamTypeCbx.setVisible(false);
		RamTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		RamTypeCbx.setBackground(Color.WHITE);
		RamTypeCbx.setBounds(234, 89, 249, 28);
		componentInfoPanel.add(RamTypeCbx);
		
		socketTypeCbx = new JComboBox();
		socketTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"LGA 1156", "LGA 1155", "LGA 1150", "LGA 1151", "LGA 1200", "Socket AM2", "Socket AM3", "Socket AM4", "Socket AM5", "Socket FM1", "Socket FM2", "Socket TR4", "Socket sTRX4"}));
		socketTypeCbx.setVisible(false);
		socketTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		socketTypeCbx.setBackground(Color.WHITE);
		socketTypeCbx.setBounds(234, 35, 249, 28);
		componentInfoPanel.add(socketTypeCbx);
		
		conexionDiscoDuroLabel = new JLabel("Conexion Disco Duro:");
		conexionDiscoDuroLabel.setVisible(false);
		conexionDiscoDuroLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		conexionDiscoDuroLabel.setBounds(29, 200, 261, 28);
		componentInfoPanel.add(conexionDiscoDuroLabel);
		
		abrirListaBttn = new JButton("Abrir Lista");
		abrirListaBttn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		abrirListaBttn.setVisible(false);
		abrirListaBttn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				abrirListaBttn.setBackground(Color.gray);
				abrirListaBttn.setForeground(Color.white);
			}
			public void mouseExited(MouseEvent arg0) {
				abrirListaBttn.setBackground(Color.white);
				abrirListaBttn.setForeground(Color.black);
			}
		});
		abrirListaBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conexionDiscoDuroPanel.setVisible(!conexionDiscoDuroPanel.isVisible());
				if (conexionDiscoDuroPanel.isVisible()) {
					abrirListaBttn.setText("Cerrar Lista");
				} else {
					abrirListaBttn.setText("Abrir Lista");
				}
			}
		});
		abrirListaBttn.setBackground(Color.white);
		abrirListaBttn.setBounds(306, 195, 177, 38);
		abrirListaBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
		abrirListaBttn.setFocusPainted(false);
		componentInfoPanel.add(abrirListaBttn);
		
		almacenamientoLabel = new JLabel("Almacenamiento:");
		almacenamientoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		almacenamientoLabel.setBounds(29, 35, 233, 28);
		componentInfoPanel.add(almacenamientoLabel);
		
		discoTipoConexionLabel = new JLabel("Tipo Conexion:");
		discoTipoConexionLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		discoTipoConexionLabel.setBounds(29, 144, 233, 28);
		componentInfoPanel.add(discoTipoConexionLabel);
		
		tipoDiscoLabel = new JLabel("Tipo Disco:");
		tipoDiscoLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoDiscoLabel.setBounds(29, 88, 233, 28);
		componentInfoPanel.add(tipoDiscoLabel);
		
		velEscrituraLabel = new JLabel("Vel. Escritura:");
		velEscrituraLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		velEscrituraLabel.setBounds(29, 200, 165, 28);
		componentInfoPanel.add(velEscrituraLabel);
		
		velLecturaLabel = new JLabel("Vel. Lectura:");
		velLecturaLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		velLecturaLabel.setBounds(29, 259, 165, 28);
		componentInfoPanel.add(velLecturaLabel);
		
		almacenamientoSpn = new JSpinner();
		almacenamientoSpn.setModel(new SpinnerNumberModel(new Integer(4), new Integer(2), null, new Integer(2)));
		almacenamientoSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		almacenamientoSpn.setBounds(255, 36, 177, 28);
		componentInfoPanel.add(almacenamientoSpn);
		
		discoMedidaCbx = new JComboBox();
		discoMedidaCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = discoMedidaCbx.getSelectedItem().toString();
				
				
				try {
		            // Verificar si el valor del almacenamiento es menor que 1000 y el item es "TB"
		            if (item.equals("TB")) {
		                int gbValue = (Integer) almacenamientoSpn.getValue();
		                if (gbValue < 1000) {
		                    discoMedidaCbx.setSelectedIndex(0);
		                    throw new IllegalArgumentException("El valor de almacenamiento debe ser mayor o igual a 1,000 GB.");
		                }
		                
		                float tbValue = gbValue / 1000.0f;
		                almacenamientoSpn.setModel(new SpinnerNumberModel(tbValue, 0.001f, null, 1f));
		                almacenamientoSpn.setValue(tbValue);
		                
		            } else if (item.equals("GB")) {
		                float tbValue = Float.parseFloat(almacenamientoSpn.getValue().toString());
		                int gbValue = Math.round(tbValue * 1000);
		                
		                almacenamientoSpn.setModel(new SpinnerNumberModel(gbValue, 1, null, 1));
		                almacenamientoSpn.setValue(gbValue);
		            }
		        } catch (IllegalArgumentException e) {
		            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
				
				
			}
		});
		discoMedidaCbx.setModel(new DefaultComboBoxModel(new String[] {"GB", "TB"}));
		discoMedidaCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		discoMedidaCbx.setBackground(Color.WHITE);
		discoMedidaCbx.setBounds(445, 36, 60, 28);
		componentInfoPanel.add(discoMedidaCbx);
		
		hddToggleBttn = new JToggleButton("HDD");
		
		hddToggleBttn.setFont(new Font("Century Gothic", Font.BOLD, 19));
		hddToggleBttn.setBackground(Color.WHITE);
		hddToggleBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
		hddToggleBttn.setFocusPainted(false);
		hddToggleBttn.setSelected(true);
		hddToggleBttn.setBounds(255, 83, 92, 38);
		componentInfoPanel.add(hddToggleBttn);
		
		ssdToggleBttn = new JToggleButton("SSD");
		
		ssdToggleBttn.setFont(new Font("Century Gothic", Font.BOLD, 19));
		ssdToggleBttn.setBackground(Color.WHITE);
		ssdToggleBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
		ssdToggleBttn.setFocusPainted(false);
		ssdToggleBttn.setBounds(359, 83, 92, 38);
		componentInfoPanel.add(ssdToggleBttn);
		
		
		hddToggleBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ssdToggleBttn.setSelected(false);
			}
		});
		ssdToggleBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				hddToggleBttn.setSelected(false);
			}
		});
		
		medidaEscrituraCbx = new JComboBox();
		medidaEscrituraCbx.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = medidaEscrituraCbx.getSelectedItem().toString();
				
				try {
		        	
		        	if (item.equals("(GB/s)")) {
			            int mbValue = ((Integer)velEscrituraSpn.getValue());
			            int gbValue = mbValue / 1000;
			            if ( mbValue < 1000 ) {
			            	medidaEscrituraCbx.setSelectedIndex(0);
			            	throw new IllegalArgumentException("El valor de almacenamiento debe ser mayor o igual a 1,000 MB.");
			            }

			            velEscrituraSpn.setModel(new SpinnerNumberModel(gbValue, new Integer(1), null, new Integer(1)));
			            velEscrituraSpn.setValue(gbValue);

			        } else if (item.equals("(MB/s)")) {
			            int gbValue = ((Integer)velEscrituraSpn.getValue());
			            int mbValue = gbValue * 1000;
			            

			            velEscrituraSpn.setModel(new SpinnerNumberModel(mbValue, new Integer(16), null, new Integer(16)));
			            velEscrituraSpn.setValue(mbValue);
			        }
		        	
		        }catch (IllegalArgumentException e) {
		            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
			}
		});
		medidaEscrituraCbx.setModel(new DefaultComboBoxModel(new String[] {"(MB/s)", "(GB/s)"}));
		medidaEscrituraCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		medidaEscrituraCbx.setBackground(Color.WHITE);
		medidaEscrituraCbx.setBounds(391, 200, 92, 28);
		componentInfoPanel.add(medidaEscrituraCbx);
		
		medidaLecturaCbx = new JComboBox();
		medidaLecturaCbx.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        String item = medidaLecturaCbx.getSelectedItem().toString();

		        try {
		        	
		        	if (item.equals("(GB/s)")) {
			            int mbValue = ((Integer)velLecturaSpn.getValue());
			            int gbValue = mbValue / 1000;
			            if ( mbValue < 1000 ) {
			            	medidaLecturaCbx.setSelectedIndex(0);
			            	throw new IllegalArgumentException("El valor de almacenamiento debe ser mayor o igual a 1,000 MB.");
			            }

			            velLecturaSpn.setModel(new SpinnerNumberModel(gbValue, new Integer(1), null, new Integer(1)));
			            velLecturaSpn.setValue(gbValue);

			        } else if (item.equals("(MB/s)")) {
			            int gbValue = ((Integer)velLecturaSpn.getValue());
			            int mbValue = gbValue * 1000;
			            

			            velLecturaSpn.setModel(new SpinnerNumberModel(mbValue, new Integer(16), null, new Integer(16)));
			            velLecturaSpn.setValue(mbValue);
			        }
		        	
		        }catch (IllegalArgumentException e) {
		            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		        }
		        
		        
		    }
		});
		medidaLecturaCbx.setModel(new DefaultComboBoxModel(new String[] {"(MB/s)", "(GB/s)"}));
		medidaLecturaCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		medidaLecturaCbx.setBackground(Color.WHITE);
		medidaLecturaCbx.setBounds(391, 259, 92, 28);
		componentInfoPanel.add(medidaLecturaCbx);
		
		velEscrituraSpn = new JSpinner();
		velEscrituraSpn.setModel(new SpinnerNumberModel(new Integer(16), new Integer(16), null, new Integer(16)));
		velEscrituraSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		velEscrituraSpn.setBounds(202, 200, 177, 28);
		componentInfoPanel.add(velEscrituraSpn);
		
		velLecturaSpn = new JSpinner();
		velLecturaSpn.setModel(new SpinnerNumberModel(new Integer(16), new Integer(16), null, new Integer(16)));
		velLecturaSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		velLecturaSpn.setBounds(202, 259, 177, 28);
		componentInfoPanel.add(velLecturaSpn);
		
		conectionGPULabel = new JLabel("Tipo GPU:");
		conectionGPULabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		conectionGPULabel.setBounds(29, 144, 233, 28);
		componentInfoPanel.add(conectionGPULabel);
		
		conectionGPUCbx = new JComboBox();
		conectionGPUCbx.setModel(new DefaultComboBoxModel(new String[] {"PCIe 3.0", "PCIe 4.0", "AGP", "PCI", "Thunderbolt 3"}));
		conectionGPUCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		conectionGPUCbx.setBackground(Color.WHITE);
		conectionGPUCbx.setBounds(239, 145, 249, 28);
		componentInfoPanel.add(conectionGPUCbx);
		
		tipoGPULabel = new JLabel("Tipo de GPU:");
		tipoGPULabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoGPULabel.setBounds(29, 35, 165, 28);
		componentInfoPanel.add(tipoGPULabel);
		
		vramLabel = new JLabel("VRAM:");
		vramLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		vramLabel.setBounds(29, 144, 117, 28);
		componentInfoPanel.add(vramLabel);
		
		velocidadGPULabel = new JLabel("Velocidad:");
		velocidadGPULabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		velocidadGPULabel.setBounds(29, 200, 165, 28);
		componentInfoPanel.add(velocidadGPULabel);
		
		tipoConexionGPULabel = new JLabel("Tipo Conexion:");
		tipoConexionGPULabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoConexionGPULabel.setBounds(29, 88, 165, 28);
		componentInfoPanel.add(tipoConexionGPULabel);
		
		tipoGPUtxtField = new JTextField();
		tipoGPUtxtField.setBounds(234, 35, 177, 28);
		componentInfoPanel.add(tipoGPUtxtField);
		tipoGPUtxtField.setColumns(10);
		
		vramSpn = new JSpinner();
		vramSpn.setModel(new SpinnerNumberModel(new Float(2), new Float(2), new Float(16), new Float(2)));
		vramSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		vramSpn.setBounds(234, 145, 177, 28);
		componentInfoPanel.add(vramSpn);
		
		tipoConexionGPUcbx = new JComboBox();
		tipoConexionGPUcbx.setModel(new DefaultComboBoxModel(new String[] {"PCIe 3.0", "PCIe 4.0", "AGP", "PCI", "Thunderbolt 3"}));
		tipoConexionGPUcbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tipoConexionGPUcbx.setBackground(Color.WHITE);
		tipoConexionGPUcbx.setBounds(234, 89, 177, 28);
		componentInfoPanel.add(tipoConexionGPUcbx);
		
		velocidadGPUspn = new JSpinner();
		velocidadGPUspn.setModel(new SpinnerNumberModel(new Float(1), new Float(1), null, new Float(0.2)));
		velocidadGPUspn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		velocidadGPUspn.setBounds(234, 201, 177, 28);
		componentInfoPanel.add(velocidadGPUspn);
		
		JRadioButton microprocesadorRdoBttn = new JRadioButton("Micro-procesador");
		microprocesadorRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		microprocesadorRdoBttn.setFocusPainted(false);
		microprocesadorRdoBttn.setBounds(35, 126, 251, 28);
		panel_2.add(microprocesadorRdoBttn);
		
		JRadioButton ramRdoBttn = new JRadioButton("RAM");
		ramRdoBttn.setSelected(true);
		ramRdoBttn.setFocusPainted(false);
		ramRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		ramRdoBttn.setBounds(35, 49, 251, 28);
		panel_2.add(ramRdoBttn);
		
		JRadioButton tarjetaMadreRdoBttn = new JRadioButton("Tarjeta Madre");
		tarjetaMadreRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tarjetaMadreRdoBttn.setFocusPainted(false);
		tarjetaMadreRdoBttn.setBounds(35, 203, 251, 28);
		panel_2.add(tarjetaMadreRdoBttn);
		
		JRadioButton discoDuroRdoBttn = new JRadioButton("Disco Duro");
		discoDuroRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		discoDuroRdoBttn.setFocusPainted(false);
		discoDuroRdoBttn.setBounds(35, 357, 251, 28);
		panel_2.add(discoDuroRdoBttn);
		
		JRadioButton gpuRdoBttn = new JRadioButton("GPU");
		gpuRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		gpuRdoBttn.setFocusPainted(false);
		gpuRdoBttn.setBounds(35, 280, 251, 28);
		panel_2.add(gpuRdoBttn);
		
		JPanel selectionPanel = new JPanel();
		selectionPanel.setBorder(new RoundedBorder(new Color(239, 239, 229), 1, 10));
		selectionPanel.setBounds(12, 13, 332, 413);
		panel_2.add(selectionPanel);
		
		setEverythingTo(false);
		
		memoriaLabel.setVisible(true);
		memoriaTypeLabel.setVisible(true);
		cantMemoriaSpn.setVisible(true);
		medidaMemoriaCbx.setVisible(true);
		memoriaTypeCbx.setVisible(true);
		
		ramRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(true);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(new CompoundBorder(), "Informacion de RAM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), border));
				
				setEverythingTo(false);
				
				memoriaLabel.setVisible(true);
				memoriaTypeLabel.setVisible(true);
				cantMemoriaSpn.setVisible(true);
				medidaMemoriaCbx.setVisible(true);
				memoriaTypeCbx.setVisible(true);
				
			
			}
		});
		gpuRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(true);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(new CompoundBorder(), "Informacion de GPU", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), border));
				
				setEverythingTo(false);
				
				medidaVelocidadLabel.setBounds(423, 200, 60, 28);
				medidaVelocidadLabel.setVisible(true);
				velocidadGPUspn.setVisible(true);
				tipoConexionGPUcbx.setVisible(true);
				vramSpn.setVisible(true);
				tipoGPUtxtField.setVisible(true);
				tipoConexionGPULabel.setVisible(true);
				velocidadGPULabel.setVisible(true);
				vramLabel.setVisible(true);
				tipoGPULabel.setVisible(true);
			}
		});
		discoDuroRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(true);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(new CompoundBorder(), "Informacion de Disco Duro", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), border));
				
				setEverythingTo(false);
				
				hddToggleBttn.setVisible(true);
				ssdToggleBttn.setVisible(true);
				almacenamientoSpn.setVisible(true);
				discoMedidaCbx.setVisible(true);
				medidaEscrituraCbx.setVisible(true);
				medidaLecturaCbx.setVisible(true);
				almacenamientoLabel.setVisible(true);
				tipoDiscoLabel.setVisible(true);
				discoTipoConexionLabel.setVisible(true);
				velEscrituraLabel.setVisible(true);
				velLecturaLabel.setVisible(true);
				abrirListaBttn.setVisible(true);
				abrirListaBttn.setBounds(306, 144, 177, 38);
				conexionDiscoDuroPanel.setBounds(500, 144, 206, 177);
				velEscrituraSpn.setVisible(true);
				velLecturaSpn.setVisible(true);
				
			}
		});
		tarjetaMadreRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(true);
				microprocesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(new CompoundBorder(), "Informacion de Tarjeta Madre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), border));
				
				setEverythingTo(false);
				

				tipoSocketLabel.setVisible(true);
				tipoRamLabel.setVisible(true);
				RamTypeCbx.setVisible(true);
				socketTypeCbx.setVisible(true);
				conexionDiscoDuroLabel.setVisible(true);
				abrirListaBttn.setVisible(true);
				abrirListaBttn.setBounds(306, 200, 177, 38);
				conexionDiscoDuroPanel.setBounds(500, 200, 206, 177);
				conectionGPULabel.setVisible(true);
				conectionGPUCbx.setVisible(true);
				
			}
		});
		microprocesadorRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(true);
				
				Image img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(new CompoundBorder(), "Informacion de Mircoprocesador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentInfoPanel.setBorder(new CompoundBorder(new RoundedBorder(new Color(0, 78, 137), 1, 10), border));
				
				setEverythingTo(false);
				
				
				nucleosSpn.setVisible(true);
				velocidadSpn.setVisible(true);
				tipoConexionCbx.setVisible(true);
				medidaVelocidadLabel.setBounds(423, 36, 60, 28);
				medidaVelocidadLabel.setVisible(true);
				nucleosLabel.setVisible(true);
				tipoConexionLabel.setVisible(true);
				velocidadLabel.setVisible(true);
			}
		});
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(new Color(3, 104, 196));
			buttonPane.setBounds(0, 706, 1245, 53);
			getContentPane().add(buttonPane);
			{
				regBttn = new JButton("Registrar");
				regBttn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						Componente newComponente = null;
						
						String id = idTextField.getText();
						String marca = marcaTextField.getText();
						String modelo = modeloTextField.getText();
						int cantidad = Integer.parseInt(cantidadSpn.getValue().toString());
						float precio = Float.parseFloat(precioSpn.getValue().toString());
						
						if ( ramRdoBttn.isSelected() ) {
							String memoria = cantMemoriaSpn.getValue().toString() + " " + medidaMemoriaCbx.getSelectedItem().toString();
							String tipoMemoria = memoriaTypeCbx.getSelectedItem().toString();
							
							newComponente = new Ram(id, marca, modelo, precio, cantidad, 0, memoria, tipoMemoria);
						} else if ( microprocesadorRdoBttn.isSelected() ) {
							float velocidad = Float.parseFloat(velocidadSpn.getValue().toString());
							String tipoConexion = tipoConexionCbx.getSelectedItem().toString();
							int nucleos = Integer.parseInt(nucleosSpn.getValue().toString());
							
							newComponente = new MicroProcesador(id, marca, modelo, precio, cantidad, 0, velocidad, tipoConexion, nucleos);
							
						} else if (gpuRdoBttn.isSelected()) {
						    String tipo = tipoGPUtxtField.getText();
						    float vRAM = Float.parseFloat(vramSpn.getValue().toString());
						    float velocidad = Float.parseFloat(velocidadGPUspn.getValue().toString());
						    String tipoConexion = tipoConexionGPUcbx.getSelectedItem().toString();
						    
						    newComponente = new GPU(id, marca, modelo, precio, cantidad, 0, tipo, vRAM, velocidad, tipoConexion);

						} else if (tarjetaMadreRdoBttn.isSelected()) {
						    String conectionSocket = socketTypeCbx.getSelectedItem().toString();
						    String tipoRam = RamTypeCbx.getSelectedItem().toString();
						    String conectionGPU = conectionGPUCbx.getSelectedItem().toString();
						    
						    ArrayList<String> tipoDiscoDuro = new ArrayList<>();
						    if (ideCheckBox.isSelected()) tipoDiscoDuro.add("IDE");
						    if (sataCheckBox.isSelected()) tipoDiscoDuro.add("SATA");
						    if (sata2CheckBox.isSelected()) tipoDiscoDuro.add("SATA-2");
						    if (sata3CheckBox.isSelected()) tipoDiscoDuro.add("SATA-3");
						    if (m2SataCheckBox.isSelected()) tipoDiscoDuro.add("M.2 SATA");
						    if (eSataCheckBox.isSelected()) tipoDiscoDuro.add("eSATA");
						    
						    newComponente = new TarjetaMadre(id, marca, modelo, precio, cantidad, 0, conectionSocket, tipoRam, conectionGPU, tipoDiscoDuro);

						} else if ( discoDuroRdoBttn.isSelected() ) {
							float almacenamiento = Float.parseFloat(almacenamientoSpn.getValue().toString());
							if (discoMedidaCbx.getSelectedItem().toString().equals("TB")) {
						        almacenamiento *= 1000; // Convertir a GB si está en TB
						    }
							
							float velLectura = Float.parseFloat(velLecturaSpn.getValue().toString());
						    float velEscritura = Float.parseFloat(velEscrituraSpn.getValue().toString());
						    
						    String tipo = hddToggleBttn.isSelected() ? "HDD" : "SSD";
						    
						    ArrayList<String> tipoConexiones = new ArrayList<>();
						    if (ideCheckBox.isSelected()) tipoConexiones.add("IDE");
						    if (sataCheckBox.isSelected()) tipoConexiones.add("SATA");
						    if (sata2CheckBox.isSelected()) tipoConexiones.add("SATA-2");
						    if (sata3CheckBox.isSelected()) tipoConexiones.add("SATA-3");
						    if (m2SataCheckBox.isSelected()) tipoConexiones.add("M.2 SATA");
						    if (eSataCheckBox.isSelected()) tipoConexiones.add("eSATA");
						    
						    newComponente = new DiscoDuro(id, marca, modelo, precio, cantidad, 0, almacenamiento, velLectura, velEscritura, tipo, tipoConexiones);
						}
						
						Tienda.getInstance().insertarComponente(newComponente);
						PopUp newPopUp = new PopUp(newComponente);
						newPopUp.setLocationRelativeTo(contentPanel);
						newPopUp.setVisible(true);
						
						clean();
					}
				});
				regBttn.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						regBttn.setBackground(new Color(11, 182, 72));
						regBttn.setForeground(Color.white);
						regBttn.setBorder(new RoundedBorder(new Color(11, 182, 72), 1, 10));
					}
					public void mouseExited(MouseEvent arg0) {
						regBttn.setBackground(Color.white);
						regBttn.setForeground(Color.black);
						regBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
					}
				});
				regBttn.setBounds(480, 5, 136, 36);
				regBttn.setFont(new Font("Century Gothic", Font.BOLD, 19));
				regBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
				regBttn.setFocusPainted(false);
				regBttn.setBackground(Color.white);
				regBttn.setActionCommand("Registrar");
				getRootPane().setDefaultButton(regBttn);
			}
			{
				cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				cancelButton.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {
						cancelButton.setBackground(new Color(167, 34, 34));
						cancelButton.setForeground(Color.white);
						cancelButton.setBorder(new RoundedBorder(new Color(167, 34, 34), 1, 10));
					}
					public void mouseExited(MouseEvent arg0) {
						cancelButton.setBackground(Color.white);
						cancelButton.setForeground(Color.black);
						cancelButton.setBorder(new RoundedBorder(Color.white, 1, 10));
					}
				});
				cancelButton.setBounds(621, 5, 136, 36);
				cancelButton.setFont(new Font("Century Gothic", Font.BOLD, 19));
				cancelButton.setFocusPainted(false);
				cancelButton.setBorder(new RoundedBorder(Color.white, 1, 10));
				cancelButton.setBackground(Color.white);
				cancelButton.setActionCommand("Cancel");
			}
			buttonPane.setLayout(null);
			buttonPane.add(regBttn);
			buttonPane.add(cancelButton);
		}
	}
	
	protected void clean() {
		idTextField.setText("C-" + Tienda.getInstance().getCodComponente());
		
		cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		cantMemoriaSpn.setValue(2);
		//medidaMemoriaCbx.setSelectedIndex(0);
		memoriaTypeCbx.setSelectedIndex(0);

		RamTypeCbx.setSelectedIndex(0);
		socketTypeCbx.setSelectedIndex(0);
		
		nucleosSpn.setValue(2);
		velocidadSpn.setValue(0.5);
		tipoConexionCbx.setSelectedIndex(0);

		hddToggleBttn.setSelected(true);
		ssdToggleBttn.setSelected(false);
		almacenamientoSpn.setValue(4);
		//discoMedidaCbx.setSelectedIndex(0);
		medidaEscrituraCbx.setSelectedIndex(0);
		medidaLecturaCbx.setSelectedIndex(0);
		velEscrituraSpn.setValue(16);
		velLecturaSpn.setValue(16);
		
		conectionGPUCbx.setSelectedIndex(0);
		
		velocidadGPUspn.setValue(0.5);
		tipoConexionGPUcbx.setSelectedIndex(0);
		vramSpn.setValue(2);
		tipoGPUtxtField.setText("");
		
		conexionDiscoDuroPanel.setVisible(false);
		abrirListaBttn.setVisible(false);
		abrirListaBttn.setText("Abrir Lista");
		ideCheckBox.setSelected(false);
		sataCheckBox.setSelected(false);
		sata2CheckBox.setSelected(false);
		sata3CheckBox.setSelected(false);
		m2SataCheckBox.setSelected(false);
		eSataCheckBox.setSelected(false);
		
		
	}

	private void setEverythingTo(boolean estado) {
		memoriaLabel.setVisible(estado);
		memoriaTypeLabel.setVisible(estado);
		cantMemoriaSpn.setVisible(estado);
		medidaMemoriaCbx.setVisible(estado);
		memoriaTypeCbx.setVisible(estado);
		tipoRamLabel.setVisible(estado);
		tipoSocketLabel.setVisible(estado);
		RamTypeCbx.setVisible(estado);
		socketTypeCbx.setVisible(estado);
		conexionDiscoDuroLabel.setVisible(estado);
		
		nucleosSpn.setVisible(estado);
		velocidadSpn.setVisible(estado);
		tipoConexionCbx.setVisible(estado);
		nucleosLabel.setVisible(estado);
		tipoConexionLabel.setVisible(estado);
		velocidadLabel.setVisible(estado);
		
		memoriaLabel.setVisible(estado);
		memoriaTypeLabel.setVisible(estado);
		cantMemoriaSpn.setVisible(estado);
		medidaMemoriaCbx.setVisible(estado);
		memoriaTypeCbx.setVisible(estado);
		almacenamientoLabel.setVisible(estado);
		tipoDiscoLabel.setVisible(estado);
		
		hddToggleBttn.setVisible(estado);
		ssdToggleBttn.setVisible(estado);
		almacenamientoSpn.setVisible(estado);
		discoMedidaCbx.setVisible(estado);
		medidaEscrituraCbx.setVisible(estado);
		medidaLecturaCbx.setVisible(estado);
		almacenamientoLabel.setVisible(estado);
		tipoDiscoLabel.setVisible(estado);
		discoTipoConexionLabel.setVisible(estado);
		velEscrituraLabel.setVisible(estado);
		velLecturaLabel.setVisible(estado);
		velEscrituraSpn.setVisible(estado);
		velLecturaSpn.setVisible(estado);
		
		conectionGPULabel.setVisible(estado);
		conectionGPUCbx.setVisible(estado);
		medidaVelocidadLabel.setVisible(estado);
		
		velocidadGPUspn.setVisible(estado);
		tipoConexionGPUcbx.setVisible(estado);
		vramSpn.setVisible(estado);
		tipoGPUtxtField.setVisible(estado);
		tipoConexionGPULabel.setVisible(estado);
		velocidadGPULabel.setVisible(estado);
		vramLabel.setVisible(estado);
		tipoGPULabel.setVisible(estado);
		
		conexionDiscoDuroPanel.setVisible(estado);
		if ( !estado ) {
			abrirListaBttn.setVisible(false);
			abrirListaBttn.setText("Abrir Lista");
			ideCheckBox.setSelected(false);
			sataCheckBox.setSelected(false);
			sata2CheckBox.setSelected(false);
			sata3CheckBox.setSelected(false);
			m2SataCheckBox.setSelected(false);
			eSataCheckBox.setSelected(false);
		}
		
	}
}
