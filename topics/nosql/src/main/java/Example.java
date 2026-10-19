package learning.database.nosql;
import java.util.*;
public final class Example {
 record Models(Map<String,Object> document, Map<String,String> keyValue, Map<String,Map<String,String>> columnFamily, Map<String,Set<String>> graph) {}
 static Models customer(String id,String name) {
  return new Models(Map.of("id",id,"profile",Map.of("name",name)), Map.of("customer:"+id,name), Map.of(id,Map.of("profile:name",name)), Map.of("customer:"+id,Set.of("orders")));
 }
 public static void main(String[] args) { System.out.println(customer("42","Ada")); }
}
