package ocp.principle.solucao;

public class OcpPrinciple {

    public static void main(String[] args) {

        // 1) Ler dados de assaliariados e estagiarios (nome, tipo, remuneração)
        // exibir a folha de pagamento com o total pago aos funcionários
        Remuneravel assalariado = new ContratoCLT(3000.00);
        Remuneravel estagiario = new ContratoEstagio(1500.00);  

        FolhaPagamento folhaPagamento = new FolhaPagamento();
        folhaPagamento.calcular(assalariado);
        folhaPagamento.calcular(estagiario);

        System.out.println("Total pago aos funcionários: " + folhaPagamento.saldo);
    }
}
