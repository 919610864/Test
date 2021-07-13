package string_test;

/**
 * 剑指 Offer 15. 二进制中1的个数
 */
public class Solution15 {

    // you need to treat n as an unsigned value
    public static int hammingWeight(int n) {

        String binaryString = Integer.toBinaryString(n);
        String binaryStringArray [] = binaryString.split("");
        int result = 0;
        for(int i = 0;i<binaryStringArray.length;i++){
            if(1 == Integer.valueOf(binaryStringArray[i])){
                result+=1;
            }
        }
        return result;

    }

    public static int hammingWeight1(int n) {

        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;

    }




    public static void main(String[] args) {
        int result = hammingWeight1(10);
        System.out.println(result);
    }

}
