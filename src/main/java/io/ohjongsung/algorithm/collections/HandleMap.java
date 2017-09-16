package io.ohjongsung.algorithm.collections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-08
 * Description :
 */
public class HandleMap {
    public static void main(String[] args) {
        Map<String, String> map1 = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();

        map1.put("1", "1");
        map1.put("2", "2");
        map1.put("3", "3");
        map1.put("4", "4");

        map2.put("3","3");
        map2.put("4","4");
        map2.put("5","5");
        map2.put("6","6");

        intersectionMap(map1, map2);
        unionMap(map1, map2);
        differenceMap(map1, map2);
    }

    private static void differenceMap(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> differenceMap = new HashMap<>(map1);
        differenceMap.entrySet().removeAll(map2.entrySet());
        System.out.println(differenceMap);
    }

    private static void unionMap(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> unionMap = new HashMap<>(map1);
        for (String key : map2.keySet()) {
            String value = map2.get(key);
            if (!unionMap.containsKey(key) && !unionMap.containsValue(value)) {
                unionMap.put(key, value);
            }
        }
        System.out.println(unionMap);
    }

    private static void intersectionMap(Map<String, String> map1, Map<String, String> map2) {
        Map<String, String> intersectionMap = new HashMap<>(map1);
        intersectionMap.entrySet().retainAll(map2.entrySet());
        System.out.println(intersectionMap);
    }
}
