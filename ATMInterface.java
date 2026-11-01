
import java.util.Scanner;
import java.util.ArrayList;

public class ATMInterface {

    private static Scanner sc = new Scanner(System.in);

    private static BankAccount account =
            new BankAccount("Durgalakshmi", 1234, 5000.00);

    public static void main(String[] args) {

        System.out.println("================================");
        System.out.println("       WELCOME TO ATM");
        System.out.println("================================");

        if (!login()) {
            System.out.println("Account locked. Please try again later.");
            return;
        }

        int choice;

        do {
            displayMenu();
            choice = readChoice();

            switch (choice) {

                case 1:
                    checkBalance();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    showTransactions();
                    break;

                case 5:
                    changePin();
                    break;

                case 6:
                    System.out.println("Thank you for using our ATM!");
                    break;

                default:
                    System.out.println("Invalid choice! Try again.");
            }

        } while (choice != 6);

        sc.close();
    }

    private static boolean login() {

        int attempts = 3;

        while (attempts > 0) {

            System.out.print("Enter your 4-digit PIN: ");
            int enteredPin = readInteger();

            if (account.verifyPin(enteredPin)) {
                System.out.println("Login Successful!");
                return true;
            }

            attempts--;
            System.out.println("Incorrect PIN! Attempts left: " + attempts);
        }

        return false;
    }

    private static void displayMenu() {

        System.out.println("\n========== ATM MENU ==========");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Transaction History");
        System.out.println("5. Change PIN");
        System.out.println("6. Exit");
        System.out.println("==============================");
    }

    private static int readChoice() {
        System.out.print("Enter your choice: ");
        return readInteger();
    }

    private static int readInteger() {

        while (!sc.hasNextInt()) {
            System.out.println("Invalid input! Enter a number.");
            sc.next();
            System.out.print("Try again: ");
        }

        return sc.nextInt();
    }

    private static double readAmount() {

        while (!sc.hasNextDouble()) {
            System.out.println("Invalid amount!");
            sc.next();
            System.out.print("Enter amount again: ");
        }

        return sc.nextDouble();
    }

    private static void checkBalance() {

        System.out.printf(
                "Available Balance: Rs. %.2f%n",
                account.getBalance()
        );
    }

    private static void deposit() {

        System.out.print("Enter deposit amount: ");
        double amount = readAmount();

        if (account.deposit(amount)) {
            System.out.println("Deposit successful!");
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    private static void withdraw() {

        System.out.print("Enter withdrawal amount: ");
        double amount = readAmount();

        if (account.withdraw(amount)) {
            System.out.println("Please collect your cash.");
            System.out.println("Withdrawal successful!");
        } else {
            System.out.println("Invalid amount or insufficient balance!");
        }
    }

    private static void showTransactions() {

        ArrayList<Transaction> history = account.getTransactions();

        System.out.println("\n====== TRANSACTION HISTORY ======");

        if (history.isEmpty()) {
            System.out.println("No transactions available.");
            return;
        }

        for (Transaction transaction : history) {
            transaction.displayTransaction();
        }
    }

    private static void changePin() {

        System.out.print("Enter current PIN: ");
        int oldPin = readInteger();

        System.out.print("Enter new 4-digit PIN: ");
        int newPin = readInteger();

        if (account.changePin(oldPin, newPin)) {
            System.out.println("PIN changed successfully!");
        } else {
            System.out.println("Incorrect PIN or invalid new PIN!");
        }
    }
}


