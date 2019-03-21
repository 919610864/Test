package thread;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args)  {
        final BoundedBuffer boundedBuffer = new BoundedBuffer();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("t1 run");
                for (int i=0;i<20;i++) {
                    try {
                        System.out.println("��ǰ�߳�Ϊ��"+Thread.currentThread().getName()+"putting..");
                        boundedBuffer.put(Integer.valueOf(i));
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

        }) ;

//        Thread t3 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("t1 run");
//                for (int i=21;i<40;i++) {
//                    try {
//                        System.out.println("��ǰ�߳�Ϊ��"+Thread.currentThread().getName()+"putting..");
//                        boundedBuffer.put(Integer.valueOf(i));
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }) ;

//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i=0;i<20;i++) {
//                    try {
//                        Object val = boundedBuffer.take();
//                        System.out.println("��ǰ�߳�Ϊ"+Thread.currentThread().getName()+"��ֵΪ��"+val);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//        }) ;

        t1.start();
        //t3.start();
        //t2.start();
    }

    /**
     * BoundedBuffer ��һ������100�ļ��ϣ���������û��Ԫ��ʱ��take������Ҫ�ȴ���ֱ����Ԫ��ʱ�ŷ���Ԫ��
     * �����е�Ԫ�����ﵽ���ֵʱ��Ҫ�ȴ�ֱ��Ԫ�ر�take֮���ִ��put�Ĳ���
     * @author yukaizhao
     *
     */
    static class BoundedBuffer {
        final Lock lock = new ReentrantLock();
        final Condition notFull = lock.newCondition();
        final Condition notEmpty = lock.newCondition();

        final Object[] items = new Object[100];
        int putptr, takeptr, count;

        public void put(Object x) throws InterruptedException {
            System .out.println("put wait lock");
            lock.lock();
            System.out.println("put get lock");
            try {
                while (count == items.length) {
                    System.out.println("buffer full, please wait");
                    notFull.await();
                }

                items[putptr] = x;
                if (++putptr == items.length)
                    putptr = 0;
                ++count;
                notEmpty.signal();
            } finally {
                lock.unlock();
            }
        }

        public Object take() throws InterruptedException {
            System.out.println("take wait lock");
            lock.lock();
            System.out.println("take get lock");
            try {
                while (count == 0) {
                    System.out.println("no elements, please wait");
                    notEmpty.await();
                }
                Object x = items[takeptr];
                if (++takeptr == items.length)
                    takeptr = 0;
                --count;
                notFull.signal();
                return x;
            } finally {
                lock.unlock();
            }
        }
    }
}
