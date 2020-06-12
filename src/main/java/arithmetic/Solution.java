package arithmetic;

import collection.ConcurrentHashMapDemo;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         int [] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        findRepeatNumber(nums);
    }

    public static int findRepeatNumber(int[] nums) {

        if(nums == null){
            return 0;
        }

        Arrays.sort(nums);
        int num = -1;
        for (int i = 0;i<nums.length;i++){
            if(i != nums[i]){
                num = nums[i];
                break;
            }
        }
        return num;
    }

}
