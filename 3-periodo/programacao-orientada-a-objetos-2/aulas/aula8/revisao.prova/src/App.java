import model.Funcionario;
import model.Departamento;
import util.Util;

public class App {
    public static void main(String[] args) {
        try {
            Funcionario funcionario1 = new Funcionario("Ana", "111.222.333-44", 2500);
            Funcionario funcionario2 = new Funcionario("Bruno", "222.333.444-55", 2600);
            Funcionario funcionario3 = new Funcionario("Maria", "444.555.666-77", 3000);
            Funcionario funcionario4 = new Funcionario("João", "555.666.777-88", 2800);

            Funcionario gerente = new Funcionario("Carlos", "333.444.555-66", 5000) {
                @Override
                public double calcularSalario() {
                    return salarioBase * 1.2;
                }

                @Override
                public String mostrarDados() {
                    return super.mostrarDados() + "\nCargo: Gerente\nSalário Total: " + Util.formatarMoeda(calcularSalario()) + "\n";
                }
            };

            Departamento rh = new Departamento("RH", 2);
            rh.adicionarFuncionario(funcionario1);
            rh.adicionarFuncionario(funcionario3);

            Departamento gerencia = new Departamento("Gerência", 1);
            gerencia.adicionarFuncionario(gerente);

            Departamento vendas = new Departamento("Vendas", 3);
            vendas.adicionarFuncionario(funcionario2);
            vendas.adicionarFuncionario(funcionario4);

            System.out.println("\n=== Departamento: " + rh.getNome() + " ===");
            System.out.println(rh.listarFuncionarios());

            System.out.println("\n=== Departamento: " + gerencia.getNome() + " ===");
            System.out.println(gerencia.listarFuncionarios());

            System.out.println("\n=== Departamento: " + vendas.getNome() + " ===");
            System.out.println(vendas.listarFuncionarios());

        } catch (Exception e) {
            System.out.println("Erro ao executar a aplicação: " + e.getMessage());
        }
    }
}

