import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        System.out.println();

        Scanner s = new Scanner(System.in);
        String str = "", reverse = "";
        char ch;

        System.out.print("Digit a word: ");
        str = s.nextLine();

        System.out.print("\nOriginal word: " + str);

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
            reverse = ch + reverse;
        }

        System.out.print("\nReverse word: " + reverse);  

        System.out.println();
        System.out.println();
    }
}
