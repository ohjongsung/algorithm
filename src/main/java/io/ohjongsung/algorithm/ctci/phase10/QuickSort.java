package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-02
 * Description : 퀵 정렬 구현 : O(nlogn)
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] arr = { 68, 9, 32, 2, 14, 7, 31, 26 };

        quickSort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void quickSort(int[] arr, int begin, int end) {
        if (begin >= end) {
            return;
        }

        int pivot = getPartition(arr, begin, end);
        quickSort(arr, begin, pivot - 1);
        quickSort(arr, pivot + 1, end);
    }

    private static int getPartition(int[] arr, int begin, int end) {
        int p = (begin + end) / 2;

        int L = begin;
        int R = end;
        while (L < R) {

            while (arr[L] < arr[p] && L < R) {
                L++;
            }

            while (arr[R] >= arr[p] && L < R) {
                R--;
            }

            if (L < R) {
                int temp = arr[L];
                arr[L] = arr[R];
                arr[R] = temp;
            }
        }
        int temp = arr[p];
        arr[p] = arr[R];
        arr[R] = temp;

        return R;
    }
}
