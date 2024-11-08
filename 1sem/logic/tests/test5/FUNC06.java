// FUNC06 - Calcular o peso ideal de uma pessoa
// Faça uma função que recebe, por parâmetro, a altura (double) e o sexo (char) de uma pessoa e retorna o seu peso ideal. Para homens, o cálculo do peso ideal utiliza a fórmula : peso ideal = (72.7 x altura) - 58 e, para mulheres, peso ideal = (62.1 x altura) - 44.7.
// Faça o programa que utilize a função, ele deverá receber a altura e o peso, utilizar a função e retornar a resposta, conforme a tabela acima.
// (Obrigatório a utilização de funções)
//dica : comando para ler um char : s.next().charAt(0);

import java.util.Scanner;

public class FUNC06 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double altura = s.nextDouble();
        char sexo = s.next().charAt(0);
        System.out.printf("%.2f\n", CalcIMC(altura, sexo));

        s.close();
    }

    public static double CalcIMC(double altura, char sexo) {
        double result = 0;

        if (sexo == 'M' || sexo == 'm')
            result = CalcPesoHomem(altura);
        if (sexo == 'F' || sexo == 'f')
            result = CalcPesoMulher(altura);

        return result;
    }

    public static double CalcPesoHomem(double altura) {
        double peso = 0;
        peso = (72.7 * altura) - 58;
        return peso;
    }

    public static double CalcPesoMulher(double altura) {
        double peso = 0;
        peso = (62.1 * altura) - 44.7;
        return peso;
    }
}
