package arithmetic.leecode_arthmetic;
/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *[
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 */

import java.util.Random;

public class Solution2 {

    public static boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i = 0;i<matrix.length;i++){
            for(int j = 0;j<matrix[i].length;j++){
                int data = matrix[i][j];
                if(target < data){
                    break;
                }else if(target == data){
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 从尾部开始比较
     * @param matrix
     * @param target
     * @return
     */
    public static boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if(matrix.length <= 0){
            return false;
        }
        boolean isFlag = false;
        for (int i = matrix.length-1;i>=0;i--){
            if(matrix[i].length == 1){
                if (target == matrix[i][0]){
                    isFlag = true;
                    break;
                }
            }else {
                for (int j = 0;j<matrix[i].length;j++){
                    if(target > matrix[i][j]){
                        continue;
                    }else if (target == matrix[i][j]){
                        isFlag = true;
                        break;
                    }
                }
            }
        }
        return isFlag;
    }

    public static void main(String[] args) {
        int n = 10;
        int m = 20;
        int array [] [] = new int[n][m];
        Random random = new Random();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                array[i][j] = random.nextInt(10*(j+1));
            }
        }
        boolean flag = findNumberIn2DArray(array,20);
        System.out.println(flag);
    }
}
