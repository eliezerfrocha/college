package models;

public interface Conta {
    double depositar(double valor);
    void sacar(double valor);
    double getSaldo();
}
