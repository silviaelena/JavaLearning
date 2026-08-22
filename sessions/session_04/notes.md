# Java Mastery — Session 4

**Date:** 2026-08-22  
**Start:** 11:19 (+03:00)  
**End:** 14:11 (+03:00)  
**Breaks:** 40 minutes excluded  
**Active duration:** 2h 12m  
**Status:** Complete

## Central question
When a method belongs to an object, how does it know which object's state to use, and how should that state be protected?

## Big-picture model

```text
OBJECT
  ↓
instance fields = persistent object state

INSTANCE METHOD CALL
  ↓
this → receiver object

inside method:
field       → object's state
parameter   → copied argument value for this invocation
local       → temporary invocation data

name collision:
parameter/local shadows field
this.field explicitly means object's field

ENCAPSULATION
  ↓
private state
+ controlled behavior
→ object protects its invariants

new Class(...)
  ↓
allocate object
→ default field values
→ explicit field initializers
→ constructor chain
→ constructor body

RETURN
  ↓
returns a value
primitive → primitive value copied
reference → reference value copied

mutable object reference exposed
→ caller may mutate shared object

immutable object
→ reference may be reassigned
→ object itself cannot be mutated
```

## Topics covered

### 1. Instance fields, parameters, and local variables
- Instance fields are part of an object's persistent state.
- Parameters belong to one method invocation and receive copied argument values.
- Local variables belong to one invocation/block and are temporary working state.
- Locals/parameters do not persist as object state between calls.

Example:

```java
class Counter {
    int total = 0;               // field

    void add(int amount) {       // parameter
        int doubled = amount * 2; // local
        total += doubled;
    }
}
```

## 2. `this` and the receiver object

Inside an instance method, `this` refers to the object on which the method was invoked.

```java
p1.addScore(5);
```

Conceptually during the call:

```text
this → p1
amount = 5
```

Therefore an unqualified field access such as:

```java
score = score + amount;
```

is effectively:

```java
this.score = this.score + amount;
```

when no local variable or parameter shadows `score`.

## 3. Shadowing and name resolution

If a parameter or local variable has the same name as a field, the nearer name shadows the field.

```java
class Player {
    String name;

    void rename(String name) {
        name = name;
    }
}
```

Both occurrences of `name` above refer to the parameter, so the field is unchanged.

To access the object's field explicitly:

```java
void rename(String name) {
    this.name = name;
}
```

Mental rule:

```text
name      → nearest local/parameter first
this.name → current object's field
```

## 4. Encapsulation

`private` prevents arbitrary direct access to a field from outside the class, but encapsulation is more than hiding fields.

The stronger model is:

```text
hide internal representation
→ expose controlled operations
→ class owns the rules governing valid state changes
```

Example:

```java
class BankAccount {
    private double balance;

    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        }
    }

    boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }
}
```

Behavior-oriented APIs such as `deposit()` and `withdraw()` are often better than a trivial `setBalance()` because they express domain operations and provide places to enforce invariants.

## 5. Constructors

A constructor initializes a newly allocated object.

Conceptual sequence for:

```java
new Person("Ana")
```

```text
1. allocate object
2. fields receive default values
3. explicit field initializers run
4. constructor runs with this → new object
5. constructor parameters receive copied argument values
6. constructor body initializes state
```

Example:

```java
class Person {
    String name = "Unknown";

    Person(String name) {
        System.out.println(this.name); // Unknown
        this.name = name;
        System.out.println(this.name); // Ana
    }
}
```

### Default constructor rule

If a class declares no constructors, Java provides a compiler-generated no-argument constructor.

Once any constructor is explicitly declared, Java does not generate an additional no-argument constructor.

```java
class Dog {
    Dog(String name) { }
}

new Dog(); // compile error
```

## 6. Constructor overloading and chaining

Constructors may be overloaded by parameter list.

```java
Dog()
Dog(String name)
Dog(String name, int age)
```

One constructor can delegate to another constructor in the same class using `this(...)`.

```java
Dog() {
    this("Unknown", 0);
}
```

Rule: `this(...)` must be the first statement in a constructor.

Constructor execution follows the delegated call inward and then unwinds outward.

```java
Dog() {
    this("Unknown");
    System.out.println("A");
}

Dog(String name) {
    this(name, 5);
    System.out.println("B");
}

Dog(String name, int age) {
    System.out.println("C");
}
```

`new Dog()` prints:

```text
C
B
A
```

## 7. Method overloading

Methods can share a name if their parameter lists differ.

```java
void print(String text)
void print(int number)
void print(String text, int times)
```

Return type alone cannot distinguish overloads.

Invalid:

```java
int getValue()
double getValue()
```

Overload selection is resolved at compile time from the available signatures and argument types. Exact matches are preferred; widening conversions may make another overload applicable.

Example:

```java
void add(int a, int b)
void add(double a, double b)

add(1, 2);     // int overload
add(1.0, 2.0); // double overload
add(1, 2.0);   // int widens to double
```

Full overload-resolution rules are intentionally parked for later.

## 8. Return values

A method call can evaluate to a value.

```java
int area() {
    return width * height;
}
```

The returned value is distinct conceptually from persistent object state.

