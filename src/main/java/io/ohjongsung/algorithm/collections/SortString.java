package io.ohjongsung.algorithm.collections;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-14
 * Description :
 */
public class SortString {
    public static void main(String[] args) {
        String unSorted = "dBcAaEC";

        // put the characters into an array
        Character[] chars = new Character[unSorted.length()];
        for (int i = 0; i < chars.length; i++)
            chars[i] = unSorted.charAt(i);

        // sort the array
        Arrays.sort(chars, new Comparator<Character>() {
            public int compare(Character c1, Character c2) {
                int cmp = Character.compare(
                        Character.toLowerCase(c1.charValue()),
                        Character.toLowerCase(c2.charValue())
                );
                if (cmp != 0) return cmp;
                return Character.compare(c2.charValue(),c1.charValue());
            }
        });

        // rebuild the string
        StringBuilder sb = new StringBuilder(chars.length);
        for (char c : chars) sb.append(c);
        unSorted = sb.toString();
        System.out.println(unSorted);
    }
}
