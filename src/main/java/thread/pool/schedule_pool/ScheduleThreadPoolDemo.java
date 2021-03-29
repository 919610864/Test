package thread.pool.schedule_pool;

import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolDemo {

    /**
     * 定时线程池测试
     */
    @Test
    public void testScheduleAtFixedRate(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("执行任务开始");
            }
        },1,1L, TimeUnit.SECONDS);

        scheduledExecutorService.shutdown();

    }


    @Test
    public void testScheduleWithFixedDelay(){
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(1);
        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                long startTime = System.currentTimeMillis(),nowTime = startTime;
                while ((nowTime - startTime)< 5000){
                    nowTime = System.currentTimeMillis();
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){

                    }
                }
                System.out.println("task over ...");
            }
        },1,2L, TimeUnit.SECONDS);

    }
}
