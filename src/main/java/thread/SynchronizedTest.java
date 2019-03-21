package thread;

public class SynchronizedTest {
    public void method1() {
        synchronized (this) {
            System.out.println("synchronized �����1");
        }
    }

//    public synchronized void method2() {
//            System.out.println("synchronized �����2");
//    }
//
//    public static void method3(){
//        System.out.println("synchronized �����2");
//    }
}
