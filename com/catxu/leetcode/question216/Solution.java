package com.catxu.leetcode.question216;

import java.util.LinkedList;
import java.util.List;

/**
 * 216. Combination Sum III
 */
class Solution {

    private final List<List<Integer>> ans = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(0, 1, new LinkedList<>(), k, n);
        return ans;
    }

    private void dfs(int sum, int start, List<Integer> state, int k, int n) {
        if (sum == n) {
            ans.add(new LinkedList<>(state));
            return;
        }
        for (int i = start; i < 10; i++) {
            if (sum + i > n) continue;
            state.add(i);
            dfs(sum + i, i + 1, state, k, n);
            state.removeLast();
        }
    }
}
