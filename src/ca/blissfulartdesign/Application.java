package ca.blissfulartdesign;

import java.util.Scanner;
public class Application {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        do {
            Player player1 = new Player();
            Scanner input = new Scanner(System.in);
            do {
                System.out.print(player1.charSheet());
                System.out.println("Are you pleased with this character? (Y/N): ");
                char yesNo = input.next().trim().charAt(0);
                if (yesNo == 'Y' || yesNo == 'y') {
                    i = 0;
                    j = 0;
                } else if (yesNo == 'N' || yesNo == 'n') {
                    player1.statGen();
                }
            } while (j == 1) ;
        } while (i == 1);
    }
}