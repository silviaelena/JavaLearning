package session_04.exercises;

/**
 * @author snistor
 */
public class BankAccountTest {
    public static void main(String[] args) {
        BankAccount account = new BankAccount("Alice", 100.0);
        System.out.println("Initial balance: " + account.getBalance());

        account.deposit(50.0);
        System.out.println("After deposit(50): " + account.getBalance());

        boolean withdraw30Result = account.withdraw(30.0);
        System.out.println("withdraw(30) succeeded? " + withdraw30Result + " | Balance: " + account.getBalance());

        boolean withdraw500Result = account.withdraw(500.0);
        System.out.println("withdraw(500) succeeded? " + withdraw500Result + " | Balance: " + account.getBalance());

        account.deposit(-10.0);
        System.out.println("After deposit(-10): " + account.getBalance());

        // my prediction: 120.0
        System.out.println("\nFinal balance: " + account.getBalance());
    }
}
