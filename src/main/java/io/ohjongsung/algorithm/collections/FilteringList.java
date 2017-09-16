package io.ohjongsung.algorithm.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description :
 */
public class FilteringList {
    public static void main(String[] args) {
        List<Integer> numbers = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            numbers.add(i);
        }

        filteringJava7(numbers);
        filteringJava8(numbers);
    }

    private static void filteringJava8(List<Integer> numbers) {
        List<Integer> filteredList = numbers.stream()
                .filter(num -> num < 20).collect(Collectors.toList());
        System.out.println(filteredList);
    }

    private static void filteringJava7(List<Integer> numbers) {
        List<Integer> filteredList = new LinkedList<>();
        for (int i : numbers) {
            if (i < 20) {
                filteredList.add(i);
            }
        }
        System.out.println(filteredList);
    }
}
