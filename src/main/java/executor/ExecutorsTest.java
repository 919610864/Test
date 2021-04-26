package executor;

import java.util.concurrent.Executors;

public class ExecutorsTest {

    public static void main(String[] args) {
        Executors.newFixedThreadPool(10);
        Executors.newCachedThreadPool();
        Executors.newSingleThreadExecutor();
        Executors.newScheduledThreadPool(10);
    }
}
