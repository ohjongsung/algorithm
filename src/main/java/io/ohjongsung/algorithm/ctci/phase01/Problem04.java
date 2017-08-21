package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-21
 * Description : 같은 문자가 연속으로 반복될 경우, 그 횟수를 사용해 문자열을 압축하는 메서드를 구현하라. 가령 압축해야 할 문자열이
 * aabccccccccaaa라면 a2b1c8a3과 같이 압축되어야 한다. 압축 결과로 만들어지는 문자열이 원래 문자열보다 짧아지지 않는 경우, 이 메서드
 * 는 원래 문자열을 그대로 반환해야 한다.
 */
public class Problem04 {
    public static void main(String[] args) {
        String str = "aabccccccccaaa";

        String result = compress(str);
        System.out.println(result);
    }

    private static String compress(String str) {
        int size = countCompression(str);
        if (str.length() <= size) {
            return str;
        }

        char last = str.charAt(0);
        int count = 0;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                builder.append(last);
                builder.append(count);
                last = str.charAt(i);
                count = 1;
            }
        }
        builder.append(last);
        builder.append(count);

        return builder.toString();
    }

    private static int countCompression(String str) {
        char last = str.charAt(0);
        int count = 0;
        int size = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == last) {
                count++;
            } else {
                size += 1 + String.valueOf(count).length(); // 글자 a의 자리 1 + a의 갯수 자리 1 을 더한다.
                last = str.charAt(i);
                count = 1;
            }
        }
        size += 1 + String.valueOf(count).length();
        return size;
    }
}
