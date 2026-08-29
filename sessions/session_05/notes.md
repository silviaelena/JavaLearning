# Java Mastery — Session 5

**Date:** 2026-08-29

**Topic:** `final`, immutability, and defensive copying

**Status:** Theory complete

## Central question

What does `final` actually freeze in Java, and what else must a class do to keep its objects immutable?

## Big-picture model

```text
final variable or field
→ its stored value can be assigned once
→ it cannot later be reassigned

final reference
→ the reference cannot point to another object
→ the object it points to may still be mutable

immutable object
→ its observable state cannot change after construction

defensive copy
→ outside code receives or keeps a different mutable object
→ the object's internal state is not exposed
```

The foundation of this session is:

```text
final reference ≠ immutable object
```

## 1. `final` variables and fields

A `final` variable may be assigned exactly once.

```java
final int score = 10;
score = 20; // compile error: score was already assigned
```

The rule applies to both primitive values and reference values.

```java
final String name = "Ana";
name = "Maria"; // compile error: would store a different reference
```

For a field, each object gets its own one-time assignment:

```java
final class User {
    private final String name;

    User(String name) {
        this.name = name;
    }
}
```

`final` on a class has a different meaning: the class cannot be extended.

```java
final class User {
}
```

Preventing inheritance can support an immutable design, but it does not make a class immutable by itself.

## 2. Blank `final` and definite assignment

A **blank final** is declared without an initializer and assigned later.

```java
final int level;
level = 5; // first and only assignment
```

Before a blank `final` is used, the compiler must be able to prove that it has been assigned. A blank `final` field must be assigned exactly once on every constructor path.

This compiles:

```java
final class Account {
    private final String role;

    Account(boolean admin) {
        if (admin) {
            role = "Admin";
        } else {
            role = "User";
        }
    }
}
```

Both possible paths assign `role` once.

This does not compile:

```java
Account(boolean admin) {
    if (admin) {
        role = "Admin";
    }
    // when admin is false, role is never assigned
}
```

This also does not compile:

```java
Account(boolean admin) {
    role = "User";

    if (admin) {
        role = "Admin"; // possible second assignment
    }
}
```

Practical rule:

```text
declare blank final
→ assign exactly once
→ assign on every possible path
→ assign before use
```

## 3. A `final` reference does not freeze its object

Consider a mutable class:

```java
class Box {
    int value;
}
```

Then:

```java
final Box box = new Box();
box.value = 50; // allowed: the same Box is being changed
box = new Box(); // compile error: box would point elsewhere
```

The reference and object are separate parts of the model:

```text
box variable                 Box object
reference cannot change ───► value may change
```

`final` controls assignment to `box`. It does not automatically control mutation inside the `Box`.

## 4. Practical immutable-class design

An immutable object's observable state cannot change after construction.

A useful practical checklist is:

- prevent unsafe subclassing, often by making the class `final`;
- keep fields `private`;
- normally make fields `final`;
- establish all state during construction;
- provide no setters or other mutating methods;
- do not retain caller-owned mutable objects as internal state;
- do not return mutable internal objects to callers.

This checklist is a design guide, not a claim that one keyword creates immutability. The types stored in the fields matter too.

```java
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
```

`SmallDog` is immutable at the practical depth of this course:

```text
class is final
+ fields are private and final
+ no mutating methods
+ String is immutable
→ state cannot change after construction
```

## 5. Broken version: representation exposure

Suppose `Address` is mutable:

```java
class Address {
    String city;

    Address(String city) {
        this.city = city;
    }
}
```

This `Person` looks immutable at first, but it is not:

```java
final class Person {
    private final String name;
    private final Address address;

    Person(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    Address getAddress() {
        return address;
    }
}
```

### Representation exposure on constructor input

The constructor stores the exact mutable object supplied by the caller:

```text
caller variable a ─────┐
                       ▼
                  Address { "Paris" }
                       ▲
                       │
Person.address ────────┘
```

The caller can change `Person`'s observable state without using a `Person` method:

```java
Address a = new Address("Paris");
Person p = new Person("Ana", a);

a.city = "Berlin";
System.out.println(p.getAddress().city); // Berlin
```

This is a representation leak on input: outside code retains access to an object used as internal representation.

### Representation exposure on getter output

The getter returns the internal mutable object itself:

```java
Address returned = p.getAddress();
returned.city = "Rome";
```

Now `returned` and `p.address` refer to the same `Address`. This is a representation leak on output.

