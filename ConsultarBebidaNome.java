package TRAB2;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultarBebidaNome {

	private JFrame frame;
	private JTextField textNome;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultarBebidaNome window = new ConsultarBebidaNome();
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
	public ConsultarBebidaNome() {
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
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTitulo = new JLabel("Informe o nome da bebida que deseja consultar");
		lblTitulo.setForeground(new Color(255, 255, 255));
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblTitulo.setBounds(61, 28, 304, 36);
		frame.getContentPane().add(lblTitulo);
		
		textNome = new JTextField();
		textNome.setBounds(30, 103, 331, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome Bebida");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setBounds(30, 78, 68, 14);
		frame.getContentPane().add(lblNome);
		
		JButton btnConsultar = new JButton("Consultar");
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bebida bebida = new Bebida();
				bebida.setNome(textNome.getText());
				banco.consultarBebidaNome(bebida.getNome());
			}
		});
		btnConsultar.setBounds(30, 163, 89, 23);
		frame.getContentPane().add(btnConsultar);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(309, 163, 89, 23);
		frame.getContentPane().add(btnSair);
	}

}
