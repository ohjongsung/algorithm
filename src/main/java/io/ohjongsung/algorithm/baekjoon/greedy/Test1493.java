package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * created by ohjongsung on 2019-03-27
 * https://www.acmicpc.net/problem/1493
 * 박스 채우기
 */
public class Test1493 {
	private static long LENGTH;
	private static long WIDTH;
	private static long HEIGHT;
	private static int N;
	private static long[][] CUBES;
	private static int COUNT = 0;
	private static boolean POSSIBLE = true;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] lwh = br.readLine().split(" ");
			LENGTH = Long.parseLong(lwh[0]);
			WIDTH = Long.parseLong(lwh[1]);
			HEIGHT = Long.parseLong(lwh[2]);

			N = Integer.parseInt(br.readLine());

			CUBES = new long[N][2];
			for (int i = 0; i < N; i++) {
				String[] ln = br.readLine().split(" ");
				// 한변의 길이
				CUBES[i][0] = (long) Math.pow(2d, (double) Long.parseLong(ln[0]));
				// 큐브 개수
				CUBES[i][1] = Long.parseLong(ln[1]);
			}
			Arrays.sort(CUBES, Comparator.<long[]>comparingLong(l -> l[0]).reversed());
			fill(LENGTH, WIDTH, HEIGHT);
			System.out.println(POSSIBLE ? COUNT : -1);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void fill(long l, long w, long h) {
		if (!POSSIBLE) {
			return;
		}
		if (l == 0 || w == 0 || h == 0) {
			return;
		}
		for (int i = 0; i < N; i++) {
			if (CUBES[i][1] > 0 && l >= CUBES[i][0] && w >= CUBES[i][0] && h >= CUBES[i][0]) {
				COUNT++;
				CUBES[i][1]--;
				fill(l, w, h - CUBES[i][0]);
				fill(CUBES[i][0], w - CUBES[i][0], CUBES[i][0]);
				fill(l - CUBES[i][0], w, CUBES[i][0]);
				return;
			}
		}
		POSSIBLE = false;
	}
}
