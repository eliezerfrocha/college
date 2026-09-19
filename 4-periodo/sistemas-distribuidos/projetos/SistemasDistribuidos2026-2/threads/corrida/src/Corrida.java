import java.util.Random;

public class Corrida implements Runnable {
    private static final int TOTAL_VOLTAS = 20;
    private static final int TAMANHO_BARRA = 28;
    private static final int TOTAL_PILOTOS = 3;

    private static final String CARRINHO = "🚗";
    private static final String RESET = "\u001B[0m";
    private static final String NEGRITO = "\u001B[1m";
    private static final String CINZA = "\u001B[90m";
    private static final String SALVAR_CURSOR = "\u001B[s";
    private static final String RESTAURAR_CURSOR = "\u001B[u";
    private static final String LINHA_INTEIRA = "\u001B[2K";

    private static final String[] CORES = {"\u001B[31m", "\u001B[32m", "\u001B[34m" };
    private static final String[] PILOTOS = { "Schumacher", "Senna", "Barrichello" };
    private static final int[] VOLTAS = new int[TOTAL_PILOTOS];
    private static final String[] CLASSIFICACAO = new String[TOTAL_PILOTOS];

    private static int chegadas;

    private Random random = new Random();

    private String nome;
    private int cor;

    public Corrida(String nome, int cor) {
        this.nome = nome;
        this.cor = cor % CORES.length;
    }

    public static void imprimirPainelInicial() {
        synchronized (System.out) {
            System.out.println(NEGRITO + "+--------------------------------------+");
            System.out.println("|          CORRIDA DE THREADS           |");
            System.out.println("+--------------------------------------+" + RESET);
            System.out.println(CINZA + "  LARGADA |------------------------------->| CHEGADA" + RESET);
            System.out.println(CINZA + "  Pista: esquerda -> direita | 20 voltas" + RESET + "\n");
            
            for (int piloto = 0; piloto < TOTAL_PILOTOS; piloto++) {
                imprimirFaixa(piloto);
            }
            
            System.out.println("\n" + CINZA + "  Atualizacao ao vivo | Ctrl+C para interromper" + RESET);
            System.out.flush();
        }
    }

    @Override
    public void run() {
        for (int volta = 1; volta <= TOTAL_VOLTAS; volta++) {
            if (volta == TOTAL_VOLTAS) {
                registrarChegada();
            }
            atualizarPainel(volta);
            try {
                Thread.sleep(random.nextInt(2001));
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private void registrarChegada() {
        synchronized (CLASSIFICACAO) {
            CLASSIFICACAO[chegadas] = nome;
            chegadas++;
        }
    }

    public static void imprimirPodio() {
        synchronized (System.out) {
            System.out.println("\n=== PODIO FINAL ===");
            System.out.println("🥇 1o lugar: " + CLASSIFICACAO[0]);
            System.out.println("🥈 2o lugar: " + CLASSIFICACAO[1]);
            System.out.println("🥉 3o lugar: " + CLASSIFICACAO[2]);
        }
    }

    private void atualizarPainel(int volta) {
        synchronized (VOLTAS) {
            VOLTAS[cor] = volta;
            synchronized (System.out) {
                // O cursor fica no fim do painel; atualizamos somente a faixa alterada.
                int linhasAcima = TOTAL_PILOTOS + 2 - cor;
                System.out.printf("%s\u001B[%dA\r%s", SALVAR_CURSOR, linhasAcima, LINHA_INTEIRA);
                imprimirFaixa(cor);
                System.out.print(RESTAURAR_CURSOR);
                System.out.flush();
            }
        }
    }

    private static void imprimirFaixa(int piloto) {
        int voltaAtual = VOLTAS[piloto];
        int posicao = voltaAtual * (TAMANHO_BARRA - CARRINHO.length()) / TOTAL_VOLTAS;
        int espacosRestantes = TAMANHO_BARRA - posicao - CARRINHO.length();
        String pista = "S" + "=".repeat(posicao) + CARRINHO + ".".repeat(espacosRestantes) + "🏁";
        int percentual = voltaAtual * 100 / TOTAL_VOLTAS;
        String estado = obterEstado(piloto, voltaAtual);

        System.out.printf("%s  %d. %-12s %s  %02d/%02d  %3d%%  %-8s%s%n",
            CORES[piloto], piloto + 1, PILOTOS[piloto], pista, voltaAtual, TOTAL_VOLTAS, percentual, estado, RESET);
    }

    private static String obterEstado(int piloto, int voltaAtual) {
        if (voltaAtual == 0) {
            return "PRONTO";
        }
        if (voltaAtual < TOTAL_VOLTAS) {
            return "CORRENDO";
        }
        synchronized (CLASSIFICACAO) {
            for (int colocacao = 0; colocacao < chegadas; colocacao++) {
                if (CLASSIFICACAO[colocacao].equals(PILOTOS[piloto])) {
                    return (colocacao + 1) + "o LUGAR";
                }
            }
        }
        return "CHEGOU";
    }

}
