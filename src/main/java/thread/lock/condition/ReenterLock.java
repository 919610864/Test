package thread.lock.condition;

import java.util.concurrent.locks.ReentrantLock;

public class ReenterLock implements Runnable {

    public static ReentrantLock reentrantLock = new ReentrantLock();

    public static int i = 0;

    @Override
    public void run() {
        reentrantLock.lock();
        try{
            for (int j=0;j<100000;j++){

                i++;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ReenterLock reentrantLock = new ReenterLock();
        Thread t1 = new Thread(reentrantLock);
        Thread t2 = new Thread(reentrantLock);
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(i);
    }
}
