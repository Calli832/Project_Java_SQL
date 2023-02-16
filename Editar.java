package TRAB2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Editar {

	private JFrame frame;
	private JTextField textNome;
	private JTextField textIdBebida;
	private JTextField textPreco;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Editar window = new Editar();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Editar() {
		initialize();
	}

	private void initialize() {
		BancoDados banco = new BancoDados();
		banco.conectar();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 0, 0));
		frame.getContentPane().setLayout(null);
		
		JLabel lblPreco = new JLabel("Preço");
		lblPreco.setForeground(Color.WHITE);
		lblPreco.setBounds(148, 71, 46, 14);
		frame.getContentPane().add(lblPreco);
		
		textPreco = new JTextField();
		textPreco.setColumns(10);
		textPreco.setBounds(148, 96, 86, 20);
		frame.getContentPane().add(textPreco);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setForeground(Color.WHITE);
		lblNome.setBounds(23, 71, 46, 14);
		frame.getContentPane().add(lblNome);
		
		textNome = new JTextField();
		textNome.setBounds(23, 96, 86, 20);
		frame.getContentPane().add(textNome);
		textNome.setColumns(10);
		
		textIdBebida = new JTextField();
		textIdBebida.setColumns(10);
		textIdBebida.setBounds(23, 40, 86, 20);
		frame.getContentPane().add(textIdBebida);
		
		JLabel lblCod = new JLabel("Id Bebida");
		lblCod.setForeground(Color.WHITE);
		lblCod.setBounds(23, 15, 46, 14);
		frame.getContentPane().add(lblCod);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(314, 136, 89, 23);
		frame.getContentPane().add(btnSair);
		
		JButton btnEditar_1 = new JButton("Editar");
		btnEditar_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Bebida bebida = new Bebida();
				bebida.setIdBebida(Integer.parseInt(textIdBebida.getText()));
				bebida.setNome(textNome.getText());
				bebida.setPreco(Double.parseDouble(textPreco.getText()));
				banco.editarBebidas(bebida.getIdBebida(), bebida.getNome(), bebida.getPreco());
			}
		});
		btnEditar_1.setBounds(23, 136, 89, 23);
		frame.getContentPane().add(btnEditar_1);
		
		
		frame.setBounds(100, 100, 450, 222);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
