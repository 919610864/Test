package executor;

import thread.thread_per_message.Helper;

import java.util.concurrent.Executor;

public class Host {

    private final Helper helper = new Helper();

    private final Executor executor;

    public Host(Executor executor){
        this.executor = executor;
    }


}
