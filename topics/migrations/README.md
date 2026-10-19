# Database Migration Strategies

**Roadmap coverage:** Database Migration Strategies

Database migrations evolve schemas safely. The expand-and-contract sequence adds backward-compatible fields, deploys dual-compatible code, backfills, switches reads, then removes old schema only after rollback windows close.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.migration.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Common strategies

- **Big-bang/offline:** stop writes, transform, validate, and switch over; simpler but may require downtime.
- **Rolling/expand-and-contract:** add compatible schema first, deploy code that reads/writes both shapes as needed, backfill in resumable batches, switch reads, then remove the old shape after every old client is gone.
- **Parallel migration / CDC:** replicate changes to a target, validate consistency, then cut over; supports low downtime but demands lag monitoring, conflict handling, and a clear write authority.

Choose rollback and forward-fix plans before starting. The sample illustrates a small backfill and compatibility read, not a production migration runner.

## Trade-offs

Online changes reduce downtime but require compatibility across mixed application versions, resumable backfills, observability, and a tested rollback/forward-fix plan.

## Anti-patterns to avoid

Destructive schema changes before every application instance has stopped using the old shape; unbounded lock-taking migration at peak load.

## Sources

[AWS database migration guidance](https://docs.aws.amazon.com/dms/latest/userguide/Welcome.html)
