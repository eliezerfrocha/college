import java.util.Scanner;

public class SumofConsecutiveOddNumbers1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int x = s.nextInt();
        int y = s.nextInt();

        s.close();

        int inicio = x;
        int fim = y;

        if (x > y) {
            fim = x;
            inicio = y;
        }

        int sum = 0;

        for (int i = inicio + 1; i < fim; i++) {
            if (i % 2 != 0)
                sum += i;
        }

        System.err.println(sum);
    }
}
