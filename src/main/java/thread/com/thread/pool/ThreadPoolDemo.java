package thread.com.thread.pool;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 4, 3L,
                TimeUnit.SECONDS, new PriorityBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());
        for (int i = 0; i < 10; i++) {
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
        pool.shutdown();

    }
}
