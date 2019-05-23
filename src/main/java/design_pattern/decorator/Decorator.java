package design_pattern.decorator;

/**
 * 装饰者把动作的执行委托给需要装饰的对象
 */
public class Decorator extends SchoolReport{

    private SchoolReport schoolReport;

    public Decorator(SchoolReport schoolReport){
        this.schoolReport = schoolReport;
    }


    @Override
    public void report() {
        this.schoolReport.report();
    }

    @Override
    public void sign(String name) {
        this.schoolReport.sign(name);
    }
}
