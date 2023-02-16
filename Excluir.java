package TRAB2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Excluir {

	private JFrame frame;
	private JTextField textID;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Excluir window = new Excluir();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Excluir() {
		initialize();
	}

	private void initialize() {
		BancoDados banco = new BancoDados();
		banco.conectar();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lbID = new JLabel("ID");
		lbID.setForeground(Color.WHITE);
		lbID.setBounds(39, 59, 46, 14);
		frame.getContentPane().add(lbID);
		
		textID = new JTextField();
		textID.setBounds(39, 72, 102, 20);
		frame.getContentPane().add(textID);
		textID.setColumns(10);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBounds(319, 109, 89, 23);
		frame.getContentPane().add(btnSair);
		
		JLabel lblExpli = new JLabel("Digite o ID do produto que irá excluir");
		lblExpli.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblExpli.setForeground(Color.WHITE);
		lblExpli.setBounds(39, 11, 337, 25);
		frame.getContentPane().add(lblExpli);
		
		JButton btnExcluir_1 = new JButton("Excluir");
		btnExcluir_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banco.apagarBebidas(Integer.parseInt(textID.getText()));
			}
		});
		btnExcluir_1.setBounds(39, 109, 89, 23);
		frame.getContentPane().add(btnExcluir_1);
		frame.setBounds(100, 100, 450, 195);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
