package thread.theadlocal;

import java.util.concurrent.TimeUnit;

public class ThreadLocalTest {

    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        new Thread(()->{
            try{
                for (int i = 0; i < 100; i++) {
                    threadLocal.set(i);
                    System.out.println("当前线程:"+Thread.currentThread().getName()+"========="+threadLocal.get());
                    new Thread(()->{
                        System.out.println("当前线程:"+Thread.currentThread().getName()+"========="+threadLocal.get());
                    },"t1_sub").start();
                    try {
                        TimeUnit.MICROSECONDS.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }finally {
                threadLocal.remove();
            }

        },"threadlocal1").start();

        new Thread(()->{
            try{
                for (int i = 100; i > 0; i--) {
                    System.out.println("当前线程:"+Thread.currentThread().getName()+"========="+threadLocal.get());
                    try {
                        TimeUnit.MICROSECONDS.sleep(300);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            }finally {
                threadLocal.remove();
            }

        },"threadlocal2").start();
    }
}
