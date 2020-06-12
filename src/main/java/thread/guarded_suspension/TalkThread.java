package thread.guarded_suspension;

public class TalkThread extends Thread{
    private final RequestQueue input;
    private final RequestQueue output;

    public TalkThread(RequestQueue input,RequestQueue output,String name){
        super(name);
        this.input = input;
        this.output = output;

    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "BEGIN");
        for (int i = 0;i <20;i++){
            Request request = input.getRequest();
            System.out.println(Thread.currentThread().getName() + "get" + request);

            Request request2 = new Request(request+"out");
            System.out.println(Thread.currentThread().getName()+"put"+request2);
            output.putRequest(request2);
        }
        System.out.println(Thread.currentThread().getName() + "END");
    }
}
