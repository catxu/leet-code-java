package com.catxu.leetcode.question2904;

import java.util.*;

/**
 * 2094. Finding 3-Digit Even Numbers
 */
class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int digit : digits) {
            cnt[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        next:
        for (int i = 100; i < 1000; i += 2) {
            int num = i;
            int[] d = new int[10];
            while (num != 0) {
                int k = num % 10;
                if (++d[k] > cnt[k]) {
                    continue next;
                }
                num /= 10;
            }
            res.add(i);
        }
        int n = res.size();
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public int[] findEvenNumbersII(int[] digits) {
        int[] cnt = new int[10];
        for (int d : digits) {
            cnt[d]++;
        }

        List<Integer> ans = new ArrayList<>();
        dfs(0, 0, cnt, ans);
        return ans.stream().mapToInt(i -> i).toArray();
    }

    // i=0 百位，i=1 十位，i=2 个位，x 表示当前正在构造的数字
    private void dfs(int i, int x, int[] cnt, List<Integer> ans) {
        if (i == 3) {
            ans.add(x);
            return;
        }
        for (int d = 0; d < 10; d++) {
            if (cnt[d] > 0 && (i == 0 && d > 0 || i == 1 || i == 2 && d % 2 == 0)) {
                cnt[d]--; // 消耗一个数字 d
                dfs(i + 1, x * 10 + d, cnt, ans);
                cnt[d]++; // 复原
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findEvenNumbersII(new int[]{1, 2, 3, 4})));
    }
}