Making the field `private final` did not solve either leak:

```text
private → outside code cannot name the field directly
final   → the field cannot refer to a different Address

but

shared Address object → can still be mutated
```

See [`exercises/BrokenPersonAddressExample.java`](exercises/BrokenPersonAddressExample.java) for the complete runnable version.

## 6. Corrected version: defensive copies in both directions

The corrected `Person` makes a new `Address` when mutable data enters and when it leaves:

```java
final class Person {
    private final String name;
    private final Address address;

    Person(String name, Address address) {
        this.name = name;

        // Defensive copy on input
        this.address = new Address(address.city);
    }

    String getName() {
        return name;
    }

    Address getAddress() {
        // Defensive copy on output
        return new Address(address.city);
    }
}
```

The constructor protects the object from later changes through the caller's original reference:

```text
caller a ───────► Address #1 { "Paris" }

Person.address ─► Address #2 { "Paris" }
```

The getter protects the object from changes through a returned reference:

```text
Person.address ─► Address #2 { "Paris" }

returned ───────► Address #3 { "Paris" }
```

Therefore:

```java
Address a = new Address("Paris");
Person p = new Person("Ana", a);

a.city = "Berlin";
System.out.println(p.getAddress().city); // Paris

Address returned = p.getAddress();
returned.city = "Rome";
System.out.println(p.getAddress().city); // Paris
```

Every call to `getAddress()` creates a new object, so two returned references do not have the same identity:

```java
Address x = p.getAddress();
Address y = p.getAddress();

System.out.println(x == y); // false
```

See [`exercises/DefensiveCopyPersonAddressExample.java`](exercises/DefensiveCopyPersonAddressExample.java) for the complete runnable version.

## 7. Shallow copy versus deep copy

A **shallow copy** creates a new outer object but may reuse references to nested objects.

```text
User #1 ─► Address { "Paris" }
User #2 ──────────┘
```

If the shared nested `Address` is mutable, changing it through either `User` affects both.

A **deep copy** also copies the nested mutable objects that must be independent.

```text
User #1 ─► Address #1 { "Paris" }
User #2 ─► Address #2 { "Paris" }
```

For this session, do not turn "deep copy" into a rule that everything must always be copied recursively. The useful question is:

> Can external code still reach and mutate any object that forms part of this object's internal state?

Immutable nested objects, such as `String`, can normally be shared safely. Mutable nested objects require enough copying or another safe design so that callers cannot mutate internal state.

## 8. Safe sharing of immutable objects

`DogCare` stores and returns the same `SmallDog` reference:

```java
public class DogCare {
    private final SmallDog smallDog;

    public DogCare(SmallDog smallDog) {
        this.smallDog = smallDog;
    }

    public SmallDog getSmallDog() {
        return smallDog;
    }
}
```

That sharing is safe because `SmallDog` is immutable:

```text
caller dog ───────────┐
                      ▼
                 SmallDog { "Rex" }
                      ▲
                      │
DogCare.smallDog ─────┘
```

Both references point to the same object, but neither caller can mutate it.

```java
SmallDog dog = new SmallDog("Rex");
DogCare care = new DogCare(dog);

System.out.println(dog == care.getSmallDog()); // true
```

The `true` result is not an immutability problem. Returning an internal reference is dangerous when the referenced object is mutable, not merely because a reference is shared.

Precise rule:

```text
share mutable internal object   → potentially dangerous
share immutable internal object → safe
```

## Session 5 checkpoint

```text
final
→ prevents reassignment

private
→ hides the field from direct outside access

no mutators
→ prevents state changes through the public API

defensive copy on input
→ caller cannot retain access to internal mutable state

defensive copy on output
→ caller cannot obtain access to internal mutable state

immutable referenced object
→ safe to share directly
```

## CONTINUE / PARK

**CONTINUE:** The practical model above is sufficient for this stage of the course.

**PARK:** `clone()`, serialization-based copying, general object-graph copy frameworks, immutable collections, concurrency guarantees, and JVM-level details. They are useful later, but they are not needed to understand Session 5.

## Retrieval prompts

Without notes, explain:

1. Why can a `final Box` still be mutable?
2. What must Java prove about a blank `final` field?
3. Why is `this.address = address` dangerous when `Address` is mutable?
4. Why can `return address` break an otherwise immutable design?
5. Why is returning the same immutable `SmallDog` safe?
6. When is a shallow copy insufficient?
