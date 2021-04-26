package arithmetic.two;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Stack;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

class Car  {

    static synchronized void f(){

    }

    public static void main(String[] args) throws InterruptedException, BrokenBarrierException {
        Thread t1 =new Thread(Car::f);
        Thread t2 =new Thread(Car::f);
        t1.start();
        Car car = new Car();
        CyclicBarrier cy = new CyclicBarrier(10);
        cy.await();
        t2.start();
        Stack stack = new Stack();
    }


}
