package lists.list3.etapa1;

import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);

    public static boolean valida(double x1, double y1, double x2, double y2) {
        return x1 != x2 || y1 != y2;
    }

    public static double leCoordenada(int indice) {
        System.out.print("Digite a coordenada " + indice + ": ");
        return sc.nextDouble();
    }
    
    public static void main(String[] args) {
        double x1 = leCoordenada(1);
        double y1 = leCoordenada(2);
        double x2 = leCoordenada(3);
        double y2 = leCoordenada(4);

        if (valida(x1, y1, x2, y2)) {
            Retas reta = new Retas(x1, y1, x2, y2);
            System.out.println(reta.exibe());
        } else {
            System.out.println("Erro: Os pontos são iguais. A reta não pode ser criada.");
        }
    }
}
