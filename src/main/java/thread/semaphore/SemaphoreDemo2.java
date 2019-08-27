package thread.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

class Log {
    public static void print(String s){
        System.out.println(Thread.currentThread().getName()+":"+s);
    }
}

class BoundedResource{
    private final Semaphore semaphore;
    private final int permits;
    private final static Random random = new Random(314159);

    public BoundedResource(int permits) {
        this.semaphore = new Semaphore(permits);
        this.permits = permits;
    }

    public void use() throws InterruptedException {
        semaphore.acquire();
        try{
            doUse();
        }finally {
            semaphore.release();
        }

    }

    private void doUse() throws InterruptedException {
        Log.print("BEGIN : use = " + (permits - semaphore.availablePermits()));
        Thread.sleep(random.nextInt(500));
        Log.print("END : use = " + (permits - semaphore.availablePermits()));

    }
}

class UserThread extends Thread {
    private final static Random random = new Random(26535);
    private final BoundedResource boundedResource;

    public UserThread(BoundedResource boundedResource) {
        this.boundedResource = boundedResource;
    }

    @Override
    public void run() {
        try{
            while (true){
                random.nextInt(500);
                boundedResource.use();
            }
        }catch (InterruptedException e){

        }
    }
}
public class SemaphoreDemo2 {
    public static void main(String[] args) {
        BoundedResource boundedResource = new BoundedResource(3);
        for (int i = 0;i<10;i++){
            new UserThread(boundedResource).start();
        }
    }
}
