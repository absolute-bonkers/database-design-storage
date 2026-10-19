package learning.database.acid;
import org.junit.jupiter.api.Test; import java.util.*; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void transferIsAtomicAndPreservesTotal() { var before=Map.of("a",100,"b",0); var after=Example.transfer(before,"a","b",25); assertEquals(75,after.get("a"));assertEquals(25,after.get("b"));assertEquals(100,before.get("a")+before.get("b")); }
 @Test void rejectsInsufficientFundsWithoutChangingInput() { var b=Map.of("a",5,"z",0);assertThrows(IllegalArgumentException.class,()->Example.transfer(b,"a","z",8));assertEquals(5,b.get("a")); }
}
