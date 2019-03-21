package design_pattern.prototype;

public class CloneTest {

    public static void main(String[] args) {

        ConcretePrototype cp = new ConcretePrototype();
        cp.setAge(19);
        try {
            ConcretePrototype copy = (ConcretePrototype) cp.clone();
            System.out.println(copy.getAge());
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
