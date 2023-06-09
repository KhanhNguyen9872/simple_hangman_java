import java.util.Scanner;
import game.*;

public class Main {
    public static void main(String[] args) {
        int score = 6;
        Scanner input = new Scanner(System.in);
        System.out.print(" Welcome to Hangman!\n Press 'Y' and Enter to start the game!\n Choose: ");
        char userinp = input.nextLine().charAt(0);
        if ((userinp == 'Y') || (userinp == 'y')) {
            hangman.run(score);
        }
    }
    
}
