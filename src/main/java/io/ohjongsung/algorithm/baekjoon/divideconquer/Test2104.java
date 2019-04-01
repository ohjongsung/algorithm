package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-03-30
 * https://www.acmicpc.net/problem/2104
 * 부분배열 고르기
 */
public class Test2104 {
	private static int N;
	private static long[] arr = new long[100001];
	private static int max = Integer.MIN_VALUE;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				arr[i] = Long.parseLong(st.nextToken());
			}
			long result = solve(1, N);
			System.out.println(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static long solve(int start, int end) {
		if (start == end) {
			return arr[start] * arr[end];
		}

		int mid = (start + end) / 2;
		long result = Math.max(solve(start, mid), solve(mid+1, end));

		int left = mid;
		int right = mid;
		long minValue = arr[mid];
		long sum = arr[mid];

		while (right - left <= end - start) {
			long leftMinValue = left > start ? Math.min(minValue, arr[left - 1]) : -1;
			int leftIndex = leftMinValue == -1 ? 0 : left - 1;
			long leftResult = (sum + arr[leftIndex]) * leftMinValue;
			long rightMinValue = right < end ? Math.min(minValue, arr[right + 1]) : -1;
			int rightIndex = rightMinValue == -1 ? 0 : right + 1;
			long rightResult = (sum + arr[rightIndex]) * rightMinValue;

			if (leftResult > rightResult) {
				sum += arr[leftIndex];
				left -= 1;
				minValue = leftMinValue;
			} else {
				sum += arr[rightIndex];
				right += 1;
				minValue = rightMinValue;
			}

			result =  Math.max(result, sum * minValue);
		}

		return result;
	}
}
