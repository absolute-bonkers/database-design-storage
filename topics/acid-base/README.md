# ACID vs BASE

**Roadmap coverage:** ACID; BASE

ACID transactions provide atomicity, consistency, isolation, and durability within the database’s documented scope. BASE is a broad description of availability-oriented, eventually consistent behavior—not a substitute for precise guarantees.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.acid.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Guarantees

ACID names atomicity (all-or-nothing), consistency (preserve defined constraints), isolation (control concurrent effects), and durability (committed state survives documented failures). BASE—basically available, soft state, eventual consistency—is an informal family of availability-oriented design choices, not a formal database contract. Eventual convergence alone does not guarantee application invariants.

## Trade-offs

Strong transactions simplify invariants but may constrain throughput/availability across distributed boundaries; eventual consistency increases scale options but pushes reconciliation to consumers.

## Anti-patterns to avoid

Treating BASE as “no correctness” or using eventual consistency for balances/unique constraints without compensating controls.

## Sources

[PostgreSQL transactions](https://www.postgresql.org/docs/current/tutorial-transactions.html), [Dynamo paper and eventual consistency](https://www.allthingsdistributed.com/2008/12/eventually_consistent.html)
