package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-31
 * Description : 선택 정렬 구현 : O(n^2)
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = { 68, 9, 32, 2, 14, 7, 31, 26 };

        selectionSort(arr);
    }

    private static void selectionSort(int[] arr) {
        int temp = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
            showState(arr, i + 1);
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
