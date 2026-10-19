# Connection Pooling

**Roadmap coverage:** Connection Pooling

A connection pool bounds concurrently open database connections and amortizes setup. This small semaphore-backed example demonstrates bounded admission; real pools also handle validation, timeout, leak detection, and transaction reset.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.pool.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Pool lifecycle

Borrow a connection for a bounded operation, use a finite acquisition timeout, commit or roll back, reset session state, and return it even on exceptions. Set per-process pool sizes with the total replica count and database connection budget in mind. PgBouncer distinguishes pooling modes with different session semantics.

## Trade-offs

Reuse reduces connection churn, but oversized pools amplify contention and undersized pools queue requests. Pool limits must align with database capacity and deployment replica count.

## Anti-patterns to avoid

Opening a connection per request, unbounded pool growth, or returning a connection with an open transaction/session state.

## Sources

[PgBouncer configuration](https://www.pgbouncer.org/config.html)
