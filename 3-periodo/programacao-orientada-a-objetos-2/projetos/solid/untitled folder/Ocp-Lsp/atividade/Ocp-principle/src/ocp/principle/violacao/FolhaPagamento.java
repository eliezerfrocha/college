package ocp.principle.violacao;

public class FolhaPagamento {
 
    protected double saldo;
    
    public double calcular(Funcionario funcionario)
    {
       /* Se ( funcionario = assalariado  )
              saldo += Pagamento.salario();
          senão se ( funcionario = estagiario) {
                   saldo += Pagamento.bolsaAuxilio();
       */
        if (funcionario.getTipo().equals("assalariado")) {
            saldo += Pagamento.salario(); // Pagamento.salario();
        } else {
            saldo += Pagamento.bolsaAuxilio(); // Pagamento.bolsaAuxilio();
        } 
        return saldo;
    }
}


