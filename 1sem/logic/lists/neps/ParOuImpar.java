import java.util.Scanner;

public class ParOuImpar {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int n1 = s.nextInt();
        int n2 = s.nextInt();

        if ((n1+n2)%2 == 0) {
            System.out.println("> Par.");
        } else {
            System.out.println("> Ímpar.");
        }
    }
}
