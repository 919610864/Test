package thread.future;

public class FutureData implements Data {

    private RealData realData;

    private boolean ready;

    public synchronized void setRealData(RealData realData){
        if(ready){
            return;    //balk
        }
        this.realData = realData;
        this.ready = true;
        notifyAll();
    }




    @Override
    public String getContent() {
        while (!ready){
            try{
                wait();
            }catch (Exception e){

            }
        }
        return realData.getContent();
    }
}
