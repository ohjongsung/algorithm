package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-22
 * Description : 이미지를 표현하는 MxN 행렬이 있다. 이미지의 각 픽셀은 4바이트로 표현된다. 이때, 이미지를 90도 회전시키는 메서드를
 * 작성하라. 부가적인 행렬을 사용하지 않고서도 할 수 있겠는가?
 */
public class Problem05 {
    public static void main(String[] args) {

        int[][] image = {
                { 1, 2, 3, 4 },
                { 5, 6, 7, 8 },
                { 9, 10, 11, 12 },
                { 13, 14, 15, 16 }
        };
        // 부가적인 행렬 사용..
        int[][] rotated = rotate(image);
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j < rotated[i].length; j++) {
                System.out.print(rotated[i][j]);
            }
            System.out.println("");
        }
    }

    private static int[][] rotate(int[][] image) {
        int[][] rotated = new int[image.length][image[0].length];
        for (int i = 0; i < image.length; i++) {
            for (int j = 0; j < image[i].length; j++) {
                rotated[j][image.length - 1 - i] = image[i][j];
            }
        }
        return rotated;
    }

}
