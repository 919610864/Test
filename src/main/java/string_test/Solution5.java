package string_test;

import java.nio.charset.StandardCharsets;

/**
 * leecode 剑指offer-5
 * 替换空格
 */
public class Solution5 {

    public static void main(String[] args) {
        String s = " We are happy. ";
        byte percentCode= "%".getBytes()[0];
        byte twentyCode = "2".getBytes()[0];
        byte zeroCode = "0".getBytes()[0];
        byte spaceCode= " ".getBytes()[0];
        byte[] array = s.getBytes();
        byte [] newArray = new byte[array.length*3];
        int index = 0;
        for (int i = 0;i<array.length;i++) {
            if (array[i] == spaceCode) {
                newArray[index++] = percentCode;
                newArray[index++] = twentyCode;
                newArray[index++] = zeroCode;
            } else {
                newArray[index++] = array[i];
            }
        }
        System.out.println(new String(newArray,0,index));
    }
}
