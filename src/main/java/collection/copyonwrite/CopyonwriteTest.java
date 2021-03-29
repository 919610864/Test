package collection.copyonwrite;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.CopyOnWriteArrayList;

public class CopyonwriteTest implements Comparator{

    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        copyOnWriteArrayList.add("a");
        copyOnWriteArrayList.add("b");
        copyOnWriteArrayList.add("c");
        copyOnWriteArrayList.add("d");
        copyOnWriteArrayList.add("d");
        copyOnWriteArrayList.add("d");
        System.out.println(copyOnWriteArrayList.size());
        TreeMap treeMap = new TreeMap();
    }

    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}
