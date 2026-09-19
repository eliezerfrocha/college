package ocp.principle.solucao;

public class FolhaPagamento {
    protected double saldo;
    
    public double calcular(Remuneravel funcionario)
    {
        // saldo = funcionario.remuneracao();
        saldo += funcionario.remuneracao(); // Chama o método remuneracao() do objeto Remuneravel
        return saldo;
    }
}

