package thread.pool;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * 线程池
 * 作用:线程复用
 */
public class ThreadPoolDemoTest {

    /**
     * test thread pool
     *
     */
    @Test
    public void testThreadPool() throws InterruptedException {
        //core = 10 ,非core = 0 只有10个线程执行任务
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);
        // core = 0 非core 未知数
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        ExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(10);
        ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();
        for(int i = 0;i<100;i++){
            cachedThreadPool.execute(new MyTask());
        }
        cachedThreadPool.shutdown();
        cachedThreadPool.awaitTermination(1,TimeUnit.DAYS);
    }

    class MyTask implements Runnable{

        @Override
        public void run() {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("当前线程名称:"+Thread.currentThread().getName());
        }
    }
}
