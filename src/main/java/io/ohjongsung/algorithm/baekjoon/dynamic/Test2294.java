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
	private static int[][] DP;
	private static int IMPOSSIBLE = 1000000000;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nk = br.readLine().split(" ");
			N = Integer.parseInt(nk[0]);
			K = Integer.parseInt(nk[1]);
			COINS = new int[N];
			DP = new int[N+1][K+1];
			for (int i = 0; i < N+1; i++) {
				Arrays.fill(DP[i], -1);
			}
			for (int i = 0; i < N; i++) {
				COINS[i] = Integer.parseInt(br.readLine());
			}

			int result = resolve(0, K);
			if (result == IMPOSSIBLE) {
				System.out.println(-1);
			} else {
				System.out.println(result);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static int resolve(int n, int k) {
        if (n == N)
            return (k == 0 ? 0 : IMPOSSIBLE);
        if (DP[n][k] != -1)
            return DP[n][k];

        int result = resolve(n + 1, k);
        if (k >= COINS[n])
            result = Math.min(result, resolve(n, k - COINS[n]) + 1);
        DP[n][k] = result;
        return result;
	}
}
