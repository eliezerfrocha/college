import java.util.Scanner;
import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Lendo os três valores inteiros
        int[] valores = new int[3];
        for (int i = 0; i < 3; i++) {
            valores[i] = scanner.nextInt();
        }

        // Salvando a ordem original
        int[] original = Arrays.copyOf(valores, valores.length);

        // Ordenando os valores
        Arrays.sort(valores);

        // Imprimindo os valores em ordem crescente
        for (int valor : valores) {
            System.out.println(valor);
        }

        // Imprimindo uma linha em branco
        System.out.println();

        // Imprimindo os valores na sequência original
        for (int valor : original) {
            System.out.println(valor);
        }

        scanner.close();
    }
}