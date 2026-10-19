package learning.database.replication;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void picksHigherVersion() { assertEquals("new",Example.merge(new Example.Versioned("old",1,"a"),new Example.Versioned("new",2,"b")).value()); }
 @Test void tieBreakIsDeterministic() { var a=new Example.Versioned("a",2,"a"); var b=new Example.Versioned("b",2,"b"); assertEquals(b,Example.merge(a,b)); assertEquals(b,Example.merge(b,a)); }
}
