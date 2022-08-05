package jvm;

import java.util.HashSet;
import java.util.Set;

/**
 * jdk7以上 常量池被移至到java堆中 不在方法区中
 * VM args：-XX:MaxPermSize jdk7以前
 * VM args：-XX:MaxMetaspaceSize 不好使
 * VM args：-Xmx1M jdk7以后
 */
public class TestMethodArea {


    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        short i = 0;
        while (true){
            set.add(String.valueOf(i++).intern());
        }
    }
}
