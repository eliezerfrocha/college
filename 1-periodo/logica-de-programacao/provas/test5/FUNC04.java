//FUNC04 - Calcular volume de uma esfera
//Faça uma função que recebe por parâmetro o raio de uma esfera e calcula o seu volume , 
//onde  = 3.1416. Faça o programa que utilize a função, ele deverá receber o raio da esfera, utilizar a função e retornar a resposta, conforme a tabela acima.
//Obrigatório a utilização de funções)

import java.util.Scanner;

public class FUNC04 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Calculo volume.
        double num = s.nextDouble();
        System.out.printf("Volume : %.2f\n", CalcVolume(num));

        s.close();
    }

    public static double CalcVolume(double raio) {
        double result = 0;

        if (raio > 0) {
            double volume = 4 * Math.PI * Math.pow(raio, 3) / 3;
            result = volume;
        }

        return result;
    }
}
