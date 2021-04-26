package arithmetic;

import org.junit.Test;

/**
 * 判断一个数字是否是2的N次幂
 * 采用按位与的方式 只能做二进制操作
 */
public class Test1 {


    /**
     * 判断奇偶
     */
    @Test
    public void testOddOrEvenNumber(){
        int number  = 111;
        if((number & 1) == 1){
            System.out.println("奇数");
        }else {
            System.out.println("偶数");
        }
    }


    /**
     * 判断是否为2的N次方
     */
    @Test
    public void testPowerOfTwo(){
        int number = 1024;

        if((number &(number - 1)) == 0){
            System.out.println("number是2的N次方");
        }else {
            System.out.println("number不是2的N次方");
        }
    }
}
