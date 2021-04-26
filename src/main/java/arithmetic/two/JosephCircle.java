package arithmetic.two;

/**
 * 约瑟夫问题
 * N个人围成一圈，从第一个开始报数，第M个将被杀掉，
 * 	最后剩下一个，其余人都将被杀掉。例如N=6，M=5，
 * 	被杀掉的顺序是：5，4，6，2，3。
 */
public class JosephCircle {

    private Node head;

    private Node tail;

    private int size = 0;


    JosephCircle(){
        head = null;
        tail = null;
    }

    void add(int index,int data){
        if(index == size - 1){
            addLast(data);
        }else {
            //添加指定位置

        }
    }

    /**
     * 末尾添加
     * @param data
     */
    private void addLast(int data) {
        //获取尾部节点
        ///final Node t = this.tail;
        Node node = new Node(data,head);
        if(tail == null){
            head = node;
        }else {
            tail.next = node;
        }
        tail = node;
        size ++;
    }

    public int find(int index){
        int data = 0;
        Node cur = null;
        for(int i = 0;i<index;i++){
            cur = head.next;
        }
        return cur.value;
    }

    public static void main(String[] args) {
        //元素总数为N ,每次删除第M个
        int n = 6;
        int m = 5;
        JosephCircle josephCircle = new JosephCircle();
        josephCircle.addLast(1);
        josephCircle.addLast(2);
        josephCircle.addLast(3);
        josephCircle.addLast(4);
        josephCircle.addLast(5);
        josephCircle.addLast(6);
        while (josephCircle.size > 0){
            int result = josephCircle.find(m);
            System.out.println(result);
            //删除
            josephCircle.remove(m);
        }
    }

    private void remove(int m) {
        if(size < 2){
            System.out.println("总元素为1个时,不删除");
        }else {
            Node cur = null;//获取要删除节点的前一个几点
            for(int i = 0;i<m;i++){
                cur = head.next;
            }
            cur.next = cur.next.next;


        }
    }


    private static class  Node {
        int value;
        //private Node pre;
        private Node next;

        public Node(int value,Node next){
            //this.pre = pre;
            this.value =value;
            this.next = next;
        }

}

}
