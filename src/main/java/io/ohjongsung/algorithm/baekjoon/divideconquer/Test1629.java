package io.ohjongsung.algorithm.baekjoon.divideconquer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-30
 * https://www.acmicpc.net/problem/1629
 * 곱셈
 */
public class Test1629 {
	private static long A;
	private static long B;
	private static long C;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] abc = br.readLine().split(" ");
			A = Long.parseLong(abc[0]);
			B = Long.parseLong(abc[1]);
			C = Long.parseLong(abc[2]);

			long result = pow(A, B);
			System.out.println(result);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static long pow(long a, long b) {
		if (b == 0) {
			return 1;
		}

		long n = pow(a, b / 2);
		long sum = split(n * n);

		if (b % 2 == 0) {
			return sum;
		} else {
			return split(sum * a);
		}
	}

	private static long split(long n) {
		return n % C;
	}
}
