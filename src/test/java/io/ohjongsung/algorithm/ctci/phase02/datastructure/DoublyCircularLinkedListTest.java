package io.ohjongsung.algorithm.ctci.phase02.datastructure;

import org.junit.Test;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 이중 원형 연결 리스트 테스트
 */
public class DoublyCircularLinkedListTest {

    @Test
    public void test() {
        // 1,2,4,5 추가
        DoublyCircularLinkedList<Integer> list = new DoublyCircularLinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(4);
        list.addLast(5);
        System.out.println(list.toString());

        // [1,2,4,5] 인지 확인
        assert(1 == list.get(0));
        assert(2 == list.get(1));
        assert(4 == list.get(2));
        assert(5 == list.get(3));

        // 앞에 0 추가
        list.addFirst(0);
        System.out.println(list.toString());

        // [0,1,2,4,5] 인지 확인
        assert(0 == list.get(0));
        assert(5 == list.get(4));

        // 중간에 3 추가
        list.add(3, 3);
        System.out.println(list.toString());

        // [0,1,2,3,4,5] 인지 확인
        assert(3 == list.get(3));
        assert(5 == list.get(5));

        // 0,2,4 지우고, 앞과 뒤 지우기
        list.remove(0);
        System.out.println(list.toString());
        list.remove(1);
        System.out.println(list.toString());
        list.remove(2);
        System.out.println(list.toString());
        list.removeLast();
        System.out.println(list.toString());
        list.removeFirst();
        System.out.println(list.toString());

        // [3] 인지 확인
        assert(3 == list.get(0));
    }
}