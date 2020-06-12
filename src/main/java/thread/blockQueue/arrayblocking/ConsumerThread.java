package thread.blockQueue.arrayblocking;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 使用exchanger方法将空的缓存区传递给ProducerThread
 * 传递空的缓存区后,作为交换,接口被填满字符的缓冲区
 * 使用缓存区的字符(显示)
 */
public class ConsumerThread extends Thread {

    private Exchanger<char []> exchanger;

    private char [] buffer = null;

    private char index = 0;

    private final Random random;

    public ConsumerThread(Exchanger<char []> exchanger,char [] buffer,long seed){
        super("ConsumerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        random = new Random(seed);

    }

    @Override
    public void run() {
        try{
            while (true){
                //交换缓存区
                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");

                for (int i=0;i < buffer.length;i++){
                    System.out.println(Thread.currentThread().getName() + ":" + buffer[i] + "->");
                    Thread.sleep(random.nextInt(1000));
                }
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
    }
}
