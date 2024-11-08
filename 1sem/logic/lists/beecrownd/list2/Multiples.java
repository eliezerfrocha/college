import java.util.Scanner;
/*
 * 1044 - Multiples
 *  Read two integer values (A and B). After, the program should print the message "Sao Multiplos" (are multiples) 
    or "Nao sao Multiplos" (aren’t multiples), corresponding to the read values.

    Input:
    The input has two integer numbers.
    -
    Output:
    Print the relative message to the input as stated above. 
 */
public class Multiples {
    public static void main(String[] args) {
        System.out.println();
        
        Scanner s = new Scanner(System.in);
        
        int a = s.nextInt();
        int b = s.nextInt();

        s.close();
        
        if (a % b == 0 || b % a == 0) {
            System.out.println("Sao Multiplos");
        } else {
            System.out.println("Nao sao Multiplos");
        }
        
        System.out.println();     
    }
}
