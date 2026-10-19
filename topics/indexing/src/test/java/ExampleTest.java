package learning.database.indexing;
import org.junit.jupiter.api.Test; import java.util.List; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void hashIndexSupportsEqualityLookupIncludingDuplicateKeys() { assertEquals(List.of(10,30),Example.hashIndex(Example.sample()).get("A").stream().map(Example.Item::price).toList());assertEquals(20,Example.hashIndex(Example.sample()).get("B").getFirst().price()); }
 @Test void compositeIndexUsesTenantThenSku() { assertEquals(30,Example.compositeIndex(Example.sample()).get(new Example.Key(2,"A")).price()); }
}
