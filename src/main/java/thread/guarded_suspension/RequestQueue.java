package thread.guarded_suspension;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 用于存放请求
 */
public class RequestQueue {
    private final Queue<Request> queue = new LinkedList<>();

    public synchronized Request getRequest(){
        while (queue.peek() == null){
            try {
                wait();
            }catch (Exception e){

            }
        }
        return queue.remove();
    }

    public synchronized void putRequest(Request request){
        queue.offer(request);
        notifyAll();
    }
}
