package session_02.exercises;

/**
 * @author snistor
 */
public class Temperature {
    double celsius;

    public double fahrenheit() {
        return (celsius * 1.8) + 32;
    }

    public boolean isFreezing() {
        return celsius <= 0;
    }

    public void increase(double amount) {
        celsius += amount;
    }
}
