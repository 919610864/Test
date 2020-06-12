package thread.guarded_suspension;

public class Main {

    public static void main(String[] args) {
        RequestQueue requestQueue = new RequestQueue();
        new ClientThread(requestQueue,"Alice",12345).start();
        new ServerThread(requestQueue,"Blice",123456).start();
    }
}