For primitives, the primitive value is returned/copied.

For reference types, the reference value is returned/copied; the referenced object is not automatically copied.

## 9. Returning references and representation exposure

```java
class Holder {
    private Box box = new Box();

    Box getBox() {
        return box;
    }
}
```

Calling `getBox()` gives the caller a copy of the reference value stored in `box`.

```text
holder.box ──┐
             ▼
           Box
             ▲
callerRef ────┘
```

If `Box` is mutable, external code can mutate the same object even though the `box` field itself is private.

This is representation exposure: `private` protects direct access to the field slot, but not automatically the mutability of an object whose reference is deliberately returned.

## 10. Mutable vs immutable objects

Mutable object:

```java
class Name {
    String value;
}
```

Two references may point to the same object, and mutation through one alias is visible through the other.

`String` is immutable. Operations such as:

```java
String s = "hello";
s = s.toUpperCase();
```

do not mutate the original String object. `toUpperCase()` returns a String representing the uppercase result, and `s` may then be reassigned to the returned reference.

Important: a `String` variable still stores a reference value because `String` is a class type.

## 11. `final` preview

Session 4 ended with the distinction:

```java
final Box box = new Box();
```

`final` prevents reassignment of the reference stored in `box`, but does not by itself make the referenced `Box` object immutable.

```java
box.value = 10;   // may be legal
box.value = 20;   // may be legal
box = new Box();  // not legal after initialization
```

Full `final` semantics and designing truly immutable classes are moved to Session 5.

## Coding work

Implemented from a blank editor:

- `BankAccount.java`
- `BankAccountTest.java`

The implementation includes:
- private owner and balance fields;
- constructor initialization;
- positive-deposit validation;
- withdrawal validation;
- boolean success/failure result for withdrawal;
- getters;
- invalid-operation tests.

Predicted final balance correctly as `120.0` for:

```text
100
+50 → 150
-30 → 120
-500 → rejected
-10 deposit → rejected
```

Design note parked for later: `double` is not ideal for monetary values because of floating-point representation; revisit with `BigDecimal` when numeric/API topics are appropriate.

## Quiz result

**10 / 10** on the closing Session 4 quiz.

Correctly retrieved:
- `this` as receiver object;
- field/parameter/local distinction;
- shadowing;
- encapsulation and invariants;
- default-constructor rule;
- constructor chaining;
- method overloading;
- returned reference semantics;
- `String` immutability;
- `final` reference vs mutable referenced object.

## Hot points / clarification loops

### Parameter shadowing
Initially predicted that the left-hand side of `name = name` referred implicitly to `this.name`. Corrected to the rule that both unqualified names resolve to the parameter when the parameter shadows the field. Subsequent applications were correct.

### String as a reference type
Briefly forgot that a `String` field stores a reference value. Once recalled that `String` is a class type, the Session 3 reference-value model transferred correctly.

### Returning references
Clarified that returning a reference-typed expression copies the reference value; it does not copy the referenced object.

### `final`
Initially described `final` as preventing a change to the Holder reference; corrected to: it prevents reassignment of the particular `box` field/reference variable.

## Session assessment

The Session 3 model of values, references, mutation, reassignment, and pass-by-value remained stable and successfully transferred into object-state and method reasoning.

The main new conceptual acquisition was the relationship:

```text
object state → instance fields
instance behavior → methods
method receiver → this
```

Encapsulation was understood at the stronger design level: not merely private fields/getters/setters, but ownership of valid state transitions through the class API.

Constructors, chaining, overload selection, return semantics, and mutable-reference exposure were handled accurately after introduction.

## Retrieval queue

1. An object's state is stored in its instance fields.
2. An instance method executes with `this` referring to its receiver object.
3. Parameters and locals belong to a method invocation; fields belong to objects.
4. A parameter/local shadows an unqualified field with the same name.
5. `this.field` explicitly accesses the current object's field.
6. Encapsulation means controlling state and protecting invariants, not merely generating getters/setters.
7. The compiler provides a default no-arg constructor only when no constructor is declared.
8. `this(...)` invokes another constructor in the same class and must be first in the constructor body.
9. Overloading is distinguished by parameter lists, not return types.
10. Returning a reference copies the reference value, not the referenced object.
11. Returning a mutable internal object can expose representation despite a private field.
12. `String` is a reference type but its objects are immutable.
13. `final` reference does not imply immutable referenced object.

## Retention reconstruction

Without notes, reconstruct:

```text
OBJECT
  ↓
fields = persistent object state

INSTANCE METHOD
  ↓
this → receiver object

field / parameter / local
  ↓
state / argument-copy / temporary data

shadowing
  ↓
local or parameter wins
this.field → explicit object field

private + controlled methods
  ↓
encapsulation + invariants

construction
  ↓
allocate → initialize fields → constructor chain → body

return
  ↓
copy value
reference value can be the copied value

exposed mutable reference
  ↓
shared object can be mutated externally

immutable object
  ↓
object state cannot be mutated after creation
```

Then explain in 2–3 minutes, in your own words:

> How does an object maintain state, and how do Java methods interact with that state?

Recall this model briefly the next day and again after a few days rather than rereading the full lesson.
