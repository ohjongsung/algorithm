package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-03-
 * https://www.acmicpc.net/problem/11047
 * 동전 0
 */
public class Test11047 {
	private static int n;
	private static int k;
	private static int[] a;
	private static int count = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nk = br.readLine().split(" ");
			n = Integer.parseInt(nk[0]);
			k = Integer.parseInt(nk[1]);
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(a);
			countNeedCoins();
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countNeedCoins() {
		int i = n - 1;
		while (i >= 0) {
			if (a[i] <= k) {
				int quotient = k / a[i];
				int remainder = k % a[i];
				count += quotient;
				k = remainder;
				i--;
			} else {
				i--;
			}
		}
	}
}
