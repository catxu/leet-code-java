package com.catxu.leetcode.question77;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 * <p>
 * Given two integers n and k, return all possible combinations of k numbers chosen from the range [1, n].
 * <p>
 * You may return the answer in any order.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 4, k = 2
 * <p>
 * Output: [[1,2],[1,3],[1,4],[2,3],[2,4],[3,4]]
 * <p>
 * Explanation: There are 4 choose 2 = 6 total combinations.
 * <p>
 * Note that combinations are unordered, i.e., [1,2] and [2,1] are considered to be the same combination.
 * <p>
 * Example 2:
 * <p>
 * Input: n = 1, k = 1
 * <p>
 * Output: [[1]]
 * <p>
 * Explanation: There is 1 choose 1 = 1 total combination.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 20
 * <p>
 * 1 <= k <= n
 */
class Solution {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(res, n, k, 1, new ArrayList<>());
        return res;
    }

    private void dfs(List<List<Integer>> res, int n, int k, int start, List<Integer> combinations) {
        if (combinations.size() == k) {
            // 这里要新建 List 放入 res 中，否则引用会被清空
            res.add(new ArrayList<>(combinations));
        }

        for (int i = start; i <= n; i++) {
            if (combinations.contains(i) || (!combinations.isEmpty() && i < combinations.get(combinations.size() - 1))) {
                continue;
            }
            combinations.add(i);
            dfs(res, n, k, start + 1, combinations);
            combinations.remove(combinations.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.combine(4, 2));
        System.out.println(s.combine(1, 1));
    }
}
