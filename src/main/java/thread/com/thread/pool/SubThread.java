package thread.com.thread.pool;

public class SubThread implements Runnable{

    private final int i;
    public SubThread(int i){
        this.i = i;
    }
    @Override
    public void run(){
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }
}
