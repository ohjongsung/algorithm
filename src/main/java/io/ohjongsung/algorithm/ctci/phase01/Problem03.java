package io.ohjongsung.algorithm.ctci.phase01;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-08-21
 * Description : 주어진 문자열 내의 모든 공백을 '%20'으로 바꾸는 메서드를 작성하라. 문자열 끝에 추가로 필요한 문자들을 더할 수 있는
 * 충분한 공간이 있다고 가정하라. 그리고 공백을 포함하는 문자열의 길이도 함께 주어진다고 가정하라. (주의: Java로 구현한다면, 문자 배열
 * 을 사용하여 필요한 연산을 각 문자에 바로 적용할 수 있도록 하라.)
 * ex)
 * input  : "Mr John Smith    ", 13
 * output : "Mr%20John%20Smith"
 */
public class Problem03 {
    public static void main(String[] args) {
        String str = "Mr John Smith    ";
        int length = 13;

        String result = replaceSpaces(str, length);
        System.out.println(result);
    }

    public static String replaceSpaces(String str, int length) {
        char[] arr_s = str.toCharArray();
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (arr_s[i] == ' ') {
                count++;
            }
        }
        int newLength = length + count * 2;
        char[] arr_new = new char[newLength];
        for (int i = length - 1; i >= 0; i--) {
            if (arr_s[i] == ' ') {
                arr_new[newLength - 1] = '0';
                arr_new[newLength - 2] = '2';
                arr_new[newLength - 3] = '%';
                newLength = newLength - 3;
            } else {
                arr_new[newLength - 1] = arr_s[i];
                newLength = newLength - 1;
            }
        }
        return new String(arr_new, 0, arr_new.length);
    }
}
