package learning.database.indexing;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void hashIndexSupportsEqualityLookup() { assertEquals(20,Example.hashIndex(Example.sample()).get("B").price()); }
 @Test void compositeIndexUsesTenantThenSku() { assertEquals(30,Example.compositeIndex(Example.sample()).get(new Example.Key(2,"A")).price()); }
}
