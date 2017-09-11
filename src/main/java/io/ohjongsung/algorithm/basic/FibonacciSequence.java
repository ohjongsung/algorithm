package io.ohjongsung.algorithm.basic;

import java.util.HashMap;
import java.util.Map;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description : 피보나치 수열
 */
public class FibonacciSequence {
    public static Map<Integer, Integer> memo1 = new HashMap<>();
    public static Map<Integer, Integer> memo2 = new HashMap<>();
    public static void main(String[] args) {
        printResult(fiboRecursion(30));
        printResult(fiboDynamicP(30));
        printResult(fiboWhile(30));
    }

    private static int fiboWhile(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        for (int i = 2; i < n; i++) {
            int value = fiboWhile(n - 2) + fiboWhile(n - 1);
            memo2.put(n, value);
        }
        return memo2.get(n);
    }

    private static int fiboDynamicP(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        if (memo1.containsKey(n)) {
            return memo1.get(n);
        }
        int value = fiboDynamicP(n - 2) + fiboDynamicP(n - 1);
        memo1.put(n, value);
        return value;
    }

    private static int fiboRecursion(int n) {
        if (n == 1 || n == 2) {
            return 1;
        }
        return fiboRecursion(n - 2) + fiboRecursion(n - 1);
    }

    private static void printResult(int result) {
        System.out.println(result);
    }
}
