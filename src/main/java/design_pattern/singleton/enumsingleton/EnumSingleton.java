package design_pattern.singleton.enumsingleton;


/**
 *
 * 通过枚举实现单例
 * 通过类加载保证线程安全
 *
 * 天然支持 反射 破坏单例类  有自己的反序列化机制
 *
 */
public enum EnumSingleton {

    INSTANCE;

    public void print(){
        System.out.println(this.hashCode());
    }
}
