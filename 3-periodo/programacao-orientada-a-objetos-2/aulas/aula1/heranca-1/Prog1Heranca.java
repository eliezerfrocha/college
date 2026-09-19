package aula1.heranca;

import java.util.Date;

public class Prog1Heranca {
    public static void main(String[] args) {
        System.out.println("\n");
        //Entradas:
        Aluno aluno = new Aluno("Jose Francisco", "123.456.789-00", new Date( ), 123456);
        //Saidas:
        System.out.println("................ RESULTADO ................ \n");
        System.out.println("Nome       .......... " + aluno.getNome());
        System.out.println("CPF        .......... " + aluno.getCpf());
        System.out.println("Data Nasc. .......... " + aluno.getDataNascimento());
        System.out.println("Matrícula  .......... " + aluno.getMatricula());
        System.out.println("\n...........................................");
        System.out.println("\n");
    }
}
