package classload;

public class MyClassloderTest {

    public void add (){
        System.out.println("add method");
    }

    public static void main(String[] args) {
        MyClassloderTest myClassloderTest = new MyClassloderTest();
        myClassloderTest.add();
        System.out.println(myClassloderTest.getClass().getClassLoader());
    }
}
