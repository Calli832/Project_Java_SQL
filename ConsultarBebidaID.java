package TRAB2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarBebidaID {

	private JFrame frame;
	private JTextField textID;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarBebidaID window = new ConsultarBebidaID();
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
	public ConsultarBebidaID() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		BancoDados banco = new BancoDados();
		banco.conectar();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setForeground(new Color(0, 0, 0));
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(41, 96, 95, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel IdBebida = new JLabel("ID Bebida");
		IdBebida.setForeground(new Color(255, 255, 255));
		IdBebida.setBounds(42, 71, 46, 14);
		frame.getContentPane().add(IdBebida);
		
		JLabel lblNewLabel = new JLabel("Informe o ID da bebida que deseja consultar");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel.setBounds(54, 24, 345, 36);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnConsulta = new JButton("Consultar");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bebida bebida = new Bebida();
				bebida.setIdBebida(Integer.parseInt(textID.getText()));
				banco.consultarBebidaId(bebida.getIdBebida());
			}
		});
		btnConsulta.setBounds(41, 159, 89, 23);
		frame.getContentPane().add(btnConsulta);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(310, 159, 89, 23);
		frame.getContentPane().add(btnSair);
	}
}
