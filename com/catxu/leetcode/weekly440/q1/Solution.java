package com.catxu.leetcode.weekly440.q1;

/**
 * 3477. Fruits Into Baskets II
 */
class Solution {

    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n];
        int placed = 0;

        for (int fruit : fruits) {
            for (int i = 0; i < n; i++) {
                if (!used[i] && baskets[i] >= fruit) {
                    used[i] = true;
                    placed++;
                    break;
                }
            }
        }

        return n - placed;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numOfUnplacedFruits(new int[]{4, 2, 5}, new int[]{3, 5, 4}));
    }
}