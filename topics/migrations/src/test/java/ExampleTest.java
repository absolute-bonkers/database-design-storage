package learning.database.migration;
import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void backfillPreservesOldDataAndAddsNewField() { var n=Example.backfill(new Example.Legacy("Ada"));assertEquals("Ada",n.fullName());assertEquals("Ada",n.displayName()); }
 @Test void dualReadSupportsRowsBeforeBackfill() { assertEquals("Lin",Example.readDisplay(new Example.Expanded("Lin",null))); }
}
