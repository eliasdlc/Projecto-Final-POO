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

import Logica.Cliente;
import Logica.RoundedBorder;
import Logica.Tienda;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PopUpRegCliente extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private static final Color SecondaryC = new Color(3, 104, 196);
	private static final Color hoverEffectColor = new Color(3, 135, 255);
	private JTextField idtxt;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField phonetxt;
	private JTextField dirtxt;
	private JTextField descTxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			PopUpRegCliente dialog = new PopUpRegCliente(null);
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public PopUpRegCliente(String id) {
		setUndecorated(true);
		setBounds(100, 100, 450, 400);
		setModal(true);
		
		setLocationRelativeTo(getParent());
		
		int arcWidth = 20;
		int archeight = 20;
        setShape(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arcWidth, archeight));		
        getContentPane().setLayout(new BorderLayout());
		
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new BorderLayout(0, 0));
		{
			JPanel panel = new JPanel();
			panel.setBackground(new Color(247, 247, 247));
			panel.setBounds(0, 0, 450, 382);
			contentPanel.add(panel, BorderLayout.CENTER);
			panel.setLayout(null);
			
			JPanel line = new JPanel();
			line.setBackground(SecondaryC);
			line.setBounds(0, 0, 450, 10);
			panel.add(line);
			
			JLabel idlabel = new JLabel("Id:");
			idlabel.setFont(new Font("Century Gothic", Font.BOLD, 18));
			idlabel.setBounds(15, 75, 69, 20);
			panel.add(idlabel);
			
			JLabel namelbl = new JLabel("Nombre:");
			namelbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
			namelbl.setBounds(15, 111, 103, 20);
			panel.add(namelbl);
			
			JLabel emaillbl = new JLabel("Correo:");
			emaillbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
			emaillbl.setBounds(15, 147, 69, 20);
			panel.add(emaillbl);
			
			JLabel titleTxt = new JLabel("Registrar Cliente");
			titleTxt.setFont(new Font("Century Gothic", Font.BOLD, 24));
			titleTxt.setBounds(111, 16, 199, 41);
			panel.add(titleTxt);
			
			idtxt = new JTextField();
			idtxt.setText(id);
			idtxt.setEditable(false);
			idtxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			idtxt.setBounds(133, 73, 164, 26);
			panel.add(idtxt);
			idtxt.setColumns(10);
			
			JLabel phonelbl = new JLabel("Telefono:");
			phonelbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
			phonelbl.setBounds(15, 189, 103, 20);
			panel.add(phonelbl);
			
			nametxt = new JTextField();
			nametxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			nametxt.setColumns(10);
			nametxt.setBounds(133, 109, 236, 26);
			panel.add(nametxt);
			
			emailtxt = new JTextField();
			emailtxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			emailtxt.setColumns(10);
			emailtxt.setBounds(133, 145, 236, 26);
			panel.add(emailtxt);
			
			phonetxt = new JTextField();
			phonetxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			phonetxt.setColumns(10);
			phonetxt.setBounds(133, 187, 176, 26);
			panel.add(phonetxt);
			
			JLabel dirlbl = new JLabel("Direccion:");
			dirlbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
			dirlbl.setBounds(15, 228, 92, 20);
			panel.add(dirlbl);
			
			dirtxt = new JTextField();
			dirtxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			dirtxt.setBounds(133, 226, 292, 26);
			panel.add(dirtxt);
			dirtxt.setColumns(10);
			
			JLabel desclbl = new JLabel("Descripcion:");
			desclbl.setFont(new Font("Century Gothic", Font.BOLD, 18));
			desclbl.setBounds(15, 274, 137, 20);
			panel.add(desclbl);
			
			descTxt = new JTextField();
			descTxt.setFont(new Font("Century Gothic", Font.BOLD, 16));
			descTxt.setBounds(133, 268, 292, 26);
			panel.add(descTxt);
			descTxt.setColumns(10);
			
			JButton regBtn = new JButton("Registrar");
			regBtn.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseEntered(MouseEvent e) {
					regBtn.setBorder(new RoundedBorder(hoverEffectColor, 1, 20));
					regBtn.setBackground(hoverEffectColor);
				}
				@Override
				public void mouseExited(MouseEvent e) {
					regBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
					regBtn.setBackground(SecondaryC);
				}
			});
			regBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String id = idtxt.getText();
					String name = nametxt.getText();
					String email = emailtxt.getText();
					String phone = phonetxt.getText();
					String dir = dirtxt.getText();
					String desc = descTxt.getText();
					
					Cliente cli = new Cliente(id, name, email, desc, phone, dir);
					Tienda.getInstance().insertarCliente(cli);
					clean();
					dispose();
				}
			});
			regBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			regBtn.setBackground(SecondaryC);
			regBtn.setForeground(Color.WHITE);
			regBtn.setFont(new Font("Century Gothic", Font.BOLD, 18));
			regBtn.setBounds(73, 332, 115, 29);
			panel.add(regBtn);
			
			JButton cancelBtn = new JButton("Cancelar");
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
			cancelBtn.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});
			cancelBtn.setBorder(new RoundedBorder(SecondaryC, 1, 20));
			cancelBtn.setBackground(SecondaryC);
			cancelBtn.setForeground(Color.WHITE);
			cancelBtn.setFont((new Font("Century Gothic", Font.BOLD, 18)));
			cancelBtn.setBounds(240, 332, 115, 29);
			panel.add(cancelBtn);
		}
	}
	
	public void clean() {
		idtxt.setText("");
		nametxt.setText("");
		dirtxt.setText("");
		descTxt.setText("");
		phonetxt.setText("");
		emailtxt.setText("");
	}
}
