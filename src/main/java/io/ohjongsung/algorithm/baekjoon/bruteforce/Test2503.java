package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * created by ohjongsung on 2019-03-17
 * https://www.acmicpc.net/problem/2503
 * 숫자 야구
 */
public class Test2503 {
	private static List<Integer> nums = new ArrayList<>();
	private static int count = 0;
	private static int n = 0;
	private static int qa[];
	private static int qb[];
	private static int qc[];
	private static int strike[];
	private static int ball[];
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			guessList();
			n = Integer.parseInt(br.readLine());
			qa = new int[n];
			qb = new int[n];
			qc = new int[n];
			strike = new int[n];
			ball = new int[n];
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				int questionNum = Integer.parseInt(str[0]);
				qc[i] = questionNum % 10;
				questionNum = questionNum / 10;
				qb[i] = questionNum % 10;
				questionNum = questionNum / 10;
				qa[i] = questionNum % 10;
				strike[i] = Integer.parseInt(str[1]);
				ball[i] = Integer.parseInt(str[2]);
			}
			verify();
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void verify() {
		nums.stream()
				.forEach(num -> {
					int c = num % 10;
					num = num / 10;
					int b = num % 10;
					num = num / 10;
					int a = num % 10;
					if (a != b && a != c && b != c && a != 0 && b != 0 && c != 0) {
						boolean[] valid = new boolean[n];
						for (int i = 0; i < n; i++) {
							int st = 0;
							int bl = 0;
							if (a == qa[i]) {
								st++;
							} else {
								if (qa[i] == b) {
									bl++;
								} else if (qa[i] == c) {
									bl++;
								}
							}

							if (b == qb[i]) {
								st++;
							} else {
								if (qb[i] == a) {
									bl++;
								} else if (qb[i] == c) {
									bl++;
								}
							}

							if (c == qc[i]) {
								st++;
							} else {
								if (qc[i] == a) {
									bl++;
								} else if (qc[i] == b) {
									bl++;
								}
							}

							if (st == strike[i] && bl == ball[i]) {
								valid[i] = true;
							}
						}

						if (areAllTrue(valid)) {
							count++;
						}
					}
				});
	}

	public static boolean areAllTrue(boolean[] array)
	{
		for(boolean b : array) if(!b) return false;
		return true;
	}

	private static void guessList() {
		for (int i = 111; i < 1000; i++) {
			nums.add(i);
		}
	}
}
