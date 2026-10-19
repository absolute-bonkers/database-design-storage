# Relational Databases (SQL)

**Roadmap coverage:** Normalization; Indexing; Joins

Relational tables model entities and relations with keys and constraints. Normalize write models to reduce update anomalies; indexes accelerate selected predicates; joins combine related rows by keys.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.relational.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Core ideas

- **Normalization:** organize facts so each fact has one authoritative location. In the common progression, 1NF uses atomic values; 2NF removes partial dependency on part of a composite key; 3NF removes transitive dependencies among non-key attributes. Apply keys and constraints to enforce relationships.
- **Joins:** an inner join returns matching pairs; a left join preserves every left-side row and fills missing right-side values with nulls. Join through declared keys, not incidental row order.
- **Indexes:** indexes can speed predicates and join lookups, but are maintained on writes and are selected by the database planner. The separate indexing topic compares structures.

The example keeps `Customer` and `Order` facts in separate records and joins through `customerId`, illustrating a normalized relationship.

## Trade-offs

Normalization improves integrity but can require joins; denormalization can speed reads at the cost of duplicated data and harder writes. Indexes consume space and add write work.

## Anti-patterns to avoid

Adding indexes for every column, storing repeated facts in denormalized fields without ownership, or joining tables without explicit keys.

## Sources

[PostgreSQL constraints](https://www.postgresql.org/docs/current/ddl-constraints.html), [PostgreSQL indexes](https://www.postgresql.org/docs/current/indexes.html), [table expressions and joins](https://www.postgresql.org/docs/current/queries-table-expressions.html)
