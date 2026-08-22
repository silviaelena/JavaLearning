# Java Mastery Curriculum

This curriculum has two parallel goals:

1. **Java mastery** — rebuild a precise mental model of the language, object model, standard library, runtime, JVM, concurrency, and modern Java.
2. **Interview fluency** — restore fast blank-editor coding, API recall, debugging, code prediction, and eventually DSA-oriented Java performance.

The primary conceptual spine is *Head First Java, 3rd Edition*, supplemented with implementation-heavy exercises, UPB Java/OOP material, and interview-oriented drills.

## Pedagogical rule

Each session follows **Map → mechanism → practice → depth**.

Depth control:

- **STOP** — foundational misconception; fix before proceeding.
- **CONTINUE** — understanding is sufficient for the current layer.
- **PARK** — important, but belongs to a later abstraction layer.
- **DEEPEN** — central to the current learning objective.

Normal target: **45–60 minutes of active study**. Unfinished material rolls forward rather than extending a session until cognitive saturation.

---

# Phase 1 — Rebuild the Java language model

Goal: make basic Java semantics automatic again before adding library breadth or interview pressure.

## Session 1 — Execution model and source structure ✅

- source file → compiler → bytecode → JVM
- classes and `main`
- source-file/class naming
- statements, blocks, basic syntax
- compile-time vs runtime errors

## Session 2 — Classes and objects ✅

- class vs object
- fields and methods
- object construction with `new`
- multiple independent instances
- object state
- method invocation

## Session 3 — Values, primitives, and references ✅

- primitive values vs reference values
- assignment copies values
- aliasing
- mutation vs reassignment
- `null`
- arrays as objects
- arrays of references
- Java is always pass-by-value
- object-count reasoning

## Session 4 — Object state, methods, constructors, encapsulation ✅ / closing

- instance fields vs parameters vs local variables
- implicit and explicit `this`
- shadowing and name resolution
- method-local lifetime vs persistent object state
- `private` and encapsulation
- behavior-oriented APIs vs trivial setters
- constructors
- default constructor rules
- constructor overloading and `this(...)` chaining
- method overloading
- return values
- returning reference values
- representation exposure
- mutable vs immutable objects

## Session 5 — `final` and immutability

- `final` variables, fields, parameters, and references
- `final` reference ≠ immutable object
- construction-time invariants
- designing an immutable class
- defensive copying
- immutable components
- `String` as an immutable reference type
- introduction to records as immutable-data-oriented syntax

## Session 6 — Equality and object identity

- `==` for primitives
- `==` for references
- `.equals()`
- identity vs logical equality
- `hashCode()` contract
- why equality matters in collections
- `toString()`
- `Object` as the root class

## Session 7 — Arrays and control flow fluency

- array creation and initialization
- indexing and bounds
- enhanced `for`
- classic `for`, `while`, `do/while`
- `break` and `continue`
- nested loops
- blank-editor array exercises
- small interview-style scans and transformations

---

# Phase 2 — Object-oriented Java

Goal: move from “objects with methods” to Java’s type system and polymorphic design model.

## Session 8 — Inheritance

- `extends`
- inherited state and behavior
- method overriding
- superclass/subclass relationships
- `super`
- constructor chaining across inheritance
- IS-A vs HAS-A

## Session 9 — Polymorphism

- superclass references to subclass objects
- dynamic dispatch
- compile-time reference type vs runtime object type
- overriding vs overloading
- casts and `instanceof`
- failure modes of incorrect casts

## Session 10 — Abstract classes and interfaces

- abstract classes
- abstract methods
- interfaces
- implementing multiple interfaces
- default methods
- programming to an interface
- choosing inheritance vs composition vs interfaces

## Session 11 — Access control, packages, and API boundaries

- `public`, `protected`, package-private, `private`
- packages and imports
- visibility across package/inheritance boundaries
- package design
- encapsulation at class and package level

## Session 12 — Nested classes, enums, and records

- static nested classes
- inner classes
- local/anonymous classes at recognition level
- enums as types, not integer constants
- enum fields/methods
- records
- when records fit and when they do not

---

# Phase 3 — Errors, types, and reusable abstractions

## Session 13 — Exceptions

- exception hierarchy
- checked vs unchecked exceptions
- `try` / `catch` / `finally`
- `throw` vs `throws`
- propagation
- designing useful failure behavior
- try-with-resources

## Session 14 — Generics

- generic classes and methods
- type parameters
- compile-time type safety
- raw types
- bounded type parameters
- wildcards
- PECS: producer `extends`, consumer `super`
- type erasure at the correct abstraction level

## Session 15 — Collections I: List and Set

- `Collection` hierarchy
- `List`
- `ArrayList`
- `LinkedList` at conceptual/performance level
- `Set`
- `HashSet`
- iteration
- complexity intuition

## Session 16 — Collections II: Map, hashing, ordering

- `Map`
- `HashMap`
- keys and values
- equality/hashCode interaction
- `TreeMap` / `TreeSet`
- natural ordering
- `Comparable`
- `Comparator`
- interview-frequency collection patterns

