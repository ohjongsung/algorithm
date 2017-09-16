package io.ohjongsung.algorithm.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description :
 */
public class RemoveDuplicatesInList {
    public static void main(String[] args) {
        List<String> duplicatedList = new LinkedList<>();
        duplicatedList.add("a");
        duplicatedList.add("b");
        duplicatedList.add("c");
        duplicatedList.add("d");
        duplicatedList.add("e");
        duplicatedList.add("a");
        duplicatedList.add("a");
        duplicatedList.add("f");
        duplicatedList.add("c");

        removeDuplicate(duplicatedList);
        removeDuplicate2((LinkedList<String>) duplicatedList);
    }

    // linkedList라면 큐 구현체의 특성을 살려, 요게 좋다
    private static void removeDuplicate2(LinkedList<String> duplicatedList) {
        for (int i = 0; i < duplicatedList.size(); i++) {
            String element = duplicatedList.pop();
            if (duplicatedList.contains(element)) {
                continue;
            }
            duplicatedList.add(element);
        }
        System.out.println(duplicatedList);
    }

    // arrayList라면 랜덤 액세스가 O(1)인 특성을 살려, 요게 좋다.
    private static void removeDuplicate(List<String> duplicatedList) {
        ListIterator<String> iter = duplicatedList.listIterator();
        while (iter.hasNext()) {
            int firstIndex = duplicatedList.indexOf(iter.next());
            int lastIndex = duplicatedList.lastIndexOf(duplicatedList.get(firstIndex));

            if (firstIndex != lastIndex) {
                iter.remove();
            }
        }
        Collections.sort(duplicatedList);
        System.out.println(duplicatedList);
    }
}
