package thread.lock.deadLock;

public class DeadLockDemo {
    private static String A = "A";

    private static String B = "B";

    public static void main(String [] args){
        new DeadLockDemo().deadLock();
    }

    private void deadLock(){
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (A){
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (B){
                        System.out.println("B");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (B){
                    synchronized (A){
                        System.out.println("A");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
