package session_05.exercises;

/**
 * VERSION 1 — BROKEN
 *
 * Person stores and returns the same mutable Address object. The example shows
 * representation exposure on both constructor input and getter output.
 */
public class BrokenPersonAddressExample {
    public static void main(String[] args) {
        Address original = new Address("Paris");
        Person person = new Person("Ana", original);

        original.city = "Berlin";
        System.out.println(person.getAddress().city); // Berlin: input leak

        Address returned = person.getAddress();
        returned.city = "Rome";
        System.out.println(person.getAddress().city); // Rome: output leak

        System.out.println(original == person.getAddress()); // true
    }

    private static class Address {
        private String city;

        private Address(String city) {
            this.city = city;
        }
    }

    private static final class Person {
        private final String name;
        private final Address address;

        private Person(String name, Address address) {
            this.name = name;

            // BROKEN: the caller keeps a reference to this mutable object.
            this.address = address;
        }

        private String getName() {
            return name;
        }

        private Address getAddress() {
            // BROKEN: the caller receives the internal mutable object.
            return address;
        }
    }
}
