package io.ohjongsung.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-04-13
 * https://www.acmicpc.net/problem/1463
 * 1로 만들기
 */
public class Test1463 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[] dp = new int[n+1];
			Arrays.fill(dp, 100000000);
			dp[1] = 0;
			for (int i = 1; i < n; i++) {
				dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
				if (i * 2 <= n) {
					dp[i * 2] = Math.min(dp[i * 2], dp[i] + 1);
				}
				if (i * 3 <= n) {
					dp[i * 3] = Math.min(dp[i * 3], dp[i] + 1);
				}
			}

			System.out.println(dp[n]);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
