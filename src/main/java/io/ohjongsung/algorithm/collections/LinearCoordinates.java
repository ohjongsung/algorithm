package io.ohjongsung.algorithm.collections;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-23
 * Description :
 */
public class LinearCoordinates {
    public static void main(String[] args) {
        String minCoordinates = getMinCoordinates();
        System.out.println(minCoordinates);
    }

    private static String getMinCoordinates() {
        int[] arr = { 1, 3, 6, 7, 9, 16, 27, 39, 42, 50 };
        int minIndex = 0;
        int minValue = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            if (minValue > arr[i + 1] - arr[i]) {
                minValue = arr[i + 1] - arr[i];
                minIndex = i;
            }
        }

        return "( " + arr[minIndex] + ", " + arr[minIndex + 1] + " )";
    }
}
