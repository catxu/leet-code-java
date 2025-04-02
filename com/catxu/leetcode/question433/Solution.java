package com.catxu.leetcode.question433;

import java.util.*;

/**
 * 433. Minimum Genetic Mutation
 */
class Solution {
    private static final int GENE_LEN = 8;
    private static final char[] KEYS = {'A', 'C', 'G', 'T'};

    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene)) {
            return 0;
        }
        Set<String> dict = new HashSet<>();
        Collections.addAll(dict, bank);
        if (!dict.contains(endGene)) {
            return -1;
        }
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);
        int step = 0;

        // blind bfs
        while (!queue.isEmpty()) {
            step++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                for (int j = 0; j < GENE_LEN; j++) {
                    StringBuilder sb = new StringBuilder(cur);
                    char c = cur.charAt(j);
                    for (char key : KEYS) {
                        if (c != key) {
                            sb.setCharAt(j, key);
                            String next = sb.toString();
                            if (!visited.contains(next) && dict.contains(next)) {
                                if (next.equals(endGene)) {
                                    return step;
                                }
                                visited.add(next);
                                queue.offer(next);
                            }
                        }
                    }
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minMutation("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}));
        System.out.println(new Solution().minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
    }
}
