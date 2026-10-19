package learning.database.cap;
public final class Example {
 enum Choice { CONSISTENCY, AVAILABILITY, LOW_LATENCY }
 record Decision(boolean partition,Choice choice) {}
 static Decision choose(boolean partition,boolean preferConsistency) { return partition?new Decision(true,preferConsistency?Choice.CONSISTENCY:Choice.AVAILABILITY):new Decision(false,preferConsistency?Choice.CONSISTENCY:Choice.LOW_LATENCY); }
 public static void main(String[] args){System.out.println(choose(true,false));}
}
