
import java.util.ArrayList;

public class BankAccount {

    private String accountHolder;
    private int pin;
    private double balance;

    private ArrayList<Transaction> transactions;

    public BankAccount(String accountHolder, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public boolean verifyPin(int enteredPin) {
        return pin == enteredPin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) {
            return false;
        }

        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
        return true;
    }

    public boolean withdraw(double amount) {
        if (amount <= 0 || amount > balance) {
            return false;
        }

        balance -= amount;
        transactions.add(new Transaction("Withdrawal", amount));
        return true;
    }

    public boolean changePin(int oldPin, int newPin) {
        if (pin != oldPin || newPin < 1000 || newPin > 9999) {
            return false;
        }

        pin = newPin;
        return true;
    }

    public ArrayList<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public String getAccountHolder() {
        return accountHolder;
    }
}
