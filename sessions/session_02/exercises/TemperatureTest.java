package session_02.exercises;

/**
 * @author snistor
 */
public class TemperatureTest {
    public static void main(String[] args) {
        Temperature temperature1 = new Temperature();
        Temperature temperature2 = new Temperature();

        temperature1.celsius = 20;
        temperature2.celsius = -1;

        temperature1.increase(10);

        temperature1.fahrenheit();
        temperature2.fahrenheit();

        System.out.println(temperature1.isFreezing());
        System.out.println(temperature2.isFreezing());
    }
}
