package com.catxu.leetcode.question89;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code
 */
class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        ans.add(0);
        ans.add(1);
        int cur = 1;
        for (int i = 2; i <= n; i++) {
            cur *= 2;
            for (int j = ans.size() - 1; j >= 0; j--) {
                ans.add(cur + ans.get(j));
            }
        }
        return ans;
    }

    public List<Integer> grayCodeIV(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        for (int i = 0; i < 1 << n; i++) {
            ans.add(i ^ i >> 1); // i ^ i / 2
        }
        return ans;
    }

    public List<Integer> grayCodeIII(int n) {
        if (n == 1) {
            List<Integer> base = new ArrayList<>();
            base.add(0);
            base.add(1);
            return base;
        }
        List<Integer> list = grayCodeIII(n - 1);
        for (int i = list.size() - 1; i >= 0; i--) {
            list.add((1 << n - 1) + list.get(i));
        }
        return list;
    }

    int num = 0;

    public List<Integer> grayCodeII(int n) {
        List<Integer> ans = new ArrayList<>(1 << n);
        dfs(ans, n);
        return ans;
    }

    private void dfs(List<Integer> ans, int n) {
        if (n == 0) {
            ans.add(num);
            return;
        }
        dfs(ans, n - 1);
        num = num ^ (1 << (n - 1));
        dfs(ans, n - 1);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().grayCode(3));
        System.out.println(new Solution().grayCode(1));
        System.out.println(new Solution().grayCodeII(3));
        System.out.println(new Solution().grayCodeII(1));
        System.out.println(new Solution().grayCodeIII(3));
        System.out.println(new Solution().grayCodeIII(1));
        System.out.println(new Solution().grayCodeIV(3));
        System.out.println(new Solution().grayCodeIV(1));
    }
}
