package thread.balk;

public class Main {

    /**
     * data 为一个自定义数据类型 数据类型
     * 定义俩线程
     * @param args
     */
    public static void main(String[] args) {
        Data data = new Data("data.txt","(empty)");
        new ChangerThread("ChangerThread",data).start();
        new ServerThread("ServerThread",data).start();
    }
}
