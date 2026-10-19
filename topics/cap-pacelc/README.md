# CAP Theorem & PACELC

**Roadmap coverage:** CAP Theorem; PACELC

CAP characterizes the consistency/availability tradeoff for a distributed data system during a network partition. PACELC adds the normal-operation latency-versus-consistency choice. These simplified policies make the decision explicit.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.cap.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Interpreting the trade-off

CAP's consistency is a strong, linearizable view and availability means each request to a non-failed node eventually receives a response; the trade-off is relevant when partitions prevent coordination. PACELC states the additional choice: else (without a partition), latency versus consistency. Real systems may make different choices by operation, quorum, and configuration.

## Trade-offs

A theorem is not a product-selection checklist: guarantees depend on operation, failure model, and configuration. Lower latency may mean weaker consistency.

## Anti-patterns to avoid

Claiming a system is universally “CA” or “CP” without stating its partition and normal-operation behavior.

## Sources

[Gilbert and Lynch, Brewer’s conjecture](https://users.ece.cmu.edu/~adrian/731-sp04/readings/GL-cap.pdf), [Abadi, PACELC](https://doi.org/10.1109/MC.2012.33)
