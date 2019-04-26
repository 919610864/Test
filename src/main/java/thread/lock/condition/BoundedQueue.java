package thread.lock.condition;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BoundedQueue<T> {

    private LinkedList items = new LinkedList();
    private int maxLength;
    private int addIndex,removeIndex,count;
    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();

    public BoundedQueue(int size){
        maxLength = size;
    }

    //添加一个元素，如果数组满，则添加线程进入等待状态，直到有“空位”
    public void add(T t) throws InterruptedException {
        lock.lock();
        try{
            System.out.println("count="+count);
            while (count == maxLength){
                System.out.println("数据满了，调用await");
                notFull.await();
            }
            items.add(t);
            ++count;
            System.out.println("数据没满，可以发信号");
            notEmpty.signal();
        }finally {
            lock.unlock();
        }
    }


    public T remove() throws InterruptedException {
        lock.lock();
        try{
            System.out.println("removeIndex="+removeIndex);
            while (count == 0){
                notEmpty.await();
            }
            Object x = items.removeFirst();
            if(++removeIndex == maxLength){
                removeIndex = 0;
            }
            System.out.println("remove中的count="+count);
            --count;
            notFull.signal();
            return (T) x;
        }finally {
            lock.unlock();
        }
    }

    public int size(){
        return count;
    }

    @Override
    public String toString() {
        StringBuffer stringBuffer= new StringBuffer();
        for (int i=0;i<count;i++){
            stringBuffer.append(items.get(i));
        }
        return stringBuffer.toString();
    }
}
