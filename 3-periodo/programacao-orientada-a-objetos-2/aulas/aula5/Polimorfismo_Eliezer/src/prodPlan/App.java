package prodPlan;

import prodPlan.models.*;

public class App {
    /**
     * MÉTODO estático que cria um vetor de objetos Parte a ser usado nos testes
     *
     * @return vetor de objetos Parte
     */
    static Parte[] criaPartes() {
        return new Parte[] {
                new Motor(112, "motor m112", "motor de avanco do cabecote", 100.0f, 1.2f, 1.1f, 1250),
                new Motor(114, "motor m114", "motor auxiliar", 60.0f, 0.6f, 0.8f, 1250),
                new Motor(111, "motor m111", "motor de ventilador", 70.0f, 1.0f, 1.0f, 3000),
                new Motor(110, "motor m110", "motor principal", 120.0f, 1.8f, 1.5f, 1250),
                new Parafuso(231, "parafuso p1", "parafuso de fixacao do cabecote", 2.5f, 100.0f, 8.0f),
                new Parafuso(232, "parafuso p2", "parafuso de fixacao do motor", 2.5f, 80.0f, 6.0f),
                new Parafuso(233, "parafuso p3", "parafuso de fixacao do ventilador", 2.0f, 60.0f, 6.0f),
                new Parafuso(234, "parafuso p4", "parafuso de uso geral", 3.0f, 120.0f, 12.0f)
        };
    }

    /**
     * MÉTODO estático do tipo void que escreve na saída padrão o conteúdo de um
     * vetor de
     * objetos Parte devidamente convertidos para String.
     * 
     * @param titulo texto a ser mostrado antes da listagem
     * @param partes vetor de objetos Parte a ser listado
     */
    static void listaPartes(String titulo, Parte[] partes) {
        System.out.println(titulo);
        for (Parte parte : partes) {
            System.out.println(parte);
        }

        //listaPartes(titulo, partes);
    }

    /**
     * MÉTODO estático que cria um vetor de objetos Item a ser usado nos testes
     * 
     * @param partes vetor de objetos Parte a partir do qual serao criados os
     *               objetos Item que
     *               formarão o vetor
     * @return vetor de objetos Item
     */
    static Item[] criaItens(Parte[] partes) {
        return new Item[] {
                new Item(partes[0], 10), // motor m112
                new Item(partes[5], 50), // parafuso p2
                new Item(partes[7], 30), // parafuso p4
                new Item(partes[2], 5) // motor m111
        };
    }

    /**
     * MÉTODO estático que escreve na saída padrão o conteúdo de um vetor de objetos
     * Item,
     * devidamente convertidos para String.
     * 
     * @param titulo texto apresentado antes da listagem.
     * @param itens  vetor de objetos Item a ser listado.
     */
    static void listaItens(String titulo, Item[] itens) {
        System.out.println(titulo);
        float total = 0;
        for (Item item : itens) {
            System.out.println(item);
            total += item.calculaValor();
        }
        System.out.println("\nValor total:" + total);
        //listaItensTabelado(titulo, itens);
    }

    /**
     * MÉTODO principal que dispara os testes.
     * 
     * @param args o de sempre.
     */
    public static void main(String[] args) {
        Parte[] partes = criaPartes();
        Item[] itens = criaItens(partes);
        listaPartes("\n*** Partes utilizadas na producao ****", partes);
        listaItens("\n*** Itens solicitados ***", itens);
    }

    //#region AUXILIARES

    // static void listaItensTabelado(String titulo, Item[] itens) {
    //     System.out.println(titulo);
    //     System.out.printf("%-8s %-25s %-10s %-15s %-10s\n", 
    //         "Cód", "Nome", "Qtd", "Valor Unitário", "Total");
    
    //     float totalGeral = 0;
    //     for (Item item : itens) {
    //         float valorUnitario = item.calculaValor();
    //         float valorTotal = valorUnitario * item.getQuantidade();
    
    //         System.out.printf("%-8d %-25s %-10d %-15.2f %-10.2f\n",
    //             item.getCod(),
    //             item.getNome(),
    //             item.getQuantidade(),
    //             valorUnitario,
    //             valorTotal
    //         );
    
    //         totalGeral += valorTotal;
    //     }
    
    //     System.out.println("------------------------------------------------------------");
    //     System.out.printf("%-45s %-10.2f\n", "Valor total:", totalGeral);
    // }

    // static void listaPartesTabelado(String titulo, Parte[] partes) {
    //     System.out.println(titulo);
    
    //     System.out.printf("%-8s %-20s %-30s %-10s %-10s %-10s %-10s %-10s\n",
    //         "Cód", "Nome", "Descrição", "Valor", "Potência", "Corrente", "RPM", "Comp x Dia");
    
    //     for (Parte parte : partes) {
    //         System.out.printf("%-8d %-20s %-30s %-10.2f",
    //             parte.getCod(),
    //             parte.getNome(),
    //             parte.getDescricao(),
    //             parte.calculaValor()
    //         );
    
    //         if (parte instanceof Motor motor) {
    //             System.out.printf(" %-10.2f %-10.2f %-10d %-10s\n",
    //                 motor.getPotencia(),
    //                 motor.getPotencia(),
    //                 motor.getRpm(),
    //                 "-"
    //             );
    //         } else if (parte instanceof Parafuso parafuso) {
    //             System.out.printf(" %-10s %-10s %-10s %-5.1f x %-5.1f\n",
    //                 "-", "-", "-", 
    //                 parafuso.getComprimento(), 
    //                 parafuso.getDiametro()
    //             );
    //         } else {
    //             System.out.printf(" %-10s %-10s %-10s %-10s\n", "-", "-", "-", "-");
    //         }
    //     }
    // }

    //#endregion
}