import java.util.Scanner;

public class VET03 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] vetor = new int[n];

        for (int i = 0; i < n; i++) { vetor[i] = s.nextInt(); }

        int count = 0;
        for (int i = 0; i < n; i++) {
            if (vetor[i] % 2 == 0) count++;
        }

        System.out.println(count);
        boolean primeiro = true;
        System.out.print("{");

        for (int i = 0; i < n; i++) {
            if (vetor[i] % 2 == 0) {
                if (!primeiro) { System.out.print(";"); }
                System.out.print(vetor[i]);
                primeiro = false;
            }
        }

        System.out.println("}");
    }
}
