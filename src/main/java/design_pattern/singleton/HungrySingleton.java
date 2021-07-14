package design_pattern.singleton;

/**
 * 饿汉模式
 * 类的加载初始化阶段完成了实例的初始化
 * 本质是借助JVM类加载机制，保证了实例的唯一性和线程安全性
 *
 * 类加载过程：
 *      1.加载 loading
 *      2.连接 验证 准备：给类的静态成员赋默认值 解析
 *      3.初始化：给类的静态变量赋初值
 *      4.使用
 *      5.销毁
 *
 *  只有在真正使用对应的类时，才会触发初始化 如（
 *  当前类是启动类即main函数所在类，直接进行new
 *  操作，访问静态属性、访问静态方法，
 *  用反射访问类，初始化一个类的子类等.）
 */
public class HungrySingleton {

    private static HungrySingleton hungrySingleton = new HungrySingleton();

    private HungrySingleton(){

    }

    public static HungrySingleton getInstance(){
        return hungrySingleton;
    }



}
