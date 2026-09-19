import java.util.Scanner;

public class MultiplicationTable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        scanner.close();
        
        // Verifica se o número está dentro dos limites especificados
        if (N <= 1 || N >= 1000) {
            System.out.println("Número fora do intervalo permitido.");
            return;
        }
        
        // Imprime a tabela de multiplicação
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " x " + N + " = " + (i * N));
        }
        
        scanner.close();
    }
}
