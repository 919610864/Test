package thread.lock;

public class DaemonDemo {

    public static class DaemonT implements Runnable{

        @Override
        public void run() {
            while (true){
                System.out.println("i am alive");
                try{
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new DaemonT()) ;
        t.setDaemon(true);
        t.start();
        Thread.sleep(2000);

    }
}
