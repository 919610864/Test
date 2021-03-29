package handler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK 动态代理类,需要实现InvocationHandler接口
 */
public class AnimalInvocationHandler implements InvocationHandler {

    /**
     * 被代理对象
     */
    private Object target;

    private AnimalPar animalPar;

    private Animal animal;

    /**
     * 绑定目标对象并返回代理类
     * @param target
     * @return
     */
    public Object bind(Object target){
        this.target = target;
        return Proxy.newProxyInstance(AnimalPar.class.getClassLoader(),new Class[]{Animal.class},
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object result = null;
        System.out.println("执行业务逻辑前");
        result = method.invoke(target,args);
        System.out.println("执行业务逻辑后");
        return result;
    }


    public static void main(String[] args) {
        AnimalInvocationHandler animalInvocationHandler = new AnimalInvocationHandler();
        Dog dog = new Dog();
        Animal proxy = (Animal) animalInvocationHandler.bind(dog);
        proxy.eat();

    }
}
