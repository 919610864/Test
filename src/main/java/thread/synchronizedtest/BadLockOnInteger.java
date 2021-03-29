package thread.synchronizedtest;

import java.util.concurrent.locks.LockSupport;

/**
 * Integer ���ڲ��ɱ����һ�����󱻴������Ͳ����ܱ��޸�
 * ʹ��i++ ===> i=Integer.valueOf(i.intValue()+1);
 * ��ʱ��Ҫsynchronized (i)�ĳ�synchronized (instance)����
 * -XX:+UnlockDiagnosticVMOptions -XX:+PrintAssembly
 */
public class BadLockOnInteger implements Runnable {

    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j=0;j<10000;j++){
            synchronized (instance){
                i++;
                System.out.println("线程:"+Thread.currentThread().getName()+";i="+i);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(instance);
        Thread thread2 = new Thread(instance);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println(i);
    }
}
