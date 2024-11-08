package lista01.Recursividade01;

import java.util.Scanner;

public class Fibonacci {
    static int numCalls;

    public static int fibonacci(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        // Lê o número de casos de teste
        int N = s.nextInt();
        // Para cada caso de teste
        for (int i = 0; i < N; i++) {
            int X = s.nextInt(); // Lê o valor de X
            numCalls = -1; // Inicializa o número de chamadas (-1 porque a primeira chamada não conta)
            int result = fibonacci(X); // Calcula o Fibonacci de X
            // Imprime a saída no formato solicitado
            System.out.println("fib(" + X + ") = " + numCalls + " calls = " + result);
        }
        s.close();
    }
}
