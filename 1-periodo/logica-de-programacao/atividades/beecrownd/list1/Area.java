import java.util.Scanner;
/**
 * 1012 - Area
 *  Make a program that reads three floating point values: A, B and C. Then, calculate and show:
    
    a) the area of the rectangled triangle that has base A and height C.
    b) the area of the radius's circle C. (pi = 3.14159)
    c) the area of the trapezium which has A and B by base, and C by height.
    d) the area of ​​the square that has side B.
    e) the area of the rectangle that has sides A and B.

    Input:
    The input file contains three double values with one digit after the decimal point.
    -
    Output:
    The output file must contain 5 lines of data. Each line corresponds to one of the areas described above, 
    always with a corresponding message (in Portuguese) and one space between the two points and the value. 
    The value calculated must be presented with 3 digits after the decimal point.
 */
public class Area {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        double a = s.nextDouble();
        double b = s.nextDouble();
        double c = s.nextDouble();
        s.close();

        double triangulo = a * c / 2.0;
        double circulo = 3.14159 * (c * c);
        double trapezio = ((a + b) * c) / 2;
        double quadrado = b * b;
        double retangulo = a * b;

        System.out.println(String.format("TRIANGULO: %.3f", triangulo));
        System.out.println(String.format("CIRCULO: %.3f", circulo));
        System.out.println(String.format("TRAPEZIO: %.3f", trapezio));
        System.out.println(String.format("QUADRADO: %.3f", quadrado));
        System.out.println(String.format("RETANGULO: %.3f", retangulo)); 
    }
}
