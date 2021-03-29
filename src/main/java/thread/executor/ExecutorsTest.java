package thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorsTest {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newScheduledThreadPool(10);
        Executors.newScheduledThreadPool(1);

    }
}
