package thread.future;

import java.util.concurrent.Callable;

/**
 * jdk1.5之后 将工作单元 和 执行机制 分开
 * 工作单元:Runnble Callable
 */
public class FutureTest {

    public static void main(String[] args) {
        Callable<Boolean> callable = new Callable<Boolean>() {
            @Override
            public Boolean call() throws Exception {
                return null;
            }
        };
    }
}
