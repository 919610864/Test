package design_pattern.decorator;

public class SortDecorator extends Decorator{


    public SortDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportSort(){
        System.out.println("我的排名是第38");
    }

    @Override
    public void report() {
        super.report();
        this.reportSort();
    }
}
