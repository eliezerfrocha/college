public abstract class Funcionario {
    protected String nome;
    protected String clt;
    protected double salario;

    public Funcionario(String nome, String clt, double salario) {
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
    }

    // Método abstrato
    public abstract double calculaSalario();
}