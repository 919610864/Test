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
        MyThread t2 = new MyThread("t2", lock);
        MyThread t3 = new MyThread("t3", lock);
        MyThread t4 = new MyThread("t4", lock);
        MyThread t5 = new MyThread("t5", lock);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }
}


