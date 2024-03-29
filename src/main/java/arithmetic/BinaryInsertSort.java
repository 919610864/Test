package arithmetic;

/**
 * ���ַ���������
 */
public class BinaryInsertSort {

    public static void main(String[] args) {
        int[] a = {49, 38, 65, 97, 176, 213, 227, 49, 78, 34, 12, 164, 11, 18, 1};
        System.out.println("����֮ǰ��");
        show(a);
        sort(a);
        System.out.println();
        System.out.println("����֮��");
        show(a);
    }

    private static void show(int [] a){
        for (int i = 0; i < a.length; i++)
        {
            System.out.print(a[i] + " ");
        }
    }

    /**
     * ���ֲ��������㷨
     * @param a
     */
    private static void sort(int [] a){
        for (int i = 0; i < a.length; i++) {
            int temp = a[i];
            int left = 0;
            int right = i - 1;
            int mid = 0;
            while (left <= right) {
                mid = (left + right) / 2;
                if (temp < a[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            for (int j = i - 1; j >= left; j--) {
                a[j + 1] = a[j];
            }
            if (left != i) {
                a[left] = temp;
            }
        }
    }
}
