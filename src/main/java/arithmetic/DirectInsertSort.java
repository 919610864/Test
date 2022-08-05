package arithmetic;

/**
 * 插入排序
 * 时间复杂度:O(n^2)
 * 最好的情况,O(n)
 */
public class DirectInsertSort {
    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 1};
//        System.out.println("排序之前：");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
        // 直接插入排序
        int size = a.length;
        for (int i = 1; i < size; i++) { //为什么从1开始,因为第一个数字已经确定
            // 待插入元素
            int temp = a[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                // 将大于temp的往后移动一位
                if (a[j] > temp) {
                    a[j + 1] = a[j];
                } else {
                    break;
                }
            }
            a[j + 1] = temp;
            System.out.print("第"+i+"次排序");
            for (j = 0; j<size; j++) {
                System.out.print(a[j] + " ");
            }
            System.out.println();
        }
        //System.out.println();
//        System.out.println("排序之后：");
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }

    }
}
