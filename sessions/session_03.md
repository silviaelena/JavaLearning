# Java Mastery — Session 3

**Date:** 2026-08-21  
**Start:** 16:47 (+03:00)  
**End:** 17:39 (+03:00)  
**Duration:** 52 minutes

## Central question
What exactly is stored in a Java variable, and what happens when variables are assigned to each other?

## Topics covered
- Primitive values vs reference values
- Reference variables
- Reference assignment and aliasing
- Mutation vs reassignment
- `null`
- Arrays as objects
- Arrays of object references
- Java pass-by-value for primitive and reference values
- Method parameters receiving copied values

## Core mental model
Java variables store values, and assignment copies values.

- Primitive variable → stores a primitive value.
- Reference variable → stores a reference value or `null`.
- Assigning one reference variable to another copies the reference value; it does not copy the object.
- Multiple variables can therefore refer to the same object (aliasing).
- Reassigning one reference variable does not reassign the others.
- Mutating an object through one alias is visible through other aliases to that same object.
- Method parameters receive copied values, which is why Java is always pass-by-value.

### Primitive assignment

```text
int x = 10;
int y = x;

x → 10
y → 10
```

The primitive value itself is copied.

### Reference assignment

```text
Dog a = new Dog();
Dog b = a;

a ──┐
    ▼
  Dog
    ▲
b ──┘
```

The reference value is copied; the object is not duplicated.

### Mutation vs reassignment

```java
b.name = "Rex";
```

Mutates the object referred to by `b`.

```java
b = new Dog();
```

Changes the reference value stored in `b`; it does not mutate the old object or reassign another alias.

## Important array note
When creating an array of objects, for example:

```java
Dog[] dogs = new Dog[3];
```

Java creates **one array object with three slots whose values are initially `null`**. It does **not** create three `Dog` objects with fields defaulted to their normal values, and it does **not** invoke the `Dog` default constructor three times.

The `Dog` objects are created only when `new Dog()` is executed explicitly, for example:

```java
dogs[0] = new Dog();
```

At that point one `Dog` object is created and its reference value is stored in `dogs[0]`.

## Pass-by-value
Java is always pass-by-value.

For primitives, the primitive value is copied into the method parameter.

For references, the reference value is copied into the method parameter:

```text
caller variable ──┐
                  ▼
                Object
                  ▲
parameter ────────┘
```

Therefore:
- mutating the shared object through the parameter is visible to the caller;
- reassigning the local parameter does not change what the caller's variable refers to.

## Coding work
### Player lab
Implemented:
- two independent `Player` objects;
- a third alias to the first player;
- mutation through the alias;
- reassignment of the alias to the second player;
- mutation of the second player through the reassigned alias;
- a `reset(Player p)` method demonstrating mutation followed by local-parameter reassignment.

Correctly predicted that the original player's score becomes `0`, not `999`.

### Book quiz lab
Implemented:
- two independent `Book` objects;
- a third alias variable;
- mutation through aliases;
- reassignment;
- an array containing references to existing `Book` objects;
- two array positions referring to the same `Book` object;
- `replace(Book b)` demonstrating Java pass-by-value.

Correctly predicted the original book's final page count as `0`.

## Quiz result
**SOLID overall.**

Correctly handled:
- primitive assignment;
- reference assignment;
- aliasing;
- mutation vs reassignment;
- `null` as a reference value;
- arrays of references;
- object-count reasoning;
- Java pass-by-value;
- blank-editor implementation.

### One answer to refine
Interview question: “Is Java pass-by-reference for objects?”

Preferred Level 1 answer:
> No. Java is always pass-by-value. For object variables, the value being copied is a reference to the object.

Level 2 mechanism:
> When an object reference is passed to a method, Java copies the reference value into the parameter. The caller variable and parameter may then refer to the same object, so mutation is visible through both. Reassigning the parameter changes only the parameter's copied reference.

## Retrieval queue
1. Java variables store values; assignment copies values.
2. Primitive assignment copies the primitive value.
3. Reference assignment copies the reference value, not the object.
4. Aliases are different variables/slots that refer to the same object.
5. Mutation changes the referenced object; reassignment changes the value stored in a variable.
6. `null` is a reference value meaning “no object”.
7. `new Dog[3]` creates one array and zero `Dog` objects.
8. Java is always pass-by-value; a reference value can be the value that is copied.
9. Reassigning a method parameter does not reassign the caller's variable.

## Session assessment
The central reference model was acquired quickly and remained stable across prediction, arrays, aliasing, method calls, and blank-editor coding. The main concepts were largely retrieval/reconstruction rather than first-time learning.

## Retention task
Without notes, reconstruct:

```text
Java variables store values
        ↓
primitive variable → primitive value
reference variable → reference value / null

assignment → copies value

reference copy
        ↓
two variables can refer to same object

mutation → changes object
reassignment → changes variable

method call → copies argument value into parameter
        ↓
Java is always pass-by-value
```

Recall this model briefly the next day and again after a few days rather than rereading the full lesson.
