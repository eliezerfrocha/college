import java.util.Scanner;

public class EvenSquare {
    public class Main {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int N = scanner.nextInt();
    
            for (int i = 2; i <= N; i += 2) {
                int square = i * i;
                System.out.printf("%d^2 = %d%n", i, square);
            }
    
            scanner.close();
        }
    }
}
