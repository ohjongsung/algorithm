package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-04-11
 * https://www.acmicpc.net/problem/2339
 * 석판 자르기
 */
public class Test2339 {
	private static int[][] BOARD = new int[20][20];
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int impurity = 0;
			int crystal = 0;
			for (int i = 0; i < n; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < n; j++) {
					BOARD[i][j] = Integer.parseInt(st.nextToken());
					if (BOARD[i][j] == 1) {
						impurity++;
					}
					if (BOARD[i][j] == 2) {
						crystal++;
					}
				}
			}

			if (crystal == 1 && impurity == 0) {
				System.out.println(1);
			} else {
				// direction 0 : 가로, 1 : 세로
				int rawSplit = split(0, n, 0, n, true);
				int colSplit = split(0, n, 0, n, false);
				int result = rawSplit + colSplit;
				if (result == 0) {
					result = -1;
				}
				System.out.println(result);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	private static int split(int xStart, int xEnd, int yStart, int yEnd, boolean vertical) {
		int impurity = 0;
		int crystal = 0;
		List<Integer> yImpurityGrid = new ArrayList<>();
		List<Integer> xImpurityGrid = new ArrayList<>();

		for (int y = yStart; y < yEnd; y++) {
			for (int x = xStart; x < xEnd; x++) {
				if (BOARD[y][x] == 1) {
					impurity++;
					yImpurityGrid.add(y);
					xImpurityGrid.add(x);
				}
				if (BOARD[y][x] == 2) {
					crystal++;
				}
			}
		}

		if (crystal == 1 && impurity == 0) {
			return 1;
		} else if (crystal > 1 && impurity == 0) {
			return 0;
		} else if (crystal == 0) {
			return 0;
		}  else if (impurity > 0) {
			int result = 0;
			for (int i = 0; i < impurity; i++) {
				int x = xImpurityGrid.get(i);
				int y = yImpurityGrid.get(i);

				if (vertical) {
					if (verticalSplitCrystalCnt(x, yStart, yEnd) > 1) {
						continue;
					}
					if (x - xStart < 1 || xEnd - x < 1) {
						continue;
					}
					result += split(xStart, x, yStart, yEnd, false) * split(x + 1, xEnd, yStart, yEnd, false);
				} else {
					if (horizontalSplitCrystalCnt(y, xStart, xEnd) > 1) {
						continue;
					}
					if (y - yStart < 1 || yEnd - y < 1) {
						continue;
					}
					result += split(xStart, xEnd, yStart, y, true) * split(xStart, xEnd, y + 1, yEnd, true);
				}
			}
			return result;
		}
		return 0;
	}

	private static int verticalSplitCrystalCnt(int x, int yStart, int yEnd) {
		int crystal = 0;
		for (int y = yStart; y < yEnd; y++) {
			if (BOARD[y][x] == 2) {
				crystal++;
			}
		}
		return crystal;
	}

	private static int horizontalSplitCrystalCnt(int y, int xStart, int xEnd) {
		int crystal = 0;
		for (int x = xStart; x < xEnd; x++) {
			if (BOARD[y][x] == 2) {
				crystal++;
			}
		}
		return crystal;
	}
}
