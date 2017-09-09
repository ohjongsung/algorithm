package io.ohjongsung.algorithm.ctci.phase10;

import io.ohjongsung.algorithm.ctci.phase04.datastructure.Heap;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description : 힙 정렬 구현 : O(nlogn)
 */
public class HeapSort {
    public static void main(String[] args) {
        int[] arr = { 69, 10, 30, 2, 16, 8, 31, 22 };
        heapSort(arr);
    }

    private static void heapSort(int[] arr) {
        Heap heap = new Heap();

        for (int i : arr) {
            heap.insertHeap(i);
        }

        for (int i = arr.length - 1; i >= 0; i--) {
            arr[i] = heap.deleteHeap();
        }

        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
