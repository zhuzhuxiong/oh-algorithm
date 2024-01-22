package com.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 文本左右对齐
 *
 * @author zz
 */
public class Code68No24 {

    public static List<String> fullJustify(String[] words, int maxWidth) {

        ArrayList<String> ans = new ArrayList<>();
        int n = words.length;
        ArrayList<String> list = new ArrayList<>();

        for (int i = 0; i < n; ) {
            list.clear();
            list.add(words[i]);
            int cur = words[i++].length();
            while (i < n && cur + 1 + words[i].length() <= maxWidth) {
                cur = cur + 1 + words[i].length();
                list.add(words[i++]);
            }

            if (i == n) {
                StringBuilder sb = new StringBuilder(list.get(0));
                for (int k = 1; k < list.size(); k++) {
                    sb.append(" ").append(list.get(k));
                }
                while (sb.length() < maxWidth) {
                    sb.append(" ");
                }
                ans.add(sb.toString());
                break;
            }

            int cnt = list.size();
            if (cnt == 1) {
                String str = list.get(0);
                while (str.length() != maxWidth) {
                    str += " ";
                }
                ans.add(str);
                continue;
            }
            //cnt：list包含的单词数，cnt-1：两个单词间有一个空格，cur - 空格： 剩下的为字符长度。
            int wordLength = cur - (cnt - 1);
            int spaceLength = maxWidth - wordLength;
            //空格分担到三个位置，每个位置 itemLength 个空格
            int itemLength = spaceLength / (cnt - 1);

            //拼接空格数
            String spaceItem = "";
            for (int k = 0; k < itemLength; k++) {
                spaceItem += " ";
            }

            StringBuilder sb = new StringBuilder();
            for (int k = 0, sum = 0; k < cnt; k++) {
                String item = list.get(k);
                sb.append(item);
                if (k == cnt - 1) {
                    break;
                }
                sb.append(spaceItem);
                sum += itemLength;

                int remain = cnt - k - 1 - 1;
                if (remain * itemLength + sum < spaceLength) {
                    sb.append(" ");
                    sum++;
                }
            }
            ans.add(sb.toString());
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] str = {"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"};
        List<String> list = fullJustify(str, 20);
        System.out.println(list);
    }
}
