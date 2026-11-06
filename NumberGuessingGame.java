
import java.util.Scanner;
import java.util.Random;

public class NumberGuessingGame {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        int number = random.nextInt(100) + 1;
        int guess;
        int attempts = 0;

        System.out.println("====================================");
        System.out.println("       🎮 NUMBER GUESSING GAME");
        System.out.println("====================================");
        System.out.println("Welcome, Player! 🌟");
        System.out.println("A secret number has been generated.");
        System.out.println("Your challenge is to guess the number!");
        System.out.println("Enter a number between 1 and 100.");
        System.out.println("------------------------------------");

        do {
            System.out.print("👉 Enter your guess: ");
            guess = sc.nextInt();
            attempts++;

            if (guess < number) {
                System.out.println("📉 Too Low!");
                System.out.println("💪 Great effort! Don't give up.");
                System.out.println("✨ Believe in yourself. You're getting closer!");
            }

            else if (guess > number) {
                System.out.println("📈 Too High!");
                System.out.println("🔥 Keep going! Every attempt brings you closer.");
                System.out.println("🌟 Stay focused. You've got this!");
            }

            else {
                System.out.println("\n🎉 CONGRATULATIONS! 🎉");
                System.out.println("🏆 Excellent work! You guessed the correct number!");
                System.out.println("👏 Your determination made it possible!");
                System.out.println("🎯 Total Attempts: " + attempts);
                System.out.println("🌟 Never stop believing in yourself!");
            }

            System.out.println("------------------------------------");

        } while (guess != number);

        System.out.println("Thank you for playing! 😊");
        System.out.println("====================================");

        sc.close();
    }
}
