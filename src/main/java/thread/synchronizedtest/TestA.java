package thread.synchronizedtest;

import java.util.concurrent.locks.LockSupport;

public class TestA {

    public void testWaitMethod(Object lock){
        try{
            synchronized (lock){
                System.out.println(Thread.currentThread().getName() + "begin wait");
                lock.wait();
                LockSupport.unpark(Thread.currentThread());
                System.out.println(Thread.currentThread().getName()+" end wait");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        TestA testA = new TestA();
        Object lock = new Object();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                testA.testWaitMethod(lock);
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                testA.testWaitMethod(lock);
            }
        });
        t1.start();
        t2.start();
        t1.join();
        t2.join();

    }
}
