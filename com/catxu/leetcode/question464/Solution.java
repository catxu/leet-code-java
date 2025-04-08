package com.catxu.leetcode.question464;

/**
 * 464. Can I Win
 */
class Solution {
    // 记忆化存储: 0 = 未计算, 1 = 当前玩家能赢, 2 = 当前玩家不能赢
    private byte[] memo;
    private int n;
    private int t;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        this.n = maxChoosableInteger;
        this.t = desiredTotal;

        // 边界情况 1: n大于目标数，先手直接赢
        if (n >= t) {
            return true;
        }

        // 边界情况 2: 所有数字总和小于目标，谁都赢不了
        int sumOfAll = n * (n + 1) / 2;
        if (sumOfAll < t) {
            return false;
        }

        // 初始化记忆化数组，大小为 2^n
        // Java 中 byte 数组默认初始化为 0，正好代表“未计算”
        memo = new byte[1 << n];

        // 从初始状态 (mask=0, currentTotal=0) 开始递归
        return dfs(0, 0);
    }

    /**
     * 记忆化的深搜
     *
     * @param mask         当前已选数字的位掩码
     * @param currentTotal 当前已选数字的总和
     * @return boolean      当前轮到的玩家是否能保证获胜
     */
    private boolean dfs(int mask, int currentTotal) {
        // 1. 检查备忘录
        if (memo[mask] != 0) {
            // 1 表示能赢，2 表示不能赢
            return memo[mask] == 1;
        }

        boolean canWinFlag = false; // 假设当前玩家不能赢

        // 2. 遍历所有可选数字 i (1 to maxInt)
        for (int i = 1; i <= n; i++) {
            int currentBit = (1 << (i - 1)); // 数字 i 对应的位
            // 3. 检查数字 i 是否可用
            if ((mask & currentBit) == 0) { // 第 i-1 位是 0，表示数字 i 可用
                // 4a. 检查选择 i 是否立即获胜
                if (currentTotal + i >= t) {
                    canWinFlag = true; // 找到了一个必胜走法
                    break; // 无需再检查其他数字
                }

                // 4b. 检查选择 i 后，对手是否必败
                // 递归调用判断对手在下一个状态是否能赢
                // 如果对手不能赢 (!canWinHelper(...))，则当前玩家选择 i 可以获胜
                int nextMask = mask | currentBit;
                int nextTotal = currentTotal + i;
                if (!dfs(nextMask, nextTotal)) {
                    canWinFlag = true; // 找到了一个必胜走法
                    break; // 无需再检查其他数字
                }
            }
        }

        // 5. 记录结果到备忘录并返回
        memo[mask] = (byte) (canWinFlag ? 1 : 2);
        return canWinFlag;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canIWin(3, 5));
    }
}