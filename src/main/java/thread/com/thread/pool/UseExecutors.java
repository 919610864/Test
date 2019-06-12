package thread.com.thread.pool;

import java.util.concurrent.*;

public class UseExecutors {

    public static void main(String[] args) {
        long begin = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future future1 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "t1";
            }

        });
        Future future2 = executorService.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "t2";
            }
        });
        Future future3 = executorService.submit(new Callable<Object>() {

            @Override
            public Object call() throws Exception {
                Thread.sleep(2000);
                return "t3";
            }
        });
        try {
            if(future1.get()!=null && future2.get()!=null && future3.get()!=null){
                System.out.println("执行完毕");
                System.out.println(future1.get());
                System.out.println(future2.get());
                System.out.println(future3.get());
            }
            System.out.println(System.currentTimeMillis()-begin);
            System.out.println("over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
