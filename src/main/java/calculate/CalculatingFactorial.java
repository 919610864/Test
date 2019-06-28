package calculate;

/**
 * 倒叙输出数字 例：输入1234，输出4321
 */
public class CalculatingFactorial {

    public int reverseNum(int paraNum){
        int revNum = 0;
        // 关键也就是这三行的代码
        while(paraNum != 0){
            revNum =  paraNum % 10 + revNum * 10;
            paraNum /= 10;
        }
        return revNum;
    }
    public static void main(String[] args) {
        System.out.println(new CalculatingFactorial().reverseNum(1234));
    }

}
