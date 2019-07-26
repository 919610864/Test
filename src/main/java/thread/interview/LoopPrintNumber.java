package thread.interview;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 使用多线程循环打印ABC三次
 */
public class LoopPrintNumber {

    //当前线程
    private static int THREAD_NUMBER = 1;
    //打印总数
    private static int PRINT_COUNT =3;
    private static Lock lock = new ReentrantLock();
    private static Condition printA = lock.newCondition();
    private static Condition printB = lock.newCondition();
    private static Condition printC = lock.newCondition();

    static class PrintA extends Thread {

        @Override
        public void run() {
            lock.lock();
                try {
                    for(int i=0;i<PRINT_COUNT;i++){
                        if(THREAD_NUMBER!= 1) {
                            System.out.println("线程"+Thread.currentThread().getName()+",thread_number:"+THREAD_NUMBER+",i="+i);
                            printA.await();
                        }
                        System.out.println("i="+i);
                        System.out.println("A");
                        THREAD_NUMBER++;
                        printB.signal();
                    }

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    lock.unlock();
                }
        }
    }

    static class PrintB extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for(int i=0;i<PRINT_COUNT;i++){
                    if(THREAD_NUMBER!= 2) {
                        System.out.println("线程"+Thread.currentThread().getName()+",thread_number:"+THREAD_NUMBER);
                        printB.await();
                    }
                    System.out.println("i="+i);
                    System.out.println("B");
                    THREAD_NUMBER++;
                    printC.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    static class PrintC extends Thread {

        @Override
        public void run() {
            lock.lock();
            try {
                for(int i=0;i<PRINT_COUNT;i++){
                    if(THREAD_NUMBER!= 3) {
                        System.out.println("线程"+Thread.currentThread().getName()+",thread_number:"+THREAD_NUMBER+",i="+i);
                        printC.await();
                    }
                    System.out.println("i="+i);
                    System.out.println("C");
                    THREAD_NUMBER = 1;
                    printA.signal();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new PrintA();
        Thread t2 = new PrintB();
        Thread t3 = new PrintC();
        t1.start();
        t2.start();
        t3.start();
    }


}
