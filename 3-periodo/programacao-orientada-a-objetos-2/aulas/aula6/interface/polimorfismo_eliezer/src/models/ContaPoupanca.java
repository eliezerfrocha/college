package models;

public class ContaPoupanca implements Conta {
    public double saldo;

    public double depositar(double valor) {
        return this.saldo += valor;
    }
    public void sacar(double valor) {
        if (valor <= this.saldo) {
            this.saldo -= valor;
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public double getSaldo() {
        return this.saldo;
    }
}
