package aqs;

public class Foo{

    private volatile boolean firstFinished;
    private volatile boolean secondFinished;
    private Object lock = new Object();

    public Foo(){

    }

    public void first(Runnable printFirst) throws InterruptedException {
        System.out.println("����first");
        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"�����");
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            firstFinished = true;
            System.out.println("firstFinished����Ϊtrue");
            lock.notifyAll();
        }
    }

    public void second(Runnable printSecond) throws InterruptedException {
        System.out.println("����second");

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"�����");
            while (!firstFinished) {
                System.out.println("��ǰ�߳���:"+Thread.currentThread().getName());
                lock.wait();
            }

            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            secondFinished = true;
            lock.notifyAll();
        }
    }

    public void third(Runnable printThird) throws InterruptedException {
        System.out.println("����third");

        synchronized (lock) {
            System.out.println(Thread.currentThread().getName()+"�����");

            while (!secondFinished) {
                System.out.println("��ǰ�߳���:"+Thread.currentThread().getName());
                lock.wait();
            }
            printThird.run();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Foo foo = new Foo();
        Thread t1 = new Thread(() -> System.out.println("one"));
        Thread t2 = new Thread(() -> System.out.println("two"));
        Thread t3 = new Thread(() -> System.out.println("Three"));
        foo.first(t1);
        foo.second(t2);
        foo.third(t3);
        t3.start();
        t2.start();
        t1.start();

    }
}
