package string;

import java.io.UnsupportedEncodingException;

/**
 * 1.不同编码级  gbk utf-8
 */
public class String1 {


    public static void main(String [] args) throws UnsupportedEncodingException {
//        String str = "Java\u2122";
//        System.out.println(str);
//
//        String str2 = "?";
//        System.out.println("字符串 \"\uD835\uDD46\" 的长度是：" + str2.length());
//

        int length = new String("字").getBytes("UTF-8").length;
        System.out.println(length);
    }


}
