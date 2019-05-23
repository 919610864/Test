package design_pattern.builder.demo;


public class BMWCarProduct extends CarModel{


    @Override
    public void start() {
        System.out.println("宝马开始启动了");
    }

    @Override
    public void stop() {
        System.out.println("宝马骑车停止了");
    }
}
