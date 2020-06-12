package thread.lock.ReentrantReadWriteLock;

public class ReadThread extends Thread{

    private final Data data;

    public ReadThread(Data data){
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char [] chars = data.read();
                System.out.println(Thread.currentThread().getName() + " reads " + String.valueOf(chars));
            }
        }catch (Exception e){

        }
    }
}
