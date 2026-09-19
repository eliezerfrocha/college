import java.util.Scanner;
/**
 * 1008 - Salary
 *  Write a program that reads an employee's number, his/her worked hours number in a month and the amount 
    he received per hour. Print the employee's number and salary that he/she will receive at end of the month, 
    with two decimal places.

    Don’t forget to print the line's end after the result, otherwise you will receive “Presentation Error”.
    Don’t forget the space before and after the equal signal and after the U$.

    Input:
    The input file contains 2 integer numbers and 1 value of floating point, representing the number, 
    worked hours amount and the amount the employee receives per worked hour.
    -
    Output:
    Print the number and the employee's salary, according to the given example, with a blank space before 
    and after the equal signal.
 */
public class Salary {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int funcionarios = s.nextInt();
        int horas = s.nextInt();       
        double valorPorHora = s.nextDouble();
        s.close();

        double salario = horas * valorPorHora;
        
        System.out.println("NUMBER = " + funcionarios);
        System.out.println(String.format("SALARY = U$ %.2f" , salario));
    }   
}
