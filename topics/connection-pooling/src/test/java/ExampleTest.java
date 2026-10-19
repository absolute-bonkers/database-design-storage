package learning.database.pool;
import org.junit.jupiter.api.Test; import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void boundsConcurrentConnections() throws Exception { var p=new Example.Pool(1);assertTrue(p.acquire(0));assertFalse(p.acquire(0));p.release();assertTrue(p.acquire(0)); }
 @Test void rejectsNonpositiveSize() { assertThrows(IllegalArgumentException.class,()->new Example.Pool(0)); }
 @Test void rejectsReturningMoreConnectionsThanWereBorrowed() { var p=new Example.Pool(1);assertThrows(IllegalStateException.class,p::release);assertEquals(1,p.available()); }
}
