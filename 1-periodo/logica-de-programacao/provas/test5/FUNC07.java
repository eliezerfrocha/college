// FUNC07 - Realizar calculos em vetores
// Leia dois vetores de inteiros x e y, cada um com n elementos. Calcule e mostre os vetores resultantes em cada caso abaixo:
// Soma entre x e y : soma de cada elemento de x com o elemento da mesma posição em y. Gerará o vetor soma e o imprimirá através da função imprimirVetor.
// Produto entre x e y : multiplicação de cada elemento de x com o elemento da mesma posição em y. Gerará o vetor produto e o imprimirá através da função imprimirVetor.
// Obs: No programa em java deverão ser criadas no mínimo 3 funções. Sugestões de funções preencherVetor, imprimirVetor, somaVetor e multiplicaVetor. Ao final, utilize a função imprimeVetor para imprimir o vetor soma e o vetor produto.
// (Obrigatório a utilização de funções)

import java.util.Scanner;

public class FUNC07 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();

        int[] arrSoma = new int[N];
        int[] arrMultiplicacao = new int[N];

        // Entradas
        for (int i = 0; i < N; i++) {
            arrSoma[i] = s.nextInt();
        }
        for (int i = 0; i < N; i++) {
            arrMultiplicacao[i] = s.nextInt();
        }

        // Chamada de func
        int[] arrResultadoSoma = SomaVetores(arrMultiplicacao, arrSoma, N);
        int[] arrResultadoProduto = MultiplicaVetores(arrMultiplicacao, arrSoma, N);

        // Printa Soma
        System.out.print("Soma : {");

        for (int i = 0; i < arrResultadoSoma.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arrResultadoSoma[i]);
        }

        System.out.println("}");

        // Print Produto
        System.out.print("Produto : {");

        for (int i = 0; i < arrResultadoProduto.length; i++) {
            if (i != 0) {
                System.out.print(", ");
            }
            System.out.print(arrResultadoProduto[i]);
        }

        System.out.println("}");
    }

    // SomaVetores
    public static int[] SomaVetores(int[] arr1, int[] arr2, int N) {
        int[] arrRetorno = new int[N];

        for (int i = 0; i < N; i++) {
            arrRetorno[i] = arr1[i] + arr2[i];
        }

        return arrRetorno;
    }

    // Multiplica Vetores
    public static int[] MultiplicaVetores(int[] arr1, int[] arr2, int N) {
        int[] arrRetorno = new int[N];

        for (int i = 0; i < N; i++) {
            arrRetorno[i] = arr1[i] * arr2[i];
        }

        return arrRetorno;
    }
}
