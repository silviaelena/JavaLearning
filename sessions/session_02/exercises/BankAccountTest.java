package session_02.exercises;

/**
 * @author snistor
 */
public class BankAccountTest {
    public  static void main(String[] args) {
        BankAccount bankAccountAna = new BankAccount("Ana", 50000);
        BankAccount bankAccountBob = new BankAccount("Bob", 20000);
        // wrong
//        BankAccount bankAccountCa;
//        bankAccountCa.printBalance();

        bankAccountAna.deposit(10000);
        bankAccountBob.deposit(20000);
        bankAccountAna.withdraw(5000);
        bankAccountBob.withdraw(7000);
        bankAccountAna.withdraw(5000);
        bankAccountBob.deposit(7000);
        bankAccountBob.withdraw(70000);

        bankAccountAna.printBalance();
        bankAccountBob.printBalance();
    }
}
