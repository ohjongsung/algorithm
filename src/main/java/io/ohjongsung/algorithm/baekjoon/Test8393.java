package io.ohjongsung.algorithm.baekjoon;

import java.util.Scanner;

public class Test8393 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int result = n * (n + 1) / 2;
		System.out.print(result);
	}
}
