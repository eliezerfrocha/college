package model.produto;

public class ProdutoDigital extends Produto {
    public ProdutoDigital(String nome, double preco, int quantidade) {
        super(nome, preco, Integer.MAX_VALUE); // Estoque ilimitado para produtos digitais
    }

    @Override
    public void atualizarEstoque(int quantidade) {}
}
