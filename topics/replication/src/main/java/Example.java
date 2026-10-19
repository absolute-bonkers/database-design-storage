package learning.database.replication;
import java.util.*;
public final class Example {
 record Versioned(String value,long version,String writer) {}
 static Versioned merge(Versioned a,Versioned b) { int c=Long.compare(a.version(),b.version()); if(c==0)c=a.writer().compareTo(b.writer()); return c>=0?a:b; }
 public static void main(String[] args) { System.out.println(merge(new Versioned("east",2,"a"),new Versioned("west",3,"b"))); }
}
