package thread.exechange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 两个线程可以互相进行数据交换
 */
public class ExchangerTest {

    public static ExecutorService executorService = Executors.newFixedThreadPool(10);

    public static void main(String[] args) {
        final Exchanger<String> exchanger = new Exchanger<>();

        executorService.execute(new Runnable() {

            public void run() {
                String content = null;
                try {
                    content = exchanger.exchange("你好");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("交换内容："+content);
            }
        });
    }
}
