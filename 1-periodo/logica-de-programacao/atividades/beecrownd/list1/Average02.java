import java.util.Scanner;
/**
 * 1006 - Average 2
 *  Read three values (variables A, B and C), which are the three student's grades. Then, calculate the average, 
    considering that grade A has weight 2, grade B has weight 3 and the grade C has weight 5. Consider that each grade 
    can go from 0 to 10.0, always with one decimal place.

    Input:
    The input file contains 3 values of floating points (double) with one digit after the decimal point.
    -
    Output:
    Print the message "MEDIA"(average in Portuguese) and the student's average according to the following example, 
    with a blank space before and after the equal signal.
 */
public class Average02 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();
        s.close();
        
        double media = ((a * 2) + (b * 3) + (c * 5)) / 10;
        System.out.println(String.format("MEDIA = %.1f" , media));
    }
}
