package reflect;

import org.junit.Test;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReflectTest {

    /**
     * java泛型是通过类型擦除实现的 为什么通过反射还能获得泛型类型
     * 我们都知道java泛型的实现是通过类型擦除实现的，
     * 在字节码中，并没有保存泛型的信息。泛型的实现是在字节码之上的，类似于语法糖
     */
    @Test
    public void test1(){
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        System.out.println(a.getClass() == b.getClass());
    }


    public Map<Integer,String> map = new HashMap<>();

    /**
     * 如何通过反射获取泛型类型
     * 在class文件中，并没有丢弃泛型类型
     * Signature属性
     * Signature属性出现在类、字段表、方法表结构的属性表中，会为这些属性记录泛型签名信息。
     * Java的反射API可以获取泛型类型，最终的数据来源也是这个属性。
     * 所以java泛型的类型擦除并不是在class文件中不保存泛型信息，
     * 而是在字节码中擦除了这些信息，这样做的好处就是在不改变虚拟器的前提下可以引入泛型的特性。
     * @throws NoSuchFieldException
     */
    @Test
    public void getGenericTypesType() throws NoSuchFieldException {
        Field field = ReflectTest.class.getField("map");
        System.out.println(field.getType());
        Type type = field.getGenericType();
        if (type instanceof ParameterizedType) {
            ParameterizedType pt = ((ParameterizedType) type);
            Type [] acType = pt.getActualTypeArguments();
            for (Type t : acType)
                System.out.println(t);
        }
    }

    public void testAllType(){
        Class c1 = Object.class; //类
        Class c2 = Comparable.class; //接口
    }

    public void test2() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class c1 = Class.forName("");
        Object o = c1.newInstance();

        //通过构造器创建对象

    }
//////////////////////////////////////////////////////////通过反射获取泛型 demo ///////////////////////////////////////////////////

    public List<User> putUser(Map<String,Long> map,List<User> users){
        System.out.println("put user");
        return new ArrayList<>();
    }

    /**
     * 通过反射获取请求参数泛型类型 和返回值参数类型
     */
    @Test
    public void getGenericByReflection() throws ClassNotFoundException, NoSuchMethodException {
        //1.获取请求方法参数泛型
        Class c1 = Class.forName("reflect.ReflectTest");
        Method m1 = c1.getMethod("putUser", Map.class, List.class);
        Type[] genericParameterTypes = m1.getGenericParameterTypes();
        for(int i = 0;i<genericParameterTypes.length;i++){
            //System.out.println(genericParameterTypes[i].getTypeName());
            if(genericParameterTypes[i] instanceof ParameterizedType){
                Type[] actualTypeArguments = ((ParameterizedType) genericParameterTypes[i]).getActualTypeArguments();
                for(int j = 0;j<actualTypeArguments.length;j++){
                    System.out.println("请求参数泛型:"+actualTypeArguments[j].getTypeName());
                }

            }
        }

        //2.获取返回值泛型
        Type genericReturnType = m1.getGenericReturnType();
        if(genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments = ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for(int j = 0;j<actualTypeArguments.length;j++){
                System.out.println("返回参数类型:"+actualTypeArguments[j].getTypeName());
            }

        }

        //获取接口泛型 最终得到T
        Class c2 = Class.forName("reflect.User");
        Type[] typeParameters = c2.getTypeParameters();
        for (int i = 0;i<typeParameters.length;i++){
            System.out.println(typeParameters[i].getTypeName());
        }

//        User<ChildUser> user = new User();
//        Type[] typeParameter2 = user.getClass().getTypeParameters();
//        for (int i = 0;i<typeParameter2.length;i++){
//            System.out.println(typeParameter2[i].getTypeName());
//        }
    }

}
