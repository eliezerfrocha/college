import java.util.Scanner;

public class PopulationIncrease {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();

        for (int i = 0; i < T; i++) {
            int PA = scanner.nextInt();
            int PB = scanner.nextInt();
            double G1 = scanner.nextDouble();
            double G2 = scanner.nextDouble();

            int anos = 0;

            while (PA <= PB && anos <= 100) {
                PA += (int)(PA * (G1 / 100));
                PB += (int)(PB * (G2 / 100));
                anos++;
            }

            if (anos > 100) {
                System.out.println("Mais de 1 seculo.");
            } else {
                System.out.println(anos + " anos.");
            }
        }
        scanner.close();
    }
}