package thread.com.thread.pool;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadPoolDemo {

    public static void main(String[] args) {
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 3, 3L,
                TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 4; i++) {
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 10; i++) {
                        System.out.println(Thread.currentThread().getName() + " 执行 - " + i);
                    }
                    System.out.println("run");
                }
            });
        }
        ReentrantLock reentrantLock = new ReentrantLock();
        reentrantLock.lock();

    }
}
