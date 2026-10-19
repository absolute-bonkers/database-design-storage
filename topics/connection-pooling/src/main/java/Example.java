package learning.database.pool;
import java.util.concurrent.*;
public final class Example {
 static final class Pool { private final Semaphore permits; Pool(int max){if(max<1)throw new IllegalArgumentException();permits=new Semaphore(max);}
  boolean acquire(long timeoutMs)throws InterruptedException{return permits.tryAcquire(timeoutMs,TimeUnit.MILLISECONDS);} void release(){permits.release();} int available(){return permits.availablePermits();}}
 public static void main(String[] args)throws Exception{var p=new Pool(2);System.out.println(p.acquire(10));p.release();}
}
