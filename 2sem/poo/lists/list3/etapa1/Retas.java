package lists.list3.etapa1;

class Retas {
    private double x1, y1, x2, y2;

    public Retas(double x1, double x2, double y1, double y2) {
        this.x1 = x1;
        this.x2 = x2;
        this.y1 = y2;
        this.y2 = y2;
    }

    // -> metodos
    public double comprimento() {
        return Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
    }

    public String exibe() {
        return "\nReta: [(" + x1 + ", " + y1 + "), (" + x2 + ", " + y2 + ")] \nComprimento: " + comprimento();
    }
}