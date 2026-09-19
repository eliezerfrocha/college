package lists.list3.etapa3;

public class Validacao {
    public static boolean valida(double x1, double y1, double x2, double y2) {
        // Verifica se os pontos são distintos
        return x1 != x2 || y1 != y2;
    }

    public static boolean isQuadOne(double x1, double y1, double x2, double y2) {
        // Verifica se as coordenadas estão no primeiro quadrante
        return x1 >= 0 && y1 >= 0 && x2 >= 0 && y2 >= 0;
    }
}
