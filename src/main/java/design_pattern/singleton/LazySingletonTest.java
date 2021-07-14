package design_pattern.singleton;

/**
 * 多线程情况下 会出现以下情况
 * design_pattern.singleton.LazySingletonTest@469bbe93
 * design_pattern.singleton.LazySingletonTest@f82783a
 */
public class LazySingletonTest {

    private static LazySingletonTest instance ;

    public static LazySingletonTest getInstance() {
        if (instance == null) {
            try {
                Thread.sleep(200);
                instance = new LazySingletonTest();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return instance;
    }

    public static void main(String[] args) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonTest instance = LazySingletonTest.getInstance();
                System.out.println(instance);

            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                LazySingletonTest instance = LazySingletonTest.getInstance();
                System.out.println(instance);

            }
        }).start();
    }
}
