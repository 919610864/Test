package design_pattern.singleton.inner;

import java.io.Serializable;

/**
 * 静态内部类
 *本质 通过类加载保证线程安全
 * 也属于懒加载的一种 只有真正使用的时候 才会去初始化
 *
 */
public class InnerclassSingleton implements Serializable {


    private InnerclassSingleton (){

        if(InnerclassHolder.innerclassSingleton!=null){
            throw new RuntimeException("无法通过反射创建单例实例");
        }

    }

    public InnerclassSingleton getInstance(){
        return InnerclassHolder.innerclassSingleton;
    }

    /**
     * 静态内部类
     */
    private static class InnerclassHolder{

        private static InnerclassSingleton innerclassSingleton = new InnerclassSingleton();

    }


}
