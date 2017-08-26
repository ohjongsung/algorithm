package io.ohjongsung.algorithm.ctci.phase03.datastructure;

import org.junit.Test;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-26
 * Description : 큐 구현 테스트
 */
public class QueueTest {
    @Test
    public void test() throws Exception {
        Queue<Integer> numbers = new Queue<>();
        numbers.enqueue(0);
        numbers.enqueue(1);
        numbers.enqueue(2);
        numbers.enqueue(3);

        assert (4 == numbers.size());
        assert (0 == numbers.dequeue());
        assert (3 == numbers.size());
        assert (1 == numbers.dequeue());
        assert (2 == numbers.size());
        assert (2 == numbers.dequeue());
        assert (1 == numbers.size());
    }

}