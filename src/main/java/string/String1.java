package string;

import java.io.UnsupportedEncodingException;

/**
 * 1.��ͬ���뼶  gbk utf-8
 */
public class String1 {


    public static void main(String [] args) throws UnsupportedEncodingException {
//        String str = "Java\u2122";
//        System.out.println(str);
//
//        String str2 = "?";
//        System.out.println("�ַ��� \"\uD835\uDD46\" �ĳ����ǣ�" + str2.length());
//

        int length = new String("��").getBytes("UTF-8").length;
        System.out.println(length);
    }


}
