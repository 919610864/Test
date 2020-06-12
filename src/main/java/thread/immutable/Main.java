package thread.immutable;

public class Main {
    private static final long CALL_COUNT = 1000000000;
    public static void main(String[] args) {
        trial("NotSync",CALL_COUNT,new NotSync());
        trial("sync",CALL_COUNT,new Synch());

    }

    private static void trial(String msg, long count, Object obj) {
        System.out.println(msg + ": BEGIN");
        long startTime = System.currentTimeMillis();
        for (int i = 0;i<count;i++){
            obj.toString();
        }
        System.out.println(msg + ": END");
        System.out.println("Elapsed time = "+(System.currentTimeMillis() -startTime) + "msec.");
    }


}

class Synch {

    private final String name = "Synch";

    public synchronized String toString(){
        return "["+name+"]";
    }
}

class NotSync {

    private final String name = "NotSync";

    public String toString(){
        return "["+name+"]";
    }
    
}
