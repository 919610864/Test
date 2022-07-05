package string_test;

import java.util.*;

/**
 * 剑指offer-38
 *
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * demo:
 *      输入：s = "abc"
 *      输出：["abc","acb","bac","bca","cab","cba"]
 */
public class Solution38 {

    public static void main(String[] args) {
        String s = "abcabcde";
        String[] sArray = permutation(s);
        Set<Character> set = new HashSet<>();
        System.out.println(Arrays.toString(sArray));
    }

    public static String[] permutation(String s) {
        String sArray [] = s.split("");
        //去重
        Set<String> set = new HashSet<>();
        for (int i = 0; i < sArray.length; i++) {
            set.add(sArray[i]);
        }
        Iterator<String> iterator = set.iterator();


        return sArray;
    }
}
