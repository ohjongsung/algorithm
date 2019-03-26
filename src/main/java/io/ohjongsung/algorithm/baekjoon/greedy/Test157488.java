package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * created by ohjongsung on 2019-03-26
 * https://www.acmicpc.net/problem/15748
 * Rest Stops
 */
public class Test157488 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] lnfb = br.readLine().split(" ");
			int l = Integer.parseInt(lnfb[0]);
			int n = Integer.parseInt(lnfb[1]);
			int f = Integer.parseInt(lnfb[2]);
			int b = Integer.parseInt(lnfb[3]);

			int[][] xc = new int[n][2];
			for (int i = 0; i < n; i++) {
				String[] temp = br.readLine().split(" ");
				xc[i][0] = Integer.parseInt(temp[0]);
				xc[i][1] = Integer.parseInt(temp[1]);
			}

			long result = 0;
			int currentL = 0;
			Arrays.sort(xc, Comparator.<int[]>comparingInt(c -> c[1]).thenComparingInt(c -> c[0]).reversed());
			for (int i = 0; i < n; i++) {
				if (xc[i][0] <= currentL) {
					continue;
				}
				long diff = xc[i][0] - currentL;
				long eatTime = diff * (f - b);
				result += eatTime * xc[i][1];
				currentL = xc[i][0];
			}
			System.out.println(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
