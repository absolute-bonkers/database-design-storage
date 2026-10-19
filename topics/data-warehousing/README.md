# Data Warehousing & OLAP vs OLTP

**Roadmap coverage:** Data Warehousing; OLAP vs OLTP

OLTP systems serve concurrent, small, integrity-sensitive transactions. Warehouses optimize integrated historical analysis and OLAP aggregation. A batch example moves operational events into a simple analytical grouping.

## Runnable example

`src/main/java/Example.java` is a self-contained Java 21 simulation; it uses no production services or credentials. Run it from the repository root:

```sh
./gradlew runExample -Pexample=learning.database.warehouse.Example
```

Run its focused tests with:

```sh
./gradlew test
```

The root `./gradlew test` runs this topic’s tests together with every other topic test.

## Workload shape

OLTP favors short, selective reads/writes, normalized records, and transactional constraints. OLAP favors scans, joins, and aggregations across historical/fact data, often in a warehouse with transformed dimensions. A warehouse is a system and data pipeline; OLAP is an analytical workload/query style. Freshness and lineage are part of the contract.

## Trade-offs

Separate analytical workloads to avoid expensive scans harming transaction latency; pipelines introduce freshness delay, data-quality checks, and lineage requirements.

## Anti-patterns to avoid

Running large dashboard scans on a latency-sensitive transaction database without workload isolation or resource controls.

## Sources

[OLTP overview](https://learn.microsoft.com/en-us/azure/architecture/data-guide/relational-data/online-transaction-processing), [OLAP overview](https://learn.microsoft.com/en-us/azure/architecture/data-guide/relational-data/online-analytical-processing)
