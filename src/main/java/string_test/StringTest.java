package string_test;

import org.junit.Test;

public class StringTest {

    @Test
    public void t1(){
        int [] arr = new int[]{3,1,6,8,2,5};
        int [] arr1 ={3,1,6,8,2,5};
        System.out.println(arr.equals(arr1));//结果 false
        String[] aa=new String[]{"aa","bb","cc"};
        String[] bb={"aa","bb","cc"};
        System.out.println(aa.equals(bb));//结果 false
        String a="abc";
        String b=new String("abc");
        String c=new String("abc");
        System.out.println(a==b);//结果 false
        System.out.println(b == c);
//        System.out.println(a.equals(b));//结果 true
//        System.out.println(b.equals(c));//结果 true
//        System.out.println(a.equals(c));//结果 true
    }
}
