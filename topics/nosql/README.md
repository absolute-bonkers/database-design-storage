# NoSQL Database Models

**Roadmap coverage:** Document; Key-Value; Column-Family; Graph

NoSQL is a family of data models. This runnable in-memory example represents the same customer facts as a nested document, key/value entry, wide-row map, and graph edge.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.nosql.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Four models

- **Document:** nested, aggregate-shaped records (for example, a customer profile with embedded preferences).
- **Key-value:** lookup an opaque value by a unique key; Redis and Memcached are common examples with different feature sets.
- **Column-family / wide-column:** partitioned rows with flexible columns grouped into families, designed around partition-key queries (Cassandra documents its own model).
- **Graph:** nodes and typed relationships model highly connected data and traversals.

Model around known access patterns. The example uses ordinary Java maps to show the shapes, not a wire-compatible database.

## Trade-offs

Choose around access patterns and consistency requirements, not labels. Flexible models can reduce joins but shift validation, relationships, and query constraints into application design.

## Anti-patterns to avoid

Treating all NoSQL products as interchangeable or choosing one before listing the required reads, writes, and consistency guarantees.

## Sources

[MongoDB data modeling](https://www.mongodb.com/docs/manual/data-modeling/), [Redis data types](https://redis.io/docs/latest/develop/data-types/), [Cassandra architecture](https://cassandra.apache.org/doc/latest/cassandra/architecture/), [Neo4j graph model](https://neo4j.com/docs/getting-started/graph-database/)
