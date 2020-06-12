package thread.thread_per_message;

public class Host {

    private final Helper helper = new Helper();



    public void request(final int count,final char c) {
        System.out.println(" Request ("+count+","+c+") Begin");
        new Thread(){
            @Override
            public void run() {
                helper.handle(count,c);
            }
        }.start();
        System.out.println(" Request ("+count+","+c+") END");
    }
}
