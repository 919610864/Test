package thread.synchronizedtest;

public class SynchronizedTest {

    public synchronized void method2() {
            System.out.println("synchronized2");
    }

    public static synchronized void method3(){
        System.out.println("synchronized3");
    }
}
