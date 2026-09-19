public class Empresa {
    public static void main(String[] args) {
        Funcionario gerente = new Gerente("Ana", "123", 8000.0, 2000.0);
        Funcionario vendedor = new Vendedor("Carlos", "456", 3000.0, 10000.0, 0.1);

        System.out.println("Salário do gerente: " + gerente.calculaSalario());
        System.out.println("Salário do vendedor: " + vendedor.calculaSalario());
    }
}