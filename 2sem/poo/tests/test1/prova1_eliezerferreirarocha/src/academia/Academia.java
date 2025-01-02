package academia;

public class Academia {
    private int numeroDeAlunos;
    private static int aulasComPersonal = 0;

    public Academia() {
        this.numeroDeAlunos = 0;
    }

    public void atualizarNumeroDeAlunos(int novoNumero) {
        if (novoNumero >= 0) {
            this.numeroDeAlunos = novoNumero;
            System.out.println("Número de alunos atualizado para: " + this.numeroDeAlunos);
        } else {
            System.out.println("Erro: Número de alunos não pode ser negativo.");
        }
    }

    public void registrarAulaComPersonal(int categoriaAluno) {
        if (aulasComPersonal >= 5) {
            System.out.println("Limite de aulas com personal atingido no mês.");
            return;
        }

        switch (categoriaAluno) {
            case 1 -> {
                System.out.println("Categoria 1 não tem direito a aulas com personal.");
            }
            case 2 -> {
                aulasComPersonal++;
                System.out.println(
                        "Aula com personal registrada para aluno da Categoria 2. Total de aulas: " + aulasComPersonal);
            }
            case 3 -> {
                if (aulasComPersonal + 2 <= 5) {
                    aulasComPersonal += 2;
                    System.out.println("Duas aulas com personal registradas para aluno da Categoria 3. Total de aulas: "
                            + aulasComPersonal);
                } else {
                    aulasComPersonal++;
                    System.out
                            .println("Só foi possível registrar 1 aula com personal para Categoria 3. Total de aulas: "
                                    + aulasComPersonal);
                }
            }
            default -> {
                System.out.println("Erro: Categoria inválida.");
            }
        }
    }

    public int getNumeroDeAlunos() {
        return numeroDeAlunos;
    }

    public static int getAulasComPersonal() {
        return aulasComPersonal;
    }

    public static boolean aumentarAcessosPersonal() {
        if (aulasComPersonal >= 5) {
            return false;
        }
        aulasComPersonal++;
        return true;
    }

    public static void main(String[] args) {
        Academia academia = new Academia();

        academia.atualizarNumeroDeAlunos(10);

        academia.registrarAulaComPersonal(1); 
        academia.registrarAulaComPersonal(2);         
        academia.registrarAulaComPersonal(3); 
        academia.registrarAulaComPersonal(3); 

        System.out.println("Número total de aulas com personal realizadas: " + Academia.getAulasComPersonal());
    }
}