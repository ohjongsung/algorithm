package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Test2231 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			int x = 0;
			for (int i = 0; i < n; i++) {
				int temp = getSplitSum(i);
				if (n == temp) {
					x = i;
					break;
				}
			}
			System.out.println(x);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	public static int getSplitSum(int x) {
		int result = x;
		while (x > 0) {
			result += x % 10;
			x = x / 10;
		}
		return result;
	}
}
