package com.catxu.leetcode.question22;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. Generate Parentheses
 * <p>
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 3
 * <p>
 * Output: ["((()))","(()())","(())()","()(())","()()()"]
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1
 * <p>
 * Output: ["()"]
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 8
 */
class Solution {
    List<String> ans = new ArrayList<>();
    StringBuilder path = new StringBuilder();

    public List<String> generateParenthesis(int n) {
        backtrack(n, 0, 0);
        return ans;
    }

    private void backtrack(int n, int open, int close) {
        if (open > n || close > n || open < close) {
            return;
        }
        if (path.length() == n * 2) {
            ans.add(path.toString());
            return;
        }
        path.append("(");
        backtrack(n, open + 1, close);
        path.deleteCharAt(path.length() - 1);

        path.append(")");
        backtrack(n, open, close + 1);
        path.deleteCharAt(path.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generateParenthesis(3));
    }
}
