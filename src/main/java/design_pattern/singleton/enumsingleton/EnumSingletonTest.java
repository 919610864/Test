package design_pattern.singleton.enumsingleton;

import design_pattern.singleton.enumsingleton.EnumSingleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class EnumSingletonTest {

    public static void main(String[] args) throws InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchMethodException {

        //测试枚举是否可以通过反射 序列化 破坏 单例类
        Constructor<EnumSingleton> declaredConstructor = EnumSingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        EnumSingleton enumSingleton1 = declaredConstructor.newInstance("INSTANCE",0);

        System.out.println(enumSingleton1 == EnumSingleton.INSTANCE);

    }
}
