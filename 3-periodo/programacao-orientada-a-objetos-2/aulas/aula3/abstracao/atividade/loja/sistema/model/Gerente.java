public class Gerente extends Funcionario {
    private double bonificacao;

    public Gerente(String nome, String clt, double salario, double bonificacao) {
        super(nome, clt, salario);
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
        this.bonificacao = bonificacao;
    }

    @Override
    public double calculaSalario() {
        return salario + bonificacao;
    }
}