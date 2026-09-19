/**
 * REC04SomaDeImpares
 * 
 * beecrowd | 5211
 * REC04 - SOMA DE IMPARES
 * By BRUNO QUEIROZ PINTO, Brazil
 * Timelimit: 1
 * Escreva uma função recursiva que retorne o somatório dos números impares de 1
 * até N. O valor de N será um valor entre 1 e 10000.
 * 
 * Faça um programa em Java que utilize a função recursiva criada.
 * 
 * obs.: a solução obrigatoriamente precisa ser recursiva.
 * 
 * 
 * Entrada
 * Um número inteiro N que indica a quantidade de números a serem analisados.
 * 
 * Saída
 * Imprimir os números impares conforme exemplo dado na tabela abaixo.
 */
import java.util.Scanner;

public class REC04SomaDeImpares {
    public static int somaImpares(int n) {
        if (n == 1)
            return 1;
        else if (n % 2 == 0)
            return somaImpares(n - 1);
        else
            return n + somaImpares(n - 2);
    }

    public static String montaExpressao(int n) {
        if (n == 1)
            return "1";
        else if (n % 2 == 0)
            return montaExpressao(n - 1);
        else
            return montaExpressao(n - 2) + " + " + n;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String expressao = montaExpressao(n);
        int soma = somaImpares(n);
        System.out.println(expressao + " = " + soma);
        sc.close();
    }
}