package thread.pool.schedule_pool;

import lombok.SneakyThrows;
import org.junit.Test;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduleThreadPoolDemo {


    private final ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);


    private final ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor(new ThreadFactoryImpl(
            "NSScheduledThread"));

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
        },10,1L, TimeUnit.SECONDS);

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

    @Test
    public void test(){
        //开启定时任务:每隔10s扫描一次Broker,移除不活跃的Broker
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @SneakyThrows
            @Override
            public void run() {
                Thread.sleep(2000);
                System.out.println("s1,每隔10s扫描一次，移除broker");
            }
        }, 2, 2, TimeUnit.SECONDS);
        //开启定时任务:每隔10min打印一次KV配置
        this.scheduledExecutorService.scheduleAtFixedRate(new Runnable() {

            @Override
            public void run() {
                System.out.println("每隔1分钟打印一次 K-V配置");
            }
        }, 2, 2, TimeUnit.SECONDS);

        while (true){
            //System.out.println("main thread");
        }
    }

}
