import java.util.Scanner;
/**
 * ConverterMedidas
 */
public class ConverterMedidas {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);
	    
		int input = s.nextInt();
		System.out.printf("%d metros\n", input);

        s.close();

        int c = input*100;
        System.out.printf("%d centímetros\n", c);

        int m = input*1000;
        System.out.printf("%d milímetros\n", m);

        double k = input/1000.00;
        System.out.printf("%.4f quilômetros\n", k);

        double miles = input/1609.00;
        System.out.printf("%.4f milhas\n", miles);

        System.out.println();
    }
}