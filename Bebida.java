package TRAB2;


public class Bebida {
	private int idBebida;
    private String nome;
    private Double preco;

    public Bebida(){
        int idBebida = 1;
        String nome = "aaaaaa";
        Double preco = 0.00;
    }

    public Bebida(int idBebida, String nome, Double preco) {
        this.idBebida = idBebida;
        this.nome = nome;
        this.preco = preco;
    }

    public int getIdBebida() {
        return idBebida;
    }

    public void setIdBebida(int idBebida) {
        this.idBebida = idBebida;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Id Bebida: " + idBebida + "\nNome Bebida: " + nome + "\nPreco: " + preco;
    }
    
}
