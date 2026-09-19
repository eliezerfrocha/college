import java.util.Scanner;

public class SixOddNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        int x = sc.nextInt();

        while (count < 6) {
            if (x % 2 != 0) {
                System.out.println(x);
                count++;
            }
            x++;
        }
        sc.close();
    }
}
