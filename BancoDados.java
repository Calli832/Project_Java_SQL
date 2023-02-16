package TRAB2;

import java.sql.Connection;
import javax.swing.JOptionPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BancoDados {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultset = null;

	public void conectar() {
		String servidor = "jdbc:mysql://localhost:3306/Bebidas";
		String usuario = "root";
		String senha = "senha12";
		String driver = "com.mysql.jdbc.Driver";
		try {
			Class.forName(driver);
			this.connection = DriverManager.getConnection(servidor, usuario, senha);
			this.statement = this.connection.createStatement();
		} catch (Exception e) {
			System.out.println("Erro" + e.getMessage());
		}
	}

	public boolean estaConectado() {
		if (this.connection != null) {
			return true;
		} else {
			return false;
		}
	}

	public void desconectar() {
		try {
			this.connection.close();
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	public void listarBebidas() {
		try {
			String query = "SELECT * FROM Bebidas ORDER BY idBebida";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				JOptionPane.showMessageDialog(null,"\nId: " + this.resultset.getString("idBebida") + "\nNome: "
						+ this.resultset.getString("nome")
						+ "\nPreco: " + this.resultset.getString("preco"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void inserirBebidas(int idBebida, String nome, Double preco) {
		try {
			String query = "INSERT INTO Bebidas (idBebida, nome, preco) VALUES ('"+ idBebida + "', '" + nome + "','" + preco +"')";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Bebida Cadastrada");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage());
		}
	}

	public void editarBebidas(int idBebida, String nome, Double preco) {
		try {
			String query = "UPDATE Bebidas SET nome = '" + nome + "', preco = '" + preco + 
					"' WHERE idBebida = " + idBebida + ";";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Bebida Editada");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
		}
	}

	public void apagarBebidas(int idBebida) {
		try {
			String query = "DELETE FROM Bebidas WHERE idBebida = " + idBebida + ";";
			this.statement.executeUpdate(query);
			JOptionPane.showMessageDialog(null,"Bebida Excluida");
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
		}
	}

	public void consultarBebidaNome(String nome) {
		try {
			String query = "SELECT * FROM Bebidas WHERE nome = '" + nome + "';";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				JOptionPane.showMessageDialog(null,"\nId: " + this.resultset.getString("idBebida") + "\nNome: "		 + this.resultset.getString("nome")
						+ "\nPreco: " + this.resultset.getString("preco"));
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Erro: " + e.getMessage());
		}
	}

	public void consultarBebidaId(int idBebida) {
		try {
			String query = "SELECT * FROM Bebidas WHERE idBebida = " + idBebida + ";";
			this.resultset = this.statement.executeQuery(query);
			while (this.resultset.next()) {
				JOptionPane.showMessageDialog(null,"\nId: " + this.resultset.getString("idBebida") + "\nNome: "		 + this.resultset.getString("nome")
						+ "\nPreco: " + this.resultset.getString("preco"));
			}
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}
}
