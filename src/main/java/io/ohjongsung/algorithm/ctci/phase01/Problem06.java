package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-22
 * Description : MxN 행렬을 순회하면서 0인 원소를 발견하면, 해당 원소가 속한 행과 열의 모든 원소를 0으로 설정하는 알고리즘을
 * 작성하라.
 */
public class Problem06 {
    public static void main(String[] args) {
        int[][] arr = {
                { 1, 2, 3, 4 },
                { 5, 0, 7, 1 },
                { 9, 4, 8, 2 },
                { 3, 0, 5, 7 }
        };

        int[][] result = findZero(arr);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
            System.out.println("");
        }
    }

    private static int[][] findZero(int[][] arr) {
        boolean[] findZeroInRow = new boolean[arr.length];
        boolean[] findZeroInColumn = new boolean[arr.length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j] == 0) {
                    findZeroInRow[i] = true;
                    findZeroInColumn[j] = true;
                }
            }
        }

        int[][] result = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (findZeroInRow[i] || findZeroInColumn[j]) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = arr[i][j];
                }
            }
        }
        return result;
    }
}
