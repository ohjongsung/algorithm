package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-03-24
 * https://www.acmicpc.net/problem/2217
 * 로프
 */
public class Test2217 {
	private static int n;
	private static int[]k;
	private static int maximumWeight = Integer.MIN_VALUE;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			k = new int[n];
			for (int i = 0; i < n; i++) {
				k[i] = Integer.parseInt(br.readLine());
			}
			Arrays.sort(k);
			getMaximumWeight();
			System.out.println(maximumWeight);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void getMaximumWeight() {
		int numOfRope = n;
		for (int i = 0; i < n; i++) {
			if (k[i] * numOfRope > maximumWeight) {
				maximumWeight = k[i] * numOfRope;
			}
			numOfRope--;
		}
	}
}
