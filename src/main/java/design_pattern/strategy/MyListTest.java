package design_pattern.strategy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MyListTest {
    public static void main(String[] args) {
        //策略模式
        List<Long> number = new ArrayList<>();
        Collections.sort(number, new Comparator<Long>() {
            @Override
            public int compare(Long o1, Long o2) {
                return 0;
            }
        });
    }
}
