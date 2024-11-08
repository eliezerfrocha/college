import java.util.Scanner;
/**
 * 1013 - The Greatest
 *  Make a program that reads 3 integer values and present the greatest one followed by the message "eh o maior". 
    Use the following formula: MaiorAB = (a + b + abs * (a - b)) / 2

    Input:
    The input file contains 3 integer values.
    -
    Output:
    Print the greatest of these three values followed by a space and the message “eh o maior”.
 */
public class TheGreatest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int res = 0; // global response 
        
        int valor1 = s.nextInt();
        int valor2 = s.nextInt();
        int valor3 = s.nextInt();   
        s.close();
        
        if (valor1 > valor2 && valor1 > valor3) {
            res = valor1;         
        } else if (valor2 > valor3) {
            res = valor2;
        } else {
            res = valor3;
        }

        System.out.println(res + " EH O MAIOR");
    }
}
