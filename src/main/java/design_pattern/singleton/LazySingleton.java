package design_pattern.singleton;

/**
 * 懒汉模式：延迟加载，只有真正使用的时候，才开始实例化
 * 存在问题：线程安全
 * double check + synchronize(加锁优化)
 * JIT，CPU可能对指令重排序，导致使用到尚未初始化对象 解决方法：使用volatile 防止指令重排
 *
 * javap -g LazySingleton.java 生成字节码文件
 * javac -v -p LazySingleton.class > LazySingleton 反编译
 *
 */
public class LazySingleton {

    //volatile 防止对象创建指令重排序
    private static volatile LazySingleton instance;

    //私有构造函数
    private LazySingleton(){

    }

    /**
     * 采用double check 创建对象
     * 使用synchronized 加锁 保证并发情况下 只有一个线程进入代码块
     * 无法保证 通过 反射 或者序列化对单例对象的破坏
     */
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class){
                if(instance == null){
                    instance = new LazySingleton();
                }
            }
        }

        return instance;

    }

//    public static void main(String[] args) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingletonTest instance = LazySingletonTest.getInstance();
//                System.out.println(instance);
//
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                LazySingletonTest instance = LazySingletonTest.getInstance();
//                System.out.println(instance);
//
//            }
//        }).start();
//    }
}
