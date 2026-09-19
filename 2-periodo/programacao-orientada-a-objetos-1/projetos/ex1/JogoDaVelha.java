package ex1;
import java.util.Scanner;

public class JogoDaVelha {
    static char[][] tabuleiro = { 
        { ' ', ' ', ' ' }, 
        { ' ', ' ', ' ' }, 
        { ' ', ' ', ' ' } 
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        char jogadorAtual = 'x';
        boolean jogoFinalizado = false;

        while (!jogoFinalizado) {
            interfaceJogo(jogadorAtual);
            int posicao = scanner.nextInt();

            if (validacao(posicao)) {
                atualizarTabuleiro(posicao, jogadorAtual);
                if (vitoria(jogadorAtual)) {
                    exibeFim(1, jogadorAtual);
                    jogoFinalizado = true;
                } else if (empate()) {
                    exibeFim(0, jogadorAtual);
                    jogoFinalizado = true;
                } else {
                    jogadorAtual = (jogadorAtual == 'x') ? 'o' : 'x';
                }
            } else {
                restricao();
            }
        }
    }

    // Função que exibe o tabuleiro e lê a jogada
    public static void interfaceJogo(char jogadorAtual) {
        System.out.println("Tabuleiro atual:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(tabuleiro[i][j] + "\t");
            }
            System.out.print((i * 3 + 1) + "\t" + (i * 3 + 2) + "\t" + (i * 3 + 3));
            System.out.println();
        }
        System.out.println("Jogador \"" + jogadorAtual + "\", é a sua vez de jogar");
        System.out.print("Escolha uma posição (1-9): ");
    }

    // Função que valida se a jogada é válida
    public static boolean validacao(int posicao) {
        if (posicao < 1 || posicao > 9) {
            return false;
        }

        int linha = (posicao - 1) / 3;
        int coluna = (posicao - 1) % 3;
        return tabuleiro[linha][coluna] == ' ';
    }

    // Função que exibe uma mensagem para jogada inválida
    public static void restricao() {
        System.out.println("Posição inválida. Tente novamente.");
    }

    // Função que atualiza o tabuleiro com a jogada atual
    public static void atualizarTabuleiro(int posicao, char jogadorAtual) {
        int linha = (posicao - 1) / 3;
        int coluna = (posicao - 1) % 3;
        tabuleiro[linha][coluna] = jogadorAtual;
    }

    // Função que verifica se o jogo terminou em empate
    public static boolean empate() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tabuleiro[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    // Função que verifica se há um vencedor
    public static boolean vitoria(char jogadorAtual) {
        // Verifica linhas e colunas
        for (int i = 0; i < 3; i++) {
            if ((tabuleiro[i][0] == jogadorAtual && tabuleiro[i][1] == jogadorAtual && tabuleiro[i][2] == jogadorAtual) ||
                (tabuleiro[0][i] == jogadorAtual && tabuleiro[1][i] == jogadorAtual && tabuleiro[2][i] == jogadorAtual)) {
                return true;
            }
        }

        // Verifica diagonais
        if ((tabuleiro[0][0] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][2] == jogadorAtual) ||
            (tabuleiro[0][2] == jogadorAtual && tabuleiro[1][1] == jogadorAtual && tabuleiro[2][0] == jogadorAtual)) {
            return true;
        }

        return false;
    }

    // Função que exibe o resultado final do jogo
    public static void exibeFim(int resultado, char jogadorAtual) {
        if (resultado == 1) {
            System.out.println("Parabéns! O jogador \"" + jogadorAtual + "\" venceu o jogo!");
        } else {
            System.out.println("Deu velha! O jogo terminou em empate.");
        }
    }
}
