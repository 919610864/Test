package thread.inheri;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTest {

    //父子线程之间共享变量
    public static ThreadLocal inheritableThreadLocal = new InheritableThreadLocal();
    //当前线程私有变量
    public static ThreadLocal threadLocal = new ThreadLocal();

    public static void main(String[] args) throws InterruptedException {
        //ExecutorService executorService = Executors.newFixedThreadPool(10);
        inheritableThreadLocal.set("主线程值");
        Thread.sleep(1000l);
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("进入子线程:"+inheritableThreadLocal.get());

            }
        },"t1");
        t1.start();

        while (true);

    }
}
