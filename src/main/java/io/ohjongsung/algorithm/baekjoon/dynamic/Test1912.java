package io.ohjongsung.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-03-16
 * https://www.acmicpc.net/problem/1912
 * 연속합
 */
public class Test1912 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] arr = new int[n];
			int[] dp = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			int max = arr[0];
			dp[0] = arr[0];
			for (int i = 1; i < n; i++) {
				dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);

				max = Math.max(max, dp[i]);
			}
			System.out.println(max);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
