import java.util.Scanner;

/**
 * 1050 - DDD
 * Read an integer number that is the code number for phone dialing. Then, print
 * the destination according
 * to the following table:
 * 
 * | DDD | Destination |
 * | 61 | Brasilia |
 * | 71 | Salvador |
 * | 11 | Sao Paulo |
 * | 21 | Rio de Janeiro |
 * | 32 | Juiz de Fora |
 * | 19 | Campinas |
 * | 27 | Vitoria |
 * | 31 | Belo Horizonte |
 * 
 * If the input number isn’t found in the above table, the output must be:
 * DDD nao cadastrado
 * That means “DDD not found” in Portuguese language.
 * 
 * Input:
 * The input consists in a unique integer number.
 * -
 * Output:
 * Print the city name corresponding to the input DDD. Print DDD nao cadastrado
 * if doesn't exist corresponding DDD to the typed number.
 */
public class DDD {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        int ddd = s.nextInt();
        String response = "";

        s.close();

        switch (ddd) {
            case 61:
                response = "Brasilia";
                break;
            case 71:
                response = "Salvador";
                break;
            case 11:
                response = "Sao Paulo";
                break;
            case 21:
                response = "Rio de Janeiro";
                break;
            case 32:
                response = "Juiz de Fora";
                break;
            case 19:
                response = "Campinas";
                break;
            case 27:
                response = "Vitoria";
                break;
            case 31:
                response = "Belo Horizonte";
                break;
            default: 
                response = "Insira um DDD válido.";
                break;
        }

        System.out.println(response);
        System.out.println();
    }
}
