package src.GuessGame;

import java.util.Scanner;

class Game {
    private int randomNumber;
    private final int maxRange;
    private int numberOfAttempts;

    // Game constructor
    public Game(int maxRange, int numberOfAttempts) {
        this.maxRange = maxRange;
        this.numberOfAttempts = numberOfAttempts;
        generateRandomNumber();
    }

    private void generateRandomNumber() {
        randomNumber = (int) (Math.random() * maxRange) + 1; // Returning a number between 1 and max range
    }

    public boolean guessNumber(int guess) {
        numberOfAttempts--;
        if (guess == randomNumber) {
            System.out.println("Congratulations! You guessed the correct number.");
            return true;
        } else if (guess < randomNumber) {
            System.out.println("Try a higher number. Attempts left: " + numberOfAttempts);
        } else {
            System.out.println("Try a lower number. Attempts left: " + numberOfAttempts);
        }
        return false;
    }

    public boolean isGameOver() {
        return numberOfAttempts <= 0;
    }

    // Getter/Accessor
    public int getNumber() {
        return randomNumber;
    }

}

// Inheritance: Derived class (Player) inherits attributes and methods from the base class (Object).
class Player extends Game {
    private final String playerName;

    // Player constructor
    public Player(String playerName, int maxRange, int numberOfAttempts) {
        super(maxRange, numberOfAttempts);
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }
}

public class GuessTheNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Guessing Game!");

        System.out.print("Enter your name: ");
        String playerName = scanner.nextLine();

        System.out.print("Enter the maximum range for the guessing game: ");
        int maxRange = scanner.nextInt();

        System.out.print("Enter the number of attempts: ");
        int numberOfAttempts = scanner.nextInt();

        Player player = new Player(playerName, maxRange, numberOfAttempts);

        while (!player.isGameOver()) {
            System.out.print("Guess the number between 1 and " + maxRange + ": ");
            int guess = scanner.nextInt();
            if (player.guessNumber(guess)) {
                break;
            }
        }

        System.out.println("Game over! The correct number was: " + player.getNumber());
        scanner.close();
    }
}