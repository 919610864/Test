package design_pattern.decorator;

public class HighScoreDecorator extends Decorator {


    public HighScoreDecorator(SchoolReport schoolReport) {
        super(schoolReport);
    }

    public void reportHighScore(){
        System.out.println("这次最高考试语文最高75，数学80，英语92");
    }

    @Override
    public void report(){
        this.reportHighScore();
        super.report();
    }

}
