import java.util.Scanner;

public class AlarmClock {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            // Ler os valores de H1, M1, H2 e M2
            int H1 = scanner.nextInt();
            int M1 = scanner.nextInt();
            int H2 = scanner.nextInt();
            int M2 = scanner.nextInt();

            // Condição de parada
            if (H1 == 0 && M1 == 0 && H2 == 0 && M2 == 0) {
                break;
            }

            // Converter tudo para minutos
            int currentMinutes = H1 * 60 + M1;
            int alarmMinutes = H2 * 60 + M2;

            // Calcular a diferença de minutos
            int minutesToSleep;
            if (alarmMinutes >= currentMinutes) {
                minutesToSleep = alarmMinutes - currentMinutes;
            } else {
                minutesToSleep = (1440 - currentMinutes) + alarmMinutes;
            }

            // Imprimir o resultado
            System.out.println(minutesToSleep);
        }

        scanner.close();
    }
}
