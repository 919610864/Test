package thread.balk;

public class ServerThread extends Thread {

    private final Data data;

    public ServerThread(String name,Data data){
        super(name);
        this.data = data;
    }

    @Override
    public void run() {
        try {
            data.save();
            Thread.sleep(1000);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
