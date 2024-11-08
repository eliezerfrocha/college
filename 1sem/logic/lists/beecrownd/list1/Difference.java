import java.util.Scanner;
/**
 * 1007 - Difference
 *  Read four integer values named A, B, C and D. Calculate and print the difference of product A and B by 
    the product of C and D (A * B - C * D).

    Input:
    The input file contains 4 integer values.
    -
    Output:
    Print DIFERENCA (DIFFERENCE in Portuguese) with all the capital letters, according to the following example, 
    with a blank space before and after the equal signal.
 */
public class Difference {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();
        int b = s.nextInt();
        int c = s.nextInt();
        int d = s.nextInt();
        s.close();
        
        int diferenca = a * b - c * d;
        System.out.println("DIFERENCA = " + diferenca);
    }
}
