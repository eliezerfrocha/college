package monitor;

public class App {
    public static void main(String[] args) {
        System.out.println("\n=== PRODUTOR-CONSUMIDOR | MONITOR ===");
        System.out.println("O buffer tem capacidade para 5 itens.\n");

        Buffer buffer = new Buffer();

        Produtor produtor = new Produtor(buffer);
        Consumidor consumidor = new Consumidor(buffer);

        new Thread(produtor,"Thread Produtora").start();
        new Thread(consumidor,"Thread Consumidora").start();

        System.out.println("\nProdutor e consumidor iniciados. Use Ctrl+C para parar.\n");
    }
}