package io.ohjongsung.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-04-15
 * https://www.acmicpc.net/problem/2294
 * 동전 2
 */
public class Test2294 {
	private static int N;
	private static int K;
	private static int[] coins;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nk = br.readLine().split(" ");
			N = Integer.parseInt(nk[0]);
			K = Integer.parseInt(nk[1]);
			coins = new int[N];
			for (int i = 0; i < N; i++) {
				coins[i] = Integer.parseInt(br.readLine());
			}


		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
