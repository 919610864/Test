package thread.future_task;

import java.util.concurrent.Callable;

public class FutureTaskDemo implements Callable<String> {


    @Override
    public String call() throws Exception {
        return "当前线程名称:"+Thread.currentThread().getName();
    }
}
