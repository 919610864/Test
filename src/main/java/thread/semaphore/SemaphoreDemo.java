package thread.semaphore;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量
 */
public class SemaphoreDemo {

    private static final int ThREAD_COUNT = 30;
    //定义线程池数量
    private static ExecutorService executorService = Executors.newFixedThreadPool(30);
    //定义信号量数量
    private static Semaphore semaphore = new Semaphore(1);

    public static void main(String[] args) {
        for (int i = 0;i<ThREAD_COUNT;i++){
            executorService.execute(new Runnable() {
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println(Thread.currentThread().getName()+"save data");
                        Thread.sleep(2000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });
        }
        executorService.shutdown();
    }
}
