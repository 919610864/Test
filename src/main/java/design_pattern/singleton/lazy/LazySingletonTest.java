package design_pattern.singleton.lazy;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * 多线程情况下 会出现以下情况
 * design_pattern.singleton.lazy.LazySingletonTest@469bbe93
 * design_pattern.singleton.lazy.LazySingletonTest@f82783a
 */
public class LazySingletonTest {

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        //获取构造函数
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton lazySingleton = declaredConstructor.newInstance();

        System.out.println(lazySingleton == LazySingleton.getInstance());


    }
}
