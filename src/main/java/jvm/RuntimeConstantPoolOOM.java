package jvm;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        short i = 0;
//        while (true){
//            set.add(String.valueOf(i++).intern());
//        }

        String str = "maguodong";
        System.out.println(str.intern() == str);

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);

        String str3 = new String("123");
        System.out.println(str3.intern() == str3);

        String s1 = new String("abc");

        String s2 = "abc";

        String s3 = s1.intern();

        System.out.println(s1 == s3);

        HashMap hashMap=new HashMap();
        hashMap.put("a","a");

    }
}
