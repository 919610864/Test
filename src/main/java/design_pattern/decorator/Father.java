package design_pattern.decorator;

public class Father {

    public static void main(String[] args) {
        SchoolReport schoolReport = new FouthGradeSchoolReport();
        schoolReport = new HighScoreDecorator(schoolReport);
        schoolReport = new SortDecorator(schoolReport);
        schoolReport.report();
        schoolReport.sign("老三");
    }
}
