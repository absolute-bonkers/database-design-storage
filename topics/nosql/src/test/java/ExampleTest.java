package learning.database.nosql;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void mapsFactsIntoFourDifferentModels() { var m=Example.customer("42","Ada"); assertEquals("Ada",((java.util.Map<?,?>)m.document().get("profile")).get("name")); assertEquals("Ada",m.keyValue().get("customer:42")); assertEquals("Ada",m.columnFamily().get("42").get("profile:name")); assertTrue(m.graph().get("customer:42").contains("orders")); }
 @Test void keepsEntityKeyInEachModel() { var m=Example.customer("7","Lin"); assertEquals("7",m.document().get("id")); assertTrue(m.keyValue().containsKey("customer:7")); }
}
