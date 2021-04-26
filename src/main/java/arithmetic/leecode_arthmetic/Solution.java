package arithmetic.leecode_arthmetic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 找出重复数据即可
 * 剑指offer算法第一题
 * https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
 */
public class Solution {

    public static void main(String[] args) {
        int [] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber(nums));
    }

    public static Object[] findRepeatNumber(int[] nums) {

        if(nums == null){
            return new Object[0];
        }

        Arrays.sort(nums);
        int num = -1;
        List<Integer> result = new ArrayList<>();
        for (int i = 0;i<nums.length;i++){
            if(num == nums[i]){
                result.add(num);
                continue;
            }
            num = nums[i];
        }
        return result.toArray();
    }

}
