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
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.text.Format;
import java.text.NumberFormat;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.TitledBorder;
import javax.swing.text.MaskFormatter;

import Logica.RoundedBorder;

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

public class RegComponentes extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JLabel memoriaTypeLabel;
	private JLabel memoriaLabel;
	private JComboBox medidaMemoriaCbx;
	private JSpinner cantMemoriaSpn;
	private JComboBox memoriaTypeCbx;
	private JLabel velocidadLabel;
	private JSpinner velocidadSpn;
	private JComboBox tipoConexionCbx;
	private JSpinner nucleosSpn;

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
		setBounds(100, 100, 1399, 789);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		contentPanel.add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		TitledBorder titledBorder = new TitledBorder(new CompoundBorder(), "Informacion General", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		titledBorder.setTitleFont(new Font("Century Gothic", Font.PLAIN, 15));
		panel_1.setBorder(titledBorder);
		
		panel_1.setBounds(12, 13, 1347, 219);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Id:");
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNewLabel.setBounds(266, 63, 118, 28);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(384, 63, 185, 28);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblMarca = new JLabel("Marca:");
		lblMarca.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblMarca.setBounds(266, 129, 118, 28);
		panel_1.add(lblMarca);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(384, 129, 353, 28);
		panel_1.add(textField_1);
		
		JLabel lblModelo = new JLabel("Modelo:");
		lblModelo.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblModelo.setBounds(791, 129, 118, 28);
		panel_1.add(lblModelo);
		
		JLabel lblPrecio = new JLabel("Precio:");
		lblPrecio.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblPrecio.setBounds(596, 63, 118, 28);
		panel_1.add(lblPrecio);
		
		JLabel lblCantidad = new JLabel("Cantidad:");
		lblCantidad.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblCantidad.setBounds(925, 63, 118, 28);
		panel_1.add(lblCantidad);
		
		
		NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();
		
		JSpinner spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(new Float(0), new Float(0), null, new Float(10)));

		
		
		spinner.setBounds(714, 63, 185, 28);
		panel_1.add(spinner);
		
		JSpinner spinner_1 = new JSpinner();
		spinner_1.setBounds(1055, 63, 219, 28);
		panel_1.add(spinner_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(921, 129, 353, 28);
		panel_1.add(textField_2);
		
		JLabel componentIcon = new JLabel("");
		componentIcon.setBounds(33, 13, 185, 185);
		Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
		Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
		componentIcon.setIcon(new ImageIcon(scaledImg));
		panel_1.add(componentIcon);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(12, 245, 1347, 439);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JPanel componentPanel = new JPanel();
		TitledBorder border = new TitledBorder(null, "Informacion de RAM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
		border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
		componentPanel.setBorder(border);
		componentPanel.setBounds(356, 13, 979, 413);
		panel_2.add(componentPanel);
		componentPanel.setLayout(null);
		
		JPanel conexionDiscoDuroPanel = new JPanel();
		conexionDiscoDuroPanel.setBounds(291, 200, 206, 177);
		conexionDiscoDuroPanel.setBackground(new Color(255, 255, 255));
		conexionDiscoDuroPanel.setBorder(new RoundedBorder(new Color(255, 255, 255), 1, 10));
		conexionDiscoDuroPanel.setLayout(new GridLayout(0, 2));
		
		conexionDiscoDuroPanel.setVisible(false);
		componentPanel.add(conexionDiscoDuroPanel);
		
		JCheckBox ideCheckBox = new JCheckBox("IDE");
		ideCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		ideCheckBox.setOpaque(false);
		JCheckBox sataCheckBox = new JCheckBox("SATA");
		sataCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
		sataCheckBox.setOpaque(false);
        JCheckBox sata2CheckBox = new JCheckBox("SATA-2");
        sata2CheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        sata2CheckBox.setOpaque(false);
        JCheckBox sata3CheckBox = new JCheckBox("SATA-3");
        sata3CheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        sata3CheckBox.setOpaque(false);
        JCheckBox m2SataCheckBox = new JCheckBox("M.2 SATA");
        m2SataCheckBox.setFont(new Font("Century Gothic", Font.PLAIN, 16));
        m2SataCheckBox.setOpaque(false);
        JCheckBox eSataCheckBox = new JCheckBox("eSATA");
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
		componentPanel.add(memoriaLabel);
		
		memoriaTypeLabel = new JLabel("Tipo Memoria:");
		memoriaTypeLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		memoriaTypeLabel.setBounds(29, 88, 177, 28);
		componentPanel.add(memoriaTypeLabel);
		
		memoriaTypeCbx = new JComboBox();
		memoriaTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		memoriaTypeCbx.setBackground(Color.WHITE);
		memoriaTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		memoriaTypeCbx.setBounds(234, 88, 177, 28);
		componentPanel.add(memoriaTypeCbx);
		
		
		
		cantMemoriaSpn = new JSpinner();
		cantMemoriaSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		cantMemoriaSpn.setBounds(234, 35, 177, 28);
		componentPanel.add(cantMemoriaSpn);
		
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
		componentPanel.add(medidaMemoriaCbx);
		
		velocidadLabel = new JLabel("Velocidad:");
		velocidadLabel.setVisible(false);
		velocidadLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		velocidadLabel.setBounds(29, 35, 177, 28);
		componentPanel.add(velocidadLabel);
		
		JLabel tipoConexionLabel = new JLabel("Tipo Conexion:");
		tipoConexionLabel.setVisible(false);
		tipoConexionLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoConexionLabel.setBounds(29, 88, 177, 28);
		componentPanel.add(tipoConexionLabel);
		
		JLabel nucleosLabel = new JLabel("Nucleos:");
		nucleosLabel.setVisible(false);
		nucleosLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		nucleosLabel.setBounds(29, 144, 177, 28);
		componentPanel.add(nucleosLabel);
		
		tipoConexionCbx = new JComboBox();
		tipoConexionCbx.setVisible(false);
		tipoConexionCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		tipoConexionCbx.setBounds(234, 88, 177, 28);
		componentPanel.add(tipoConexionCbx);
		
		JComboBox medidaVelocidadCbx = new JComboBox();
		medidaVelocidadCbx.setVisible(false);
		medidaVelocidadCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		medidaVelocidadCbx.setBounds(423, 35, 60, 28);
		componentPanel.add(medidaVelocidadCbx);
		
		velocidadSpn = new JSpinner();
		velocidadSpn.setVisible(false);
		velocidadSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		velocidadSpn.setBounds(234, 35, 177, 28);
		componentPanel.add(velocidadSpn);
		
		nucleosSpn = new JSpinner();
		nucleosSpn.setVisible(false);
		nucleosSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		nucleosSpn.setBounds(234, 144, 177, 28);
		componentPanel.add(nucleosSpn);
		
		JLabel tipoSocketLabel = new JLabel("Tipo Socket:");
		tipoSocketLabel.setVisible(false);
		tipoSocketLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoSocketLabel.setBounds(29, 35, 177, 28);
		componentPanel.add(tipoSocketLabel);
		
		JLabel tipoRamLabel = new JLabel("Tipo RAM:");
		tipoRamLabel.setVisible(false);
		tipoRamLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tipoRamLabel.setBounds(29, 88, 177, 28);
		componentPanel.add(tipoRamLabel);
		
		JComboBox RamTypeCbx = new JComboBox();
		RamTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"DDR", "DDR2", "DDR3", "DDR4", "DDR5"}));
		RamTypeCbx.setVisible(false);
		RamTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		RamTypeCbx.setBackground(Color.WHITE);
		RamTypeCbx.setBounds(234, 89, 249, 28);
		componentPanel.add(RamTypeCbx);
		
		JComboBox socketTypeCbx = new JComboBox();
		socketTypeCbx.setModel(new DefaultComboBoxModel(new String[] {"LGA 1156", "LGA 1155", "LGA 1150", "LGA 1151", "LGA 1200", "Socket AM2", "Socket AM3", "Socket AM4", "Socket AM5", "Socket FM1", "Socket FM2", "Socket TR4", "Socket sTRX4"}));
		socketTypeCbx.setVisible(false);
		socketTypeCbx.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		socketTypeCbx.setBackground(Color.WHITE);
		socketTypeCbx.setBounds(234, 35, 249, 28);
		componentPanel.add(socketTypeCbx);
		
		JLabel conexionDiscoDuroLabel = new JLabel("Conexion Disco Duro:");
		conexionDiscoDuroLabel.setVisible(false);
		conexionDiscoDuroLabel.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		conexionDiscoDuroLabel.setBounds(29, 144, 261, 28);
		componentPanel.add(conexionDiscoDuroLabel);
		
		JButton abrirListaBttn = new JButton("Abrir Lista");
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
		abrirListaBttn.setBounds(306, 139, 177, 38);
		abrirListaBttn.setBorder(new RoundedBorder(Color.white, 1, 10));
		abrirListaBttn.setFocusPainted(false);
		componentPanel.add(abrirListaBttn);
		
		JRadioButton procesadorRdoBttn = new JRadioButton("Procesador");
		procesadorRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		procesadorRdoBttn.setFocusPainted(false);
		procesadorRdoBttn.setBounds(35, 170, 251, 28);
		panel_2.add(procesadorRdoBttn);
		
		JRadioButton microprocesadorRdoBttn = new JRadioButton("Micro-procesador");
		microprocesadorRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		microprocesadorRdoBttn.setFocusPainted(false);
		microprocesadorRdoBttn.setBounds(35, 104, 251, 28);
		panel_2.add(microprocesadorRdoBttn);
		
		JRadioButton ramRdoBttn = new JRadioButton("RAM");
		ramRdoBttn.setSelected(true);
		ramRdoBttn.setFocusPainted(false);
		ramRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		ramRdoBttn.setBounds(35, 38, 251, 28);
		panel_2.add(ramRdoBttn);
		
		JRadioButton tarjetaMadreRdoBttn = new JRadioButton("Tarjeta Madre");
		tarjetaMadreRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		tarjetaMadreRdoBttn.setFocusPainted(false);
		tarjetaMadreRdoBttn.setBounds(35, 236, 251, 28);
		panel_2.add(tarjetaMadreRdoBttn);
		
		JRadioButton discoDuroRdoBttn = new JRadioButton("Disco Duro");
		discoDuroRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		discoDuroRdoBttn.setFocusPainted(false);
		discoDuroRdoBttn.setBounds(35, 368, 251, 28);
		panel_2.add(discoDuroRdoBttn);
		
		JRadioButton gpuRdoBttn = new JRadioButton("GPU");
		gpuRdoBttn.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		gpuRdoBttn.setFocusPainted(false);
		gpuRdoBttn.setBounds(35, 302, 251, 28);
		panel_2.add(gpuRdoBttn);
		
		
		
		ramRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(true);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				procesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/ram-memory.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de RAM", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
				
				nucleosSpn.setVisible(false);
				velocidadSpn.setVisible(false);
				tipoConexionCbx.setVisible(false);
				medidaVelocidadCbx.setVisible(false);
				nucleosLabel.setVisible(false);
				tipoConexionLabel.setVisible(false);
				velocidadLabel.setVisible(false);
				
				memoriaLabel.setVisible(true);
				memoriaTypeLabel.setVisible(true);
				cantMemoriaSpn.setVisible(true);
				medidaMemoriaCbx.setVisible(true);
				memoriaTypeCbx.setVisible(true);
				
				tipoSocketLabel.setVisible(false);
				tipoRamLabel.setVisible(false);
				RamTypeCbx.setVisible(false);
				socketTypeCbx.setVisible(false);
				conexionDiscoDuroLabel.setVisible(false);
				abrirListaBttn.setVisible(false);
			}
		});
		gpuRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(true);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				procesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/gpu.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de GPU", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
			}
		});
		discoDuroRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(true);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				procesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/hard-drive.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de Disco Duro", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
			}
		});
		tarjetaMadreRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(true);
				microprocesadorRdoBttn.setSelected(false);
				procesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/motherboard.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de Tarjeta Madre", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
				
				tipoSocketLabel.setVisible(true);
				tipoRamLabel.setVisible(true);
				RamTypeCbx.setVisible(true);
				socketTypeCbx.setVisible(true);
				conexionDiscoDuroLabel.setVisible(true);
				abrirListaBttn.setVisible(true);
				
				nucleosSpn.setVisible(false);
				velocidadSpn.setVisible(false);
				tipoConexionCbx.setVisible(false);
				medidaVelocidadCbx.setVisible(false);
				nucleosLabel.setVisible(false);
				tipoConexionLabel.setVisible(false);
				velocidadLabel.setVisible(false);
				
				memoriaLabel.setVisible(false);
				memoriaTypeLabel.setVisible(false);
				cantMemoriaSpn.setVisible(false);
				medidaMemoriaCbx.setVisible(false);
				memoriaTypeCbx.setVisible(false);
			}
		});
		microprocesadorRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(true);
				procesadorRdoBttn.setSelected(false);
				
				Image img = new ImageIcon(this.getClass().getResource("/micro-cpu.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de Mircoprocesador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
				
				//setEverythingToFalse();
				nucleosSpn.setVisible(true);
				velocidadSpn.setVisible(true);
				tipoConexionCbx.setVisible(true);
				medidaVelocidadCbx.setVisible(true);
				nucleosLabel.setVisible(true);
				tipoConexionLabel.setVisible(true);
				velocidadLabel.setVisible(true);
				
				memoriaLabel.setVisible(false);
				memoriaTypeLabel.setVisible(false);
				cantMemoriaSpn.setVisible(false);
				medidaMemoriaCbx.setVisible(false);
				memoriaTypeCbx.setVisible(false);
				
				tipoSocketLabel.setVisible(false);
				tipoRamLabel.setVisible(false);
				RamTypeCbx.setVisible(false);
				socketTypeCbx.setVisible(false);
				conexionDiscoDuroLabel.setVisible(false);
				abrirListaBttn.setVisible(false);
				
			}
		});
		procesadorRdoBttn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ramRdoBttn.setSelected(false);
				gpuRdoBttn.setSelected(false);
				discoDuroRdoBttn.setSelected(false);
				tarjetaMadreRdoBttn.setSelected(false);
				microprocesadorRdoBttn.setSelected(false);
				procesadorRdoBttn.setSelected(true);
				
				Image img = new ImageIcon(this.getClass().getResource("/cpu.png")).getImage();
				Image scaledImg = img.getScaledInstance(componentIcon.getHeight(), componentIcon.getWidth(), Image.SCALE_SMOOTH);
				componentIcon.setIcon(new ImageIcon(scaledImg));
				
				TitledBorder border = new TitledBorder(null, "Informacion de Procesador", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(0, 0, 0));
				border.setTitleFont(new Font("Century Gothic", Font.PLAIN, 16));
				componentPanel.setBorder(border);
			}
		});
		
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
