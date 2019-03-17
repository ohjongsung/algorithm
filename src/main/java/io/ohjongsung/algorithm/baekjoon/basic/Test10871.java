package io.ohjongsung.algorithm.baekjoon.basic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Test10871 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out))) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int n = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine(), " ");
			while (st.hasMoreTokens()) {
				int y = Integer.parseInt(st.nextToken());
				if (y < x) {
					bw.write(y + " ");
				}
			}
			bw.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
