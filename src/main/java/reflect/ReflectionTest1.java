package reflect;

public class ReflectionTest1 {

    public static void main(String[] args) throws ClassNotFoundException {
        Person person = new Person();
        //方式一
        Class c1 = person.getClass();
        System.out.println(c1.hashCode());
        //方式二
        Class c2 = Class.forName("reflect.Person");
        System.out.println(c2.hashCode());
        //判断class是否相等
        System.out.println(c1 == c2);
    }
}


class Person{

    private String name;

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
