package io.ohjongsung.algorithm.ctci.phase03;

import io.ohjongsung.algorithm.ctci.phase03.datastructure.Stack;

import java.util.ArrayList;
import java.util.List;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-27
 * Description : Towers of Hanoi 문제에는 3개의 탑과 N개의 원판이 등장하는데, 각 원판은 어느 탑으로도 옮길 수 있다. 하노이 탑 퍼즐
 * 은 세 개의 탑 가운데 하나에 이 N개의 원판을 쌓아두고 시작한다. 이때 원판들은 지름이 작은 원판이 위쪽에 오도록 배열된다. 하노이 탑
 * 퍼즐에는 다음과 같은 제약조건이 있다.
 * 1. 한 번에 하나의 원판만 옮길 수 있다.
 * 2. 탑의 맨 꼭대기에 있는 원판은 다른 탑으로 옮길 수 있다.
 * 3. 원판은 자기보다 지름이 큰 원판 위로만 옮길 수 있다.
 * 스택을 사용하여, 첫 번째 탑에 있는 모든 원판을 마지막 탑으로 옮겨라.
 */
public class Problem04 {
    public static void main(String[] args) {
        Stack<Integer> topOne = new Stack<>();
        topOne.push(4);
        topOne.push(3);
        topOne.push(2);
        topOne.push(1);
        Stack<Integer> topTwo = new Stack<>();
        Stack<Integer> topThree = new Stack<>();

        List<Stack<Integer>> tops = new ArrayList<>();
        tops.add(topOne);
        tops.add(topTwo);
        tops.add(topThree);
        moveDisks(topOne.size(), topOne, topThree, topTwo);
        System.out.println(topOne.toString());
        System.out.println(topTwo.toString());
        System.out.println(topThree.toString());
    }

    public static void moveDisks(int n, Stack origin, Stack destination, Stack buffer) {
        if (n == 0) return;

        moveDisks(n - 1, origin, buffer, destination);
        moveToTop(origin, destination);
        moveDisks(n - 1, buffer, destination, origin);
    }

    public static void moveToTop(Stack origin, Stack destination) {
        Object item = origin.pop();
        destination.push(item);
    }
}
