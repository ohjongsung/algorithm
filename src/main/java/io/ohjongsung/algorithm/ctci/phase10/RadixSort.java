package io.ohjongsung.algorithm.ctci.phase10;

import java.util.LinkedList;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description : 기수 정렬 구현 : O(kn)
 */
public class RadixSort {
    public static void main(String[] args) {
        int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
        radixSort(arr, 2);
    }

    private static void radixSort(int[] arr, int maxDigit) {
        LinkedList<Integer>[] counter = new LinkedList[] {
                new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>(),
                new LinkedList<>(), new LinkedList<>() };
        int factor = 1;

        for (int i = 0; i < maxDigit; i++) {
            for (int j = 0; j < arr.length; j++) {
                int bucket = (arr[j] / factor) % 10;
                counter[bucket].add(arr[j]);
            }
            int pos = 0;
            for (int j = 0; j < counter.length; j++) {
                Integer value = null;
                while ((value = counter[j].poll()) != null) {
                    arr[pos++] = value;
                }
            }
            factor *= 10;
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
