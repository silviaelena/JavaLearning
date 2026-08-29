# JavaLearning

A structured Java mastery track focused on two goals in parallel:

1. **Deep Java understanding** — language semantics, object model, runtime mechanisms, JVM, memory, concurrency, modern Java.
2. **Interview fluency** — fast code production from memory, collections, comparators, APIs, debugging, prediction, and later DSA-oriented Java practice.

## Curriculum

See [`CURRICULUM.md`](CURRICULUM.md) for the full Java mastery path, including the language foundations, OOP/type system, collections/generics, modern Java, JVM/runtime, concurrency, and interview-fluency phases.

## Teaching model

**Map → mechanism → practice → depth.**

Each substantial session follows roughly:

```text
CENTRAL QUESTION
    ↓
BIG PICTURE
    ↓
RETRIEVAL WARM-UP
    ↓
MINIMAL THEORY
    ↓
VISUAL / STRUCTURAL MODEL
    ↓
WORKED EXAMPLES
    ↓
CODE PREDICTION / DEBUGGING
    ↓
BLANK-EDITOR CODE WRITING
    ↓
QUESTIONS
    ↓
QUIZ WITHOUT NOTES
    ↓
RETENTION / SPACED RECALL
```

Depth is controlled explicitly:

- **STOP** — foundational misconception; correct before proceeding.
- **CONTINUE** — understanding is sufficient.
- **PARK** — useful question, wrong abstraction layer.
- **DEEPEN** — central question worth investigating now.

## Main sources

- *Head First Java, 3rd Edition* — primary conceptual spine.
- UPB Java/OOP labs — implementation-heavy practice.
- Interview layer — blank-editor coding, syntax recall, code reading, debugging, fast API usage.

## Repository structure

Each session is self-contained:

```text
sessions/
├── session_01/
│   ├── notes.md
│   └── exercises/
├── session_02/
│   ├── notes.md
│   └── exercises/
├── session_03/
│   ├── notes.md
│   └── exercises/
├── session_04/
│   ├── notes.md
│   └── exercises/
└── session_05/
    ├── notes.md
    ├── SmallDog.java
    ├── DogCare.java
    └── exercises/
```

Completed Java exercises are stored verbatim so mistakes, corrections, and fluency patterns remain available for later course analytics.

## Sessions

| # | Topic | Date | Start | End | Duration |
|---|---|---|---:|---:|---:|
| 1 | Java execution model + source structure | 2026-08-21 | 12:10 | 12:55 | 45 min |
| 2 | Classes and objects | 2026-08-21 | 15:08 | 15:48 | 40 min |
| 3 | Primitives and references | 2026-08-21 | 16:47 | 17:39 | 52 min |
| 4 | Object state, methods, `this`, encapsulation | 2026-08-22 | 11:19 | 14:11 | 2h 12m active |
| 5 | `final`, immutability, defensive copying | 2026-08-29 | — | — | — |

See [`sessions/`](sessions/) for detailed notes and coding exercises.

## Analytics goal

Track per session:

- duration;
- concepts covered;
- coding exercises;
- hot points / clarification loops;
- fluency issues;
- requirements mistakes;
- retrieval gaps.

At the end of the course, use this data to visualize learning speed, topic friction, and the concepts that required the most clarification or repetition.
