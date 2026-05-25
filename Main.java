import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int totalScore = 0;
        boolean playAgain = true;

        System.out.println("===== Welcome to the Number Game =====");

        while (playAgain) {

            int number = random.nextInt(100) + 1;
            int attemptsLeft = 7;
            boolean guessedCorrectly = false;

            System.out.println("\nI have generated a number between 1 and 100.");
            System.out.println("You have " + attemptsLeft + " attempts.");

            while (attemptsLeft > 0) {

                System.out.print("Enter your guess: ");

                // Check if input is integer
                if (!sc.hasNextInt()) {
                    System.out.println("Please enter a valid number.");
                    sc.next(); // remove invalid input
                    continue;
                }

                int guess = sc.nextInt();

                if (guess == number) {

                    System.out.println("Correct! You guessed the number.");
                    guessedCorrectly = true;

                    int roundScore = attemptsLeft * 10;
                    totalScore += roundScore;

                    System.out.println("You scored: " + roundScore);
                    break;

                } else if (guess > number) {

                    System.out.println("Too high!");

                } else {

                    System.out.println("Too low!");
                }

                attemptsLeft--;

                if (attemptsLeft > 0) {
                    System.out.println("Attempts left: " + attemptsLeft);
                }
            }

            if (!guessedCorrectly) {
                System.out.println("\nYou lost!");
                System.out.println("The correct number was: " + number);
            }

            System.out.println("Total Score: " + totalScore);

            System.out.print("\nDo you want to play again? (yes/no): ");
            String choice = sc.next();

            if (!choice.equalsIgnoreCase("yes")) {
                playAgain = false;
            }
        }

        System.out.println("\n===== Game Over =====");
        System.out.println("Final Score: " + totalScore);

        sc.close();
    }
}