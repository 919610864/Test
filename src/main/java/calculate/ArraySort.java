package calculate;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * 求一个数组里的数的所有组合和全排列
 */
public class ArraySort {

    public static void main(String [] args) {
        String [] array = new String[]{"1","2","3","4"};
        DFS(Arrays.asList(array),"");
    }

    /**
     * 没有重复元素
     * @param candidate
     * @param prefix
     */
    private static void DFS(List<String> candidate, String prefix) {
        if(prefix.length()!=0){
            System.out.println(prefix);
        }
        for (int i = 0;i<candidate.size();i++){
            List temp = new LinkedList(candidate);
            DFS(temp,prefix+ temp.remove(i));
        }
    }

    /**
     * 存在重复元素
     * @param candidate
     * @param prefix
     * @param hashSet
     */
    private static void DFS(List<String> candidate, String prefix, HashSet hashSet) {
        if(prefix.length()!=0 && !hashSet.contains(prefix)){
            System.out.println(prefix);
            hashSet.add(prefix);
        }
        for (int i = 0;i<candidate.size();i++){
            List temp = new LinkedList(candidate);
            DFS(temp,prefix+ temp.remove(i));
        }
    }



}
