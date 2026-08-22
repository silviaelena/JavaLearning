# Session 2 — Classes and objects

**Date:** 2026-08-21  
**Start:** 15:08 (+03:00)  
**End:** 15:48 (+03:00)  
**Duration:** 40 minutes

## Central question
What is the difference between a class and an object, and how does object-specific state interact with class-defined behavior?

## Topics covered
- class vs object vs variable
- object instantiation with `new`
- reference variables at introductory level
- instance fields
- instance methods
- independent state across objects
- `this`
- parameter shadowing
- method invocation on a particular object
- instance-field default values
- local-variable definite assignment
- return values
- basic object-oriented mental model

## Key mental models

```text
class
  ↓ defines a type
object
  ↓ runtime instance
reference variable
  ↓ refers to an object
```

```text
ONE class definition

Object A             Object B
state A              state B

same class-defined methods
operate on the current object's state
```

## Coding work

### BankAccount
The user naturally wrote a more advanced solution than requested:
- `private` fields
- constructor
- `this`
- `deposit`
- `withdraw`
- `printBalance`

This showed strong retained Java instincts.

### Rectangle
Wrote:
- `double width`
- `double height`
- `area()`
- `perimeter()`
- `isSquare()`

### Temperature
Wrote:
- `double celsius`
- `fahrenheit()`
- `isFreezing()`
- `increase(double amount)`

Java syntax and method construction were fluent.

## Hot points / clarifications
- `Dog fido;` as a **local declaration** compiles, but the local variable must be definitely assigned before use.
- Instance fields receive default values; local variables do not.
- `this` refers to the **current object**, not to the caller's variable.
- `this.name = name` distinguishes the instance field from a shadowing parameter.
- “Instantiate” should refer to creating an object (`new Box()`), not assigning a field (`a.value = 5`).
- `a.value++` actually updates the field; this was missed once in the quiz.
- A method that returns a value does not automatically print or consume it; `fahrenheit()` was called without using its return value.
- The implicit default constructor is not what gives fields their default values; field default initialization occurs as part of object initialization before the constructor body executes.

## Quiz result
Overall object model was strong.

**Solid**
- class vs object
- object creation
- reference-variable concept at current abstraction level
- independent instance state
- `this`
- instance methods
- default field values
- basic return types
- code-writing fluency

**Needs retrieval**
- fields default-initialized vs locals requiring definite assignment
- `++` mutates the variable/field
- returned value must be consumed explicitly
- precise terminology: instantiate vs assign
- `this` refers to the object, not the caller variable

## Spaced-repetition queue
1. Fields get default values; locals do not.
2. `new Dog()` creates the object; `Dog d` declares the reference variable.
3. `this` refers to the current object.
4. `++` updates the variable/field.
5. Returning a value does not mean printing or storing it.
6. Class methods are not conceptually copied into every object instance.
