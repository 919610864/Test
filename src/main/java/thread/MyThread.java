package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyThread extends Thread {

    private Lock lock;
    public MyThread(String name, Lock lock) {
        super(name);
        this.lock = lock;
    }

    @Override
    public void run () {
        lock.lock();
        try {
            try {
                System.out.println(Thread.currentThread() + " running");
                Thread.sleep(2000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } finally {
            System.out.println(Thread.currentThread() + " unlock");
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        MyThread t1 = new MyThread("t1", lock);
        t1.start();
        t1.interrupt();
        Thread.currentThread().interrupt();
        System.out.println("第一次调用返回值："+Thread.currentThread().isInterrupted());
        System.out.println("第二次调用返回值："+Thread.interrupted());
    }
}


