package arithmetic.one;

public abstract class A {

    private String parentId = "1";

    public void printMe() {
        System.out.println("I love vim");
    }
    public abstract void sayHello();


    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }
}
