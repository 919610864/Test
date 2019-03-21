package arithmetic;

import java.util.Arrays;
import java.util.Random;

/**
 * 直接排序O(n^2)
 */
public class DirectorSort {
    public static void main(String[] args) {
            //声明一个数组
            int[] array = new int[10];
            //为这个数组随机填入整型数字
            Random random = new Random();
            for (int i = 0; i < array.length ; i++) {
                array[i] = random.nextInt(500);
            }

            System.out.print("原始数组  ：");
            System.out.println(Arrays.toString(array));
            /****************************************
             下面开始正式的“直接选择排序”算法
             直接选择排序的关键：
             1：从a[0]-a[N-1]中选出最小的数据，然后与a[0]交换位置
             2：从a[1]-a[N-1]中选出最小的数据，然后与a[1]交换位置（第1步结束后a[0]就是N个数的最小值）
             3：从a[2]-a[N-1]中选出最小的数据，然后与a[2]交换位置（第2步结束后a[1]就是N-1个数的最小值）
             以此类推，N-1次排序后，待排数据就已经按照从小到大的顺序排列了。
             ****************************************/
            //N个数组元素，就需要循环N轮
            for(int i = 0; i < array.length-1; i++){
                //最小数的索引，该索引每次都根据外层循环的计数器来觉得初始值。
                int minIndex = i;
                for (int j = i + 1; j < array.length; j++) {
                    //根据最小数的索引，判断当前这个数是否小于最小数。
                    //如果小于，则把当前数的索引作为最小数的索引。
                    //否则不处理。
                    if(array[minIndex] > array[j]){
                        minIndex = j;
                    }
                    //直到循环完成的时候，minIndex肯定就是当前这轮循环中，最小的那个。
                }
                //System.out.print(i + "轮，最小数" + array[minIndex] + "，");
                //System.out.print("原索引" + minIndex + "，新索引" + i);
                //得到最小数的索引后，把该索引对应的值放到最左边，并且把最左边的值放到索引所在的位置.
                //最左边的值
                int temp = array[i];
                //把最小数索引对应的值放到最左边
                array[i] = array[minIndex];
                //把原来最左边对应的值放到最小数索引所在的位置
                array[minIndex] = temp;
                System.out.println(String.format("%2s",(i + 1)) + "轮排序后：" + Arrays.toString(array));
        }
    }
}
