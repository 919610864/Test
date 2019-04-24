package thread.lock;

public class Sleep {
    /**

     * 睡眠n毫秒

     * @param time

     */

    public static void threadSleep(int time){

        try {

            Thread.sleep(time);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }

    /**

     * 睡眠n-m秒

     * @param time 1-6

     */

    public static void threadSleep(String time){

//1-6

        String[] split = time.split("-");

        int first = Integer.parseInt(split[0]);

        int second = Integer.parseInt(split[1]);

        try {

            Thread.sleep((first+(int)(Math.random()*(second-first)))*1000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}
