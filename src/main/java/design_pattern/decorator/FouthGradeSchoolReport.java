package design_pattern.decorator;

public class FouthGradeSchoolReport extends SchoolReport {


    @Override
    public void report() {
        System.out.println("汇报成绩单");
    }

    @Override
    public void sign(String name) {
        System.out.println("签名："+name);
    }
}
