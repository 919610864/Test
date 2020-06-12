package gc;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * -Xms20m
 * -Xmx20m
 * -XX:MetaspaceSize=10m
 * -XX:MaxMetaspaceSize=10m
 * -XX:-UseGCOverheadLimit
 */
public class OutJvm {
    /**
     * 1.普通的对象实例爆掉堆内存
     * @param args
     */
    public static void main(String[] args) {
        //普通的对象实例爆掉堆内存
//        List<Object> list = new ArrayList();
//        int i = 0;
//        while(true){
//            list.add(new Object());
//        }

        //interned Strings过多爆掉堆内存(有待考证此代码的准确性,请不要盲目相信,要有自己的想法)
//        List<String> list = new ArrayList();
//        int i = 0;
//        while(true){
//            list.add(String.valueOf(i++).intern());
//        }

        Map map = System.getProperties();
        Random r = new Random();
        while (true) {
            map.put(r.nextInt(), "value");
        }
    }
}
