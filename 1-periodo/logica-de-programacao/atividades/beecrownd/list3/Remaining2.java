import java.util.Scanner;

public class Remaining2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        // Loop para encontrar e imprimir os números que deixam resto 2 quando divididos por N
        for (int i = 2; i <= 10000; i += N) {
            if (i % N == 2) {
                System.out.println(i);
            }
        }

        scanner.close();
    }
}
