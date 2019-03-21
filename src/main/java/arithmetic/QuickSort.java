package arithmetic;

/**
 * 快速排序
 * 时间复杂度O(nlogn)
 */
public class QuickSort {

    public static void main(String[] args) {
        int [] array = new int [] {3,7,10,17,9,6,2};
        quickSort1(array,0,array.length-1);
        System.out.println(array.toString());
    }

    public static void quickSort1(int[] array, int start, int end){
        if(start>=end){
            return;
        }
        //定义一个基数，以这个基数作比较
        int mid = array[start];
        int i = start;
        int j = end;
        while (i < j) {

            while (i< j && array[j] > mid){
                j--;
            }
            array[i] = array[j];

            while (i< j && array[i] < mid){
                i++;
            }
            array[j] = array[i];

        }
        /*此时i==j*/
        array[i] = mid;

        //基数左边排序
        quickSort1(array,start,i-1);
        //基数右边排序
        quickSort1(array,j+1,end);

    }










}
