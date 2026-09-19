package ex4;

import java.util.Scanner;

public class App {
    static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        JogadorDeFutebol j = leJogador();
        System.out.println(j.exibeJogador());
        tempoAposentadoria(j);
    }

    public static JogadorDeFutebol leJogador() {
        System.out.print("\n********  Entrada  ********\n");
        System.out.print("Nome: ");
        String nome = s.nextLine();
        System.out.print("Nacionalidade: ");
        String nacionalidade = s.nextLine();
        System.out.print("Nascimento: ");
        int nascimento = s.nextInt(); s.nextLine();
        System.out.print("Posição: ");
        String posicao = s.nextLine();
        System.out.print("Peso: ");
        double peso = s.nextDouble(); s.nextLine();
        System.out.print("Altura: ");
        double altura = s.nextDouble(); s.nextLine();
        JogadorDeFutebol j = new JogadorDeFutebol(nome, nacionalidade, nascimento, posicao, peso, altura);
        return j;
    }

    public static void tempoAposentadoria(JogadorDeFutebol j) {
        System.out.println("\n********  Tempo Aposentadoria  ********");
        String msg = "";
        int idade = j.calculaIdade(j.nascimento);
        switch (j.posicao) {
            case "Atacante":
                if (idade < 35)
                    msg = "Faltam " + diferencaIdade(idade, 35) + " anos para o jogador " 
                    + j.getNome().toUpperCase() + " se aposentar.";
                break;
            case "Defesa":
                if (idade < 40)
                    msg = "Faltam " + diferencaIdade(idade, 35) + " anos para o jogador " 
                    + j.getNome().toUpperCase() + " se aposentar.";
                break;
            case "Meio Campo":
                if (idade < 38)
                    msg = "Faltam " + diferencaIdade(idade, 35) + " anos para o jogador " 
                    + j.getNome().toUpperCase() + " se aposentar.";
                break;
            default:
                msg = "Jogador " + j.getNome().toUpperCase() + " já se aposentou.";
                break;
        }
        System.out.println(msg);
    }

    public static int diferencaIdade(int idade, int idadeAposentadoria) {
        return idadeAposentadoria - idade;
    }
}
