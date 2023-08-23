import java.util.Random;
import java.util.Scanner;

public class NumberGuessingGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int lowerBound = 0;
        int upperBound = 100;
        int randomNumber = random.nextInt(upperBound);
        int maxAttempts = 10;
        int score = 0;

        System.out.println("Welcome to the Number Guessing Game!");
        System.out.println("I'm thinking of a number between " + lowerBound + " and " +( upperBound-1));
        System.out.println("You have " + maxAttempts + " attempts.");

        for (int attempts = 1; attempts <= maxAttempts; attempts++) {
            System.out.print("Attempt " + attempts + ": Enter your guess: ");
            int userGuess = scanner.nextInt();

            if (userGuess == randomNumber) {
                System.out.println("Congratulations! You guessed the number " + randomNumber + " in " + attempts + " attempts.");
                score = maxAttempts - attempts + 1;
                break;
            } else if (userGuess < randomNumber) {
                System.out.println("Your guess is too low. Try again.");
            } else {
                System.out.println("Your guess is too high. Try again.");
            }
        }

        if (score > 0) {
            System.out.println("Your score: " + score);
        } else {
            System.out.println("Sorry, you couldn't guess the number. The correct number was " + randomNumber);
        }

        scanner.close();
    }
}
