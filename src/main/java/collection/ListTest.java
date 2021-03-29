package collection;

import org.junit.Test;

import java.util.Vector;

/**
 * test vector
 * vector 只是相对安全
 */
public class ListTest {

    //
    @Test
    public void testVector(){
        Vector<Integer> vector = new Vector<>();
        while (true){
            for (int i = 0;i<10;i++){
                vector.add(i);
            }
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector){
                        for (int i = 0;i < vector.size();i++){
                            //当前线程让出CPU
                            Thread.yield();
                            int remove = vector.remove(i);
                            System.out.println(Thread.currentThread().getName() + ":remove:"+remove);
                        }
                    }
                }
            });

            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    synchronized (vector){
                        for (int i = 0;i < vector.size();i++){
                            //当前线程让出CPU
                            Thread.yield();
                            System.out.println(Thread.currentThread().getName() + ":get:"+vector.get(i));
                        }
                    }
                }
            });


            t1.start();
            t2.start();
            while (Thread.activeCount() > 10);
        }
    }

}
