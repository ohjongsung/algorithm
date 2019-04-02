package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-04-02
 * https://www.acmicpc.net/problem/1725
 * 히스토그램
 */
public class Test1725 {
	private static int N;
	private static int[] arr = new int[100001];
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Integer.parseInt(br.readLine());
			}
			long result = solve(1, N);
			System.out.println(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static long solve(int start, int end) {
		if (start == end) {
			return arr[start];
		}

		int mid = (start + end) / 2;
		long result = Math.max(solve(start, mid), solve(mid + 1, end));

		int left = mid;
		int right = mid;
		int minValue = arr[mid];
		int width = 1;
		while (right - left <= end - start) {
			int minLeft = left > start ? Math.min(minValue, arr[left - 1]) : -1;
			int minRight = right < end ? Math.min(minValue, arr[right + 1]) : -1;


			if (minLeft > minRight) {
				left--;
				minValue = minLeft;
			} else {
				right++;
				minValue = minRight;
			}

			result = Math.max(result, ++width * minValue);
		}

		return result;
	}
}
