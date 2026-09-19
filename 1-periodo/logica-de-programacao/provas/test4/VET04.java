import java.util.Scanner;

public class VET04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) { arr[i] = s.nextInt(); }

        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < 0) System.out.println(arr[i]);
        }
    }
}