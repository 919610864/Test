package thread.synchronizedtest;

/**
 * Integer 属于不可变对象，一但对象被创建，就不可能被修改
 * 使用i++ ===> i=Integer.valueOf(i.intValue()+1);
 * 此时需要synchronized (i)改成synchronized (instance)即可
 */
public class BadLockOnInteger implements Runnable {

    public static Integer i = 0;
    static BadLockOnInteger instance = new BadLockOnInteger();

    @Override
    public void run() {
        for (int j=0;j<10000;j++){
            synchronized (instance){
                i++;
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
