package calculate;

import java.util.Scanner;

/**
 * 斐波那契数列的通项f(n),已经f1=1,f2=1,以后每一项都是前两项的和
 * f(n) = f(n-1) + f(n-2)
 */
public class FibonacciSequence {


    public static void main(String[] args) {
        System.out.println("请输入调用次数");
        Scanner scanner = new Scanner(System.in);
        long a = scanner.nextLong();
        System.out.println(fibonacci(a));
    }

    private static long fibonacci(long k) {
        if(k == 0 || k == 1){
            k++;
            return k;
        }else {
            return fibonacci(k-1) + fibonacci(k-2);
        }
    }
}
