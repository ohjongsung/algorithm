package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-04-06
 * https://www.acmicpc.net/problem/1992
 * 쿼드트리
 */
public class Test1992 {
	private static int[][] MOVIE;
	private static int N;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			MOVIE = new int[N][N];
			for (int i = 0; i < N; i++) {
				char[] temp = br.readLine().toCharArray();

				for (int j = 0; j < N; j++) {
					MOVIE[i][j] = Character.getNumericValue(temp[j]);
				}
			}

			String result = solve(0, 0, N);
			System.out.println(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static String solve(int x, int y, int n) {
		if (isSame(x, y, n)) {
			return String.valueOf(MOVIE[x][y]);
		}

		StringBuilder sb = new StringBuilder();
		sb.append("(");
		int unit = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				sb.append(solve(x + i * unit, y + j * unit, unit));
			}
		}
		sb.append(")");

		return sb.toString();
	}

	private static boolean isSame(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (MOVIE[x][y] != MOVIE[i][j]) {
					return false;
				}
			}
		}

		return true;
	}
}
