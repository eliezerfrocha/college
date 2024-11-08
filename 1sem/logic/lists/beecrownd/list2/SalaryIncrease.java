import java.util.Scanner;
/**
 * 1048 - SalaryIncrease
 *  The company ABC decided to give a salary increase to its employees, according to the following table:
    
    -----------------------------------
    Salary	 |  Readjustment   |  Rate
    -----------------------------------
    0        |   400.00       |   15%
    400.01   |   800.00       |   12%
    800.01   |   1200.00      |   10%
    1200.01  |   2000.00      |   7%
    Above    |   2000.00      |   4%
    -----------------------------------

    Read the employee's salary, calculate and print the new employee's salary,
    as well the money earned and the increase percentual obtained by the employee, 
    with corresponding messages in Portuguese, as the below example.
    
    Input:
    The input contains only a floating-point number, with 2 digits after the decimal point.
    -
    Output:
    Print 3 messages followed by the corresponding numbers (see example) informing the new salary, 
    the among of money earned (both must be shown with 2 decimal places) and the percentual obtained 
    by the employee. 
    
    Note:
    
    Novo salario:  means "New Salary"
    Reajuste ganho: means "Money earned"
    Em percentual: means "In percentage"
 */
public class SalaryIncrease {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        double percent = 0;
        double newSalary = 0, increase = 0;
        double salary = s.nextDouble();

        s.close();

        if (salary >= 0 && salary <= 400) {
            percent = 15;
            increase = salary * (percent / 100);
            newSalary = salary + increase;
        } else if (salary >= 400.01 && salary <= 800.00) {
            percent = 12;
            increase = salary * (percent / 100);
            newSalary = salary + increase;
        } else if (salary >= 800.01 && salary <= 1200.00) {
            percent = 10;
            increase = salary * (percent / 100);
            newSalary = salary + increase;
        } else if (salary >= 1200.01 && salary <= 2000.00) {
            percent = 7;
            increase = salary * (percent / 100); 
            newSalary = salary + increase;
        } else if (salary > 2000.00) {
            percent = 4;
            increase = salary * (percent / 100);
            newSalary = salary + increase;
        }

        System.out.printf("Novo salario: %.2f\n", newSalary);
        System.out.printf("Reajuste ganho: %.2f\n", increase);
        System.out.printf("Em percentual: %.0f %%\n", percent);

        System.out.println();
    }
}

// 15%
// 12%
// 10%
// 7%
// 4%