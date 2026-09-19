package ex4;

import java.time.LocalDate;

public class JogadorDeFutebol {
    private String nome;
    public String nacionalidade;
    public int nascimento;
    public String posicao;
    public double peso;
    public double altura;

    public JogadorDeFutebol(String nome, String nacionalidade, int nascimento, String posicao,  double peso, double altura) {
        this.nome  = nome;
        this.nacionalidade  = nacionalidade;
        this.nascimento  = nascimento;
        this.posicao  = posicao;
        this.peso  = peso;
        this.altura  = altura;
    }

    // -> metodos
    public String exibeJogador() {
        System.out.print("\n********  Saída  ********\n");
        return String.format(
            "Nome: %s\nNacionalidade: %s\nNascimento: %d\nPosição: %s\nPeso: %.2f\nAltura: %.2f",
            nome, nacionalidade, nascimento, posicao, peso, altura
        );
    }

    public int calculaIdade(int nascimento) {
        return LocalDate.now().getYear() - nascimento;
    }

    // -> get e set
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNacionalidade() {
        return nacionalidade;
    }

    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }

    public int getNascimento() {
        return nascimento;
    }

    public void setNascimento(int nascimento) {
        this.nascimento = nascimento;
    }

    public String getPosicao() {
        return posicao;
    }

    public void setPosicao(String posicao) {
        this.posicao = posicao;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}