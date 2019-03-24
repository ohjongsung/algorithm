package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * created by ohjongsung on 2019-03-24
 * https://www.acmicpc.net/problem/1969
 * DNA
 */
public class Test1969 {
	private static int N;
	private static int M;
	private static char[][] DNA;
	private static char[] chars = new char[4];
	private static List<String> RESULT = new ArrayList<>();
	private static int HAMMING_DISTANCE = Integer.MAX_VALUE;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			chars[0] = 'A';
			chars[1] = 'C';
			chars[2] = 'G';
			chars[3] = 'T';
			String[] nm = br.readLine().split(" ");
			N = Integer.parseInt(nm[0]);
			M = Integer.parseInt(nm[1]);
			DNA = new char[N][M];
			for (int i = 0; i < N; i++) {
				DNA[i] = br.readLine().toCharArray();
			}
			resolve();
			RESULT.sort(Comparator.comparing(s -> s));
			for (String dna: RESULT) {
				System.out.println(dna);
			}
			System.out.println(HAMMING_DISTANCE);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void resolve() {
		char[] result = new char[M];
		for (int i = 0; i < M; i++) {
			result[i] = getMaxChar(i);
		}
		StringBuilder builder = new StringBuilder();
		for (int j = 0; j < M; j++) {
			builder.append(result[j]);
		}
		RESULT.add(builder.toString());

		setHammingDistance(result);
	}

	private static char getMaxChar(int position) {
		// a, c, g, t
		int[] count = new int[4];

		for (int i = 0; i < N; i++) {
			if (DNA[i][position] == 'A') {
				count[0]++;
			}
			if (DNA[i][position] == 'C') {
				count[1]++;
			}
			if (DNA[i][position] == 'G') {
				count[2]++;
			}
			if (DNA[i][position] == 'T') {
				count[3]++;
			}


		}
		int largest = Collections.max(Arrays.asList(count[0], count[1], count[2], count[3]));

		for (int i = 0; i < 4; i++) {
			if (largest == count[i]) {
				return chars[i];
			}
		}
		return chars[0];
	}

	private static void setHammingDistance(char[] s) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += getHammingDistance(DNA[i], s);
		}
		HAMMING_DISTANCE = sum;
	}

	private static int getHammingDistance(char[] a, char[] b) {
		int hammingDistance = 0;
		for (int i = 0; i < M; i++) {
			if (a[i] != b[i]) {
				hammingDistance++;
			}
		}
		return hammingDistance;
	}
}
