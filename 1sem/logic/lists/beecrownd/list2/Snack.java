import java.util.Scanner;
/**
 * 1038 - SelectionTest1
 *  Using the following table, write a program that reads a code and the amount of an item. 
    After, print the value to pay. This is a very simple program with the only 
    intention of practice of selection commands.

    CODE    -   SPECIFICATION     -    PRICE
    1       -   Cachorro Quente   -  R$ 4.00
    2       -   X-Salada          -  R$ 4.50
    3       -   X-Bacon           -  R$ 5.00
    4       -   Torrada simples   -  R$ 2.00
    5       -   Refrigerante      -  R$ 1.50

    Input:
    The input file contains two integer numbers X and Y. X is the product code and Y is the quantity of this item according to the above table.
    -
    Output:
    The output must be a message "Total: R$ " followed by the total value to be paid, with 2 digits after the decimal point.
 */
public class Snack {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);
        
        int cod = s.nextInt();
        double qtd = s.nextDouble();

        s.close();
        
        double total = 0;

        if (cod == 1) {
            total = 4.00 * qtd;
        } else if (cod == 2) {
            total = 4.50 * qtd;
        } else if (cod == 3) {
            total = 5.00 * qtd;
        } else if (cod == 4) {
            total = 2.00 * qtd;
        } else if (cod == 5) {
            total = 1.50 * qtd;
        }

        System.out.printf("Total: R$ %.2f\n", total);
        System.out.println();
    }
}
