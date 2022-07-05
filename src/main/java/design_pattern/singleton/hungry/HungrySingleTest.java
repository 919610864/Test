package design_pattern.singleton.hungry;

import design_pattern.singleton.lazy.LazySingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class HungrySingleTest {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, Exception {
        //获取构造函数
        Constructor<HungrySingleton> declaredConstructor = HungrySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        HungrySingleton lazySingleton = declaredConstructor.newInstance();

        System.out.println(lazySingleton == HungrySingleton.getInstance());

    }
}
