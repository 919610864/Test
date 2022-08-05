package arithmetic.leecode_arthmetic;

/**
 * 打印从1到最大的n位数
 */
public class Solution3 {

    public static void main(String[] args) {
        printNumbers(Integer.MAX_VALUE);
    }


    public static int[] printNumbers(int n) {
        int [] array = new int[n];
        for(int i = 0;i<array.length;i++){
            array[i] = i + 1;
        }
        return array;
    }
}
