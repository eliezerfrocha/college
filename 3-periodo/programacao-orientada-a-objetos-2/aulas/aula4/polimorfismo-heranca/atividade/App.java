package atividade;

import atividade.models.*;

public class App {
    public static void main(String[] args) {
        GeometriaPlana geo = new GeometriaPlana();
        System.err.println("\nExibindo a figura inicial:\n");

        // Mudando a figura para um círculo
        geo.mudarParaCirculo();
        System.out.println(geo.exibe());

        // Mudando a figura para um quadrado
        geo.mudarParaQuadrado();
        System.out.println(geo.exibe());

        // Mudando a figura para um triângulo
        geo.mudarParaTriangulo();
        System.out.println(geo.exibe());

        Figuras2D fig[] = new Figuras2D[3];
        // Criando as figuras
        fig[0] = new Circulo();
        fig[1] = new Quadrado();
        fig[2] = new Triangulo();

        // Exibindo as figuras
        System.out.println("\nExibindo as figuras do vetor:\n");
        for (int i = 0; i < fig.length; i++) {
            System.out.println(fig[i].pegaTexto());
        }
    }
}