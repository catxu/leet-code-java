package com.catxu.leetcode.question386;

import java.util.LinkedList;
import java.util.List;

/**
 * 386. Lexicographical Numbers
 */
class Solution {
    List<Integer> ans = new LinkedList<>();
    int n;

    public List<Integer> lexicalOrder(int n) {
        this.n = n;
        dfs(1);
        return ans;
    }

    private void dfs(int num) {
        if (num > n) return;
        ans.add(num);
        if (num * 10 <= n) dfs(num * 10); // 优先 append 0 保证当前字典序下，下个数字字典序最小
        // 9/10 = 0, (9+1)/10 = 1
        if (num + 1 <= n && num / 10 == (num + 1) / 10) dfs(num + 1); // 其次 字典序加1，并保证不进位
    }
}
