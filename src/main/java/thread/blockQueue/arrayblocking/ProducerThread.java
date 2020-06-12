package thread.blockQueue.arrayblocking;

import java.util.Random;
import java.util.concurrent.Exchanger;

/**
 * 填充字符,直到缓存区被填满
 * 使用exchange方法将填满的缓存区传递给ConsumerThread
 * 传递缓存区,作为交换,接口空的缓存区
 */
public class ProducerThread extends Thread {

    private Exchanger<char []> exchanger;

    private char [] buffer = null;

    private char index = 0;

    private final Random random;

    public ProducerThread(Exchanger<char []> exchanger,char [] buffer,long seed){
        super("ProducerThread");
        this.exchanger = exchanger;
        this.buffer = buffer;
        random = new Random(seed);

    }

    @Override
    public void run() {
        try{
            while (true){
                for (int i=0;i < buffer.length;i++){
                    buffer[i] = nextChar();
                    System.out.println(Thread.currentThread().getName() + ":" + buffer[i] + "->");
                }
                System.out.println(Thread.currentThread().getName() + ": BEFORE exchange");
                buffer = exchanger.exchange(buffer);
                System.out.println(Thread.currentThread().getName() + ": AFTER exchange");
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }finally {

        }
    }

    private char nextChar() throws InterruptedException {
        char c = (char) ('A' + index%26);
        index ++;
        Thread.sleep(random.nextInt(1000));
        return c;
    }
}
