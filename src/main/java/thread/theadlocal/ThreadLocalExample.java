package thread.theadlocal;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class ThreadLocalExample {

    public static class MyRunnble implements Runnable{

        private ThreadLocal<String> threadLocal = new ThreadLocal<>();

        @Override
        public void run() {
            threadLocal.set("threadlocal"+new Random().nextInt(1000));
            try {
                TimeUnit.SECONDS.sleep(1);
                System.out.println(Thread.currentThread().getName()+":"+threadLocal.get());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        MyRunnble myRunnble = new MyRunnble();
        Thread t1 = new Thread(myRunnble);
        Thread t2 = new Thread(myRunnble);
        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
