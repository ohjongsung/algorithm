package io.ohjongsung.algorithm.ctci.phase02;

import io.ohjongsung.algorithm.ctci.phase02.datastructure.SimplyLinkedList;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-24
 * Description : 비정렬(unsorted)연결 리스트에서 중복 문자를 제거하는 코드를 작성하라.
 * 연관 문제 : 임시 버퍼가 허용되지 않는 상황에서 이 문제를 어떻게 해결할 수 있겠는가?
 */
public class Problem01 {
    public static void main(String[] args) {
        SimplyLinkedList<String> duplicatedStrings = new SimplyLinkedList<>();
        duplicatedStrings.addLast("초복");
        duplicatedStrings.addLast("중복");
        duplicatedStrings.addLast("말복");
        duplicatedStrings.addLast("중복");
        duplicatedStrings.addLast("말복");
        System.out.println(duplicatedStrings.toString());
        duplicatedStrings.removeDuplicate();
        System.out.println(duplicatedStrings.toString());
    }
}
