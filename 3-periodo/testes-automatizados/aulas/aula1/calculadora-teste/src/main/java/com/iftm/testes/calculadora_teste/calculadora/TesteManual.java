package com.iftm.testes.calculadora_teste.calculadora;

public class TesteManual {
    public static void main(String[] args) {
        // ========== Arrange ==========  
        // -> Instanciar a classe
        Calculadora calculadora = new Calculadora();
        
        // -> Definir o cenário de teste e dados de entrada
        int primeiroNumeroSoma = 2;
        int segundoNumeroSoma = 3;
        int resultadoEsperadoSoma = 5;
        int resultadoObtidoSoma = 0;

        // ========== Act ==========
        try {
            resultadoObtidoSoma = calculadora.somar(primeiroNumeroSoma, segundoNumeroSoma);
        } catch (Exception e) {
            e.printStackTrace();
            resultadoObtidoSoma = 0; // Valor padrão em caso de exceção
        }
        
        // ========== Assert ==========
        System.out.println("Resultado esperado: " + resultadoEsperadoSoma);
        System.out.println("Resultado obtido: " + resultadoObtidoSoma);
        if (resultadoEsperadoSoma == resultadoObtidoSoma) {
            System.out.println("Teste OK");
        } else {
            System.out.println("Teste NOK");
        }
    }
}
