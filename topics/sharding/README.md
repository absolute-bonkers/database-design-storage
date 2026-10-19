# Database Sharding (Horizontal Partitioning)

**Roadmap coverage:** Database Sharding (Horizontal Partitioning)

Sharding distributes rows across partitions using a shard key. This example routes a stable entity key to a shard; real systems also need resharding, routing metadata, and cross-shard query plans.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.sharding.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Routing choices

Hash partitioning tends to distribute uniformly but makes range scans harder; range partitioning helps ordered scans but can create hot ranges. A shard key determines locality and often constrains queries. Resharding, global uniqueness, secondary indexes, and cross-shard transactions need explicit plans.

## Trade-offs

More write/storage capacity and isolation can come with hot shards, operational complexity, uneven growth, and expensive scatter/gather queries.

## Anti-patterns to avoid

Sharding on a mutable, low-cardinality, or highly skewed key; adding shards before measuring a single-node bottleneck.

## Sources

[MongoDB sharding](https://www.mongodb.com/docs/manual/sharding/)
