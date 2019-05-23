package design_pattern.builder;

/**
 * 具体建造者
 * 需要注意的是，如果有多个产品类就有几个具体的建造者，而且这多个产品类具有相同
 * 接口或抽象类，参考我们上面的例子
 */
public class ConCreteProduct extends Builder {

    private Product product = new Product();

    @Override
    public void setPart() {
        //产品内部逻辑
    }

    @Override
    public Product buildProduct() {
        return product;
    }
}
