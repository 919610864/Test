package thread.interview;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * 打印零与奇偶数
 * 1.方案1：使用信号量使得线程顺序执行
 */
public class ZeroEvenOdd {

    private int n;

    private Semaphore zero = new Semaphore(1);
    private Semaphore even = new Semaphore(0);
    private Semaphore odd = new Semaphore(0);

    public ZeroEvenOdd(int n) {
        this.n = n;
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i++){
            zero.acquire();
            printNumber.accept(0);
            if(i%2==1){
                odd.release();
            }else{
                even.release();
            }
        }
    }

    /**
     * 偶数
     * @param printNumber
     * @throws InterruptedException
     */
    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i=2;i<=n;i+=2){
            even.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    /**
     * 奇数
     * @param printNumber
     * @throws InterruptedException
     */
    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i=1;i<=n;i+=2){
            odd.acquire();
            printNumber.accept(i);
            zero.release();
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(10);

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.zero(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.even(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    zeroEvenOdd.odd(System.out::print);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }
}
