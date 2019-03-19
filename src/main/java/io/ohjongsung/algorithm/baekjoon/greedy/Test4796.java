package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-19
 * https://www.acmicpc.net/problem/4796
 * 캠핑
 */
public class Test4796 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int cases = 1;
			while (true) {
				String[] lpv = br.readLine().split(" ");
				int l = Integer.parseInt(lpv[0]);
				int p = Integer.parseInt(lpv[1]);
				int v = Integer.parseInt(lpv[2]);
				if (l == 0 && p == 0 & v == 0) {
					break;
				} else {
					countCampingDays(l, p, v, cases);
					cases++;
				}
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countCampingDays(int l, int p, int v, int cases) {
		int quotient = v / p;
		int remainder = v % p;

		int count =  quotient * l;
		if (remainder < l) {
			count += remainder;
		} else {
			count += l;
		}

		System.out.println(String.format("Case %d: %d", cases, count));
	}
}
