package org.iftm.atividadea2;
public class Calculadora {
    private int memoria;

    public Calculadora() {
        this.memoria = 1;
    }

    public Calculadora(int memoria) {
        this.memoria = memoria;
    }

    public int getMemoria() {
        return this.memoria;
    }

    public void zerarMemoria() {
        this.memoria = 0;
    }

    public void somar(int valor) {
        this.memoria += valor;
    }

    public void subtrair(int valor) {
        this.memoria -= valor;
    }

    public void multiplicar(int valor) {
        this.memoria *= valor;
    }

    public void dividir(int valor) throws Exception {
        if (valor == 0) {
            throw new Exception("Divisão por zero!!!");
        }
        this.memoria = this.memoria / valor;
    }

    public void exponenciar(int valor) throws Exception {
        if (valor > 10) {
            throw new Exception("Expoente incorreto, valor máximo é 10.");
        }
        int resultado = this.memoria;
        for (int i = 1; i < valor; i++) {
            resultado *= this.memoria;
        }
        this.memoria = resultado;
    }
}