package collection;

import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

public class ConcurrentHashMapDemo {



    public static void main(String[] args) {

        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        concurrentHashMap.put("a","a");
        concurrentHashMap.put("b","b");
        concurrentHashMap.put("c","c");
        concurrentHashMap.put("d","d");
        concurrentHashMap.put("e","e");
        concurrentHashMap.put("f","f");
        concurrentHashMap.put("g","f");
        concurrentHashMap.put("h","h");
        concurrentHashMap.put("i","i");
        concurrentHashMap.put("j","j");
        concurrentHashMap.put("k","k");
        concurrentHashMap.put("aa","aa");
        concurrentHashMap.put("ab","ab");
        concurrentHashMap.put("ac","ac");
        concurrentHashMap.put("ad","ad");
        concurrentHashMap.put("ae","ae");
        concurrentHashMap.put("af","af");
        concurrentHashMap.put("bb","bb");
        concurrentHashMap.put("bc","bc");
        concurrentHashMap.put("bd","bd");
        Semaphore semaphore = new Semaphore(10);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(10);
        CountDownLatch countDownLatch = new CountDownLatch(10);


    }
}
