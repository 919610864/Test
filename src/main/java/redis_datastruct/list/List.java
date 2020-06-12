package redis_datastruct.list;

import java.util.ArrayList;

/**
 * list保存了head,tail节点,保证了lpush,rpop,rpoplpush 高效性
 */
public class List {

    //头节点
    private ListNode head;

    //尾节点
    private ListNode tail;

    //长度
    private int length;


    //复制
    void dum(){


    }

    //释放
    void free(){

    }

    //对比
    int match(){
        return 1;
    }
}
