package atividade.models;

public class GeometriaPlana {
    private Figuras2D fig;

    public void mudarParaCirculo() {
        fig = new Circulo();
    }

    public void mudarParaQuadrado() {
        fig = new Quadrado();
    }

    public void mudarParaTriangulo() {
        fig = new Triangulo();
    }

    public String pegaTexto() {
        return fig.pegaTexto();
    }

    public String exibe() {
        return fig.pegaTexto();
    }
}
