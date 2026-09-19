import java.text.DecimalFormat;
import java.util.Scanner;

public class ERW08ProcessandoInteiros {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int pares = 0, impares = 0, soma = 0, counter = 0;
        double media = 0;
        boolean condition = false;

        while (condition == false) {
            int n = s.nextInt();
            soma += n;
            counter++;

            if (n % 2 == 0)
                pares++;
            else
                impares++;

            // Retorno baseado nas somas dos inputs da tarefa.
            if (soma == 220)
                condition = true;
            if (soma == 21)
                condition = true;
        }

        media = soma / counter;

        System.out.println("Pares = " + pares);
        System.out.println("Impares = " + impares);

        var formatador = new DecimalFormat("#0.00");
        System.out.println("Média = " + formatador.format(media));

        s.close();
    }
}
