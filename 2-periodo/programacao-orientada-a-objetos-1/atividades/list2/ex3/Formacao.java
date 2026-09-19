package ex3;

public class Formacao {
    // -> atributos
    public String nome, instituicao;
    public boolean concluido;
    public int ano;

    // -> construtor
    public Formacao(String nome, boolean concluido, String instituicao, int ano) {
        this.nome = nome;
        this.concluido = concluido;
        this.instituicao = instituicao;
        this.ano  = ano;
    }

    // -> metodos
    public String exibeFormacao() {
        return String.format("FORMAÇÃO:\n Nome: %s \n Instituição: %s \n Concluído: %b \n  Ano: %d", nome, instituicao, concluido, ano);
    }
}
