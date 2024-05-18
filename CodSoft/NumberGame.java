package task1;

import java.util.Scanner;
import java.util.Random;

public class NumberGame {

    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        int randomNumber;
        int attempts = 5;
        int score;
        String playAgain = "start";

        while (playAgain.equals("yes") || playAgain.equals("start")) {
            System.out.println("===========================================================");
            System.out.println("                  Welcome to Number Game");
            System.out.println("===========================================================");

            randomNumber = random.nextInt(101);
            System.out.println("\nI've picked a number between 0 and 100. Can you guess it?");
            System.out.println("You have " + attempts + " attempts.");

            while (attempts > 0) {
                System.out.print("\nEnter your guess: ");
                int guess = scanner.nextInt();

                if (guess != randomNumber) {
                    attempts--;
                    System.out.println("Wrong guess!");
                    if (attempts > 0) {
                        System.out.println("Attempts left: " + attempts);
                        if (guess > randomNumber)
                            System.out.println("Hint: Too high");
                        else
                            System.out.println("Hint: Too low");
                    } else {
                        System.out.println("Game over! The correct number was: " + randomNumber);
                        break;
                    }
                } else {
                    score = calculateScore(attempts);
                    System.out.println("Congratulations! You guessed it right!");
                    System.out.println("Your score: " + score);
                    break;
                }
            }

            System.out.print("\nPlay again? (yes/no): ");
            playAgain = scanner.next().toLowerCase();
            attempts = 5;
        }
        scanner.close();
        System.out.println("\nThanks for playing!");
        System.out.println("========================================");
    }

    private static int calculateScore(int attemptsLeft) {
        return 100 - (5 - attemptsLeft) * 20;
    }
}
