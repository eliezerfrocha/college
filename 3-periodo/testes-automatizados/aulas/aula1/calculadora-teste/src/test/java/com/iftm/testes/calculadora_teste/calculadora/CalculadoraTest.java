package com.iftm.testes.calculadora_teste.calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {
    @Test
    public void testSomar() {
        // Arrange
        Calculadora calculadora = new Calculadora();
        int primeiroNumeroSoma = 2;
        int segundoNumeroSoma = 3;
        int resultadoEsperadoSoma = 5;
        int resultadoObtidoSoma = 0;
        // Act
        resultadoObtidoSoma = calculadora.somar(primeiroNumeroSoma, segundoNumeroSoma);
        // Assert
        Assertions.assertEquals(resultadoEsperadoSoma, resultadoObtidoSoma);
    }

    @Test
    public void testSubtrair() {
        // Arrange
        Calculadora calculadora = new Calculadora();       
        int primeiroNumeroSubtracao = 5;
        int segundoNumeroSubtracao = 3;
        int resultadoEsperadoSubtracao = 2;
        int resultadoObtidoSubtracao = 0;
        // Act
        resultadoObtidoSubtracao = calculadora.subtrair(primeiroNumeroSubtracao, segundoNumeroSubtracao);
        // Assert
        Assertions.assertEquals(resultadoEsperadoSubtracao, resultadoObtidoSubtracao);
    }

    @Test
    public void testMultiplicar() {
        // Arrange
        Calculadora calculadora = new Calculadora();
        int primeiroNumeroMultiplicacao = 2;
        int segundoNumeroMultiplicacao = 3;
        int resultadoEsperadoMultiplicacao = 6;
        int resultadoObtidoMultiplicacao = 0;
        // Act
        resultadoObtidoMultiplicacao = calculadora.multiplicar(primeiroNumeroMultiplicacao, segundoNumeroMultiplicacao);
        // Assert
        Assertions.assertEquals(resultadoEsperadoMultiplicacao, resultadoObtidoMultiplicacao);
    }

    @Test
    public void testDividir() {
        // Arrange
        Calculadora calculadora = new Calculadora();
        int primeiroNumeroDivisao = 6;
        int segundoNumeroDivisao = 3;
        int resultadoEsperadoDivisao = 2;
        int resultadoObtidoDivisao = 0;
        // Act
        resultadoObtidoDivisao = calculadora.dividir(primeiroNumeroDivisao, segundoNumeroDivisao);
        // Assert
        Assertions.assertEquals(resultadoEsperadoDivisao, resultadoObtidoDivisao);
    }
}
