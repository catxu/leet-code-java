package com.catxu.leetcode.question1209;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 1209. Remove All Adjacent Duplicates in String II
 */
class Solution {
    public String removeDuplicates(String s, int k) {
        int n = s.length();
        if (n < k) return s;
        Deque<Pair> stack = new ArrayDeque<>();
        char[] w = s.toCharArray();
        Pair pair = new Pair(w[0], 1);
        stack.push(pair);
        for (int i = 1; i < n; i++) {
            if (stack.isEmpty()) {
                stack.push(new Pair(w[i], 1));
                continue;
            }
            Pair prev = stack.peek();
            if (prev.c == w[i]) {
                if (prev.cnt + 1 == k) {
                    stack.pop();
                } else {
                    prev.cnt += 1;
                }
            } else {
                stack.push(new Pair(w[i], 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            Pair node = stack.removeLast();
            sb.repeat(node.c, node.cnt);
        }
        return sb.toString();
    }

    static class Pair {
        private final char c;
        private int cnt;

        public Pair(char c, int cnt) {
            this.c = c;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().removeDuplicates("abcd", 2));
        System.out.println(new Solution().removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(new Solution().removeDuplicates("pbbcggttciiippooaais", 2));
        System.out.println(new Solution().removeDuplicates("deeedcbbcccbccdaa", 3));
    }
}
