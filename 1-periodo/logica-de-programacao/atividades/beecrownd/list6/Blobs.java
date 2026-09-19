import java.util.Scanner;

public class Blobs {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        int N = s.nextInt();
        double[] arrayComida = new double[N];
        int[] arrayDias = new int[N];

        for (int i = 0; i < N; i++) {
            arrayComida[i] = s.nextDouble();
            int dias = 0;

            while (arrayComida[i] > 1.0) {
                arrayComida[i] /= 2.0;
                dias++;
            }

            arrayDias[i] = dias;
        }

        for (int i = 0; i < N; i++) {
            System.out.println(arrayDias[i] + " dias");
        }

        s.close();
    }
}
