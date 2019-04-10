package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-04-10
 * https://www.acmicpc.net/problem/2447
 * 별 찍기 - 10
 */
public class Test2447 {
	private static char[][] STARS;
	public static void main(String[] agrs) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			STARS = new char[n][n];
			for (int i = 0; i < n; i++) {
				Arrays.fill(STARS[i], ' ');
			}
			solve(0, 0, n);
			for (int i = 0; i < n; i++) {
				System.out.println(STARS[i]);
			}
			solve2(n);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void solve(int x, int y, int n) {
		if (n == 1) {
			STARS[x][y] = '*';
			return;
		}

		int unit = n / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (i == 1 && j == 1) {
					continue;
				} else {
					solve(x + i * unit, y + j * unit , unit);
				}
			}
		}
	}

	private static void solve2(int n) {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				int x = i, y = j;
				while(x > 0) {
					if(x % 3 == 1 && y % 3 == 1) {
						break;
					}

					x /= 3;
					y /= 3;
				}
				sb.append(x == 0 ? '*' : ' ');
			}
			sb.append('\n');
		}
		System.out.println(sb);
	}
}
