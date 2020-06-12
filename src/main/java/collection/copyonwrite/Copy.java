package collection.copyonwrite;

public class Copy {

    public static void main(String[] args) {
        System.out.println("abc");
      String cde = "cde";
      System.out.println("abc" + cde);
      String c = "abc".substring(2,3);
     String d = cde.substring(1, 2);
        System.out.println(c);
        System.out.println(d);
    }
}
