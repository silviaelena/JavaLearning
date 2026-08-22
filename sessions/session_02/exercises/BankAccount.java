package chatgpt_lessons.session2;

/**
 * @author snistor
 */
public class BankAccount {
    private String owner;
    private double balance;

    BankAccount(String owner,double balance) {
        this.owner = owner;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
        } else  {
            System.out.println("Insufficient funds");
        }
    }

    public void printBalance() {
        System.out.println(owner + ": " + balance);
    }
}
