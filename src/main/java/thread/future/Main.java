package thread.future;

import java.util.concurrent.Future;

public class Main {

    public static void main(String[] args) {
        System.out.println("main BEGIN");
        Host host = new Host();
        Data data1 = host.request(10,'A');
        Data data2 = host.request(10,'B');
        Data data3 = host.request(10,'C');
        System.out.println("main otherJob BEGIN");
        try{
            Thread.sleep(2000);
        }catch (Exception e){

        }
        System.out.println("data1 = " + data1.getContent());
        System.out.println("data2 = " + data2.getContent());
        System.out.println("data3 = " + data3.getContent());
        System.out.println("main end");

    }
}
