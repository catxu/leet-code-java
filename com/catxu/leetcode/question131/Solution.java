package com.catxu.leetcode.question131;

import java.util.LinkedList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 */
class Solution {

    private char[] s;
    private int n;
    private final List<List<String>> ans = new LinkedList<>();

    public List<List<String>> partition(String S) {
        this.s = S.toCharArray();
        this.n = s.length;
        dfs(0, new LinkedList<>());
        return ans;
    }

    private void dfs(int start, List<String> state) {
        if (start == n) {
            ans.add(new LinkedList<>(state));
            return;
        }
        for (int i = start; i < n; i++) {
            if (isPalindrome(start, i)) {
                state.add(new String(s, start, i - start + 1));
                dfs(i + 1, state);
                state.removeLast();
            }
        }
    }

    private boolean isPalindrome(int start, int end) {
        while (start < end) {
            if (s[start++] != s[end--]) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().partition("aaaaa"));
    }
}
