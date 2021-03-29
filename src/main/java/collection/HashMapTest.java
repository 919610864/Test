package collection;

import java.util.HashMap;
import java.util.Map;

public class HashMapTest {
    public static void main(String[] args) {
        Map map = new HashMap();
        map.put("af","af");
        map.put("ae","ae");
        map.put("be","a");
        map.put("cc","a");
        map.put("aaa","a");
        map.put("b","a");
        map.put("bb","a");
        map.put("acd","a");
        map.put("ad","a");
        map.put("af","a");
        map.put("ae","a");
        map.put("bc","a");
        System.out.println(map.size());
    }
}
