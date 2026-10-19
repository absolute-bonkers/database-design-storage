package learning.database.migration;
import java.util.*;
public final class Example {
 record Legacy(String fullName) {} record Expanded(String fullName,String displayName) {}
 static Expanded backfill(Legacy row){return new Expanded(row.fullName(),row.fullName());}
 static String readDisplay(Expanded row){return row.displayName()!=null?row.displayName():row.fullName();}
 public static void main(String[] args){System.out.println(backfill(new Legacy("Ada Lovelace")));}
}
