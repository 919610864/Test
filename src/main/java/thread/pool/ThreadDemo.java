package thread.pool;

/**
 * test class ,implements Runnable
 */
public class ThreadDemo implements Runnable {

    @Override
    public void run() {
        System.out.println("当前线程名称:"+Thread.currentThread().getName());
    }
}
