import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    private String host;
    private int port;
    
    public Client(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void sendMessage() {
        try (Socket connection = new Socket(host, port);
             DataInputStream input = new DataInputStream(connection.getInputStream());
             DataOutputStream output = new DataOutputStream(connection.getOutputStream())) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite uma mensagem ou /sair para encerrar:");

            while (scanner.hasNextLine()) {
                String message = scanner.nextLine();
                output.writeUTF(message);
                output.flush();

                System.out.println("> " + input.readUTF());

                if (message.equalsIgnoreCase("/sair")) {
                    break;
                }
            }

            // Exemplo de envio de uma única mensagem sem leitura pelo teclado:
            // output.writeUTF("Hello from client!");
            // String message = input.readUTF();
            // System.out.println("> Received message from server: " + message);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
