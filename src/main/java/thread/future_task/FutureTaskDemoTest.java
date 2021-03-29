package thread.future_task;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

public class FutureTaskDemoTest {


    @Test
    public void testFutureTest() throws ExecutionException, InterruptedException {
        FutureTask futureTask = new FutureTask(new FutureTaskDemo());
        ExecutorService es = Executors.newFixedThreadPool(10);
        for(int i = 0;i<10;i++){
            Future ft = es.submit(futureTask);
            System.out.println(ft.get());
        }
    }


    @Test
    public void testSingleThreadExecutor() throws InterruptedException {
        long startTime = System.currentTimeMillis();
        final Random random = new Random();
        final List<Integer> list = new ArrayList();
        ExecutorService es = Executors.newSingleThreadExecutor();
        for(int i = 0;i<100000;i++){
            es.execute(new Runnable() {
                @Override
                public void run() {
                    list.add(random.nextInt());
                }
            });
        }
        es.shutdown();
        es.awaitTermination(1,TimeUnit.DAYS);
        System.out.println("时间:"+(System.currentTimeMillis()-startTime));
        System.out.println("大小:"+list.size());
    }
}
