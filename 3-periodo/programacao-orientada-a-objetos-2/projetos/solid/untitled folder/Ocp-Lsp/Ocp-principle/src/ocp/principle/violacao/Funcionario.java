package ocp.principle.violacao;

public class Funcionario {
    // nome, tipo, remuneração; 
    // construtor
    private String nome;
    private String tipo;
    private double remuneracao;

    public Funcionario(String nome, String tipo, double remuneracao) {
        this.nome = nome;
        this.tipo = tipo;
        this.remuneracao = remuneracao;
    }

    public Object getTipo() {
        return tipo;
    }
}
