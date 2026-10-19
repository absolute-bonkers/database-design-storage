package learning.database.sharding;
import java.util.*;
public final class Example {
 static int shardFor(String key,int shardCount) { if(shardCount<1) throw new IllegalArgumentException(); return Math.floorMod(key.hashCode(),shardCount); }
 static Map<Integer,List<String>> distribute(List<String> keys,int n) { Map<Integer,List<String>> out=new TreeMap<>(); for(String k:keys) out.computeIfAbsent(shardFor(k,n),x->new ArrayList<>()).add(k); return out; }
 public static void main(String[] args) { System.out.println(distribute(List.of("user-1","user-2","user-3"),3)); }
}
