package banco;

public class Categoria {
    public static int defineCategoria(int meses) {
        if (meses >= 1 && meses <= 12) {
            return 1; // até 12 meses
        } else if (meses >= 13 && meses <= 24) {
            return 2; // de 13 a 24 meses
        } else if (meses > 24) {
            return 3; // mais de 24 meses
        } else {
            return 0; // caso de meses negativos ou 0
        }
    }
}