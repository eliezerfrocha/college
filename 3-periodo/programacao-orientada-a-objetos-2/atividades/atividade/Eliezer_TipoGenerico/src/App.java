import java.util.Scanner;

import model.*;

public class App {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Vetor<Cidade> cidades = new Vetor<>(100); // capacidade inicial arbitrária
        Vetor<Pessoa> pessoas = new Vetor<>(100);
    
        while (true) {
            System.out.println("\n==================== MENU ====================");
            System.out.println("1. Cadastrar cidades");
            System.out.println("2. Exibir cidades");
            System.out.println("3. Cadastrar pessoas");
            System.out.println("4. Exibir pessoas");
            System.out.println("5. Buscar pessoa e cidade natal");
            System.out.println("0. Sair");
            System.out.println("\n==============================================");
            System.out.print("Escolha uma opção: ");
            String opcao = s.nextLine();
    
            switch (opcao) {
                case "1":
                    Vetor<Cidade> novasCidades = cadastrarCidades(s);
                    for (int i = 0; i < novasCidades.getTamanho(); i++) {
                        cidades.adicionar(novasCidades.getElemento(i));
                    }
                    break;
                case "2":
                    exibirCidades(cidades);
                    break;
                case "3":
                    Vetor<Pessoa> novasPessoas = cadastrarPessoas(s);
                    for (int i = 0; i < novasPessoas.getTamanho(); i++) {
                        pessoas.adicionar(novasPessoas.getElemento(i));
                    }
                    break;
                case "4":
                    exibirPessoas(pessoas);
                    break;
                case "5":
                    buscarPessoaECidade(s, pessoas, cidades);
                    break;
                case "0":
                    System.out.println("\n👋 Encerrando o programa. Até mais!");
                    s.close();
                    return;
                default:
                    System.out.println("\n❌ Opção inválida. Tente novamente.");
            }
        }
    }

    private static Vetor<Cidade> cadastrarCidades(Scanner s) {
        System.out.print("\n🌆 Quantas cidades você deseja cadastrar? ");
        int tamanho = s.nextInt();
        s.nextLine();
    
        Vetor<Cidade> cidades = new Vetor<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            System.out.println("\n📍 Cidade " + (i + 1) + " de " + tamanho);
            System.out.print("   > Nome: ");
            String nome = s.nextLine();
            System.out.print("   > Adjetivo: ");
            String adjetivo = s.nextLine();
            System.out.print("   > Estado (sigla ou nome): ");
            String estado = s.nextLine();
    
            cidades.setElemento(i, new Cidade(nome, adjetivo, estado));
        }
        return cidades;
    }
    
    private static void exibirCidades(Vetor<Cidade> cidades) {
        System.out.println("\n----------------------------------------");
        System.out.println("📋 CIDADES CADASTRADAS:");
        System.out.println("----------------------------------------");
        for (int i = 0; i < cidades.getTamanho(); i++) {
            Cidade c = cidades.getElemento(i);
            if (c != null) {
                System.out.printf(" - %s (%s - %s)\n", c.getNome(), c.getAdjetivo(), c.getEstado());
            }
            //System.out.printf(" - %s (%s - %s)\n", c.getNome(), c.getAdjetivo(), c.getEstado());
        }
    }
    
    private static Vetor<Pessoa> cadastrarPessoas(Scanner s) {
        System.out.print("\n👤 Quantas pessoas você deseja cadastrar? ");
        int tamanho = s.nextInt();
        s.nextLine();
    
        Vetor<Pessoa> pessoas = new Vetor<>(tamanho);
        for (int i = 0; i < tamanho; i++) {
            System.out.println("\n🧾 Pessoa " + (i + 1) + " de " + tamanho);
            System.out.print("   > Nome: ");
            String nome = s.nextLine();
            System.out.print("   > Sexo: ");
            String sexo = s.nextLine();
            System.out.print("   > Cidade Natal: ");
            String naturalidade = s.nextLine();
    
            pessoas.setElemento(i, new Pessoa(nome, sexo, naturalidade));
        }
        return pessoas;
    }
    
    private static void exibirPessoas(Vetor<Pessoa> pessoas) {
        System.out.println("\n----------------------------------------");
        System.out.println("📋 PESSOAS CADASTRADAS:");
        System.out.println("----------------------------------------");
        for (int i = 0; i < pessoas.getTamanho(); i++) {
            Pessoa p = pessoas.getElemento(i);
            if (p != null) {
                System.out.printf(" - %s (%s) | Naturalidade: %s\n", p.getNome(), p.getSexo(), p.getNaturalidade());
            }
            //System.out.printf(" - %s (%s) | Naturalidade: %s\n", p.getNome(), p.getSexo(), p.getNaturalidade());
        }
    }
    
    private static void buscarPessoaECidade(Scanner s, Vetor<Pessoa> pessoas, Vetor<Cidade> cidades) {
        System.out.print("\n🔍 Digite o nome completo de uma pessoa para buscar: ");
        String nomeBusca = s.nextLine();
    
        Pessoa pessoa = encontrarPessoaPorNome(pessoas, nomeBusca);
        if (pessoa != null) {
            Cidade cidade = encontrarCidadePorNome(cidades, pessoa.getNaturalidade());
            imprimirMensagem(pessoa, cidade);
        } else {
            System.out.printf("\n⚠️ Pessoa \"%s\" não encontrada.\n", nomeBusca);
        }
    }
    
    private static void imprimirMensagem(Pessoa pessoa, Cidade cidade) {
        if (cidade != null) {
            String adjetivo = cidade.getAdjetivo();
            String estado = cidade.getEstado();
            String artigo = pessoa.getSexo().equalsIgnoreCase("f") ? "A" : "O";
    
            System.out.printf("\n✅ %s %s %s nasceu em %s - %s.\n",
                    artigo, adjetivo, pessoa.getNome(), cidade.getNome(), estado);
        } else {
            System.out.printf("\n⚠️ %s nasceu em cidade desconhecida.\n", pessoa.getNome());
        }
    }

    private static Pessoa encontrarPessoaPorNome(Vetor<Pessoa> pessoas, String nomeBusca) {
        for (int i = 0; i < pessoas.getTamanho(); i++) {
            Pessoa pessoa = pessoas.getElemento(i);
            if (pessoa != null) {
                if (pessoa.getNome().equalsIgnoreCase(nomeBusca)) {
                    return pessoa;
                }
            }            
        }
        return null;
    }

    private static Cidade encontrarCidadePorNome(Vetor<Cidade> cidades, String nomeBusca) {
        for (int i = 0; i < cidades.getTamanho(); i++) {
            Cidade cidade = cidades.getElemento(i);
            if (cidade != null) {
                if (cidade.getNome().equalsIgnoreCase(nomeBusca)) {
                    return cidade;
                }
            }
        }
        return null;
    }
}
