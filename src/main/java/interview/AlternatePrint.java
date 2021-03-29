package interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 交替打印
 */
public class AlternatePrint {

    public static ReentrantLock lock = new ReentrantLock();
    public static Condition printA = lock.newCondition();
    public static Condition printB = lock.newCondition();
    public static volatile Boolean flag = true;

    static class PrintAThread extends Thread {
        @Override
        public void run() {
            lock.lock();
            try {
                while (flag){
                    if(!flag){
                        printA.await();
                    }
                    System.out.println("线程名称:" + Thread.currentThread().getName()+"==输出:A");
                    flag = false;
                    printB.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }


    static class PrintBThread extends Thread {
        @Override
        public void run() {
            lock.lock();

            try {
                Thread.sleep(1000l);
                while (!flag){
                    if(flag){
                        printB.wait();
                    }
                    System.out.println("线程名称:" + Thread.currentThread().getName()+"==输出:B");
                    flag = true;
                    printA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new PrintAThread();
        Thread t2 = new PrintBThread();
        t1.start();
        t2.start();
    }
}
