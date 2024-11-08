import java.util.Scanner;

public class Quadrant {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ler as coordenadas X e Y
            int X = scanner.nextInt();
            int Y = scanner.nextInt();

            // Verificar se pelo menos uma das coordenadas é zero e parar o loop se for
            if (X == 0 || Y == 0) {
                break;
            }

            // Determinar o quadrante ao qual o ponto pertence
            if (X > 0 && Y > 0) {
                System.out.println("primeiro");
            } else if (X < 0 && Y > 0) {
                System.out.println("segundo");
            } else if (X < 0 && Y < 0) {
                System.out.println("terceiro");
            } else if (X > 0 && Y < 0) {
                System.out.println("quarto");
            }
        }

        scanner.close();
    }
}
