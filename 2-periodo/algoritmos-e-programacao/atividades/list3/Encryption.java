package lists.list3;

import java.util.Scanner;

public class Encryption {

    // Function to encrypt a single line of text
    public static String encryptLine(String line) {
        // First step: Shift each character by 3 positions in ASCII
        char[] shifted = new char[line.length()];
        for (int i = 0; i < line.length(); i++) {
            shifted[i] = (char)(line.charAt(i) + 3);
        }

        // Second step: Reverse the shifted string manually
        // Reverse the shifted array in place
        for (int i = 0; i < shifted.length / 2; i++) {
            char temp = shifted[i];
            shifted[i] = shifted[shifted.length - 1 - i];
            shifted[shifted.length - 1 - i] = temp;
        }

        // Third step: Shift the second half of the reversed string by 1 position to the left in ASCII
        int mid = shifted.length / 2;
        for (int i = mid; i < shifted.length; i++) {
            shifted[i] = (char)(shifted[i] - 1);
        }

        // Convert the char array back to a string
        return new String(shifted);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of test cases
        int N = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left after reading N

        // Process each test case
        for (int i = 0; i < N; i++) {
            String line = scanner.nextLine();
            String encrypted = encryptLine(line);
            System.out.println(encrypted);
        }

        scanner.close();
    }
}
