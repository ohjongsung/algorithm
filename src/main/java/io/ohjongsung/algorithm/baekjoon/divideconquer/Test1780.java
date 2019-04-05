package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-04-05
 * https://www.acmicpc.net/problem/1780
 * 종이의 개수
 */
public class Test1780 {
	private static int[][] PAPER;
	private static int N;
	private static int COUNTM = 0;
	private static int COUNTZ = 0;
	private static int COUNTO = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			PAPER = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					PAPER[i][j] =Integer.parseInt(st.nextToken());
				}
			}
			solve(0, 0, N);

			System.out.println(COUNTM);
			System.out.println(COUNTZ);
			System.out.println(COUNTO);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void solve(int x, int y, int n) {
		if (same(x, y, n)) {
			addCount(PAPER[x][y]);
			return;
		}

		int unit = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				solve(x + i * unit, y + j * unit, unit);
			}
		}
	}

	private static boolean same(int x, int y, int n) {
		for (int i = x; i < x + n; i++) {
			for (int j = y; j < y + n; j++) {
				if (PAPER[i][j] != PAPER[x][y]) {
					return false;
				}
			}
		}
		return true;
	}

	private static void addCount(int n) {
		if (n == -1) {
			COUNTM++;
		} else if (n == 0) {
			COUNTZ++;
		} else {
			COUNTO++;
		}
	}
}
