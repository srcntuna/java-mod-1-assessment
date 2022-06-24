import java.util.Random;
import java.util.Scanner;

public class GuessGame {

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
            boolean isNumber;
            int selectedOption;
            int selectedLowerBound;
            int selectedUpperBound;
            int guessedNum;

            // loop will continue untill user provides correct input;
            while (true) {

                String inputString = scanner.nextLine();
                isNumber = isNumber(inputString);
                if (isNumber) {
                    selectedOption = Integer.parseInt(inputString);
                    // user choose to exit the program
                    if (selectedOption == 4) {
                        System.out.println("Goodbye!");
                        return;
                        // if user types a number out of options range
                    } else if (selectedOption < 1 || selectedOption > 4) {
                        System.out.println(
                                "You are bad at typing from 1 to 4. Please type a number within options range!");
                    } else {
                        // if user choose any option from easy to hard level , loop breaks and thread of
                        // execution goes to next line after loop
                        break;
                    }

                    // if user types a wrong type input
                } else {
                    System.out.println("Please type a number for options!");
                    // if user types correct input for easy to hard levels loop ends
                }
            }
            System.out.println("Level Details: ");
            // Logs the explanation from levelExps array
            System.out.println(levelExps[selectedOption - 1]);
            System.out.println("Action:");
            System.out.println("You are expected to choose boundries for your range now...");

            // loop will continue untill user provides correct input within range;
            while (true) {

                System.out.print("Please choose a lower bound for range: ");
                String lowerBoundNum = scanner.nextLine();
                // check if it is a number input
                isNumber = isNumber(lowerBoundNum);
                // if it is a number, user can choose the upper bound now
                if (isNumber) {

                    System.out.print(
                            "Please choose a upper bound for range now. Make sure it is greater than your lower bound! ");

                    // loop will continue untill user provides correct input within range;
                    while (true) {

                        String upperBoundNum = scanner.nextLine();

                        // check if it is a number input
                        isNumber = isNumber(upperBoundNum);

                        // if it is a number
                        if (isNumber) {
                            selectedLowerBound = Integer.parseInt(lowerBoundNum);
                            selectedUpperBound = Integer.parseInt(upperBoundNum);
                            // checks if the input Upper bound is greater than the lower bound
                            boolean isGreaterUpperBound = isUpperBound(selectedUpperBound, selectedLowerBound);
                            // if greater and then loops breaks
                            if (isGreaterUpperBound) {
                                break;
                                // if it is not greater, user is requested to retype a number for upper bound;
                            } else {
                                System.out.println(
                                        "Your input for upper bound is not greater than lower bound . Make sure you type a greater number for upper bound!");
                            }
                            // if it is not a number
                        } else {
                            System.out.println("Make sure you type a number for upper bound!");
                        }
                    }
                    break;
                    // if it is not a number
                } else {
                    System.out.println("Make sure you type a number for lower bound!");
                }

            }

            System.out.println("Choose a number between " + selectedLowerBound + " to " + selectedUpperBound
                    + " inclusively: ");

            // loop will continue untill user provides correct input within range;
            while (true) {

                String guessedNumInput = scanner.nextLine();

                isNumber = isNumber(guessedNumInput);

                // if it is a number
                if (isNumber) {
                    guessedNum = Integer.parseInt(guessedNumInput);
                    boolean isOutBounds = isOutOfRange(guessedNum, selectedLowerBound, selectedUpperBound);

                    // if guessedNum is out of bounds
                    if (isOutBounds) {
                        System.out.println("Your number is out of range! Type a number within range!");
                        // if guessedNum is in bounds then loops breaks
                    } else {
                        break;
                    }
                }
                // if user provides a wrong type input
                else {
                    System.out.println("You did not provide a number! Type a number within range!");
                }
            }

            // checks who is the winner

            checkWinner(selectedOption, guessedNum, selectedLowerBound, selectedUpperBound);
            System.out.println("Do you want to replay the game: (y/n)");
            String answer = scanner.nextLine();

            // if user wants to replay the game
            if (answer.equals("y")) {
                mainCaller();
            }
            // if user does not want to replay the game
            else {
                System.out.println("Goodbye!");
                return;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Computer generates random number within range

    public static int generateNumber(int lowerBound, int upperBound) {

        Random randomNum = new Random();

        return randomNum.nextInt((upperBound - lowerBound) + 1) + lowerBound;

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

    // checks Winner
    public static void checkWinner(int level, int guessedNum, int lowerBound, int upperBound) {

        int generatedNum = generateNumber(lowerBound, upperBound);

        // if user choose EASY Level
        if (level == 1) {
            if (guessedNum >= generatedNum) {
                System.out.println("Congratulations! You Won!");

            } else {
                System.out.println("Sorry, Computer Won!");
            }

            // if user choose MEDIUM Level
        } else if (level == 2) {
            if (guessedNum > generatedNum) {
                System.out.println("Congratulations! You Won!");
            } else {
                System.out.println("Sorry, Computer Won!");
            }

            // if user choose HARD Level
        } else {
            if (guessedNum == generatedNum) {
                System.out.println("Congratulations! You Won!");
            } else {
                System.out.println("Sorry, Computer Won!");
            }
        }

        System.out.println("Your Number: " + guessedNum + " Computer's Number: " + generatedNum);

    }

    // Checks if input is a number;
    public static boolean isNumber(String inputNum) {
        try {
            int result = Integer.parseInt(inputNum);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Checks if input is out of range;

    public static boolean isOutOfRange(int inputNumber, int lowerBound, int upperBound) {

        if (inputNumber < lowerBound || inputNumber > upperBound) {
            return true;
        }

        return false;
    }

    // Checks if input for Upper bound is greater than previously chosen lower bound
    public static boolean isUpperBound(int inputUpperBound, int lowerBound) {

        if (inputUpperBound > lowerBound) {
            return true;
        }
        return false;
    }

    // calls main function in case user wants to replay the game
    public static void mainCaller() {
        main(null);
    }

}
