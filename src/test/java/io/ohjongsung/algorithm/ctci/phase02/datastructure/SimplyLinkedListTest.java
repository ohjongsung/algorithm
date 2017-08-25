package io.ohjongsung.algorithm.ctci.phase02.datastructure;

import org.junit.Test;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 단순 연결 리스트 테스트
 */
public class SimplyLinkedListTest {

    @Test
    public void test() {
        SimplyLinkedList<Integer> list = new SimplyLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);

        assert (1 == list.get(0));
        assert (2 == list.get(1));
        assert (4 == list.get(2));
        assert (5 == list.get(3));

        list.add(2, 3);
        assert (3 == list.get(2));
        assert (4 == list.get(3));

        list.remove(1);
        list.remove(2);

        assert (3 == list.size());
        assert (4 == list.get(1));
    }
}