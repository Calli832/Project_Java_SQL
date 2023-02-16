package TRAB2;


import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Cadastro {

	private JFrame frame;
	private JTextField textID;
	private JTextField textNome;
	private JTextField textPreco;

	public static void main(String[] args) {
		//BancoDados banco = new BancoDados();
		//banco.conectar();

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Cadastro window = new Cadastro();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Cadastro() {
		initialize();
	}

	private void initialize() {
		BancoDados banco = new BancoDados();
		banco.conectar();
	

		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 266);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textID = new JTextField();
		textID.setBounds(21, 44, 158, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JLabel lblID = new JLabel("ID");
		lblID.setForeground(Color.WHITE);
		lblID.setBounds(21, 29, 46, 14);
		frame.getContentPane().add(lblID);
		
		textNome = new JTextField();
		textNome.setBounds(21, 92, 158, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(21, 75, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textPreco = new JTextField();
		textPreco.setBounds(21, 137, 158, 20);
		frame.getContentPane().add(textPreco);
		textPreco.setColumns(10);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setBounds(21, 120, 46, 14);
		frame.getContentPane().add(lblPreco);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(322, 181, 89, 23);
		frame.getContentPane().add(btnSair);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bebida bebida = new Bebida();
				bebida.setIdBebida(Integer.parseInt(textID.getText()));
				bebida.setNome(textNome.getText());
				bebida.setPreco(Double.parseDouble(textPreco.getText()));
			
				banco.inserirBebidas(bebida.getIdBebida(), bebida.getNome(), bebida.getPreco());
			}
		});
		btnCadastrar.setBounds(21, 181, 89, 23);
		frame.getContentPane().add(btnCadastrar);
	}
}

