package util;

import java.util.ArrayList;
import java.util.List;

import model.produto.Produto;

public class GerenciaEstoque {
    private List<Produto> produtos;

    public GerenciaEstoque() {
        produtos = new ArrayList<>();
    }

    public void adicionarProduto(Produto produto) {
        produtos.add(produto);
    }

    public Produto buscarProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return produto;
            }
        }
        return null;
    }

    public boolean produtoExistente(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equalsIgnoreCase(nome)) {
                return true;
            }
        }
        return false;
    }

    public String listarProdutos() {
        StringBuilder sb = new StringBuilder();
        sb.append("Lista de Produtos:\n");
        if (produtos.isEmpty()) {
            sb.append("------------------------------\n");
            sb.append("Nenhum produto cadastrado.\n");
            sb.append("------------------------------\n");
            return sb.toString();
        }
        for (Produto produto : produtos) {
            sb.append(produto.imprimirDetalhes());
            sb.append("------------------------------\n");
        }
        return sb.toString();
    }
}
