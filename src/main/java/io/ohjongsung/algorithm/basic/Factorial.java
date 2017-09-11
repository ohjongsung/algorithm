package io.ohjongsung.algorithm.basic;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-10
 * Description :
 */
public class Factorial {
    public static void main(String[] args) {
        int result = factorial(5);
        System.out.println(result);
        int result2 = factorialRecursion(5);
        System.out.println(result2);
    }

    private static int factorialRecursion(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        return n * factorialRecursion(n - 1);
    }

    private static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        int result = 1;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}
