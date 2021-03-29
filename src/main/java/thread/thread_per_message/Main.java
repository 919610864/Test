package thread.thread_per_message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {

    public static void main(String[] args) {
        System.out.println("main begin");
        ExecutorService executorService = Executors.newCachedThreadPool();
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(5);
        //Host host = new Host(executorService);
        Host host = new Host(scheduledExecutorService);
        try{
            host.request(10,'A');
            host.request(20,'B');
            host.request(30,'C');
            host.request(40,'D');
        }finally {
            executorService.shutdown();
            scheduledExecutorService.shutdown();
        }
        System.out.println("main end");
    }
}
