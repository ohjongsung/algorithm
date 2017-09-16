package io.ohjongsung.algorithm.collections;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-06
 * Description :
 */
public class LargestNumber {
    public static void main(String[] args) {
        int[] numbers = { 45, 44, 54, 4, 5, 11, 10, 12, 1, 2, 0 };

        combinateLargestNumber(numbers);
    }

    private static void combinateLargestNumber(int[] numbers) {
        String[] arr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            arr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(arr, (a, b) -> (b + a).compareTo(a + b));
        for (String s : arr) {
            System.out.println(s);
        }
    }
}
