import java.util.Scanner;

public class LeituraTeclado implements Runnable {
    private StringBuffer textodigitado;

    public LeituraTeclado(StringBuffer textodigitado) {
        this.textodigitado = textodigitado;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            synchronized (textodigitado) {
                textodigitado.append(input).append("\n");
            }
        }
    }   
}
