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

## Coding work
### Player lab
Implemented aliasing, mutation, reassignment, and `reset(Player p)` to demonstrate mutation followed by local-parameter reassignment.

### Book quiz lab
Implemented aliasing, arrays containing existing object references, duplicate aliases in array positions, and `replace(Book b)` demonstrating Java pass-by-value.

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
