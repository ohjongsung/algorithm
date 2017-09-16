package io.ohjongsung.algorithm.collections;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-08
 * Description :
 */
public class HandleSet {
    public static void main(String[] args) {
        Set<String> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        set1.add("a");
        set1.add("b");
        set1.add("c");
        set1.add("d");
        set1.add("e");

        set2.add("b");
        set2.add("c");
        set2.add("f");
        set2.add("g");

        // 교집합
        intersectionSet(set1, set2);
        // 차집합
        differenceSet(set1, set2);
        // 합집합
        unionSet(set1, set2);

    }

    private static void unionSet(Set<String> set1, Set<String> set2) {
        Set<String> unionSet = new HashSet<>(set1);
        //unionSet.addAll(set2);
        for (String item : set2) {
            unionSet.add(item);
        }
        System.out.println(unionSet);

    }

    private static void differenceSet(Set<String> set1, Set<String> set2) {
        Set<String> differenceSet = new HashSet<>(set1);
        //differenceSet.removeAll(set2);
        Iterator<String> iter = differenceSet.iterator();
        while (iter.hasNext()) {
            if (set2.contains(iter.next())) {
                iter.remove();
            }
        }
        System.out.println(differenceSet);
    }

    private static void intersectionSet(Set<String> set1, Set<String> set2) {
        Set<String> intersectionSet = new HashSet<>(set1);
        //intersectionSet.retainAll(set2);
        Iterator<String> iter = intersectionSet.iterator();
        while (iter.hasNext()) {
            if (!set2.contains(iter.next())) {
                iter.remove();
            }
        }
        System.out.println(intersectionSet);
    }
}
