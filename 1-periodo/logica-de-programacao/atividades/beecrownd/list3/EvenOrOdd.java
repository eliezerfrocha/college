import java.util.Scanner;

public class EvenOrOdd {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt(); // Lê o número de casos

        for (int i = 0; i < N; i++) {
            int X = scanner.nextInt(); // Lê o valor de cada caso

            // Determina se o número é nulo
            if (X == 0) {
                System.out.println("NULL");
            } else {
                // Determina se o número é par ou ímpar
                String parity = (X % 2 == 0) ? "EVEN" : "ODD";
                // Determina se o número é positivo ou negativo
                String sign = (X > 0) ? "POSITIVE" : "NEGATIVE";
                
                System.out.println(parity + " " + sign);
            }
        }

        scanner.close();
    }
}
