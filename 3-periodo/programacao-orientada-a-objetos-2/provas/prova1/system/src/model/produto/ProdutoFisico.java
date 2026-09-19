package model.produto;

public class ProdutoFisico extends Produto {
    public ProdutoFisico(String nome, double preco, int quantidade) {
        super(nome, preco, quantidade);
    }

    @Override
    public void atualizarEstoque(int quantidade) {
        if (quantidade < 0 && Math.abs(quantidade) > this.quantidade) {
            System.out.println(">> Quantidade insuficiente em estoque.");
        } else {
            super.atualizarEstoque(quantidade);
        }
    }
}
