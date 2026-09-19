package model.transacao;

import model.produto.Produto;

public class Compra extends Transacao {
    public Compra(Produto produto, int quantidade) {
        super(produto, quantidade);
    }

    @Override
    public void executar() {
        if (quantidade > 0) {
            produto.atualizarEstoque(+quantidade);
            System.out.println("\n> Compra realizada: " + quantidade + " X " + produto.getNome());
        } else {
            System.out.println(">> Quantidade inválida para compra!");
        }
    }
}
