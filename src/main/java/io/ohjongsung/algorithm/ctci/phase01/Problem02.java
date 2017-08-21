package io.ohjongsung.algorithm.ctci.phase01;

import java.util.Arrays;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-21
 * Description : 문자열 두 개를 입력으로 받아 그중 하나가 다른 하나의 순열인지 판별하는 메서드를 작성하라.
 */
public class Problem02 {
    public static void main (String[] args) {
        String str1 = "알고리즘";
        String str2 = "리즘고알";

        // 정렬을 통한 판별
        boolean permutation = isPermutation(str1, str2);
        System.out.println(permutation);
    }

    public static boolean isPermutation(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        return sort(s1).equals(sort(s2));
    }

    public static String sort(String s) {
        char[] content = s.toCharArray();
        Arrays.sort(content);

        return new String(content);
    }
}
