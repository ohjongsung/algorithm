package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-03
 * Description : 병합 정렬 구현 : O(nlogn)
 */
public class MergeSort {
    public static void main(String[] args) {
        int[] arr = { 68, 9, 32, 2, 14, 7, 31, 26 };

        mergeSort(arr, 0, arr.length - 1);
        for (int item : arr) {
            System.out.print(item + " ");
        }
    }

    private static void mergeSort(int[] arr, int begin, int end) {
        if (begin < end) {
            int middle = (begin + end) / 2;
            mergeSort(arr, begin, middle);
            mergeSort(arr, middle + 1, end);
            merge(arr, begin, middle, end);
        }
    }

    private static void merge(int[] arr, int begin, int middle, int end) {
        int[] temp_arr = new int[arr.length];
        int i,j,k;
        i = begin;
        j = middle + 1;
        k = begin;

        while (i <= middle && j <= end) {
            if (arr[i] <= arr[j]) {
                temp_arr[k] = arr[i];
                i++;
            } else {
                temp_arr[k] = arr[j];
                j++;
            }
            k++;
        }

        if (i > middle) {
            for (int t = j; t <= end; t++) {
                temp_arr[k] = arr[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                temp_arr[k] = arr[t];
                k++;
            }
        }

        for (int t = begin; t <= end; t++) {
            arr[t] = temp_arr[t];
        }
    }
}
