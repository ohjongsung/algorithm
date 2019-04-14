package io.ohjongsung.algorithm.baekjoon.dynamic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * created by ohjongsung on 2019-04-14
 * https://www.acmicpc.net/problem/9465
 * 스티커
 */
public class Test9465 {
	private static int[][] STICKER;
	private static int[][] DP;
	private static int COL_LENGTH;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int n = Integer.parseInt(br.readLine());
			for (int t = 0; t < n; t++) {
				COL_LENGTH = Integer.parseInt(br.readLine());
				STICKER  = new int[2][COL_LENGTH];
				for (int j = 0; j < 2; j++) {
					StringTokenizer st = new StringTokenizer(br.readLine());
					for (int k = 0; k < COL_LENGTH; k++) {
						STICKER[j][k] = Integer.parseInt(st.nextToken());
					}
				}
				DP = new int[COL_LENGTH+1][3];
				// bottom up 방식
				for (int i = 0; i < COL_LENGTH; i++) {
					DP[i+1][0] = Math.max(DP[i+1][0], Math.max(DP[i][0], Math.max(DP[i][1], DP[i][2])));
					DP[i+1][1] = Math.max(DP[i+1][1], Math.max(DP[i][0], DP[i][2]) + STICKER[0][i]);
					DP[i+1][2] = Math.max(DP[i+1][2], Math.max(DP[i][0], DP[i][1]) + STICKER[1][i]);
				}
				System.out.println( Math.max(DP[COL_LENGTH][0], Math.max(DP[COL_LENGTH][1], DP[COL_LENGTH][2])));
				//System.out.println(solve(0, 0));
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * Top down 방식
	 * status 0 : 이전 열에서 스티커 제거 안함
	 * status 1 : 이전 열에서 위 스티커 제거
	 * status 2 : 이전 열에서 아래 스티커 제거
	 * @param col 현재 열 위치
	 * @param status 이전 열 스티커 제거 상태
	 * @return 최대값
	 */
	private static int solve(int col, int status) {
		if (col == COL_LENGTH) {
			return 0;
		}

		int result = solve(col + 1, 0);
		if (status != 1) {
			result = Math.max(result, solve(col + 1, 1) + STICKER[0][col]);
		}
		if (status != 2) {
			result = Math.max(result, solve(col + 1, 2) + STICKER[1][col]);
		}
		DP[col][status] = result;
		return result;
	}
}
