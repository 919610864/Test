package arithmetic.stack;

/**
 * ʹ�õݹ����ջ�����
 * -Xss:520K
 */
public class TestStack {

    private int count = 0;

    public void testAdd(){
        count ++;
        testAdd();
    }
    public void test(){
        try{
            testAdd();
        }catch(Throwable e){
            System.out.println(e);
            System.out.println("ջ���:"+count);
        }
    }
    public static void main(String [] args){
        new TestStack().test();
    }
}
