package learning.database.sharding;
import org.junit.jupiter.api.Test; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void routingIsStableAndWithinRange() { int a=Example.shardFor("acct-42",5); assertEquals(a,Example.shardFor("acct-42",5)); assertTrue(a>=0&&a<5); }
 @Test void rejectsInvalidShardCount() { assertThrows(IllegalArgumentException.class,()->Example.shardFor("x",0)); }
}
