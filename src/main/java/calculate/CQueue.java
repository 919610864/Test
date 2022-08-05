package calculate;

import java.util.Stack;

/**
 * 使用2个栈实现一个队列
 */
public class CQueue {

    Stack<Integer> s1 = new Stack<>();

    Stack<Integer> s2 = new Stack<>();

    public CQueue() {

    }

    public void appendTail(int value) {
        s1.push(value);
    }

    public int deleteHead() {
        if(s2.isEmpty()){
            if(s1.isEmpty()){
                return -1;
            }
            while (!s1.isEmpty()) {
                int value = s1.pop();
                s2.push(value);
            }
        }
        return s2.pop();
    }

    /**
     * Your CQueue object will be instantiated and called as such:
     * CQueue obj = new CQueue();
     * obj.appendTail(value);
     * int param_2 = obj.deleteHead();
     */
    public static void main(String[] args) {
        CQueue cQueue = new CQueue();
        cQueue.appendTail(1);
        int param_2 = cQueue.deleteHead();

    }
}
