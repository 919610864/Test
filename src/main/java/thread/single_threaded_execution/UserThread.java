package thread.single_threaded_execution;

public class UserThread extends Thread {

    private final Gate gate;

    private final String name;

    private String myAddress;

    public UserThread(Gate gate,String name, String myAddress) {
        this.gate = gate;
        this.name = name;
        this.myAddress = myAddress;
    }


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+":"+name+"BEGIN");
        while (true){
            gate.pass(name,myAddress);
        }
    }
}
