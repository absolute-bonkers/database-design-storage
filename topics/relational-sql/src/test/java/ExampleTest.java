package learning.database.relational;
import org.junit.jupiter.api.Test; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void joinsByForeignKeyRatherThanRowPosition() { assertEquals(List.of(new Example.Receipt("Ada",7,2500)), Example.join(List.of(new Example.Customer(1,"Ada")),List.of(new Example.Order(7,1,2500)))); }
 @Test void ignoresOrphanRowsWhenInnerJoining() { assertTrue(Example.join(List.of(),List.of(new Example.Order(1,99,10))).isEmpty()); }
}
