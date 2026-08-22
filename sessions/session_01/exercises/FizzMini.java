package session_01.exercises;

/**
 * @author snistor
 */
public class FizzMini {
    public static void main(String[] args) {
        for (int i = 0; i <= 20; i++) {
            if (i % 3 == 0) {
                System.out.println("Fizz");
            } else {
                System.out.println(i);
            }
        }
        System.out.println("Done");
    }
}
