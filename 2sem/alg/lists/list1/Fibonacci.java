import java.util.Scanner;

public class Fibonacci {
    static int callCount;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt(); // Número de casos de teste

        for (int i = 0; i < N; i++) {
            int X = sc.nextInt(); // Valor de X para o qual queremos calcular Fibonacci
            callCount = 0; // Reseta o contador para cada novo caso de teste
            int result = fibonacci(X);
            // Imprime o resultado no formato solicitado
            System.out.println("fib(" + X + ") = " + (callCount - 1) + " calls = " + result);
        }

        sc.close();
    }

    // Função Fibonacci recursiva que conta o número de chamadas
    public static int fibonacci(int n) {
        callCount++; // Conta a chamada da função
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
