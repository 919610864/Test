 package thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwinsLockTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0 ;i<10;i++){
            executorService.execute(new Woker());
        }
        for (int i = 0;i<10;i++){
            try {
                Thread.sleep(1000);
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
