package ocp.principle.violacao;

public class OcpPrinciple {

    public static void main(String[] args) {

        // 1) Ler dados de assaliariados e estagiarios (nome, tipo, remuneração)
        // exibir a folha de pagamento com o total pago aos funcionários
        Funcionario assalariado = new Funcionario("João", "assalariado", 3000.00);
        Funcionario estagiario = new Funcionario("Maria", "estagiario", 1500.00);
        
        FolhaPagamento folhaPagamento = new FolhaPagamento();

        Pagamento.setBolsaAuxilio(3000.00);
        Pagamento.setSalario(1500.00);

        //double totalPago = folhaPagamento.calcular(assalariado) + folhaPagamento.calcular(estagiario);
        
        folhaPagamento.calcular(assalariado);
        // folhaPagamento.calcular(estagiario);

        System.out.println("Total pago aos funcionários: " + folhaPagamento.calcular(estagiario));
    }
    
}
