import models.ContaCorrente;
import models.ContaPoupanca;
import models.GeradorExtrato;

public class App {
    public static void main(String[] args) {
        // ContaPoupanca contaPoupanca = new ContaPoupanca();
        // contaPoupanca.depositar(1000.0);
        // System.out.println("Saldo da conta poupança: " + contaPoupanca.getSaldo());

        // ContaCorrente contaCorrente = new ContaCorrente();
        // contaCorrente.depositar(2000.0);
        // contaCorrente.sacar(100.0); // Sacando 100.0 + taxa de 5.0
        // System.out.println("Saldo da conta corrente: " + contaCorrente.getSaldo());
        // contaCorrente.sacar(2000.0); // Tentando sacar mais do que o saldo disponível

        // System.out.println("Saldo da conta corrente após tentativa de saque: " +
        // contaCorrente.getSaldo());
        // System.out.println("Taxa da conta corrente: " + contaCorrente.taxa);
        // System.out.println("Saldo total: " + (contaPoupanca.getSaldo() +
        // contaCorrente.getSaldo() - contaCorrente.taxa));
        // // Gerador de extrato

        // GeradorExtrato geradorExtrato = new GeradorExtrato();
        // String resultado = geradorExtrato.geradorConta();

        // System.out.println(resultado);

        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.depositar(1000.0);

        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.depositar(2000.0);
        contaCorrente.sacar(100.0); // Saque de 100.0 + taxa de 5.0
        contaCorrente.sacar(2000.0); // Tentativa de saque com saldo insuficiente

        // Apresentação de dados
        System.out.println("=== RESUMO DAS CONTAS ===");
        System.out.printf("Conta Poupança - Saldo: R$ %.2f\n", contaPoupanca.getSaldo());
        System.out.printf("Conta Corrente - Saldo: R$ %.2f\n", contaCorrente.getSaldo());
        System.out.printf("Conta Corrente - Taxa aplicada por saque: R$ %.2f\n", contaCorrente.getTaxa());

        double saldoTotal = contaPoupanca.getSaldo() + contaCorrente.getSaldo();
        System.out.printf("Saldo Total em Conta: R$ %.2f\n", saldoTotal);

        // Geração de extrato
        GeradorExtrato geradorExtrato = new GeradorExtrato();
        String extrato = geradorExtrato.gerarExtrato();

        System.out.println("\n=== EXTRATO DETALHADO ===");
        System.out.println(extrato);

    }
}
