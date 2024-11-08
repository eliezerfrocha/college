import java.util.Scanner;

public class VET01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();

        int[] arr1 = new int[N];
        int[] arr2 = new int[N];

        for (int i = 0; i < N; i++) {
            arr1[i] = s.nextInt();
        }

        for (int i = 0; i < N; i++) {
            arr2[i] = s.nextInt();
        }

        int[] M = new int[N];
        for (int i = 0; i < N; i++) {
            M[i] = arr1[i] * arr2[i];
        }

        System.out.print("{");

        for (int i = 0; i < N; i++) {
            System.out.print(M[i]);
            if (i < N - 1) 
                System.out.print(",");
        }

        System.out.println("}");
    }
}