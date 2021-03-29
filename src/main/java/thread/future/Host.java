package thread.future;

public class Host {

    public Data request(final int count,final char c){
        System.out.println(" request(" + count + "," + c + ") BEGIN");
        //(1) 创建FutureData的实例
        final FutureData futureData = new FutureData();
        //(2) 启动一个新线程,用于创建RealData的实例
        new Thread(){
            @Override
            public void run() {
                RealData realData = new RealData(count,c);
                futureData.setRealData(realData);
            }
        }.start();
        System.out.println(" REQUEST(" + count + "," + c + ") END");
        return futureData;
    }
}
