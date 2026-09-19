package ex2;
import java.util.Scanner;

public class EquacaoSegundoGrau {
    static Scanner s = new Scanner(System.in);

    public static double le() {
        System.out.print("> Digite um valor: ");
        return s.nextDouble();
    }

    public static void Exibe(String name, double result) {
        System.out.println(name + result);
    }

    public static boolean Condicao(int response) {
        if (response == 1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        boolean condition = true;
        
        do {
            double a, b, c, delta, x1, x2;
            // Leitura
            a = le();
            b = le();
            c = le();
            // Enstanciamento EGrau2
            EGrau2 eGrau2 = new EGrau2(a, b, c);
            // Calculo delta
            // delta = eGrau2.CalculaDelta(a, b, c);
            delta = eGrau2.CalculaDelta();

            if (delta >= 0) {
                Exibe("\n> delta = ", delta);
                // Calculo x1
                x1 = eGrau2.CalculaX1(delta);
                Exibe("> x1 = ", x1);
                // Calculo x2
                x2 = eGrau2.CalculaX2(delta);
                Exibe("> x2 = ", x2);
            } else {
                System.out.println("\n> Alerta! A equação não possui raizes reais.");
            }
            // Validação final
            System.out.println("\n> Deseja efetuar outra equação? (1 = sim / 2 = não)");
            int response = s.nextInt();
            condition = Condicao(response);

        } while (condition);
        System.out.println("\n> Até logo!! 0/");
        s.close();
    }
}
