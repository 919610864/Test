package thread.timer;

import java.util.Calendar;
import java.util.Timer;

public class TestTask {

    public static void main(String[] args) {
        // 建立Timer对象
        Timer t = new Timer();
        //定义任务
        MyTask task = new MyTask();
        //设置任务的执行，1秒后开始，每2秒执行一次
       // t.schedule(task, 1000,2000);

        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.MINUTE, 30);
        System.out.println(cal.getTime());
        t.schedule(task, cal.getTime() , 2000);
    }
}
