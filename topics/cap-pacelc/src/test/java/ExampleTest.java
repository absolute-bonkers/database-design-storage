package learning.database.cap;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void partitionForcesConsistencyOrAvailabilityChoice() { assertEquals(Example.Choice.CONSISTENCY,Example.choose(true,true).choice()); assertEquals(Example.Choice.AVAILABILITY,Example.choose(true,false).choice()); }
 @Test void pacelcChoiceAppliesOutsidePartition() { assertEquals(Example.Choice.LOW_LATENCY,Example.choose(false,false).choice()); }
}
