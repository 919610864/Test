package thread.lock;

import java.util.concurrent.locks.Lock;

public class Woker extends Thread {

    final Lock lock = new TwinsLock();

    @Override
    public void run() {

        while (true){
            System.out.println(Thread.currentThread().getName()+"准备进来啦");
            lock.lock();
            System.out.println(Thread.currentThread().getName()+"获得到锁");
            try {
                System.out.println(Thread.currentThread().getName()+"在执行");
                Sleep.threadSleep(1-5);
                System.out.println(Thread.currentThread().getName()+"执行完毕");
            } finally {
                lock.unlock();
            }
        }

    }
}
