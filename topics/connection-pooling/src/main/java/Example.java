package learning.database.pool;
import java.util.concurrent.*;
public final class Example {
 static final class Pool { private final int max; private final Semaphore permits; Pool(int max){if(max<1)throw new IllegalArgumentException();this.max=max;permits=new Semaphore(max);}
  boolean acquire(long timeoutMs)throws InterruptedException{return permits.tryAcquire(timeoutMs,TimeUnit.MILLISECONDS);} synchronized void release(){if(permits.availablePermits()==max)throw new IllegalStateException("No connection is currently borrowed");permits.release();} int available(){return permits.availablePermits();}}
 public static void main(String[] args)throws Exception{var p=new Pool(2);System.out.println(p.acquire(10));p.release();}
}
