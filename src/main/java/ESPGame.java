/*
* Class: CMSC203 CRN 30339
* Instructor: Grigoriy Grinberg
* Description: An ESP training game
* Due: 2/12/24
* Platform/compiler: Java/IntelliJ
* I pledge that I have completed the programming assignment
* independently. I have not copied the code from a student or
* any source. I have not given my code to any student.
* Print your Name here: Alexei Volkov
*/
import java.util.Scanner;
public class ESPGame {

    private static final String COLOR_RED = "Red";
    private static final String COLOR_GREEN = "Green";
    private static final String COLOR_BLUE = "Blue";
    private static final String COLOR_ORANGE = "Orange";
    private static final String COLOR_YELLOW = "Yellow";

    public static void main(String[] args){
        // Ask user for information about themselves
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = keyboard.nextLine();
        System.out.print("Describe yourself: ");
        String description = keyboard.nextLine();
        System.out.print("Due Date: ");
        String dueDate = keyboard.nextLine();

        System.out.println("CMSC203 Assignment #1: Test your ESP skills! ");
        int roundsWon = 0;

        for(int i = 1; i < 12; i++){
            System.out.println("Round " + i);
            // pick a random number 1-5
            int computerChoice = (int)(Math.random()*5) + 1;
            System.out.println("I am thinking of a number.");
            System.out.println("Is it Red, Green, Blue, Orange, or Yellow?");
            System.out.println("Enter your guess: ");
            int userChoice;
            // prompt user for a color until they enter a valid one
            do{
                String userColor = keyboard.nextLine();
                switch(userColor){
                    case(COLOR_RED):
                        userChoice = 1;
                        break;
                    case(COLOR_GREEN):
                        userChoice = 2;
                        break;
                    case(COLOR_BLUE):
                        userChoice = 3;
                        break;
                    case(COLOR_ORANGE):
                        userChoice = 4;
                        break;
                    case(COLOR_YELLOW):
                        userChoice = 5;
                        break;
                    default:
                        userChoice = -1;
                        System.out.println("You entered an incorrect color. Is it Red, Green, Blue, Orange, or Yellow? ");
                }
            }while(userChoice == -1);

            // match the computer's choice to a color
            String computerColor = "";
            switch(computerChoice){
                case(1):
                    computerColor = COLOR_RED;
                    break;
                case(2):
                    computerColor = COLOR_GREEN;
                    break;
                case(3):
                    computerColor = COLOR_BLUE;
                    break;
                case(4):
                    computerColor = COLOR_ORANGE;
                    break;
                case(5):
                    computerColor = COLOR_YELLOW;
                    break;
            }

            // if the computer and user had the same number (color) in mind
            if(computerChoice == userChoice){
                roundsWon++;
            }

            System.out.println("I was thinking of " + computerColor + ".");
        }

        // end game and say how many rounds were won, repeat user's info from beginning
        System.out.println("Game Over!");
        System.out.println("You guessed " + roundsWon + " out of 11 colors correctly.");
        System.out.println("Student Name: " + name);
        System.out.println("User Description: " + description);
        System.out.println("Due Date: " + dueDate);
    }
}
