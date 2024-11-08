//CompanhiaTelefonica
public class tarefa01 {
    public static void main(String[] args) {
        // Arrays para armazenar os dados dos clientes
        String[] nomes = { "Maria José", "XY Informática", "Joaquim Silva", "Antônio Carlos" };
        String[] telefones = { "3222-1234", "3223-6666", "3222-3344", "3212-6622" };
        int[] tiposAssinatura = { 1, 2, 0, 1 }; // 0 - Básico, 1 - Intermediário, 2 - Premium
        int[] minutosConsumidos = { 120, 457, 150, 134 };
        double[] valoresConta = new double[nomes.length];

        // Itera sobre os clientes para calcular o valor da conta
        for (int i = 0; i < nomes.length; i++) {
            // Calcula o valor da conta com base no tipo de assinatura
            if (tiposAssinatura[i] == 0) { // Básico
                valoresConta[i] = minutosConsumidos[i] * 0.50; // Exemplo: R$0.50 por minuto
            } else if (tiposAssinatura[i] == 1) { // Intermediário
                valoresConta[i] = minutosConsumidos[i] * 0.30; // Exemplo: R$0.30 por minuto
            } else if (tiposAssinatura[i] == 2) { // Premium
                valoresConta[i] = minutosConsumidos[i] * 0.20; // Exemplo: R$0.20 por minuto
            }
        }

        // Exibe os dados dos clientes
        System.out.println("\n");
        System.out.println("-----------------------------------------------------------------");
        System.out.printf("%-20s %-15s %-4s %-7s %-10s%n", "Nome", "Telefone", "Tipo", "Minutos", "Valor da Conta");
        System.out.println("-----------------------------------------------------------------");
        for (int i = 0; i < nomes.length; i++) {
            System.out.printf("%-20s %-15s %-4d %-7d R$%-9.2f%n", nomes[i], telefones[i], tiposAssinatura[i], minutosConsumidos[i], valoresConta[i]);
        }
        System.out.println("-----------------------------------------------------------------");
        System.out.println("\n");
    }
}
