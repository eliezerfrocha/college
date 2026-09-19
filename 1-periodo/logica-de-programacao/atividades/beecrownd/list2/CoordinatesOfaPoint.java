import java.util.Scanner;
/**
 * 1041 - CoordinatesOfaPoint
 *  Write an algorithm that reads two floating values (x and y), which should represent the coordinates of a 
    point in a plane. Next, determine which quadrant the point belongs, or if you are at one of the Cartesian 
    axes or the origin (x = y = 0).

            y
            | 
        Q2  |  Q1
     _______|_______ x
            |
        Q3  |  Q4
            |

    If the point is at the origin, write the message "Origem".
    If the point is at X axis write "Eixo X", else if the point is at Y axis write "Eixo Y".

    Input:
    The input contains the coordinates of a point.
    -
    Output:
    The output should display the quadrant in which the point is.
 */

public class CoordinatesOfaPoint {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double x = s.nextDouble();
        double y = s.nextDouble();

        s.close();

        if (x == 0 && y == 0) {
            System.out.println("Origem");
        } else if (x == 0) {
            System.out.println("Eixo Y");
        } else if (y == 0) {
            System.out.println("Eixo X");
        } else if (y > 0 && x > 0) {
            System.out.println("Q1");
        } else if (y > 0 && x < 0) {
            System.out.println("Q2");
        } else if (y < 0 && x < 0) {
            System.out.println("Q3");
        } else if (y < 0 && x > 0) {
            System.out.println("Q4");
        }
    }
}

//TESTS 
//0.0 0.0 -> Origem
//0.1 0.1 -> Q1
//2.0 -2.0 -> Q2
//-2.0 -2.0 -> Q3
//-4.5 2.2 -> Q4