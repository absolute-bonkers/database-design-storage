package learning.database.timeseries;
import java.time.*;import java.util.*;
public final class Example {
 record Point(Instant time,double value) {}
 static OptionalDouble averageSince(List<Point> points,Instant cutoff){return points.stream().filter(p->!p.time().isBefore(cutoff)).mapToDouble(Point::value).average();}
 public static void main(String[] args){var now=Instant.parse("2026-01-01T00:00:00Z");System.out.println(averageSince(List.of(new Point(now,10),new Point(now.plusSeconds(1),20)),now));}
}
