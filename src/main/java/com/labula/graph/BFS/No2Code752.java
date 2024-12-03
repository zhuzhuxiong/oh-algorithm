package com.labula.graph.BFS;

import java.util.*;

/**
 * open the lock
 * @author zz
 */
public class No2Code752 {

    public int openLock(String[] deadends, String target) {
        Set<String> deads = new HashSet<>();
        for (String s : deadends) {
            deads.add(s);
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        int step = 0;
        queue.offer("0000");
        visited.add("0000");

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (deads.contains(cur)) {
                    continue;
                }
                if (cur.equals(target)) {
                    return step;
                }
                for (int j = 0; j < 4; j++) {
                    String up = plusOne(cur, j);
                    if (!visited.contains(up)) {
                        queue.offer(up);
                        visited.add(up);
                    }
                    String down = minusOne(cur, j);
                    if (!visited.contains(down)) {
                        queue.offer(down);
                        visited.add(down);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String minusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '0') {
            chars[i] = '9';
        }else {
            chars[i] -= 1;
        }
        return new String(chars);
    }

    private String plusOne(String s, int i) {
        char[] chars = s.toCharArray();
        if (chars[i] == '9') {
            chars[i] = '0';
        }else {
            chars[i] += 1;
        }
        return new String(chars);
    }

    public static void main(String[] args) {
//        输出：6
        String[] deadends = {"0201","0101","0102","1212","2002"};
        String target = "0202";
        System.out.println(new No2Code752().openLock(deadends, target));
        System.out.println(new No2Code752().practice(deadends, target));
    }


    public int practice(String[] deadends, String target) {
        HashSet<String> deadSet = new HashSet<>(Arrays.asList(deadends));
        if (deadSet.contains(target)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer("0000");
        visited.add("0000");

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (deadSet.contains(cur)) {
                    continue;
                }

                if (cur.equals(target)) {
                    return step;
                }

                for (int j = 0; j < 4; j++) {
                    String plus = plus(cur, j);
                    if (!visited.contains(plus)) {
                        queue.offer(plus);
                        visited.add(plus);
                    }

                    String minus = minus(cur, j);
                    if (!visited.contains(minus)) {
                        queue.offer(minus);
                        visited.add(minus);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private String minus(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '0') {
            chars[j] = '9';
        }else {
            chars[j] -= 1;
        }
        return new String(chars);
    }

    private String plus(String cur, int j) {
        char[] chars = cur.toCharArray();
        if (chars[j] == '9') {
            chars[j] = '0';
        }else {
            chars[j] += 1;
        }
        return new String(chars);
    }
}
