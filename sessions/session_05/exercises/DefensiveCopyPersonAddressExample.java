package session_05.exercises;

/**
 * VERSION 2 — CORRECTED
 *
 * Person makes defensive copies of the mutable Address on constructor input
 * and getter output, so outside code cannot mutate Person's internal state.
 */
public class DefensiveCopyPersonAddressExample {
    public static void main(String[] args) {
        Address original = new Address("Paris");
        Person person = new Person("Ana", original);

        original.city = "Berlin";
        System.out.println(person.getAddress().city); // Paris

        Address returned = person.getAddress();
        returned.city = "Rome";
        System.out.println(returned.city);            // Rome
        System.out.println(person.getAddress().city); // Paris

        Address firstCopy = person.getAddress();
        Address secondCopy = person.getAddress();
        System.out.println(firstCopy == secondCopy);  // false
    }

    private static class Address {
        private String city;

        private Address(String city) {
            this.city = city;
        }

        private Address(Address source) {
            this.city = source.city;
        }
    }

    private static final class Person {
        private final String name;
        private final Address address;

        private Person(String name, Address address) {
            this.name = name;

            // Defensive copy on input.
            this.address = new Address(address);
        }

        private String getName() {
            return name;
        }

        private Address getAddress() {
            // Defensive copy on output.
            return new Address(address);
        }
    }
}
