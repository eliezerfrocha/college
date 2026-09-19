import java.util.Scanner;
/**
 * 1046 - GameTime
 *  Read the start time and end time of a game, in hours. Then calculate the duration of the game, knowing that the game can begin in a day and finish in another day, with a maximum duration of 24 hours. The message must be printed in portuguese “O JOGO DUROU X HORA(S)” that means “THE GAME LASTED X HOUR(S)”

    Input:
    Two integer numbers representing the start and end time of a game.
    -
    Output:
    Print the duration of the game as in the sample output.
 */
public class GameTime {
    public static void main(String[] args) {
        System.out.println();
        Scanner s = new Scanner(System.in);

        int tDay = 24;
        int tStart = s.nextInt();
        int tEnd = s.nextInt();

        s.close();

        if (tStart > tEnd) {
            System.out.println("O JOGO DUROU " + (tDay - (tStart - tEnd)) + " HORA(S)");
        } else if (tEnd > tStart) {
            System.out.println("O JOGO DUROU " + (tEnd - tStart) + " HORA(S)");
        } else {
            System.out.println("O JOGO DUROU " + tDay + " HORA(S)");
        }

        System.out.println();
    }
}
