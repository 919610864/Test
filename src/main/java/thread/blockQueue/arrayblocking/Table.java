package thread.blockQueue.arrayblocking;

import java.util.concurrent.ArrayBlockingQueue;

public class Table extends ArrayBlockingQueue<String> {


    public Table(int capacity) {
        super(capacity);
    }

    public void put(String cake){
        System.out.println(Thread.currentThread().getName() + "puts " + cake);
    }

    public String take() throws InterruptedException {
        String cake = super.take();
        System.out.println(Thread.currentThread().getName() + "takes" + cake);
        return cake;
    }

}
