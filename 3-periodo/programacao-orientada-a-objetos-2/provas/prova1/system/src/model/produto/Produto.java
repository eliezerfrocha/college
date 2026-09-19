package model.produto;

import interfaces.Imprimivel;

public abstract class Produto implements Imprimivel {
    protected String nome;
    protected double preco;
    protected int quantidade;

    public Produto(String nome, double preco, int quantidade) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public String getNome() {
        return nome;
    }

    public void atualizarEstoque(int quantidade) {
        this.quantidade += quantidade;
    }

    @Override
    public String imprimirDetalhes() {
        return "------------------------------\n" +
                "Detalhes do Produto:\n" +
                "------------------------------\n" +
                "Nome: " + nome + "\n" +
                "Preço: R$" + preco + "\n" +
                "Estoque: " + quantidade + "\n";
    }
}
