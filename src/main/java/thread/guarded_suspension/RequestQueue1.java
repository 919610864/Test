package thread.guarded_suspension;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 习题4.4
 * 思考使用LinkedList和LinkedBlockingQueue
 * 准确来讲,并不是要查出死锁,而是要根据守护条件很长时间不成立来检验生存型不足.
 */
public class RequestQueue1 {

    private final BlockingQueue<Request> blockingQueue = new LinkedBlockingQueue<>();


    public Request getRequest(){
        Request request = null;
        try {
            request = blockingQueue.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return request;
    }

    public void putRequest(Request request){
        try {
            blockingQueue.put(request);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
