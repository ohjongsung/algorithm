package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-31
 * Description : 삽입 정렬 구현 : O(n^2)
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = { 68, 9, 32, 2, 14, 7, 31, 26 };

        insertSort(arr);
    }

    private static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && arr[j-1] > temp) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
            showState(arr, i + 1);
        }
    }

    private static void showState(int[] arr, int step) {
        System.out.print(step + "단계 ");
        for (int item : arr) {
            System.out.print(item + "  ");
        }
        System.out.println();
    }
}
