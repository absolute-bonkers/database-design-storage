# Database Replication

**Roadmap coverage:** Master-Slave; Master-Master

Replication copies database changes between nodes. The example models multi-writer conflict resolution with a deterministic timestamp rule; primary/replica and multi-primary systems differ in write routing, lag, and conflict handling.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.replication.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Topologies

**Primary/replica (historically master-slave):** writes go to a primary and are copied to replicas, synchronously or asynchronously. **Multi-primary (historically master-master):** multiple nodes accept writes and need conflict detection/resolution. These are topologies, separate from synchronous/asynchronous acknowledgement policy. The example's last-writer-wins tie-break is a deterministic teaching rule, not a universal database conflict policy.

## Trade-offs

Replicas can improve read scale and availability, but asynchronous replicas can be stale. Multi-primary writes increase conflict and consistency complexity.

## Anti-patterns to avoid

Assuming a successful replica write means every reader immediately sees it, or promoting a lagging replica without a recovery plan.

## Sources

[PostgreSQL warm standby and streaming replication](https://www.postgresql.org/docs/current/warm-standby.html)
