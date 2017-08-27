package io.ohjongsung.algorithm.ctci.phase03;

import io.ohjongsung.algorithm.ctci.phase03.datastructure.MyQueue;
import io.ohjongsung.algorithm.ctci.phase03.datastructure.Stack;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-27
 * Description : 두 개의 스택을 사용하여 큐를 구현하는 MyQueue 클래스를 작성해보라.
 */
public class Problem05 {
    public static void main(String[] args) {
        MyQueue<Integer> numbers = new MyQueue<>();
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);
        numbers.enqueue(4);
        int size = numbers.size();
        for (int i = 0; i < size; i++) {
            System.out.println(numbers.dequeue());
        }
    }
}
