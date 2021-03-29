package thread.pool;

import com.google.j2objc.annotations.AutoreleasePool;
import org.junit.Test;

import java.util.concurrent.*;

public class ThreadPoolDemo {

    /**
     * test
     */
    @Test
    public void testThread(){
        ThreadPoolExecutor pool =  new ThreadPoolExecutor(2, 4, 3L,
                TimeUnit.SECONDS, new LinkedBlockingQueue<>(10), new ThreadPoolExecutor.AbortPolicy());
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


    @Test
    public void testStack(){
        add(0);
    }
    //8+4 * 1024
    private void add(int c) {
        long a;
        int b = c + 1;
        System.out.println(b);
        add(b);
    }

    @Test
    public void testException() {
        boolean completedAbruptly = true;
        try {
            try {
                Throwable thrown = null;
                try {
                    new RuntimeException("抛异常啦");
                } catch (RuntimeException x) {
                    thrown = x;
                    throw x;
                } catch (Error x) {
                    thrown = x;
                    throw x;
                } catch (Throwable x) {
                    thrown = x;
                    throw new Error(x);
                } finally {
                    System.out.println("1,finally");
                }
            } finally {
                System.out.println("2.finally");
            }
            completedAbruptly = false;
        } finally {
            System.out.println("status:" + completedAbruptly);
        }
    }

    @Test
    public void test111(){
        boolean completedAbruptly = true;
        try {
            while (true) {
                // If pool is stopping, ensure thread is interrupted;
                // if not, ensure thread is not interrupted.  This
                // requires a recheck in second case to deal with
                // shutdownNow race while clearing interrupt
                try {
                    ///beforeExecute(wt, task);
                    Throwable thrown = null;
                    try {
                        //task.run();
                        new RuntimeException("异常");
                    } catch (RuntimeException x) {
                        thrown = x; throw x;
                    } catch (Error x) {
                        thrown = x; throw x;
                    } catch (Throwable x) {
                        thrown = x; throw new Error(x);
                    } finally {
                        //afterExecute(task, thrown);
                        System.out.println("11111 finally");
                    }
                } finally {
                    System.out.println("2.finally"+completedAbruptly);
                }
            }
            //completedAbruptly = false;
        } finally {
            System.out.println("3.finally"+completedAbruptly);
        }
    }
}
