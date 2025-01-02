package aplicacao;

public class Aluno {
    private String codigo;
    private String nome;
    private String telefone;
    private int categoria;

    private static int acessos = 0;

    public Aluno(String codigo, String nome, String telefone) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;
        this.categoria = 1;
    }

    public Aluno(String codigo, String nome, String telefone, int categoria, int acessos) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;

        if (categoria == 2 || categoria == 3) {
            this.categoria = categoria;
            Aluno.acessos = acessos;
        } else {
            throw new IllegalArgumentException("Categoria inválida! Deve ser 2 ou 3.");
        }
    }

    public Aluno(String codigo, String nome, String telefone, int categoria) {
        this.codigo = codigo;
        this.nome = nome;
        this.telefone = telefone;

        if (categoria == 2 || categoria == 3) {
            this.categoria = categoria;
        } else {
            throw new IllegalArgumentException("Categoria inválida! Deve ser 2 ou 3.");
        }
    }

    public void exibirInformacoes() {
        System.out.println("Código: " + this.codigo);
        System.out.println("Nome: " + this.nome);
        System.out.println("Telefone: " + this.telefone);
        System.out.println("Categoria: " + this.categoria);
    }

    public void exibirInformacoes(boolean exibirAcessos) {
        exibirInformacoes();
        if (exibirAcessos) {
            System.out.println("Acessos: " + Aluno.acessos);
        }
    }

    public String getNome() {
        return nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public static boolean aumentarAcessosPersonal() {
        if (acessos >= 5) {
            return false;
        }
        acessos++;
        return true;
    }

    public static int getAcessosPersonal() {
        return acessos;
    }

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("ASQ1234", "João Silva", "(11) 91234-5678");
        aluno1.exibirInformacoes();

        System.out.println();

        Aluno aluno2 = new Aluno("TWER1234", "Maria Oliveira", "(21) 92345-6789", 2, 1);
        aluno2.exibirInformacoes(true);

        System.out.println();

        Aluno aluno3 = new Aluno("LKLJH1234", "Carlos Mendes", "(31) 93456-7890", 3, 2);
        aluno3.exibirInformacoes(true);

        System.out.println();

        System.out.println("Tentando aumentar os acessos...");
        boolean sucesso = Aluno.aumentarAcessosPersonal();
        System.out.println("Acesso aumentado? " + (sucesso ? "Sim" : "Não"));
        System.out.println("Acessos atuais: " + Aluno.getAcessosPersonal());
    }
}