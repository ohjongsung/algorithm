package io.ohjongsung.algorithm.collections;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-23
 * Description :
 */
public class CountStack {
    public static void main(String[] args) {
        List<Stack<Integer>> result = getFilterdStack();
        for (Stack stack : result) {
            while (!stack.isEmpty()) {
                System.out.print(stack.pop());
            }
            System.out.println();
        }
    }

    private static List<Stack<Integer>> getFilterdStack() {
        int[] arr = { 3, 5, 2, 5, 7, 1, 3, 9, 2, 11, 5, 7, 1, 4, 6 };
        List<Stack<Integer>> result = new LinkedList<>();
        int temp = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : arr) {
            if (temp + i <= 20) {
                stack.push(i);
                temp += i;
            } else {
                result.add(stack);
                stack = new Stack<>();
                stack.push(i);
                temp = i;
            }
        }
        result.add(stack);
        return result;
    }
}
