import java.util.Scanner;

public class VET02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }

        int x = s.nextInt();
        for (int i = 0; i < n; i += x) {
            System.out.println("Pos[" + i + "] = " + arr[i]);
        }
    }
}
