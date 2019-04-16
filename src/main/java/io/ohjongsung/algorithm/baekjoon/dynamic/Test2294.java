package io.ohjongsung.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-04-15
 * https://www.acmicpc.net/problem/2294
 * 동전 2
 */
public class Test2294 {
	private static int N;
	private static int K;
	private static int[] COINS;
	private static int[] DP;
	private static int IMPOSSIBLE = 1000000000;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nk = br.readLine().split(" ");
			N = Integer.parseInt(nk[0]);
			K = Integer.parseInt(nk[1]);
			COINS = new int[N];
			DP = new int[K+1];
			Arrays.fill(DP, -1);
			for (int i = 0; i < N; i++) {
				COINS[i] = Integer.parseInt(br.readLine());
			}

			int result = resolve(K);
			if (result >= IMPOSSIBLE) {
				System.out.println(-1);
			} else {
				System.out.println(result);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static int resolve(int money) {
		if (money == 0) {
			return 0;
		}

		if (DP[money] != -1) {
			return DP[money];
		}

		int result = IMPOSSIBLE;
		for (int i = 0; i < N; i++) {
			if (money >= COINS[i]) {
				result = Math.min(result, resolve(money - COINS[i]) + 1);
			}
		}

		return DP[money] = result;
	}
}
