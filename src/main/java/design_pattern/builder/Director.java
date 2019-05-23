package design_pattern.builder;

/**
 * 导演类
 */
public class Director {

    private Builder builder = new ConCreteProduct();

    /**
     * 构建不同的产品
     * @return
     */
    public Product getProduct(){
        builder.setPart();

        return builder.buildProduct();
    }
}
