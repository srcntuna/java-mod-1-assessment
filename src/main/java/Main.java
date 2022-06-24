import java.util.Random;
import java.util.Scanner;

public class Main {

    // Game level explanations
    public static String[] levelExps = {
            "Program will tell you if it was higher or equal (you win) or lower (computer wins) than the program's number.",
            "Program will tell you if it was strictly higher (you win) or lower or equal (computer wins) than the program's number.",
            "Program will tell you if it was equal (you win) or not (you lose) to the program's number. "
    };

    public static void main(String[] args) {

        // prints the greeting message and game levels for user to choose
        printGreeting();

        // try with resources to generate a scanner object to get user input
        try (Scanner scanner = new Scanner(System.in)) {
            int inputLevel;
            int inputNum;

            // loop will continue untill user provides correct input;
            while (true) {

                String inputString = scanner.nextLine();
                inputLevel = levelExplain(inputString);

                // user choose to exit the program
                if (inputLevel == 3) {
                    System.out.println("Goodbye!");
                    return;

                    // if user provides a out of range input or a wrong type input
                } else if (inputLevel == 5) {
                    System.out.println("Please type correct number for options!");

                    // if user types correct input for easy to hard levels loop ends
                } else {
                    break;
                }
            }
            System.out.println("Level Details: ");
            System.out.println(levelExps[inputLevel]);

            // loop will continue untill user provides correct input within range;
            while (true) {
                System.out.println("Choose a number between 0 to 10 inclusively: ");
                String guessedNum = scanner.nextLine();
                inputNum = checkNum(guessedNum);

                // if user provides a wrong type input
                if (inputNum == 11) {
                    System.out.println("You did not provide a number!");

                    // if user provides a out of range input
                } else if (inputNum == 12) {
                    System.out.println("Your number is out of range!");
                }
                // if user types correct input within range
                else {

                    // checks who is the winner
                    // input is plus one because initially this is following array index numbers, to
                    // prevent confusion in checkWinner function
                    checkWinner(inputLevel + 1, inputNum);
                    System.out.println("Do you want to replay the game: (y/n)");
                    String answer = scanner.nextLine();

                    // if user wants to replay the game
                    if (answer.equals("y")) {
                        mainCaller();
                    }

                    // if user does not want to replay the game
                    {
                        System.out.println("Goodbye!");
                        return;
                    }

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Computer generates random number within range

    public static int generateNumber() {

        Random randomNum = new Random();

        return randomNum.nextInt(11);

    }

    // greeting message and options

    public static void printGreeting() {

        System.out.println("Welcome To Guess A Number Game!");
        System.out.println(" --------- Levels ---------- ");
        System.out.println("|  1.    Easy               |");
        System.out.println("|  2.    Medium             |");
        System.out.println("|  3.    Hard               |");
        System.out.println("|  4.    Exit Program       |");
        System.out.println(" ---------------------------  ");
        System.out.print("Please choose a level:");

    }

    public static void checkWinner(int level, int guessedNum) {

        int generatedNum = generateNumber();

        // if user choose EASY Level
        if (level == 1) {
            if (guessedNum >= generatedNum) {
                System.out.println("You Won!");
            } else {
                System.out.println("Sorry, Computer Won!");
            }

            // if user choose MEDIUM Level
        } else if (level == 2) {
            if (guessedNum > generatedNum) {
                System.out.println("You Won!");
            } else {
                System.out.println("Sorry, Computer Won!");
            }

            // if user choose HARD Level
        } else {
            if (guessedNum == generatedNum) {
                System.out.println("You Won!");
            } else {
                System.out.println("Sorry, Computer Won!");
            }
        }

    }

    // Checks input num if it is are out of range or not a number;

    public static int checkNum(String num) {
        try {
            int guessedNum = Integer.parseInt(num);
            if (guessedNum < 0 || guessedNum > 10) {
                throw new IllegalArgumentException();
            }
            return guessedNum;
        } catch (NumberFormatException e) {
            return 11;
        } catch (IllegalArgumentException e) {
            return 12;
        }
    }

    // Checks input level for game levels if it is are out of range or not a number;
    public static int levelExplain(String sampleString) {
        try {
            int index = Integer.parseInt(sampleString) - 1;
            if (index < 0 || index > 3) {
                throw new IllegalArgumentException();
            }

            return index;

        } catch (Exception e) {
            return 5;
        }
    }

    // calls main function in case user wants to replay the game
    public static void mainCaller() {
        main(null);
    }

}
