package learning.database.relational;
import java.util.*;
public final class Example {
  record Customer(int id, String name) {}
  record Order(int id, int customerId, int cents) {}
  record Receipt(String customer, int orderId, int cents) {}
  static List<Receipt> join(List<Customer> customers, List<Order> orders) {
    Map<Integer, Customer> byId = new HashMap<>(); customers.forEach(c -> byId.put(c.id(), c));
    return orders.stream().filter(o -> byId.containsKey(o.customerId()))
      .map(o -> new Receipt(byId.get(o.customerId()).name(), o.id(), o.cents())).toList();
  }
  public static void main(String[] args) {
    System.out.println(join(List.of(new Customer(1,"Ada")), List.of(new Order(7,1,2500))));
  }
}
