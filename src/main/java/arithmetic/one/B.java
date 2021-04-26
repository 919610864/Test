package arithmetic.one;

import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class B  extends A{

    private String subId = "2";

    public static String s1 = "s1";

    @Override
    public void sayHello() {

    }

    public String getSubId() {
        return subId;
    }

    public void setSubId(String subId) {
        this.subId = subId;
    }

    public static void main(String[] args) throws Exception {
//        B obj = new B();
//        System.in.read();
//        System.out.println(obj);
        Class c1 = Class.forName("arithmetic.one.B");
        Object publicFiled = c1.newInstance();
        //Field subId = c1.getDeclaredField("parentId");
        Method getMethod = c1.getMethod("getSubId", new Class[] {});
        Object value = getMethod.invoke(publicFiled, new Object[] {});
        System.out.println(value);
    }
}
