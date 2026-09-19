package models;

public class ContaCorrente implements Conta {
    public double saldo;
    public double taxa;

    public double depositar(double valor) {
        return this.saldo += valor;
    }
    public void sacar(double valor) {
        if (valor + taxa <= this.saldo) {
            this.saldo -= (valor + taxa);
        } else {
            System.out.println("Saldo insuficiente.");
        }
    }
    public double getSaldo() {
        return this.saldo;
    }
    public Object getTaxa() {
        return this.taxa;
    }
}
