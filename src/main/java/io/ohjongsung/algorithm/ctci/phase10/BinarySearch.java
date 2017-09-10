package io.ohjongsung.algorithm.ctci.phase10;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-10
 * Description : 이진 탐색 알고리즘 : O(logn)
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] numbers = { 2, 3, 5, 7, 8, 9, 10 };
        int findData = 4;
        int result = binarySearch(numbers, 0, numbers.length - 1, findData);
        int result2 = binarySearchRecursion(numbers, 0, numbers.length - 1, findData);
        if (result2 != -1) {
            System.out.println("찾는 데이터가 " + (result2 + 1) + "번째에 있다.");
        } else {
            System.out.println("찾는 데이터가 없다.");
        }

    }

    private static int binarySearchRecursion(int[] numbers, int low, int high, int findData) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (findData == numbers[mid]) {
            return mid;
        } else if (findData < numbers[mid]) {
            return binarySearchRecursion(numbers, low, mid - 1, findData);
        } else {
            return binarySearchRecursion(numbers, mid + 1, high, findData);
        }
    }

    private static int binarySearch(int[] numbers, int low, int high, int findData) {
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;
            if (numbers[mid] > findData) {
                high = mid - 1;
            } else if (numbers[mid] < findData) {
                low = mid + 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
