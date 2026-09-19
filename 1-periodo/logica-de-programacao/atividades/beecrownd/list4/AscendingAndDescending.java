import java.util.Scanner;

public class AscendingAndDescending {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ler os valores de X e Y
            int X = scanner.nextInt();
            int Y = scanner.nextInt();

            // Verificar se os valores são iguais e parar o loop se for
            if (X == Y) {
                break;
            }

            // Determinar se estão em ordem crescente ou decrescente
            if (X < Y) {
                System.out.println("Crescente");
            } else {
                System.out.println("Decrescente");
            }
        }

        scanner.close();
    }
}
