package learning.database.warehouse;
import java.util.*;
public final class Example {
 record Sale(String region,int cents) {}
 static Map<String,Long> revenueByRegion(List<Sale> sales){Map<String,Long> totals=new TreeMap<>();for(var s:sales)totals.merge(s.region(),(long)s.cents(),Long::sum);return totals;}
 public static void main(String[] args){System.out.println(revenueByRegion(List.of(new Sale("west",120),new Sale("west",80),new Sale("east",50))));}
}
