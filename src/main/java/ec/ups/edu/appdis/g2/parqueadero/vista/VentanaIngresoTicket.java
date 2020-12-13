package ec.ups.edu.appdis.g2.parqueadero.vista;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;

public class VentanaIngresoTicket {

	private JFrame frame;
	private JTextField txtNombre;
	private JTextField txtDNI;
	private JTextField txtEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaIngresoTicket window = new VentanaIngresoTicket();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaIngresoTicket() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(32, 26, 134, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblDni = new JLabel("DNI");
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDni.setBounds(32, 94, 134, 33);
		frame.getContentPane().add(lblDni);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblEmail.setBounds(32, 166, 134, 33);
		frame.getContentPane().add(lblEmail);
		
		txtNombre = new JTextField();
		txtNombre.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtNombre.setBounds(162, 23, 173, 38);
		frame.getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDNI = new JTextField();
		txtDNI.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtDNI.setColumns(10);
		txtDNI.setBounds(162, 91, 173, 38);
		frame.getContentPane().add(txtDNI);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Tahoma", Font.BOLD, 16));
		txtEmail.setColumns(10);
		txtEmail.setBounds(162, 161, 173, 38);
		frame.getContentPane().add(txtEmail);
		
		JButton btnGuardar = new JButton("Guardar");
		btnGuardar.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnGuardar.setBounds(207, 209, 142, 33);
		frame.getContentPane().add(btnGuardar);
	}
}
