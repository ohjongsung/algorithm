package io.ohjongsung.algorithm.ctci.phase04;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description : 탐욕 알고리즘, 잔돈의 갯수 구하기
 */
public class GreedyAlgorithm {
    public static void main(String[] args) {
        int[] coins = {500, 100, 50, 10, 5, 1};
        int money = 620;
        int idx = 0;
        int ans = 0;

        while (money != 0) {
            int change = money / coins[idx];
            System.out.println(coins[idx] + "원은 " + change + "개");
            money -= change * coins[idx++];
            ans += change;
        }

        System.out.println("총 잔돈의 갯수는 " + ans);
    }
}
