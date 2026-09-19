/**
 * beecrowd | 5213
REC05 - Implemente a função recursiva
By BRUNO QUEIROZ PINTO,   Brazil
Timelimit: 1
Implemente uma função recursiva para a seguinte especificação:

Faça um programa em Java que utilize a função recursiva criada.
obs.: a solução obrigatoriamente precisa ser recursiva.

Entrada
Dois valores inteiros m e n.

Saída
Imprimir o resultado conforme exemplo disponibilizado na tabela abaixo.
Samples Input	Samples Output
2
2
h(2,2) = 6
8
9
h(8,9) = 24310 
*/

import java.util.Scanner;

public class REC05ImplementeAfuncaoRecursiva {
    public static int h(int m, int n) {
        if (m == 0 || n == 0)
            return 1;
        else
            return h(m - 1, n) + h(m, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int resultado = h(m, n);
        System.out.println("h(" + m + "," + n + ") = " + resultado);
        sc.close();
    }
}
