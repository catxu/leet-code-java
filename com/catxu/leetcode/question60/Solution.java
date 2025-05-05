package com.catxu.leetcode.question60;

/**
 * 60. Permutation Sequence
 */
class Solution {
    String ans = null;
    int cnt = 0;

    public String getPermutation(int n, int k) {
        backtracking(n, new boolean[n], new StringBuilder(), k);
        return ans;
    }

    private void backtracking(int n, boolean[] visited, StringBuilder state, int k) {
        if (ans != null) {
            return;
        }
        if (state.length() == n) {
            if (++cnt == k) {
                ans = state.toString();
            }
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (visited[i - 1]) continue;
            visited[i - 1] = true;
            state.append(i);
            backtracking(n, visited, state, k);
            visited[i - 1] = false;
            state.deleteCharAt(state.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().getPermutation(3, 2));
    }
}