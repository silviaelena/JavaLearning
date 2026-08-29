package session_05;

/**
 * @author snistor
 */
public final class SmallDog {
    private final String name;
    private final String size = "small";

    public SmallDog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
