import java.util.Scanner;
/**
 * 1017 - Interval
 *  You must make a program that read a float-point number and print a message saying in which of 
    following intervals the number belongs: [0,25] (25,50], (50,75], (75,100]. If the read number is 
    less than zero or greather than 100, the program must print the message “Fora de intervalo” 
    that means "Out of Interval".

    The symbol '(' represents greather than. For example:
    [0,25] indicates numbers between 0 and 25.0000, including both.
    (25,50] indicates numbers greather than 25 (25.00001) up to 50.0000000.

    Input:
    The input file contains a floating-point number.
    -
    Output:
    The output must be a message like following example.
    Entradas: 25.01, 25.00, 100.00, -25.02
 */
public class Interval {
    public static void main(String[] args) {
        System.out.println();

        Scanner s = new Scanner(System.in);
        float N = s.nextFloat();

        s.close();

        if (N > 25.0 && N <= 50.0) {
            System.out.println("Intervalo (25,50]");
        } else if (N >= 0 && N <= 25.0) {
            System.out.println("Intervalo [0,25]");
        } else if (N > 75.0 && N <= 100.0) {
            System.out.println("Intervalo (75,100]");
        } else {
            System.out.println("Fora de intervalo");
        }

        System.out.println();
    }
}
