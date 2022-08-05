package jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args: -Xms20m -XX:+HeapDumpOnOutOfMemoryError
 */
public class HeapOOM {

    static class OOMObject{
        private String name;
        private int age;
        private String desc;
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        while (true){
            list.add(new OOMObject());
        }
    }
}
