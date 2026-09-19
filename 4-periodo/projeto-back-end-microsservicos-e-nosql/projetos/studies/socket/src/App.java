public class App {
    public static void main(String[] args) throws InterruptedException {
        String host = "localhost";
        int port = 8080;
        int backlog = 50;
        Servidor servidor = new Servidor(host, port, backlog);
        Thread servidorThread = new Thread(servidor::connect);
        servidorThread.start();
        Thread.sleep(100);
        Client client = new Client(host, port);
        client.sendMessage();
        servidorThread.join();
    }
}
