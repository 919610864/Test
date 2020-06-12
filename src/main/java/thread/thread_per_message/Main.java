package thread.thread_per_message;

public class Main {

    public static void main(String[] args) {
        System.out.println("main begin");
        Host host = new Host();
        host.request(10,'A');
        host.request(20,'B');
        host.request(30,'C');
        host.request(40,'D');
        System.out.println("main end");
    }
}
