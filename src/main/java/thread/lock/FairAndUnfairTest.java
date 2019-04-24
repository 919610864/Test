package thread.lock;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FairAndUnfairTest {

    private static Lock fairLock = new ReentrantLock2(true);
    private static Lock unFairLock = new ReentrantLock2(false);

    @Test
    public void testFairLock() throws InterruptedException {
        testLock(fairLock);
    }

    @Test
    public void testUnFairLock() throws InterruptedException {
        testLock(unFairLock);
    }

    private void testLock(Lock lock) throws InterruptedException {
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Job(lock)) {
                @Override
                public String toString() {
                    return getName();
                }
            };
            thread.setName("" + i);
            thread.start();
        }
        Thread.sleep(11000);
}

private static class Job extends Thread {
    private Lock lock;

    public Job(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            lock.lock();
            try {
                Thread.sleep(1000);
                System.out.println("获取锁的当前线程[" + Thread.currentThread().getName() + "], 同步队列中的线程" + ((ReentrantLock2) lock).getQueuedThreads() + "");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }
}

private static class ReentrantLock2 extends ReentrantLock {

    public ReentrantLock2(boolean fair) {
        super(fair);
    }

    @Override
    public Collection<Thread> getQueuedThreads() {
        List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads());
        Collections.reverse(arrayList);
        return arrayList;
    }
}
}
