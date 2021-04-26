package collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

/***
 *
 */
public class ArrayListTest {


    /**
     * 默认创建时候 没有初始容量
     * 当添加第一个元素后,默认长度赋值为10
     * 当使用subList,原List的长度不可变,添加或者删除都会报错ConcurrentModificationException
     */
    @Test
    public void testArrayList(){
        List list = new ArrayList();
        list.add("aa1");
        list.add("aa2");
        list.add("aa3");
        list.add("aa4");
        list.add("aa5");
        list.add("aa6");
        List subList = list.subList(0,3);
        list.add("aa7");
        subList.set(2,"bb");
        list.get(2);
        System.out.println(list.size());
    }

    /**
     * test arrayList,linkedList add ,remove
     * 1.
     */
    @Test
    public void testArrayListAndLinkedList(){

    }
}
