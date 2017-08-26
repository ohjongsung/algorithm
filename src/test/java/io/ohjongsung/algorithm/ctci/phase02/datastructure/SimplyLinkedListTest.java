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
        assert (4 == list.getFromEndPos(2));
        assert (2 == list.getFromEndPos(3));
        assert (1 == list.getFromEndPos(4));
        assert (4 == list.getFromEndPosWithoutSize(2));
        assert (2 == list.getFromEndPosWithoutSize(3));
        assert (1 == list.getFromEndPosWithoutSize(4));

        list.add(2, 3);
        assert (3 == list.get(2));
        assert (4 == list.get(3));

        list.remove(1);
        list.remove(2);

        assert (3 == list.size());
        assert (4 == list.get(1));

        SimplyLinkedList<String> duplicatedStrings = new SimplyLinkedList<>();
        duplicatedStrings.addLast("초복");
        duplicatedStrings.addLast("중복");
        duplicatedStrings.addLast("말복");
        duplicatedStrings.addLast("중복");
        duplicatedStrings.addLast("말복");
        System.out.println(duplicatedStrings.toString());

        duplicatedStrings.removeDuplicate();

        assert (3 == duplicatedStrings.size());
        assert ("초복".equals(duplicatedStrings.get(0)));
        assert ("중복".equals(duplicatedStrings.get(1)));
        assert ("말복".equals(duplicatedStrings.get(2)));
        System.out.println(duplicatedStrings.toString());

        SimplyLinkedList<Integer> numbers = new SimplyLinkedList<>();
        numbers.addLast(1);
        numbers.addLast(2);
        numbers.addLast(3);
        numbers.addLast(1);
        numbers.addLast(2);
        assert (false == numbers.isPalindrome());
    }
}