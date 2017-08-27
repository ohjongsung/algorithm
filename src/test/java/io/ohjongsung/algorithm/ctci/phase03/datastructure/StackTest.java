package io.ohjongsung.algorithm.ctci.phase03.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description : 스택 구현 테스트
 */
public class StackTest {
    @Test
    public void test() throws Exception {
        Stack<Integer> numbers = new Stack<>();
        numbers.push(0);
        numbers.push(1);
        numbers.push(2);

        assert (false == numbers.isEmptry());
        assert (2 == numbers.peek());
        assert (3 == numbers.size());
        assert (2 == numbers.pop());
        assert (2 == numbers.size());
        assert (1 == numbers.pop());
        assert (1 == numbers.size());
        assert (0 == numbers.pop());
        assert (0 == numbers.size());
        assert (true == numbers.isEmptry());

        StackBetter<Integer> numbersTwo = new StackBetter<>();
        numbersTwo.push(0);
        numbersTwo.push(1);
        numbersTwo.push(2);

        assert (false == numbersTwo.isEmptry());
        assert (2 == numbersTwo.peek());
        assert (3 == numbersTwo.size());
        assert (2 == numbersTwo.pop());
        assert (2 == numbersTwo.size());
        assert (1 == numbersTwo.pop());
        assert (1 == numbersTwo.size());
        assert (0 == numbersTwo.pop());
        assert (0 == numbersTwo.size());
        assert (true == numbersTwo.isEmptry());
    }
}