package ex2;

public class EGrau2 {
    public double a, b, c;

    //-> Construtor
    public EGrau2 (double n1, double n2, double n3) {
        this.a = n1;
        this.b = n2;
        this.c = n3;
    }

    public double CalculaDelta(double a, double b, double c) {
        double delta = Math.pow(b,2) - 4 * a * c;
        return delta;
    }

    public double CalculaX1(double delta) {
        double x1 = (-b + Math.sqrt(delta)) / (2 * a);
        return x1;
    }

    public double CalculaX2(double delta) {
        double x2 = (-b - Math.sqrt(delta)) / (2 * a);
        return x2;
    }
}
