package jvm;

/**
 * VM args：-Xss128K
 * description：test xss length
 * 1.test
 * 2.
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){

        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stackLength);
            throw e;
        }
    }
}
