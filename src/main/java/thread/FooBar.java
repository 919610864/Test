//package thread;
//
//import java.util.concurrent.locks.Condition;
//import java.util.concurrent.locks.ReentrantLock;
//
///**
// * 使用reentrantlock循环打印foobar
// */
//public class FooBar {
//
//    private ReentrantLock lock = new ReentrantLock();
//    private Condition fooCondition = lock.newCondition();
//    private Condition barCondition = lock.newCondition();
//    private boolean count = true;
//    private int n;
//
//    public FooBar(int n) {
//        this.n = n;
//    }
//
//    public void foo(Runnable printFoo) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            lock.lock();
//            while (!count) {
//                fooCondition.await();
//            }
//            printFoo.run();
//            barCondition.signal();
//            count= false;
//            lock.unlock();
//        }
//    }
//
//    public void bar(Runnable printBar) throws InterruptedException {
//        for (int i = 0; i < n; i++) {
//            lock.lock();
//            while (count) {
//                barCondition.await();
//            }
//            printBar.run();
//            fooCondition.signal();
//            count=true;
//            lock.unlock();
//        }
//    }
//
//    public static void main(String[] args) throws InterruptedException {
//        FooBar fooBar = new FooBar(10);
//
//        Thread t1 = new Thread(()->{
//            try {
//                fooBar.foo(()->{
//                    System.out.print("foo");
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//        Thread t2 = new Thread(()->{
//            try {
//                fooBar.bar(()->{
//                    System.out.print("bar");
//                });
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        t2.start();
//        t1.start();
//
//    }
//}
