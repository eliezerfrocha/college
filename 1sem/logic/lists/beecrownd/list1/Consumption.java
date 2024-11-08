import java.util.Scanner;
/**
 * 1014 - Consumption
 *  Calculate a car's average consumption being provided the total distance traveled 
    (in Km) and the spent fuel total (in liters).

    Input:
    The input file contains two values: one integer value X representing the total distance (in Km) 
    and the second one is a floating point number Y  representing the spent fuel total, with a digit 
    after the decimal point.
    -
    Output:
    Present a value that represents the average consumption of a car with 3 digits after the decimal point, 
    followed by the message "km/l".
 */
public class Consumption {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int x = s.nextInt();
        double y = s.nextDouble();
        s.close();

        double media = x / y;
        
        System.out.println(String.format("%.3f km/l", media)); 
    }
}
