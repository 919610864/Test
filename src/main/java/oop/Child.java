package oop;

import java.lang.reflect.Field;

/**
 * 1.子类能否访问父类的私有字段
 * 答：可以通过get/set,如果不通过这个，通过反射可以吗？答：不可以
 * 2.
 */
public class Child extends Parent{

    private Long childId;


    public void test(){
    }


    public static void main(String[] args) throws NoSuchFieldException {
        Child child = new Child();

        Class clazz = child.getClass();
        Field id = clazz.getDeclaredField("id");
        System.out.println("父类id为："+id);
        System.out.println("输出");
    }
}
