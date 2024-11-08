import java.text.DecimalFormat;
import java.util.Scanner;

public class ERW09SomaDeNumerosReais {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        boolean condition = true;
        double soma = 0;
        int qtd = 0;

        while (condition) {
            double n = s.nextDouble();

            if (n > 0) {
                soma += n;
                qtd++;
            }

            if (n < 0)
                condition = false;
        }

        var formatador = new DecimalFormat("#0.00");
        System.out.println("Soma = " + formatador.format(soma));
        System.out.println("Quantidade = " + qtd);

        s.close();
    }
}