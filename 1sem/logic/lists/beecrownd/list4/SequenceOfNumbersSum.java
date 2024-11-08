import java.util.Scanner;

public class SequenceOfNumbersSum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ler os valores de M e N
            int M = scanner.nextInt();
            int N = scanner.nextInt();

            // Parar se qualquer valor for menor ou igual a zero
            if (M <= 0 || N <= 0) {
                break;
            }

            // Determinar o menor e o maior valor entre M e N
            int min = Math.min(M, N);
            int max = Math.max(M, N);

            // Inicializar a soma
            int sum = 0;

            // Imprimir a sequência e calcular a soma
            for (int i = min; i <= max; i++) {
                System.out.print(i + " ");
                sum += i;
            }

            // Imprimir a soma
            System.out.println("Sum=" + sum);
        }

        scanner.close();
    }
}
