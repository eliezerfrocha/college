import java.util.Scanner;

public class ERWSistemaDeVotacao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inicializar contadores de votos
        int votosCandidato1 = 0;
        int votosCandidato2 = 0;
        int votosCandidato3 = 0;
        int votosNulos = 0;
        int votosEmBranco = 0;

        while (true) {
            // Ler o voto
            int voto = scanner.nextInt();

            // Verificar se o voto é negativo e parar o loop se for
            if (voto < 0) {
                break;
            }

            // Contabilizar o voto
            switch (voto) {
                case 1:
                    votosCandidato1++;
                    break;
                case 2:
                    votosCandidato2++;
                    break;
                case 3:
                    votosCandidato3++;
                    break;
                case 4:
                    votosNulos++;
                    break;
                case 5:
                    votosEmBranco++;
                    break;
                default:
                    // Não é necessário tratar outros casos, pois a entrada é garantida estar entre 1 e 5 ou negativa
                    break;
            }
        }

        // Imprimir os resultados
        System.out.println("Candidato 1 : " + votosCandidato1 + " voto(s)");
        System.out.println("Candidato 2 : " + votosCandidato2 + " voto(s)");
        System.out.println("Candidato 3 : " + votosCandidato3 + " voto(s)");
        System.out.println("Nulos : " + votosNulos + " voto(s)");
        System.out.println("Brancos : " + votosEmBranco + " voto(s)");

        scanner.close();
    }
}
