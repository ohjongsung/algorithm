package io.ohjongsung.algorithm.ctci.phase03;

import io.ohjongsung.algorithm.ctci.phase03.datastructure.Stack;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-27
 * Description : 큰 값이 위에 오도록 스택을 오름차순 정렬하는 프로그램을 작성하라. 여벌 스택은 하나까지만 사용할 수 있고, 스택에 보관
 * 된 요소를 배열 등의 다른 자료구조로는 복사할 수 없다. 스택은 push, pop, peek, isEmpty의 네 가지 연산을 제공한다.
 */
public class Problem06 {
    /**
     * Stack, StackBetter에 구현함
     */
    public static void main(String[] args) {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(1);
        numbers.push(3);
        numbers.push(7);
        numbers.push(2);
        numbers.push(4);
        numbers.push(9);
        Stack<Integer> sortedNumbers = Stack.sort(numbers);
        while (!sortedNumbers.isEmptry()) {
            System.out.println(sortedNumbers.pop());
        }
    }

}
