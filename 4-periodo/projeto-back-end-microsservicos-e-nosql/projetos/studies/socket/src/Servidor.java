import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;

public class Servidor {
    private String host;
    private int port;
    private Integer backlog;

    public Servidor(String host, int port, Integer backlog) {
        this.host = host;
        this.port = port;
        this.backlog = backlog;
    }

    public void connect() {
        try (ServerSocket serverSocket = new ServerSocket(port, backlog, InetAddress.getByName(host))) {
            System.out.println("\nServer status:");
            System.out.println("> Server is listening on port: " + port);

            try (java.net.Socket clientSocket = serverSocket.accept();
                 DataInputStream input = new DataInputStream(clientSocket.getInputStream());
                 DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream())) {
                System.out.println("> Client connected from: " + clientSocket.getInetAddress().getHostAddress());

                while (true) {
                    String message = input.readUTF();
                    System.out.println("> Received message from client: " + message);
                    output.writeUTF("Servidor recebeu: " + message);
                    output.flush();

                    if (message.equalsIgnoreCase("/sair")) {
                        break;
                    }
                }
            }
        }
        catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}