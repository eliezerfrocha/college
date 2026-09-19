package org.iftm.atividadea2;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class CalculadoraTest {

    @Test
    public void testConstrutorSemParametro() {
        Calculadora calc = new Calculadora();
        assertEquals(1, calc.getMemoria());
    }

    @Test
    public void testConstrutorComParametroPositivo() {
        Calculadora calc = new Calculadora(3);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    public void testConstrutorComParametroNegativo() {
        Calculadora calc = new Calculadora(-3);
        assertEquals(-3, calc.getMemoria());
    }

    @Test
    public void testSomarNumeroPositivo() {
        Calculadora calc = new Calculadora(3);
        calc.somar(5);
        assertEquals(8, calc.getMemoria());
    }

    @Test
    public void testSomarNumeroNegativo() {
        Calculadora calc = new Calculadora(3);
        calc.somar(-2);
        assertEquals(1, calc.getMemoria());
    }

    @Test
    public void testSubtrairNumeroPositivo() {
        Calculadora calc = new Calculadora(3);
        calc.subtrair(2);
        assertEquals(1, calc.getMemoria());
    }

    @Test
    public void testSubtrairNumeroNegativo() {
        Calculadora calc = new Calculadora(3);
        calc.subtrair(-2);
        assertEquals(5, calc.getMemoria());
    }

    @Test
    public void testMultiplicarNumeroPositivo() {
        Calculadora calc = new Calculadora(3);
        calc.multiplicar(4);
        assertEquals(12, calc.getMemoria());
    }

    @Test
    public void testMultiplicarNumeroNegativo() {
        Calculadora calc = new Calculadora(3);
        calc.multiplicar(-2);
        assertEquals(-6, calc.getMemoria());
    }

    @Test
    public void testDividirPorZero() {
        Calculadora calc = new Calculadora(3);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.dividir(0);
        });
        assertEquals("Divisão por zero!!!", exception.getMessage());
    }

    @Test
    public void testDividirPorNumeroPositivo() throws Exception {
        Calculadora calc = new Calculadora(6);
        calc.dividir(2);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    public void testDividirPorNumeroNegativo() throws Exception {
        Calculadora calc = new Calculadora(6);
        calc.dividir(-2);
        assertEquals(-3, calc.getMemoria());
    }

    @Test
    public void testExponenciarPor1() throws Exception {
        Calculadora calc = new Calculadora(3);
        calc.exponenciar(1);
        assertEquals(3, calc.getMemoria());
    }

    @Test
    public void testExponenciarPor10() throws Exception {
        Calculadora calc = new Calculadora(2);
        calc.exponenciar(10);
        assertEquals(1024, calc.getMemoria());
    }

    @Test
    public void testExponenciarPorValorMaiorQue10() {
        Calculadora calc = new Calculadora(2);
        Exception exception = assertThrows(Exception.class, () -> {
            calc.exponenciar(11);
        });
        assertEquals("Expoente incorreto, valor máximo é 10.", exception.getMessage());
    }

    @Test
    public void testZerarMemoria() {
        Calculadora calc = new Calculadora(3);
        calc.zerarMemoria();
        assertEquals(0, calc.getMemoria());
    }
}
