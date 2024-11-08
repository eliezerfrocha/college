import java.util.Scanner;
/**
 * 1035 - SelectionTest1
 *  Read 4 integer values A, B, C and D. Then if B is greater than C and D is greater than A and if the sum of C and D 
    is greater than the sum of A and B and if C and D were positives values and if A is even, write the 
    message “Valores aceitos” (Accepted values). Otherwise, write the message “Valores nao aceitos” (Values not accepted).

    Input:
    Four integer numbers A, B, C and D.
    -
    Output:
    Show the corresponding message after the validation of the values​​.
 */
public class SelectionTest1 {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();

        s.close();

        int sumCD = c + d;
        int sumAB = a + b;

        if (b > c && d > a && sumCD > sumAB && sumCD > 0 && c > 0 && d > 0 && a % 2 == 0) {
            System.out.println("Valores aceitos");
        } else {
            System.out.println("Valores nao aceitos");
        }

        System.out.println();
    } 
}