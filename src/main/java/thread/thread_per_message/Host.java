package thread.thread_per_message;

import java.util.concurrent.*;

public class Host {

    private final Helper helper = new Helper();

    private final Executor executor = Executors.newCachedThreadPool();

    private ScheduledExecutorService scheduledExecutorService;

    public Host(ExecutorService executorService) {
        //this.executor = executorService;
    }

    public Host(ScheduledExecutorService scheduledExecutorService){
        this.scheduledExecutorService = scheduledExecutorService;
    }


    public void request(final int count,final char c) {
        System.out.println(" Request ("+count+","+c+") Begin");
//        executor.execute(new Runnable() {
//            @Override
//            public void run() {
//                helper.handle(count,c);
//            }
//        });
        scheduledExecutorService.schedule(new Runnable() {
            @Override
            public void run() {
                helper.handle(count,c);
            }
        },3L, TimeUnit.SECONDS);
        System.out.println(" Request ("+count+","+c+") END");
    }
}
