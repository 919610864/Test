package thread.guarded_suspension;

public class TalkThreadMain {

    public static void main(String[] args) {
        RequestQueue r1 = new RequestQueue();
        RequestQueue r2 = new RequestQueue();
        new TalkThread(r1,r2,"A").start();
        new TalkThread(r2,r1,"B").start();
    }
}
