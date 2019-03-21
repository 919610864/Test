package thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VolatileDemo {

    private volatile int i = 0;
    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public static void main(String [] args) throws InterruptedException {
        VolatileDemo volatileDemo = new VolatileDemo();
        List<Thread> threadList = new ArrayList<>();
        for (int i = 0 ;i<100;i++){
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    for(int j = 0 ; j < 100 ; j++){
                        volatileDemo.count();
                        volatileDemo.safeCount();
                    }
                }
            },"thread"+i);
            threadList.add(thread);
        }
        //Thread ready
        for(Thread thread : threadList){
            thread.start();
        }
        //Thread join
        for (Thread thread:threadList){
            thread.join();
        }
        System.out.println(volatileDemo.i);
        System.out.println(volatileDemo.atomicInteger.get());
    }

    private void safeCount(){
        for(;;){
            int i = atomicInteger.get();
            boolean suc = atomicInteger.compareAndSet(i,i+1);
            if(suc){
                break;
            }
        }
    }
    private void count(){
        synchronized (Integer.class){
            i++;
        }

    }



}
