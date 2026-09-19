import java.util.Scanner;

public class Bondinho {
    public static void main(String[] args) {
        System.out.println();
        
        Scanner s = new Scanner(System.in);
        int limite = 50;

        int alunos = s.nextInt();
        int monitores = s.nextInt();
        
        if ((alunos + monitores) <= limite) {
            System.out.println("S");
        } else {
            System.out.println("N");
        }

        System.out.println();
    }
}
