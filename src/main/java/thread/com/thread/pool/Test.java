package thread.com.thread.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

    public  static ExecutorService exe = Executors.newFixedThreadPool(50);

    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 1; i <= 5; i++) {
            exe.execute(new SubThread(i));
        }
        exe.shutdown();
        while (true) {
            if (exe.isTerminated()) {
                System.out.println("结束了！");
                break;
            }
            Thread.sleep(200);
        }
        System.out.println(System.currentTimeMillis()-start);
    }
}
