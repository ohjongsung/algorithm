package io.ohjongsung.algorithm.baekjoon.basic;

import java.util.Scanner;

/**
 * created by ohjongsung on 2019-03-15
 * https://www.acmicpc.net/problem/8393
 * 합
 */
public class Test8393 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = n * (n + 1) / 2;
		System.out.print(result);
	}
}
