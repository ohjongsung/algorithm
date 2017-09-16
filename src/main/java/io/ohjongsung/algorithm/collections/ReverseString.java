package io.ohjongsung.algorithm.collections;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-08
 * Description :
 */
public class ReverseString {
    public static void main(String[] args) {
        String source = "I am a boy.";
        reverseString(source);
        reverseString2(source);
    }

    private static void reverseString2(String source) {
        final StringBuilder builder = new StringBuilder(source);

        for (int i = 0; i < builder.length() / 2; i++) {
            char temp = builder.charAt(i);
            int endIndex = builder.length() - i - 1;
            builder.setCharAt(i, builder.charAt(endIndex));
            builder.setCharAt(endIndex, temp);
        }

        System.out.println(builder.toString());
    }

    private static void reverseString(String s) {
        final StringBuilder builder = new StringBuilder();
        for (int i = s.length() - 1; i >= 0; i--) {
            builder.append(s.charAt(i));
        }

        System.out.println(builder.toString());
    }
}
