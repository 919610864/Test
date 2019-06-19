package calculate;

import static java.lang.Math.sqrt;

/**
 * 打印100以内的素数
 */
public class ScreeningOfPrimeNumbers {

    public static void main(String[] args) {
        //method1利用两个for循环一次排除
       // method1();
        //method2利用开根号的办法求值
        method2();
    }

    public static void method1() {
        int[] a = new int[101];
        for (int i = 1; i < 101; i++) {
            a[i] = 1;
        }
        for (int i = 2; i < 101; i++) {
            if (a[i] != 0) {
                for (int j = i + 1; j < 101; j++) {
                    if (j % i == 0) {
                        a[j] = 0;
                    }
                }
            }
        }
        for (int i = 2; i < 101; i++) {
            if (a[i] != 0) {
                //System.out.println(i);
            }
        }
    }

    public static void method2() {
        int[] array = new int[101];
        int j;
        for (int i = 1; i < 100; i++) {
            int k = (int) sqrt(i);
            for (j = 2; j <= k; j++) {
                if (i % j == 0) {
                    break;
                }
            }
            if (j > k) {
                System.out.println("  " + i);
            }
        }
    }
}
