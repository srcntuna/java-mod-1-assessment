# Module 1 Project Guidelines

## Overview

Console application with user input loop of user-defined length (e.g. "how many
books would you like to buy?") that can replay the user's input to the user on
demand or when the user input loop is done

## Project Brief

Create a simple game that asks the user to guess a number between 0 and 10 and
tells the user whether they "won"

### Requirements

- The system must ask the user for an integer between 0 and 10.
- The system must generate a random number between 0 and 10.
- If the user's number is greater than the system's generated number, then
  the user wins.
- Otherwise, the system wins.
- The system must inform the user who won.
- The system must display an error message if the user's input is not in the
  desired range.
- The system must display an error message if the user's input is not a
  number.
- Let the user choose game "level" - tell the user what each level means:
  - Easy: guess a number - program will tell you if it was higher or equal
    (you win) or lower (computer wins) than the program's number.
  - Medium: guess a number - program will tell you if it was strictly higher
    (you win) or lower or equal (computer wins) than the program's number.
  - Hard: guess a number - program will tell you if it was equal (you win)
    or not (you lose) to the program's number.
  - Store each game level “explanation message” in an array and use the
    level indicated by the user to index into the array.

### Stretch goals

- Let the user choose the lower and upper bound (positive numbers) for the game
  (i.e. make 0 and 10 user-definable)
- Include negative numbers
- Display an ascii graphic art to let the user know the result of the game

## Getting Started

- Create a class that will contain all the logic for your game
- You need to be able to run this class, so make sure it has a
  `public static void main()`method
- Separate the different aspects of your game into their own methods

## Sample Code

- Start by creating a runnable class:

```java
public class StudentGame {
    public static void main(String[] args) {
        System.out.println("Running...");
    }
}
```

- Create a method for each separate piece of logic for your game, e.g. your game
  must generate a random number, so it will need a `generateRandomNumber()`
  method:

```java
public int generateRandomNumber() {
}
```

## Reminders

- Use existing built-in Java functions where possible.
- The `Scanner` class has useful functionality for getting input from the user.
- The `Random` class has useful functionality for generating random numbers.
