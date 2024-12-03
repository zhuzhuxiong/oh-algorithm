package com.labula.graph.BFS;

import javax.swing.text.EditorKit;
import java.util.*;

/**
 * minimum genetic mutation
 *
 * @author zz
 */
public class No3Code433 {

    public int minMutation(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);

        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(endGene)) {
                    return step;
                }

                for (String gene : getAllMutation(cur)) {
                    if (!visited.contains(gene) && bankSet.contains(gene)) {
                        queue.offer(gene);
                        visited.add(gene);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getAllMutation(String gene) {
        // todo 变成set？
        List<String> res = new ArrayList<>();

        char[] geneChars = gene.toCharArray();
        for (int i = 0; i < geneChars.length; i++) {
            char old = geneChars[i];
            for (char newChar : new char[]{'A', 'G', 'C', 'T'}) {
                geneChars[i] = newChar;
                res.add(new String(geneChars));
            }
            geneChars[i] = old;
        }
        return res;
    }

    public static void main(String[] args) {
//        输出：2
        String start = "AACCGGTT", end = "AAACGGTA";
        String[] bank = {"AACCGGTA", "AACCGCTA", "AAACGGTA"};

        System.out.println(new No3Code433().minMutation(start, end, bank));
        System.out.println(new No3Code433().practice(start, end, bank));
    }

    public int practice(String startGene, String endGene, String[] bank) {
        HashSet<String> bankSet = new HashSet<>(Arrays.asList(bank));
        if (!bankSet.contains(endGene)) {
            return -1;
        }

        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();

                if (cur.equals(endGene)) {
                    return step;
                }
                char[] chars = cur.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char oldChar = chars[j];
                    for (char c : new char[]{'A', 'C', 'G', 'T'}) {
                        chars[j] = c;
                        String newStr = new String(chars);
                        if (!visited.contains(newStr) && bankSet.contains(newStr)) {
                            queue.offer(newStr);
                            visited.add(newStr);
                        }
                        chars[j] = oldChar;
                    }
                }
            }
            step++;
        }
        return -1;
    }
}
