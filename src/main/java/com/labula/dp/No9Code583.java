package com.labula.dp;

/**
 * 两个字符串删除操作
 * @author zz
 */
public class No9Code583 {

    public int minDistance(String word1, String word2) {
        int lcs = lcs(word1, word2);

        return (word1.length()) - lcs + (word2.length() - lcs);
    }

    private int lcs(String word1, String word2) {
        return 0;
    }

    public static void main(String[] args) {

    }
}
