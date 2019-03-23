package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * created by ohjongsung on 2019-03-23
 * https://www.acmicpc.net/problem/1931
 * 회의실 배정
 */
public class Test1931 {
	private static int n;
	private static int[][] times;
	private static int count = 1;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			times = new int[n][2];
			for (int i = 0; i < n; i++) {
				String[] strC = br.readLine().split(" ");
				// startTime
				times[i][0] = Integer.parseInt(strC[0]);
				// endTime
				times[i][1] = Integer.parseInt(strC[1]);
			}
			Arrays.sort(times, Comparator.<int[]>comparingInt(time -> time[1]).thenComparingInt(time -> time[0]));
			countMaximum();
			System.out.println(count);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countMaximum() {
		int end = times[0][1];
		for (int i = 1; i < n; i++) {
			if (times[i][0] >= end) {
				count++;
				end = times[i][1];
			}
		}
	}
}
