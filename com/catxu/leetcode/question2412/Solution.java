package com.catxu.leetcode.question2412;

/**
 * 2412. Minimum Money Required Before Transactions
 */
class Solution {
    public long minimumMoney(int[][] transactions) {
        long spend = 0L;
        int cost = 0, cashback = 0;
        for (int[] transaction : transactions) {
            if (transaction[0] > transaction[1]) {
                spend += transaction[0] - transaction[1];
                cashback = Math.max(cashback, transaction[1]);
            } else {
                cost = Math.max(cost, transaction[0]);
            }
        }
        return spend + Math.max(cost, cashback);
    }

    public static void main(String[] args) {
        int[][] transactions1 = new int[3][2];
        transactions1[0] = new int[]{2, 1};
        transactions1[1] = new int[]{5, 0};
        transactions1[2] = new int[]{4, 2};
        System.out.println(new Solution().minimumMoney(transactions1));
        int[][] transactions2 = new int[2][2];
        transactions2[0] = new int[]{3, 0};
        transactions2[1] = new int[]{0, 3};
        System.out.println(new Solution().minimumMoney(transactions2));
    }
}
