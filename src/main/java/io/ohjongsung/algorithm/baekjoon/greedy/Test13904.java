package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/**
 * created by ohjongsung on 2019-03-25
 * https://www.acmicpc.net/problem/13904
 * 과제
 */
public class Test13904 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int[][] dw = new int[n][2];
			int lastDay = 0;
			for (int i = 0; i < n; i++) {
				String[] strDw = br.readLine().split(" ");
				dw[i][0] = Integer.parseInt(strDw[0]);
				dw[i][1] = Integer.parseInt(strDw[1]);
				if (dw[i][0] > lastDay) {
					lastDay = dw[i][0];
				}
			}
			int[] dayWork = new int[lastDay];
			Arrays.sort(dw, Comparator.<int[]>comparingInt(w -> w[1]).thenComparingInt(w -> w[0]));
			int sum = 0;
			for (int i = n - 1; i >= 0; i--) {
				for (int j = dw[i][0]-1; j >= 0; j--) {
					if (dayWork[j] == 0) {
						dayWork[j] = dw[i][1];
						sum += dw[i][1];
						break;
					}
				}
			}


			System.out.println(sum);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
}
