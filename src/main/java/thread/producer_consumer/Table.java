package thread.producer_consumer;

/**
 * 使用简单的wait,notify实现简单的blockQueue
 */
public class Table {
        private final String [] buffer;
        private int tail;
        private int head;
        private int count;

    public Table(int count) {
        this.buffer = new String[count];
        this.tail = 0;
        this.head = 0;
        this.count = count;
    }

    public synchronized void put(String cake) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " put " + cake);
        while (count >= buffer.length){
            wait();
        }
        count++;
        buffer[tail] = cake;
        tail = (tail + 1) % buffer.length;
        notifyAll();
    }

    public synchronized String take() throws InterruptedException {
        while (count < 0) wait();
        String cake = buffer[head];
        head = (head + 1) % buffer.length;
        count --;
        notifyAll();
        System.out.println(Thread.currentThread().getName() + "takes " + cake);
        return cake;
    }
}
