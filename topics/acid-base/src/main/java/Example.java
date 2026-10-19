package learning.database.acid;
import java.util.*;
public final class Example {
 static Map<String,Integer> transfer(Map<String,Integer> balances,String from,String to,int amount) { if(amount<=0||balances.getOrDefault(from,0)<amount)throw new IllegalArgumentException(); Map<String,Integer> next=new HashMap<>(balances); next.put(from,next.get(from)-amount); next.put(to,next.getOrDefault(to,0)+amount); return Map.copyOf(next); }
 static int converge(int local,int remote){return Math.max(local,remote);}
 public static void main(String[] args){System.out.println(transfer(Map.of("a",100,"b",0),"a","b",25));}
}
