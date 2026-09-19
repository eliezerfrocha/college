package models;

public class GeradorExtrato {
    public String geradorConta() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.saldo = 1000.0;
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.saldo = 2000.0;
        contaCorrente.taxa = 5.0;
        System.out.println("Saldo da conta poupança: " + contaPoupanca.saldo);
        System.out.println("Saldo da conta corrente: " + contaCorrente.saldo);
        System.out.println("Taxa da conta corrente: " + contaCorrente.taxa);
        System.out.println("Saldo total: " + (contaPoupanca.saldo + contaCorrente.saldo - contaCorrente.taxa));
        return "Extrato gerado com sucesso!";
    }

    public String gerarExtrato() {
        ContaPoupanca contaPoupanca = new ContaPoupanca();
        contaPoupanca.saldo = 1000.0;
        ContaCorrente contaCorrente = new ContaCorrente();
        contaCorrente.saldo = 2000.0;
        contaCorrente.taxa = 5.0;

        StringBuilder extrato = new StringBuilder();
        extrato.append("=== EXTRATO DETALHADO ===\n");
        extrato.append("Conta Poupança - Saldo: R$ ").append(contaPoupanca.saldo).append("\n");
        extrato.append("Conta Corrente - Saldo: R$ ").append(contaCorrente.saldo).append("\n");
        extrato.append("Taxa aplicada por saque: R$ ").append(contaCorrente.taxa).append("\n");
        extrato.append("Saldo Total em Conta: R$ ").append(contaPoupanca.saldo + contaCorrente.saldo).append("\n");

        return extrato.toString();
    }
}
