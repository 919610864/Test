package thread.synchronizedtest;

public class TestObj {

    public static class InnterClass{
        public  static StaticObj staticObj;
        public StaticObj obj;

        public void getObj(){
            StaticObj staticObj = new StaticObj();
        }
    }

    private static class StaticObj{

    };

    public static void main(String[] args) {
        TestObj.StaticObj testObj = new StaticObj();
    }
}
