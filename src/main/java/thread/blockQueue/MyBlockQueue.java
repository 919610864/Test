package thread.blockQueue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MyBlockQueue {

    //存储数据
    private static List list = new ArrayList();

    //总条数
    private static int count;

    private Lock lock = new ReentrantLock();

    public void add(Object o){

        list.add(o);

    }
}
