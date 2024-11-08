package ex3;

public class Pessoa {
    // -> atributos
    public String nome;
    public char sexo;
    public int idade;

    // -> construtor
    public Pessoa(String nome, char sexo, int idade) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
    }

    // -> metodos
    public String exibePessoa() {
        return String.format("PESSOA:\n Nome: %s \n Sexo: %c \n Idade: %d", nome, sexo, idade);
    }
}
