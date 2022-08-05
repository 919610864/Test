package string;

import java.util.Objects;

public class TestHashcodeAndEqual {

    private Long id;

    private String name;

    private int age;

    @Override
    public int hashCode() {

        return Objects.hashCode(id);
    }



    public static void main(String[] args) {
        TestHashcodeAndEqual t1 = new TestHashcodeAndEqual();
        t1.setId(100L);
        TestHashcodeAndEqual t2 = new TestHashcodeAndEqual();
        t2.setId(100L);
        System.out.println(t1.hashCode());
        System.out.println(t2.hashCode());
        System.out.println(t1 == t2);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
