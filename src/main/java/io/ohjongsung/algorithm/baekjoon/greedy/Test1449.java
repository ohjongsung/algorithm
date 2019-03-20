package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * created by ohjongsung on 2019-03-20
 * https://www.acmicpc.net/problem/1449
 * 수리공 항승
 */
public class Test1449 {
	private static int n;
	private static int l;
	private static int[] holes;
	private static int count = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nl = br.readLine().split(" ");
			n = Integer.parseInt(nl[0]);
			l = Integer.parseInt(nl[1]);
			holes = new int[n];
			String[] arrHoles = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				holes[i] = Integer.parseInt(arrHoles[i]);
			}
			Arrays.sort(holes);
			countNeedTapes();
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countNeedTapes() {
		int next = 0, current = 0;
		while (true) {
			if (holes[next] - holes[current] <= l - 1)
			{
				next++;
				if (next == n)
				{
					count++;
					break;
				}
			}
			else
			{
				count++;
				current = next;
			}
		}
	}
}
