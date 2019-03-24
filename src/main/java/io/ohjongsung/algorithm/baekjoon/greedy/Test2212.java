package io.ohjongsung.algorithm.baekjoon.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * created by ohjongsung on 2019-03-24
 * https://www.acmicpc.net/problem/2212
 * 센서
 */
public class Test2212 {
	private static int N;
	private static int K;
	private static Set<Integer> GRID_TEMP = new TreeSet<>();
	private static List<Integer> GRID;
	private static int SUM = 0;
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());
			K = Integer.parseInt(br.readLine());
			String[] arrGrid = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				GRID_TEMP.add(Integer.parseInt(arrGrid[i]));
			}
			GRID = new ArrayList<>(GRID_TEMP);
			solve();
			System.out.println(SUM);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void solve() {
		if (GRID.size() == 1) {
			return;
		}

		int splitPoint = K - 1;
		Map<Integer, Integer> distances = new HashMap<>();
		for (int i = 0; i < GRID.size() - 1; i++) {
			distances.put(i, GRID.get(i + 1) - GRID.get(i));
		}
		List<Integer> keySets = new ArrayList<>(distances.keySet());
		keySets.sort(Comparator.comparing(s -> distances.get(s)));
		Collections.reverse(keySets);

		List<Integer> positions = new ArrayList<>();
		if (keySets.size() < splitPoint) {
			splitPoint = keySets.size();
		}
		for (int i = 0; i < splitPoint; i++) {
			positions.add(keySets.get(i));
		}
		Collections.sort(positions);

		int start = 0;
		int position = 0;
		for (int i = 0; i < GRID.size(); i++) {
			if (position == positions.size()) {
				SUM += GRID.get(GRID.size() - 1) - GRID.get(start);
				break;
			}
			if (i == positions.get(position)) {
				SUM += GRID.get(i) - GRID.get(start);
				start = i + 1;
				position += 1;
			}
		}
	}
}
