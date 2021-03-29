package java8;

import java.util.UUID;

public class StringObjectFactory  {


    public static String get() {
        return UUID.randomUUID().toString();
    }
}
