/**
 * beecrowd | 5215
REC06 - Corrigir funcao recursiva ff
By BRUNO QUEIROZ PINTO,   Brazil
Timelimit: 1
Localize o(s) erro(s) na função recursiva abaixo e corrige-a. Indique, através de comentários, a linha onde ocorre o erro, explique qual regra não foi atendida e uma possível solução para o erro (como não há uma definição do problema podemos ter várias modificações possíveis).
funcao recursiva original com defeito:

private static int funcaoFF(int n) {
        if (n == 1){
            return funcaoFF(n-1);
        }else if (n % 2 == 0){
            return funcaoFF(n/2);
        }else {
            return funcaoFF((n-1)/2) + funcaoFF((n+1)/2);
        }      
    }
A função principal está correta e não precisa sofrer modificações:
public static void main(String[] args) throws IOException {
 Scanner s = new Scanner(System.in);
 int n = s.nextInt();
 System.out.println("ff(" + n + ") = " + funcaoFF(n));
 s.close();
}

Regras:
Todos as funções recursivas devem obedecer a três leis importantes:
Uma função recursiva deve ter um caso base / caso da parada (condição no qual não haverá mais chamadas recursivas);
Uma função recursiva deve mudar o seu estado(parâmetros) e se aproximar do caso base (condição no qual o algoritmo para);
Uma função recursiva deve chamar a si mesmo, recursivamente.

Entrada
Um valor inteiro n.

Saída
Resultado conforme tabela abaixo
Samples Input	Samples Output
-10
ff(-10) = 1
135
ff(135) = 16
1
ff(1) = 1
2
ff(2) = 1
 */

import java.util.Scanner;

public class REC06CorrigirFuncaoRecursivaFF {
    // => Funcão original com comentários.
    // private static int funcaoFF(int n) {
    // if (n == 1){
    // // Erro: O caso base deveria retornar um valor e não chamar a função
    // novamente.
    // // Como n == 1, não se pode chamar a função recursivamente com n-1, isso gera
    // uma chamada infinita.
    // return funcaoFF(n-1);
    // } else if (n % 2 == 0){
    // return funcaoFF(n/2);
    // } else {
    // return funcaoFF((n-1)/2) + funcaoFF((n+1)/2);
    // }
    // }

    // => Correção da função.
    private static int funcaoFF(int n) {
        if (n == 1 || n <= 0) {
            // Solução: Caso base deve retornar 1 para parar a recursão.
            return 1;
        } else if (n % 2 == 0) {
            return funcaoFF(n / 2);
        } else {
            return funcaoFF((n - 1) / 2) + funcaoFF((n + 1) / 2);
        }
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("ff(" + n + ") = " + funcaoFF(n));
        s.close();
    }
}
