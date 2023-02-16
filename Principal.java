package TRAB2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class Principal extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal frame = new Principal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Principal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 296);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.desktop);
		contentPane.setBorder(null);

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		BancoDados banco = new BancoDados();
		banco.conectar();
		
		JButton btnCriar = new JButton("Cadastrar Nova");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cadastro.main(null);
			}
		});
		btnCriar.setBackground(Color.WHITE);
		btnCriar.setBounds(24, 32, 140, 23);
		contentPane.add(btnCriar);
		
		JButton btnEditar = new JButton("Editar");
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Editar.main(null);
			}
		});
		Color cool = new Color (0xFFFFFF);
		btnEditar.setBackground(cool);
		btnEditar.setBounds(24, 66, 140, 23);
		contentPane.add(btnEditar);
		
		JButton btnCosultaID = new JButton("Consulta: ID");
		btnCosultaID.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarBebidaID.main(null);
			}
		});
		btnCosultaID.setBackground(Color.WHITE);
		btnCosultaID.setBounds(24, 100, 140, 23);
		contentPane.add(btnCosultaID);
		
		JButton btnConsultaNome = new JButton("Consulta: Nome");
		btnConsultaNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ConsultarBebidaNome.main(null);
			}
		});
		btnConsultaNome.setBackground(Color.WHITE);
		btnConsultaNome.setBounds(24, 134, 140, 23);
		contentPane.add(btnConsultaNome);
		
		JButton btnListar = new JButton("Listar");
		btnListar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				banco.listarBebidas();
			}
		});
		btnListar.setBackground(Color.WHITE);
		btnListar.setBounds(24, 168, 140, 23);
		contentPane.add(btnListar);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Excluir.main(null);
			}
		});
		btnExcluir.setBackground(Color.WHITE);
		btnExcluir.setBounds(24, 202, 140, 23);
		contentPane.add(btnExcluir);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnSair.setBackground(Color.WHITE);
		btnSair.setBounds(436, 202, 89, 23);
		contentPane.add(btnSair);
	}
}
