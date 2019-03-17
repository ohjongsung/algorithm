package io.ohjongsung.algorithm.baekjoon.bruteforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * created by ohjongsung on 2019-03-17
 */
public class Test2503 {
	private static List<Integer> nums = new ArrayList<>();
	private static int count = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			inputNums();
			int n = Integer.parseInt(br.readLine());
			for (int i = 0; i < n; i++) {
				String[] str = br.readLine().split(" ");
				int questionNum = Integer.parseInt(str[0]);
				int strike = Integer.parseInt(str[1]);
				int ball = Integer.parseInt(str[2]);

				if (strike == 3) {
					count = 1;
					break;
				}
				check(questionNum, strike, ball);
			}
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void check(int questionNum, int strike, int ball) {
		int qc = questionNum % 10;
		questionNum = questionNum / 10;
		int qb = questionNum % 10;
		questionNum = questionNum / 10;
		int qa = questionNum % 10;

		nums.stream()
				.forEach(num -> {
					int c = num % 10;
					num = num / 10;
					int b = num % 10;
					num = num / 10;
					int a = num % 10;

					int st = 0;
					int bl = 0;

					if (a != b && a != c && b != c && a != 0 && b != 0 && c != 0) {
						if (a == qa) {
							st++;
						}
						if (qa == b) {
							bl++;
						}
						if (qa == c) {
							bl++;
						}

						if (b == qb) {
							st++;
						}
						if (qb == a) {
							bl++;
						}
						if (qb == c) {
							bl++;
						}
						if (c == qc) {
							st++;
						}
						if (qc == a) {
							bl++;
						}
						if (qc == b) {
							bl++;
						}
						if (st == strike && bl == ball) {
							count++;
						}
					}
				});
	}

	private static void inputNums() {
		for (int i = 111; i < 1000; i++) {
			nums.add(i);
		}
	}
}
