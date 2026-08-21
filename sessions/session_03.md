# Java Mastery — Session 3

**Date:** 2026-08-21  
**Start:** 16:47 (+03:00)  
**End:** in progress  
**Duration:** in progress

## Central question
What exactly is stored in a Java variable, and what happens when variables are assigned to each other?

## Topics covered so far
- Primitive values vs reference values
- Reference assignment and aliasing
- Reassignment vs mutation
- `null`
- Arrays as objects
- Arrays of object references
- Java pass-by-value for primitive and reference values

## Important note to retain
When creating an array of objects, for example:

```java
Dog[] dogs = new Dog[3];
```

Java creates **one array object with three slots whose values are initially `null`**. It does **not** create three `Dog` objects with fields defaulted to their normal values, nor does it call the default constructor three times.

The `Dog` objects are only created when `new Dog()` is executed explicitly, for example:

```java
dogs[0] = new Dog();
```

At that point, one `Dog` object is created and the resulting reference value is stored in `dogs[0]`.

## Current core rule
Java variables store values, and assignment copies values.

- Primitive variable → stores a primitive value.
- Reference variable → stores a reference value or `null`.
- Assigning one reference variable to another copies the reference value; it does not copy the object.
- Method parameters also receive copied values, which is why Java is always pass-by-value.

## Status
Session still in progress. Final recap, hot points, retrieval queue, and duration will be added when the session closes.
