package model.transacao;

import interfaces.Operacao;
import model.produto.Produto;

public abstract class Transacao implements Operacao {
    protected Produto produto;
    protected int quantidade;

    public Transacao(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    @Override
    public void executar() {}
}
