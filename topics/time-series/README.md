# Time-Series Databases

**Roadmap coverage:** Time-Series Databases

Time-series systems organize measurements by timestamp and tags for ingestion, retention, and time-window queries. This example aggregates sorted readings into a window without an external service.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.timeseries.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Data model decisions

Use event/measurement time, tags for bounded dimensions, and fields for observations. Define retention, late-arrival behavior, rollups/downsampling, and query windows. Unbounded tags (such as unique request IDs) can explode series cardinality; high-rate ingestion and retention often matter more than a generic SQL-vs-NoSQL label.

## Trade-offs

Purpose-built systems can compress and query time-oriented data efficiently; retention, cardinality, late events, and downsampling policy need deliberate limits.

## Anti-patterns to avoid

Using unbounded high-cardinality tags or treating event time as interchangeable with ingestion time.

## Sources

[InfluxDB 3 documentation](https://docs.influxdata.com/influxdb3/core/)
