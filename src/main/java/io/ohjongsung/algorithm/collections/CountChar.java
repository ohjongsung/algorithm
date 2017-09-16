package io.ohjongsung.algorithm.collections;

/**
 * Project : algorithm
 * Developer : ohjongsung
 * Date : 2017-09-09
 * Description :
 */
public class CountChar {
    public static void main(String[] args) {
        String article = "Mr John Smith    ";
        int count = countChar(article);
        System.out.println(count);
    }

    private static int countChar(String article) {
        int count = 0;
        for (int i = 0; i < article.length(); i++) {
            if (article.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}
