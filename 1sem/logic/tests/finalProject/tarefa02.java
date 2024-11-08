// CompanhiaTelefonicaComMatriz
public class tarefa02 {
    public static void main(String[] args) {
        // Matriz de preços [tipo de assinatura][0: preço da assinatura, 1: preço do minuto excedente]
        double[][] precos = {
                { 25.5, 0.10 }, // Tipo 0
                { 35.0, 0.12 }, // Tipo 1
                { 60.0, 0.15 } // Tipo 2
        };

        // Arrays para armazenar os dados dos clientes
        String[] nomes = { "Maria José", "XY Informática", "Joaquim Silva", "Antônio Carlos" };
        String[] telefones = { "3222-1234", "3223-6666", "3222-3344", "3212-6622" };
        int[] tiposAssinatura = { 1, 2, 0, 1 }; // 0 - Básico, 1 - Intermediário, 2 - Premium
        int[] minutosConsumidos = { 120, 457, 150, 134 };
        double[] valoresConta = new double[nomes.length];

        // Número de minutos incluídos no plano para cada tipo de assinatura
        int[] minutosIncluidos = { 100, 200, 300 }; // Exemplo: 100 minutos incluídos para o tipo 0, 200 para o tipo 1, etc.

        // Calcula o valor da conta para cada cliente
        for (int i = 0; i < nomes.length; i++) {
            int tipo = tiposAssinatura[i];
            double precoAssinatura = precos[tipo][0];
            double precoMinutoExcedente = precos[tipo][1];
            int minutosExcedentes = Math.max(0, minutosConsumidos[i] - minutosIncluidos[tipo]);

            // Calcula o valor total da conta
            valoresConta[i] = precoAssinatura + (minutosExcedentes * precoMinutoExcedente);
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
