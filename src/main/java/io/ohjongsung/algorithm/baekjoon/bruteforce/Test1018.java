package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-18
 * https://www.acmicpc.net/problem/1018
 * 체스판 다시 칠하기
 */
public class Test1018 {
	private static char[][] square;
	private static int count = Integer.MAX_VALUE;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] mn = br.readLine().split(" ");
			int height = Integer.parseInt(mn[0]);
			int width = Integer.parseInt(mn[1]);
			square = new char[height][width];

			for (int i = 0; i < height; i++) {
				square[i] = br.readLine().toCharArray();
			}

			for (int i = 0; i < height - 7; i++) {
				for (int j = 0; j < width - 7; j++) {
					divideSquare(i, j);
				}
			}
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 시작 지점 좌표 i,j 를 기준으로 8 x 8 로 자른다.
	 * @param i
	 * @param j
	 */
	private static void divideSquare(int i, int j) {
		char[][] tempSquare = new char[8][8];
		char[][] tempSquare2 = new char[8][8];
		for (int k = 0; k < 8; k++) {
			for (int l = 0; l < 8; l++) {
				tempSquare[k][l] = square[k + i][l + j];
				tempSquare2[k][l] = square[k + i][l + j];
			}
		}
		countMinimumRepaint(tempSquare);
	}

	private static void countMinimumRepaint(char[][] tempSquare) {
		int tempCount = 0;
		if (tempSquare[0][0] != tempSquare[7][7]) {
			tempSquare[7][7] = convertColor(tempSquare[7][7]);
			tempCount++;
		}

		for (int i = 0; i < 7; i++) {
			for (int j = 0; j < 7; j++) {
				if (tempSquare[i][j] == tempSquare[i][j + 1]) {
					tempCount++;
					tempSquare[i][j + 1] = convertColor(tempSquare[i][j + 1]);
				}
				if (tempSquare[i][j] == tempSquare[i + 1][j]) {
					tempCount++;
					tempSquare[i + 1][j] = convertColor(tempSquare[i + 1][j]);
				}
			}
		}
		if (tempCount > 32) {
			tempCount = 64 - tempCount;
		}
		if (count > tempCount) {
			count = tempCount;
		}
	}

	/**
	 * 다른 사각형의 색깔 검증을 위해서 색을 다시 칠한다.
	 * @param color
	 * @return
	 */
	private static char convertColor(char color) {
		if (color == 'W') {
			return 'B';
		} else {
			return 'W';
		}
	}
}
