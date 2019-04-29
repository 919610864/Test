package thread;

import java.util.concurrent.*;

public class Test  implements Callable {

    @Override
    public Object call() throws Exception {
        return loop();
    }

    public static void main(String [] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newCachedThreadPool();
        long start =System.currentTimeMillis();
        Future f1=executorService.submit(new Test());
        Future f2=executorService.submit(new Test());
        Future f3=executorService.submit(new Test());
        if(f1.get()!=null && f2.get()!=null && f3.get()!=null){
            long end = System.currentTimeMillis()-start;
            System.out.println("总耗时："+end);
        }
//        loop();
//        loop();
//        loop();
//        long end = System.currentTimeMillis()-start;
//        System.out.println("总耗时："+end);
        executorService.shutdown();
    }

    public static long loop(){
        long start = System.currentTimeMillis();
//        for (int i = 0;i<100000;i++){
//            System.out.println(i);
//        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        long diff = end - start;
        return diff;
    }
}
