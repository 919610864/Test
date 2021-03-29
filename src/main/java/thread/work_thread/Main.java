package thread.work_thread;

public class Main {

    public static void main(String[] args) {
        Channel channel = new Channel(5);
        channel.startWorkers();
        new ClientThread("Alice",channel).start();
        new ClientThread("Boy",channel).start();
        new ClientThread("Cat",channel).start();
    }

}
