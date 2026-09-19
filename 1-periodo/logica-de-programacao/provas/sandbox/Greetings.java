import java.util.Scanner;

public class Greetings {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        System.out.print("> Hello my name is Java.");
        s.nextLine();
        
        System.out.println("> What is yours?");
        System.out.print("> ");
        String name = s.nextLine();

        System.out.printf("\n> Nice to meet you %s\n", name);

        Runtime.Version version = Runtime.version();
        System.out.printf("> My current version is: %s", version);
        
        System.out.println();
        System.out.println();
    }
}
