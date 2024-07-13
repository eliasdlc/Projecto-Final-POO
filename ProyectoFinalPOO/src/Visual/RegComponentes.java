package Visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.Font;
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
		memoriaTypeCbx.setBounds(234, 88, 141, 28);
		componentPanel.add(memoriaTypeCbx);
		
		
		
		cantMemoriaSpn = new JSpinner();
		cantMemoriaSpn.setFont(new Font("Century Gothic", Font.PLAIN, 20));
		cantMemoriaSpn.setModel(new SpinnerNumberModel(new Integer(2), new Integer(2), null, new Integer(2)));
		cantMemoriaSpn.setBounds(234, 35, 141, 28);
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
		medidaMemoriaCbx.setBounds(387, 35, 60, 28);
		componentPanel.add(medidaMemoriaCbx);
		
		JLabel lblVelocidad = new JLabel("Velocidad:");
		lblVelocidad.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblVelocidad.setBounds(29, 168, 177, 28);
		componentPanel.add(lblVelocidad);
		
		JLabel lblTipoConexion = new JLabel("Tipo Conexion:");
		lblTipoConexion.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblTipoConexion.setBounds(29, 219, 177, 28);
		componentPanel.add(lblTipoConexion);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblPlataforma.setBounds(29, 271, 177, 28);
		componentPanel.add(lblPlataforma);
		
		JLabel lblNucleos = new JLabel("Nucleos:");
		lblNucleos.setFont(new Font("Century Gothic", Font.PLAIN, 22));
		lblNucleos.setBounds(29, 321, 177, 28);
		componentPanel.add(lblNucleos);
		
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
