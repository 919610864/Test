package aqs;

public class Test {

    public static void take(Demo<?> animal){
        animal.print();
    }

    public static void main(String[] args) {
        Demo<Cat> cat = new Demo<Cat>(new Cat());
        take(cat);
    }
}
