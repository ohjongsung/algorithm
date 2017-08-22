package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-22
 * Description : 한 단어가 다른 단어에 포함된 문자열인지 판별하는 isSubstring이라는 메서드가 있다고 하자. s1과 s2의 두 문자열이
 * 주어졌을 때, s2가 s1을 회전시킨 결과인지 판별하는 코드를 isSubstring을 한 번만 호출하도록 하여 작성하라. (가령 'waterbottle'은
 * 'erbottlewat'을 회전시켜 얻을 수 있는 문자열이다)
 */
public class Problem07 {
    public static void main(String[] args) {
        String s1 = "waterbottle";
        String s2 = "erbottlewat";

        boolean result = isRotation(s1, s2);
        System.out.println(result);
    }

    private static boolean isRotation(String s1, String s2) {
        if (s1.length() == s2.length() && s1.length() > 0) {
            return isSubstring(s1, doubleString(s2));
        }
        return false;
    }

    private static boolean isSubstring(String s1, String s2s2) {
        return s2s2.contains(s1);
    }

    private static String doubleString(String s2) {
        return s2+s2;
    }
}
