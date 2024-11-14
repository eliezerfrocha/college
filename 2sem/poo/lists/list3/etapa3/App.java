package lists.list3.etapa3;
import java.util.Scanner;

public class App {
    static Scanner sc = new Scanner(System.in);
    
    public static double leCoordenada(int indice) {
        System.out.print("Digite a coordenada " + indice + ": ");
        return sc.nextDouble();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char opcao;

        do {
            double x1 = leCoordenada(1);
            double y1 = leCoordenada(2);
            double x2 = leCoordenada(3);
            double y2 = leCoordenada(4);

            // Verifica se as coordenadas são válidas e estão no primeiro quadrante
            if (Validacao.valida(x1, y1, x2, y2) && Validacao.isQuadOne(x1, y1, x2, y2)) {
                Retas reta = new Retas(x1, y1, x2, y2);
                System.out.println(reta.exibe());
            } else {
                System.out.println("Erro: As coordenadas devem ser distintas e estar no primeiro quadrante.");
            }

            System.out.print("Deseja repetir? (S/N): ");
            opcao = scanner.next().toUpperCase().charAt(0);
        } while (opcao == 'S');

        scanner.close();
    }
}
