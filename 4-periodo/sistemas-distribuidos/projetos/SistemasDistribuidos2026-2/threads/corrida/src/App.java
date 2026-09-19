public class App {
    public static void main(String[] args) throws Exception {
        Corrida schumacher = new Corrida("Schumacher", 0);
        Corrida senna = new Corrida("Senna", 1);
        Corrida barrichello = new Corrida("Barrichello", 2);

        System.out.println("\n+--------------------------------------+");
        System.out.println("|       PREPARANDO A LARGADA           |");
        System.out.println("+--------------------------------------+");
        
        for (int contagem = 3; contagem > 0; contagem--) {
            System.out.printf("\r\u001B[2K             %d", contagem);
            System.out.flush();
            Thread.sleep(500);
        }
        
        System.out.print("\r\u001B[2K             VALENDO!\n\n");

        Corrida.imprimirPainelInicial();

        Thread thread = new Thread(schumacher, "Schumi");
        Thread thread1 = new Thread(senna, "GOAT");
        Thread thread2 = new Thread(barrichello, "Vice");
        
        thread.start();
        thread1.start();
        thread2.start();

        thread.join();
        thread1.join();
        thread2.join();

        Corrida.imprimirPodio();
        System.out.println("\n=== CORRIDA ENCERRADA! ===");
        System.out.println("🏁 Todos os pilotos cruzaram a linha de chegada!\n");
    }
}