---

# Phase 4 — Functional and modern Java

## Session 17 — Lambdas and functional interfaces

- functions as behavior values
- lambda syntax
- functional interfaces
- `Predicate`, `Function`, `Consumer`, `Supplier`
- method references
- effectively-final captured variables

## Session 18 — Streams

- collection vs stream
- pipeline mental model
- intermediate vs terminal operations
- `map`, `filter`, `flatMap`
- `reduce`
- collectors
- lazy evaluation
- when streams help and when loops are clearer

## Session 19 — Optional and modern API design

- absence vs `null`
- `Optional`
- `map`, `flatMap`, `orElse`, `orElseGet`
- misuse patterns
- API-boundary judgment

## Session 20 — Modern Java language features

- switch expressions
- pattern matching
- records deeper dive
- sealed classes
- text blocks
- `var`
- important post-Java-8 language changes

---

# Phase 5 — I/O, testing, and production Java

## Session 21 — Files and I/O

- byte vs character streams
- readers/writers
- buffering
- `Path` / `Files`
- NIO basics
- resource management

## Session 22 — Testing and debugging

- unit-test structure
- JUnit fundamentals
- assertions
- testing behavior and edge cases
- exception tests
- debugging stack traces
- debugger mental model

## Session 23 — Build and dependency model

- classpath
- JARs
- Maven/Gradle conceptual model
- dependencies
- source/test layout
- compile/test/package lifecycle
- dependency conflicts at recognition level

---

# Phase 6 — JVM and runtime mastery

Goal: connect Java semantics to the runtime without turning every language question into a JVM rabbit hole.

## Session 24 — JVM memory model: runtime structures

- stack frames
- local variables
- heap objects
- references
- class metadata
- method invocation lifecycle
- recursion and stack overflow

## Session 25 — Garbage collection

- reachability
- garbage eligibility
- roots
- why `null` does not “free” an object directly
- generations at conceptual level
- common GC misconceptions

## Session 26 — Compilation, bytecode, and JIT

- `javac`
- bytecode
- class loading
- verification
- interpretation and JIT compilation
- warmup
- why Java can optimize dynamically

## Session 27 — Java Memory Model foundations

- visibility
- ordering
- atomicity
- happens-before
- data races
- why ordinary single-thread intuitions fail under concurrency

---

# Phase 7 — Concurrency

## Session 28 — Threads and shared mutable state

- threads
- `Runnable` / executors
- shared state
- race conditions
- synchronization
- intrinsic locks

## Session 29 — Concurrency utilities

- `ExecutorService`
- thread pools
- futures
- concurrent collections
- atomics
- locks
- coordination primitives

## Session 30 — CompletableFuture and asynchronous composition

- async tasks
- completion stages
- composition vs blocking
- exception propagation
- thread-pool implications
- bridge toward reactive programming

## Session 31 — Virtual threads and modern concurrency

- platform vs virtual threads
- blocking with virtual threads
- structured-concurrency concepts at recognition level
- appropriate vs inappropriate use

---

# Phase 8 — Interview Java fluency

This phase increasingly overlaps with LeetCode/DSA practice.

## Session 32 — Core syntax speed drills

- arrays
- strings
- loops
- methods
- classes
- collections
- sorting
- comparators
- frequency maps
- sets
- queues/stacks

## Session 33 — String and array interview patterns

- two pointers
- sliding window
- frequency counting
- prefix/suffix patterns
- parsing

## Session 34 — Collections-driven problem solving

- `HashMap`
- `HashSet`
- `Deque`
- `PriorityQueue`
- sorting + comparator patterns
- choosing the right collection quickly

## Session 35 — Recursion and trees in Java

- recursive method mechanics
- call stack
- tree node classes
- DFS/BFS implementation fluency
- avoiding Java-specific syntax friction

## Session 36 — Interview simulation and Java repair loop

- timed blank-editor tasks
- compile-error diagnosis
- API recall under pressure
- explaining complexity
- explaining Java semantics aloud
- targeted remediation from accumulated course analytics

---

# Ongoing retrieval track

Every session should retrieve earlier material rather than isolating topics.

High-priority recurring prompts:

- What does a Java variable store?
- Mutation vs reassignment?
- Why is Java always pass-by-value?
- Field vs parameter vs local variable?
- What does `this` refer to?
- Identity vs equality?
- Overloading vs overriding?
- Compile-time type vs runtime type?
- Mutable vs immutable?
- `final` reference vs immutable object?
- `equals` / `hashCode` contract?
- Which collection should be used and why?
- What state is shared across threads?

# Course analytics

Track for every session:

- date and active duration;
- concepts covered;
- blank-editor exercises;
- prediction/debugging exercises;
- quiz performance;
- hot points and clarification loops;
- syntax/API fluency issues;
- foundational misconceptions;
- parked rabbit holes;
- spaced-retrieval queue.

At course milestones, use this history to identify topics that require remediation and to visualize learning speed, friction, and retrieval stability.
