import java.util.Scanner;

public class Interval2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ler o número de casos de teste
        int N = scanner.nextInt();
        
        // Inicializar contadores
        int inCount = 0;
        int outCount = 0;

        // Loop para ler os N números inteiros e contar os que estão dentro e fora do intervalo
        for (int i = 0; i < N; i++) {
            int X = scanner.nextInt();
            if (X >= 10 && X <= 20) {
                inCount++;
            } else {
                outCount++;
            }
        }

        // Imprimir o resultado
        System.out.println(inCount + " IN");
        System.out.println(outCount + " OUT");
        // Fechar o scanner
        scanner.close();
    }
}
