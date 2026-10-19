# Database Indexing

**Roadmap coverage:** B-Tree; Hash; Composite

Indexes map search keys to rows. B-tree-like ordered indexes support ranges and ordering; hash indexes suit equality; composite key order determines usable prefixes. This example uses Java maps as an executable analogy, not a database index implementation.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.indexing.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Structures

- **B-tree:** ordered keys support equality, range predicates, and ordered scans.
- **Hash:** equality lookup; typically not useful for range ordering.
- **Composite:** a multi-column key whose column order matters; a query on the leading prefix is often usable, while a trailing-column-only query may not be.

The Java `TreeMap` and `HashMap` demonstrate access properties only; production database index implementations add pages, concurrency, statistics, and recovery.

## Trade-offs

Indexes trade additional storage and write amplification for faster lookups. Composite order must match predicates; query planners may still prefer scans.

## Anti-patterns to avoid

Creating duplicate/unused indexes, assuming hash indexes support ranges, or ignoring leftmost-prefix behavior for a composite key.

## Sources

[PostgreSQL index types and multicolumn indexes](https://www.postgresql.org/docs/current/indexes.html)
