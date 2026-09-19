public class Vendedor extends Funcionario {
    private double totalVendas;
    private double comissao;

    public Vendedor(String nome, String clt, double salario, double totalVendas, double comissao) {
        super(nome, clt, salario);
        this.nome = nome;
        this.clt = clt;
        this.salario = salario;
        this.totalVendas = totalVendas;
        this.comissao = comissao;
    }

    @Override
    public double calculaSalario() {
        return salario + (totalVendas * comissao);
    }
}