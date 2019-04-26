package thread.lock.condition;

public class BoundedQueueTest {

    public static void main(String[] args) throws InterruptedException{
        BoundedQueue boundedQueue = new BoundedQueue(5);
        boundedQueue.add("a");
        boundedQueue.add("b");
        boundedQueue.add("c");
        boundedQueue.add("d");


        Thread.sleep(2000);
        System.out.println("总数据是="+boundedQueue.toString());


        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    boundedQueue.add("e");
                    boundedQueue.add("g");
                    boundedQueue.add("j");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1");

        t1.start();

        Thread.sleep(2000);

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("消费数据开始");
                    Object r1=boundedQueue.remove();
                    System.out.println("消费第一个数据："+r1);
                    Object r2 =boundedQueue.remove();
                    System.out.println("消费第二条数据："+r2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2");

        t2.start();

        t1.join();
        t2.join();

        System.out.println("现在的数据长度="+boundedQueue.toString());
    }
}
