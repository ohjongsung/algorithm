package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-31
 * Description : 버블 정렬 구현 : O(n^2)
 */
public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = { 68, 9, 32, 2, 14, 7, 31, 26 };

        bubbleSort(arr);
    }

    private static void bubbleSort(int[] arr) {
        int temp = 0;
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j+1] < arr[j]) {
                    temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
            showState(arr, arr.length - i);
        }
    }

    private static void showState(int[] arr, int step) {
        System.out.print(step + "단계 ");
        for (int item : arr) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
