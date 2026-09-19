import java.util.Scanner;
/**
 * 1011 - Sphere
 *  Make a program that calculates and shows the volume of a sphere being provided the value of its radius (R). 
    The formula to calculate the volume is: (4/3) * pi * R3. Consider (assign) for pi the value 3.14159.

    Tip: Use (4/3.0) or (4.0/3) in your formula, because some languages (including C++) assume that the division's 
    result between two integers is another integer. :)

    Input:
    The input contains a value of floating point (double precision).
    -
    Output:
T   he output must be a message "VOLUME" like the following example with a space before and after the equal signal. The value must be presented with 3 digits after the decimal point.
 */
public class Sphere {
    public static Double pi = 3.14159;
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double raio = s.nextDouble();    
        s.close();

        double volume = (4.0 / 3) * pi * Math.pow(raio, 3.0);      
        System.out.println(String.format("VOLUME = %.3f", volume));
    }
}
