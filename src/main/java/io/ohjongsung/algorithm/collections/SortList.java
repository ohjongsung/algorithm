package io.ohjongsung.algorithm.collections;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description :
 */
public class SortList {
    public static void main(String[] args) {
        List<String> words = new LinkedList<>();

        words.add("harryPorter1");
        words.add("harryPorter2");
        words.add("harryPorter3");
        words.add("harryPorter4");
        words.add("harryPorter5");
        words.add("1harryPorter1");
        words.add("2harryPorter2");
        words.add("3harryPorter3");
        words.add("4harryPorter4");
        words.add("5harryPorter5");

        Collections.sort(words, Collections.reverseOrder());
        System.out.println(words);
    }
}
