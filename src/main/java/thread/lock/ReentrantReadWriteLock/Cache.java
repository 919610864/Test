package thread.lock.ReentrantReadWriteLock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 根据ReentrantReadWriteLock设计一种简单的缓存
 * Cache组合一种非线程安全的HashMap作为缓存的实现,同时使用读写锁的读锁和写锁来保证Cache的线程安全
 * Cache使用读写锁提升读操作的并发性,也保证了每次写操作对所有读写操作的可见性,简化了编程
 */
public class Cache {

    static Map<String,Object> map = new HashMap();

    static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();

    static Lock read = rwl.readLock();

    static Lock write = rwl.writeLock();

    public static final Object get(String key){
        read.lock();
        try{
            return map.get(key);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            read.unlock();
        }
        return null;
    }

    public static final Object put(String key,Object value){
        write.lock();
        try{
            return map.put(key,value);
        }finally {
            write.unlock();
        }
    }

    public static final void clear(){
        write.lock();
        try{
            map.clear();
        }finally {
            write.unlock();
        }
    }

    public static void main(String[] args) {
        System.out.println(1<<16);
    }
}
