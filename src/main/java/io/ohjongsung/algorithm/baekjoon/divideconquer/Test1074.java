package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-04-06
 * https://www.acmicpc.net/problem/1074
 * Z
 */
public class Test1074 {
	private static int X;
	private static int Y;
	private static int COUNT = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int temp = Integer.parseInt(st.nextToken());
			int n = (int) Math.pow(2, temp);
			X = Integer.parseInt(st.nextToken());
			Y = Integer.parseInt(st.nextToken());

			solve(0, 0, n);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void solve(int x, int y, int n) {
		if (n == 2) {
			if (x == X && y == Y) {
				System.out.println(COUNT);
				return;
			}
			COUNT++;
			if (x == X && y + 1 == Y) {
				System.out.println(COUNT);
				return;
			}
			COUNT++;
			if (x + 1 == X && y == Y) {
				System.out.println(COUNT);
				return;
			}
			COUNT++;
			if (x + 1 == X && y + 1 == Y) {
				System.out.println(COUNT);
				return;
			}
			COUNT++;
			return;
		}

		int unit = n / 2;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				int row = x + i * unit;
				int col = y + j * unit;
				solve(row, col, unit);
			}
		}
	}
}
