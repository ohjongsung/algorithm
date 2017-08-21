package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-21
 * Description : 문자열에 포함된 문자들이 전부 유일한지를 검사하는 알고리즘을 구현하라.
 * 다른 자료구조를 사용할 수 없는 상황이라면 어떻게 하겠는가?
 */
public class Problem01 {
    public static void main(String[] args) {
        String s = "국민을위한국가";

        boolean Unique = isUnique(s);
        System.out.println(Unique);
    }

    public static boolean isUnique(String s) {
        for (int i = 0; i < s.length(); i++) {
            char origin = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                char temp = s.charAt(j);
                if (i != j){
                    if (origin == temp) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
