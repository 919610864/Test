package thread;

public class Test  implements Runnable{



    public static void main(){
        new Thread(new Test()).start();
    }

    @Override
    public void run() {

    }
}
