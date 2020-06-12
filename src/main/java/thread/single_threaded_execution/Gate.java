package thread.single_threaded_execution;

/**
 * 表示人通过的门
 */
public class Gate {

    /**
     * 通过次数
     */
    private volatile int count = 0;

    /**
     * 姓名
     */
    private volatile String name = "Nobody";

    /**
     * 地址
     */
    private volatile String address = "Nowhere";

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Gate{" +
                "count=" + count +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    public synchronized void pass(String name, String myAddress) {
        this.count++;
        this.name = name;
        this.address = myAddress;
        check();
    }

    private void check() {
        if(name.charAt(0) !=address.charAt(0)){
            System.out.println("******************BROKEN**********************"+toString());
        }
    }
}
