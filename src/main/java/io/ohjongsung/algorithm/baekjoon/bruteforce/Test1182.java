package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-18
 * https://www.acmicpc.net/problem/1182
 * 부분 수열의 합
 */
public class Test1182 {
	private static int n;
	private static int s;
	private static int[] nums;
	private static int count = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] ns = br.readLine().split(" ");
			n = Integer.parseInt(ns[0]);
			s = Integer.parseInt(ns[1]);
			nums = new int[n];
			String[] strNums = br.readLine().split(" ");
			for (int i = 0; i < n; i++) {
				nums[i] = Integer.parseInt(strNums[i]);
			}
			recursive(0, 0);
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void recursive(int k, int total) {
		if (total + nums[k] == s) {
			count++;
		}

		if (k + 1 < n) {
			recursive(k + 1, total + nums[k]);
			recursive(k + 1, total);
		}
	}

	private static void verify(int num) {
		if (num == s) {
			count++;
		}
	}
}
