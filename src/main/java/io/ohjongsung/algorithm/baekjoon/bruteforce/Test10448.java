package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-17
 */
public class Test10448 {
	private static int[] tStore = new int[44];

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			generateT();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				int result = check(Integer.parseInt(br.readLine()));
				System.out.println(result);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void generateT() {
		for (int i = 0; i < 44; i++) {
			int n = i + 1;
			tStore[i] = n * (n + 1) / 2;
		}
	}

	private static int check(int k) {
		int check = 0;
		for (int i = 0; i < 44; i++) {
			for (int j = 0; j < 44; j++) {
				for (int l = 0; l < 44; l++) {
					if (tStore[i] + tStore[j] + tStore[l] == k) {
						check = 1;
						break;
					}
				}
			}
		}

		return check;
	}
}
