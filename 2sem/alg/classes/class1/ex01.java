package aula01;

import java.util.Scanner;

public class ex01 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        double n1 = s.nextDouble();
        double n2 = s.nextDouble();
        
        System.out.println(encontrarMaior(n1, n2));

        s.close();
    }

    public static double encontrarMaior(double n1, double n2) {
        if (n1 > n2) {
            return n1;
        } else {
            return n2;
        }
    }
}
