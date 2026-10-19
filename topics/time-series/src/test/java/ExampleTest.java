package learning.database.timeseries;
import org.junit.jupiter.api.Test;import java.time.*;import java.util.*;import static org.junit.jupiter.api.Assertions.*;
class ExampleTest {
 @Test void computesWindowAverageAndExcludesOldSamples() { var t=Instant.parse("2026-01-01T00:00:00Z");var pts=List.of(new Example.Point(t.minusSeconds(1),100),new Example.Point(t,10),new Example.Point(t.plusSeconds(1),20));assertEquals(15,Example.averageSince(pts,t).orElseThrow()); }
 @Test void emptyWindowHasNoAverage() { assertTrue(Example.averageSince(List.of(),Instant.EPOCH).isEmpty()); }
}
