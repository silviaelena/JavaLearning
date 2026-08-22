# Session 1 — Java execution model + basic structure

**Date:** 2026-08-21  
**Start:** 12:10 (+03:00)  
**End:** 12:55 (+03:00)  
**Duration:** 45 minutes

## Central question
What happens between writing a `.java` file and seeing a Java program execute?

## Topics covered
- `.java` source files
- `javac`
- `.class` files
- JVM bytecode
- `java ClassName`
- JVM as runtime
- `main()` as application entry point
- compile-time vs runtime errors
- basic source structure: source file → class → method → statements
- primitive value copy semantics
- basic loops and branching
- Java boolean conditions vs C-style truthiness
- relationship between source classes and generated `.class` files
- IntelliJ decompilation of `.class` bytecode

## Key mental models

```text
.java source
   ↓ javac
.class bytecode
   ↓ JVM
execution
```

```text
source file
   ↓
class
   ↓
method
   ↓
statements
```

## Coding work

### NumberAnalyzer
Wrote a blank-editor program using:
- `int[]`
- enhanced `for`
- accumulator for sum
- max tracking
- conditional counting

Fluency was strong.

### FizzMini
Wrote a classic `for` loop and modulo condition.

## Hot points / clarifications
- IntelliJ showed a `.class` file as Java-looking code because it had **decompiled** bytecode.
- Prefer saying the JVM **executes** bytecode rather than “decodes” it.
- `int y = x` copies the primitive value stored in `x`.
- Java conditions require booleans; `while (x)` is invalid for `int`, unlike C.
- A `.java` file containing multiple classes can produce multiple `.class` files.
- One boundary-condition mistake in `FizzMini`: started at `0` although requirement was `1` through `20`.

## Retrieval status

**Solid**
- `javac` vs `java`
- source vs bytecode
- JVM role
- `main()` role
- primitive copy semantics
- basic Java syntax
- loops / branching
- basic class structure

## Spaced-repetition items
1. What does `javac` produce?
2. What does `java Dog` conceptually do?
3. Why is Java portable across operating systems?
4. What is the difference between source code, bytecode, and decompiled source?
5. Why is `while (x)` invalid when `x` is an `int` in Java?
