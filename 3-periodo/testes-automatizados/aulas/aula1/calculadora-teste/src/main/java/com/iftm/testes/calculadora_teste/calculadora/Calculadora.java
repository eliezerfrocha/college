package com.iftm.testes.calculadora_teste.calculadora;

public class Calculadora {
    public int somar(int num1, int num2) {
        if (num1 < 0 || num1 > 100 
            || num2 < 0 || num2 > 100)
            return -1;
        return num1 + num2;
    }

    public int subtrair(int num1, int num2) {
        return num1 - num2;
    }

    public int multiplicar(int num1, int num2) {
        return num1 * num2;
    }

    public int dividir(int num1, int num2) {
        if (num1 == 0 || num2 == 0)
            return -1;
        return num1/num2;
    }
}