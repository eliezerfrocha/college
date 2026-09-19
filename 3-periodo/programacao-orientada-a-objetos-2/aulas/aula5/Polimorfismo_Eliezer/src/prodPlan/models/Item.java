package prodPlan.models;

public class Item extends Parte {
    private int quantidade;

    public Item(int cod, String nome, String descricao, float valor, int quantidade) {
        super(cod, nome, descricao, valor);
        this.quantidade = quantidade;
    }

    public Item(Parte parte, int i) {
        super(parte.cod, parte.nome, parte.descricao, parte.valor);
        this.quantidade = i;
    }

    @Override
    public float calculaValor() {
        return valor * quantidade;
    }

    
    @Override
    public String toString() {
        return "codigo:" + cod +
        " nome:" + nome +
        " descricao:" + descricao +
        " valor:" + valor +
        " quantidade:" + quantidade;
    }
    
    // public int getQuantidade() {
    //     return quantidade;
    // }

    // public int getCod() {
    //     return cod;
    // }

    // public String getNome() {
    //     return nome;
    // }
}
