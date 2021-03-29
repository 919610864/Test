package thread.synchronizedtest;

public class SynchronizedTest {

    public SynchronizedTest synchronizedTest;

    public synchronized void method1() {
            System.out.println("synchronized1");
    }

    public static synchronized void method2(){
        System.out.println("synchronized2");
    }

    public void method3(){
        synchronized (synchronizedTest){
            System.out.println("synchronized3");
        }
    }

    public void method4(){
        synchronized (SynchronizedTest.class){
            System.out.println("synchronized3");
        }
    }
}
