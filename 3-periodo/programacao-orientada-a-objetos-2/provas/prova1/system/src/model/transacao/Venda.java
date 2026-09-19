package model.transacao;

import model.produto.Produto;

public class Venda extends Transacao {
    public Venda(Produto produto, int quantidade) {
        super(produto, quantidade);
    }

    @Override
    public void executar() {
        if (quantidade > 0) {
            produto.atualizarEstoque(-quantidade);
            System.out.println("\n> Venda realizada: " + quantidade + " X " + produto.getNome());
        } else {
            System.out.println(">> Estoque insuficiente para venda");
        }
    }
}
