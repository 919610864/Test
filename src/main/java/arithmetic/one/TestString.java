package arithmetic.one;

public class TestString {


    public static void main(String[] args) {
        System.out.println("return value of getValue():"+getValue());
    }

    private static int getValue() {
        int i = 1;
        try
        {
            return i++;
        }finally {
            i++;
            System.out.println(i);
        }
    }
}
