package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test3085 {
	private static char[][] map;
	private static int max;
	private static int n;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			map = new char[n][n];
			for (int i = 0; i < n; i++) {
				map[i] = br.readLine().toCharArray();
			}
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					changePosition(i, j);
				}
			}
			System.out.println(max);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void changePosition(int y, int x) {
		char temp = map[y][x];

		if (x + 1 < n) {
			map[y][x] = map[y][x+1];
			map[y][x+1] = temp;
			check();
			map[y][x+1] = map[y][x];
			map[y][x] = temp;
		}

		if (y + 1 < n) {
			map[y][x] = map[y+1][x];
			map[y+1][x] = temp;
			check();
			map[y+1][x] = map[y][x];
			map[y][x] = temp;
		}
	}

	private static void check() {
		for (int x = 0; x < n; x++) {
			int count = 1;
			for (int y = 1; y < n; y++) {
				if (map[y][x] == map[y-1][x]) {
					count++;
				} else {
					if (max < count) {
						max = count;
					}
					count = 1;
				}
			}
			if (max < count) {
				max = count;
			}
		}
		for (int y = 0; y < n; y++) {
			int count = 1;
			for (int x = 1; x < n; x++) {
				if (map[y][x] == map[y][x-1]) {
					count++;
				} else {
					if (max < count) {
						max = count;
					}
					count = 1;
				}
			}
			if (max < count) {
				max = count;
			}
		}
	}
}
