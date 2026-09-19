import java.util.Scanner;

import model.produto.Produto;
import model.produto.ProdutoDigital;
import model.produto.ProdutoFisico;
import model.transacao.Compra;
import model.transacao.Venda;
import util.GerenciaEstoque;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        GerenciaEstoque gerenciaEstoque = new GerenciaEstoque();

        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("              MENU       ");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1 - ADICIONAR PRODUTO");
            System.out.println("2 - COMPRA");
            System.out.println("3 - VENDA");
            System.out.println("4 - ESTOQUE");
            System.out.println("0 - SAIR");
            System.out.println("╚══════════════════════════════╝");

            System.out.print("\n< Escolha uma opção: _");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    menuProduto(gerenciaEstoque, scanner);
                    break;
                case 2:
                    comprarProduto(gerenciaEstoque, scanner);
                    break;
                case 3:
                    venderProduto(gerenciaEstoque, scanner);
                    break;
                case 4:
                    listarEstoque(gerenciaEstoque);
                    break;
                case 0:
                    System.out.println("\n> Saindo...");
                    return;
                default:
                    System.out.println("\n>> Opção inválida! Tente novamente.");
            }
        }
    }

    // #region CADASTRO DE PRODUTO
    private static void menuProduto(GerenciaEstoque gerenciaEstoque, Scanner scanner) {

        while (true) {
            System.out.println("\n╔══════════════════════════════╗");
            System.out.println("             PRODUTO       ");
            System.out.println("╚══════════════════════════════╝");
            System.out.println("1 - PRODUTO FISICO");
            System.out.println("2 - PRODUTO DIGITAL");
            System.out.println("0 - VOLTAR");
            System.out.println("╚══════════════════════════════╝");

            System.out.print("\n< Escolha uma opção: _");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    adicionarProdutoFisico(gerenciaEstoque, scanner);
                    break;
                case 2:
                    adicionarProdutoDigital(gerenciaEstoque, scanner);
                    break;
                case 0:
                    System.out.println("\n> Voltando...");
                    return;
                default:
                    System.out.println("\n>> Opção inválida! Tente novamente.");
            }
        }
    }

    private static void adicionarProdutoFisico(GerenciaEstoque gerenciaEstoque, Scanner scanner) {
        System.out.print("\n< Nome: ");
        String nome = scanner.nextLine();
        System.out.print("< Preço: R$");
        double preco = scanner.nextDouble();
        System.out.print("< Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new ProdutoFisico(nome, preco, quantidade);
        // Verifica se o produto já existe no estoque
        // Se não existir, adiciona o produto ao estoque
        if (!gerenciaEstoque.produtoExistente(produto.getNome())) {
            gerenciaEstoque.adicionarProduto(produto);
        } else {
            System.out.println("\n>> Cadastro de produto já existente!");
            return;
        }
        System.out.println("\n" + produto.imprimirDetalhes());
        System.out.println("> Produto físico adicionado com sucesso!");
    }

    private static void adicionarProdutoDigital(GerenciaEstoque gerenciaEstoque, Scanner scanner) {
        System.out.print("\n< Nome: ");
        String nome = scanner.nextLine();
        System.out.print("< Preço: R$");
        double preco = scanner.nextDouble();
        System.out.print("< Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto produto = new ProdutoDigital(nome, preco, quantidade);
        // Verifica se o produto já existe no estoque
        // Se não existir, adiciona o produto ao estoque
        if (!gerenciaEstoque.produtoExistente(produto.getNome())) {
            gerenciaEstoque.adicionarProduto(produto);
        } else {
            System.out.println("\n>> Cadastro de produto já existente!");
            return;
        }
        System.out.println("\n" + produto.imprimirDetalhes());
        System.out.println("Produto digital adicionado com sucesso!");
    }
    // #endregion

    // #region COMPRA
    private static void comprarProduto(GerenciaEstoque gerenciaEstoque, Scanner scanner) {
        System.out.print("\n< Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("< Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto produto = gerenciaEstoque.buscarProduto(nome);
        if (produto != null) {
            Compra compra = new Compra(produto, quantidade);
            compra.executar();

            System.out.println("\n" + produto.imprimirDetalhes());
            System.out.println("> Compra realizada com sucesso!");
        } else {
            System.out.println("\n>> Produto não encontrado!");
        }
    }
    // #endregion

    // #region VENDA
    private static void venderProduto(GerenciaEstoque gerenciaEstoque, Scanner scanner) {
        System.out.print("\n< Nome do produto: ");
        String nome = scanner.nextLine();
        System.out.print("< Quantidade: ");
        int quantidade = scanner.nextInt();
        scanner.nextLine();

        Produto produto = gerenciaEstoque.buscarProduto(nome);
        if (produto != null) {
            Venda venda = new Venda(produto, quantidade);
            venda.executar();

            System.out.println("\n" + produto.imprimirDetalhes());
            System.out.println("> Venda realizada com sucesso!");
        } else {
            System.out.println("\n>> Produto não encontrado!");
        }
    }
    // #endregion

    // #region ESTOQUE
    private static void listarEstoque(GerenciaEstoque gerenciaEstoque) {
        String listaProdutos = gerenciaEstoque.listarProdutos();
        System.out.println("\n" + listaProdutos);
        if (listaProdutos.contains("Nenhum produto cadastrado.")) {
            System.out.println("\n>> Estoque vazio!");
        } else {
            System.out.println("> Estoque listado com sucesso!");
        }
    }
    // #endregion
}
