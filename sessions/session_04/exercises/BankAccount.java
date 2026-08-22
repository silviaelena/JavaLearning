package session_04.exercises;

/**
 * @author snistor
 */
public class BankAccount {
    // Private instance variables (encapsulation)
    private String owner;
    private double balance;

    // Constructor
    public BankAccount(String owner, double initialBalance) {
        this.owner = owner;
        // Ensure starting balance is not negative
        this.balance = Math.max(0.0, initialBalance);
    }

    // Deposit: only accept positive amounts
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    // Withdraw: only positive amounts and cannot exceed balance
    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true; // Withdrawal successful
        }
        return false; // Withdrawal rejected
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Getter for owner
    public String getOwner() {
        return owner;
    }
}