package learning.database.indexing;
import java.util.*;
public final class Example {
 record Item(int tenant,String sku,int price) {}
 record Key(int tenant,String sku) {}
 static List<Item> sample(){return List.of(new Item(1,"A",10),new Item(1,"B",20),new Item(2,"A",30));}
 static Map<String,List<Item>> hashIndex(List<Item> rows){Map<String,List<Item>> m=new HashMap<>();rows.forEach(x->m.computeIfAbsent(x.sku(),ignored->new ArrayList<>()).add(x));m.replaceAll((sku,items)->List.copyOf(items));return m;}
 static NavigableMap<Key,Item> compositeIndex(List<Item> rows){NavigableMap<Key,Item> m=new TreeMap<>(Comparator.comparingInt(Key::tenant).thenComparing(Key::sku));rows.forEach(x->m.put(new Key(x.tenant(),x.sku()),x));return m;}
 public static void main(String[] args){System.out.println(compositeIndex(sample()).get(new Key(1,"B")));}
}
