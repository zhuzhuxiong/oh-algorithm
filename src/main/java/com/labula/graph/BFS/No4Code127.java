package com.labula.graph.BFS;

import java.util.*;

/**
 * word ladder
 *
 * @author zz
 */
public class No4Code127 {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                char[] wordChar = cur.toCharArray();
                for (int j = 0; j < wordChar.length; j++) {
                    char old = wordChar[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (k == old) {
                            continue;
                        }
                        wordChar[j] = k;
                        String newWord = new String(wordChar);
                        if (wordSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    wordChar[j] = old;
                }
            }
            step++;
        }
        return 0;
    }

    public static void main(String[] args) {
//        输出：5
        String beginWord1 = "hot", endWord1 = "dog";
        String[] wordList1 = {"hot","dog"};
        String beginWord = "ymain", endWord = "oecij";
        String[] wordList = {"ymann", "yycrj", "oecij", "ymcnj", "yzcrj", "yycij", "xecij", "yecij", "ymanj", "yzcnj", "ymain"};
        System.out.println(new No4Code127().ladderLength(beginWord1, endWord1, Arrays.asList(wordList1)));
        System.out.println(new No4Code127().practice(beginWord1, endWord1, Arrays.asList(wordList1)));

    }

    public int practice(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> worldSet = new HashSet<>(wordList);
        if (!worldSet.contains(endWord)) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(beginWord);
        visited.add(beginWord);

        int step = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                char[] chars = cur.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        if (chars[j] == k) {
                            continue;
                        }
                        chars[j] = k;
                        String newWord = new String(chars);
                        if (worldSet.contains(newWord) && !visited.contains(newWord)) {
                            if (newWord.equals(endWord)) {
                                return step + 1;
                            }
                            queue.offer(newWord);
                            visited.add(newWord);
                        }
                    }
                    chars[j] = oldChar;
                }
            }
            step++;
        }
        return 0;
    }

}
