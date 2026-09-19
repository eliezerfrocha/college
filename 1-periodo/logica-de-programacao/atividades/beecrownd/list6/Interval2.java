import java.util.Scanner;

public class Interval2 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();
        int in = 0, out = 0;
        int[] num = new int[size];

        for (int i = 0; i < size; i++) {
            num[i] = s.nextInt();
        }

        for (int j = 0; j < size; j++) {
            if (num[j] >= 10 && num[j] <= 20)
                in++;
            else
                out++;
        }

        System.out.println(in + " in");
        System.out.println(out + " out");

        s.close();
    }
}
