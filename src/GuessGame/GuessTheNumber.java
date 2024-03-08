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
            System.out.println("Try a higher number. Attempts left" + numberOfAttempts);
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