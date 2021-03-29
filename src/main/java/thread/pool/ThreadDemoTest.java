package thread.pool;

import org.junit.Test;

public class ThreadDemoTest {


    @Test
    public void testThread(){
        System.out.println("come test");
        new ThreadDemo().run();
    }
}
