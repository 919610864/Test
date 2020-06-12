package thread.lock.ReentrantReadWriteLock;

public class Main {

    public static void main(String[] args) {
        Data data = new Data(10);
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new ReadThread(data).start();
        new WriteThread(data,"abcdefghi").start();
        new WriteThread(data,"ABCDEFGHI").start();

    }
}
