package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * created by ohjongsung on 2019-03-24
 * https://www.acmicpc.net/problem/1700
 * 멀티탭 스케줄링
 */
public class Test1700 {
	private static int[] n;
	private static int k;
	private static int[] usage;
	private static int count = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			String[] nk = br.readLine().split(" ");
			n = new int[Integer.parseInt(nk[0])];
			k = Integer.parseInt(nk[1]);
			usage = new int[k];
			String[] products = br.readLine().split(" ");
			for (int i = 0; i < k; i++) {
				usage[i] = Integer.parseInt(products[i]);
			}
			for (int i = 0; i < k; i++) {
				countUnplug(usage[i], i);
			}
			System.out.println(count);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void countUnplug(int product, int position) {
		if (!isAlreadyPluged(product)) {
			int emptyPosition = getEmptyPosition();
			if (emptyPosition >= 0) {
				n[emptyPosition] = product;
			} else {
				count++;
				int unplugedPosition = getUnplugedPosition(position);
				n[unplugedPosition] = product;
			}
		}
	}

	/**
	 * 이미 사용중이면 true, 아니면 false
	 * @param product
	 * @return
	 */
	private static boolean isAlreadyPluged(int product) {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == product) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 빈 공간을 찾는다.
	 * @return
	 */
	private static int getEmptyPosition() {
		for (int i = 0; i < n.length; i++) {
			if (n[i] == 0) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * 언플러그 위치를 찾는다.
	 * @param position
	 * @return
	 */
	private static int getUnplugedPosition(int position) {
		int unplugedPosition = 0;
		int longDistance = 0;
		for (int i = 0; i < n.length; i++) {
			int temp = willBeUse(n[i], position);
			if (temp < 0) {
				return i;
			} else {
				if (longDistance < temp) {
					longDistance = temp;
					unplugedPosition = i;
				}
			}
		}
		return unplugedPosition;
	}

	private static int willBeUse(int plugedProduct, int position) {
		for (int i = position + 1; i < k; i++) {
			if (usage[i] == plugedProduct) {
				return i;
			}
		}
		return -1;
	}
}
