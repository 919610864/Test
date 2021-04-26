package arithmetic.two;

/**
 * ժ������ Լɪ��  ʹ�õ���ѭ������
 */
public class Yuesefu {
    /**
     * ����ѭ������
     * @param totalCol
     * @return
     */
    public node createNodes(int totalCol){
        node head = null;
        node[] nodes = new node[totalCol];
        for(int i = 0 ; i < totalCol ; i++){
            nodes[i] = new node();
            nodes[i].node = i+1 ;
            if(i==0){
                head = nodes[i];
            }else{
                nodes[i-1].next = nodes[i];
            }
        }
        nodes[totalCol-1].next = head ;
        return head ;
    }

    public void begin(int total){
        int sort = 0 ;
        int n = total ;
        int m = 5 ;
        m %= n ;
        node head = createNodes(total);
        //�ж�ѭ�������ǲ���ֻʣ��һ���ڵ�
        while(head.next != head){
            for(int i = 1 ; i < m-1 ; i++){
                head = head.next;
            }
            node temp = head.next;
            System.out.println("��"+(++sort)+"����ɱ��Ϊ��"+temp.node);
            head.next = temp.next;
            head = head.next;
        }
        System.out.println("��"+(++sort)+"����ɱ��Ϊ��"+head.node);
    }

    public static void main(String[] args) {
        Yuesefu y = new Yuesefu();
        y.begin(6);
    }
}
class node {
    node next ;
    int node ;
    public node getNext() {
        return next;
    }
    public void setNext(node next) {
        this.next = next;
    }
    public int getNode() {
        return node;
    }
    public void setNode(int node) {
        this.node = node;
    }
}
