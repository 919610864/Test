package thread.producer_consumer;

/**
 * 测试
 * 简单的生产者，消费者模式，Table作为一个阻塞队列
 */
public class Main {

    public static void main(String[] args) {
        Table table = new Table(3);
        new MakeThread("MakerThread-1",table,31415).start();
        new MakeThread("MakerThread-2",table,61415).start();
        new MakeThread("MakerThread-3",table,91415).start();
        new EnterThread("EnterThread-1",table,32384).start();
        new EnterThread("EnterThread-2",table,62384).start();
        new EnterThread("EnterThread-3",table,38327).start();

    }
}
