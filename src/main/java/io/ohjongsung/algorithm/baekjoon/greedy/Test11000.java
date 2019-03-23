package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * created by ohjongsung on 2019-03-23
 * https://www.acmicpc.net/problem/11000
 * 강의실 배정
 */
public class Test11000 {
	private static int n;
	private static int[][] st;
	private static PriorityQueue<Integer> rooms = new PriorityQueue<>();
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			n = Integer.parseInt(br.readLine());
			st = new int[n][2];
			for (int i = 0; i < n; i++) {
				String[] strSt = br.readLine().split(" ");
				st[i][0] = Integer.parseInt(strSt[0]);
				st[i][1] = Integer.parseInt(strSt[1]);
			}
			Arrays.sort(st, Comparator.comparingInt(time -> time[0]));
			rooms.add(st[0][1]);
			countMinimum();
			System.out.println(rooms.size());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countMinimum() {
		for (int i = 1; i < n; i++) {
			if (rooms.peek() > st[i][0]) {
				rooms.add(st[i][1]);
			} else {
				rooms.poll();
				rooms.add(st[i][1]);
			}
		}
	}
}
