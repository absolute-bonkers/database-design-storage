package learning.database.warehouse;
import org.junit.jupiter.api.Test; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void aggregatesFactsForAnalyticalQuery() { assertEquals(Map.of("east",50L,"west",200L),Example.revenueByRegion(List.of(new Example.Sale("west",120),new Example.Sale("west",80),new Example.Sale("east",50)))); }
 @Test void emptyInputProducesNoGroups() { assertTrue(Example.revenueByRegion(List.of()).isEmpty()); }
}
