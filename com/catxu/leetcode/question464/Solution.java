package com.catxu.leetcode.question464;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        // 2. 遍历所有可选数字 i
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

    // 新增成员变量
    private int[] winningMove;

    private boolean canWinHelper(int mask, int currentTotal) {
        // 检查备忘录
        if (memo[mask] != 0) {
            return memo[mask] == 1;
        }

        boolean canWin = false;
        int moveChoice = -1; // 记录本次找到的致胜走法

        // 遍历可选数字 i
        for (int i = 1; i <= n; i++) {
            int currentBit = (1 << (i - 1));
            if ((mask & currentBit) == 0) { // 如果 i 可用

                // 情况1：选择 i 直接获胜
                if (currentTotal + i >= t) {
                    canWin = true;
                    moveChoice = i;
                    break; // 找到一个就行
                }

                // 情况2：选择 i 后，对手无法获胜
                int nextMask = mask | currentBit;
                int nextTotal = currentTotal + i;
                if (!canWinHelper(nextMask, nextTotal)) {
                    canWin = true;
                    moveChoice = i;
                    break; // 找到一个就行
                }
            }
        }

        // 记录结果
        memo[mask] = (byte) (canWin ? 1 : 2);
        if (canWin) {
            // 如果能赢，记录下致胜的那步棋
            winningMove[mask] = moveChoice;
        }
        return canWin;
    }

    /**
     * 找到第一个玩家获胜的最优路径（如果存在）
     *
     * @return List<Integer> 包含第一个玩家按顺序选择的数字列表，如果无法获胜则返回 null
     */
    public List<Integer> findOptimalPath(int maxChoosableInteger, int desiredTotal) {
        this.n = maxChoosableInteger;
        this.t = desiredTotal;

        // 边界情况 1: 目标非正数
        if (desiredTotal <= 0) {
            return new ArrayList<>(); // 无需选择，直接获胜，路径为空
        }
        // 边界情况 2: 总和不足
        int sumOfAll = maxChoosableInteger * (maxChoosableInteger + 1) / 2;
        if (sumOfAll < desiredTotal) {
            return null; // 无法达到目标，无获胜路径
        }

        // 初始化
        memo = new byte[1 << maxChoosableInteger];
        winningMove = new int[1 << maxChoosableInteger];
        Arrays.fill(winningMove, -1); // 初始化为 -1

        // 运行 DP 填充 memo 和 winningMove
        boolean p1CanWin = canWinHelper(0, 0);

        if (!p1CanWin) {
            return null; // P1 无法保证获胜
        }

        // P1 能赢，开始重构路径
        List<Integer> path = new ArrayList<>();
        int currentMask = 0;
        int currentTotal = 0;
        boolean isPlayer1Turn = true;

        while (currentTotal < desiredTotal) {
            int move;
            if (isPlayer1Turn) {
                // P1 根据必胜策略选择
                move = winningMove[currentMask];
                if (move == -1) {
                    // 理论上不应该发生，因为 p1CanWin 为 true 保证了有路可走
                    System.err.println("错误：在获胜状态下找不到 P1 的获胜步骤！");
                    return null;
                }
                path.add(move); // 记录 P1 的步骤
            } else {
                // P2 的回合，选择任意一个可行的步骤
                // P1 的策略保证了无论 P2 怎么选，P1 下一步仍有 winningMove
                // 为简单起见，让 P2 选当前最小的可用数字
                int p2_move = -1;
                for (int j = 1; j <= n; j++) {
                    if ((currentMask & (1 << (j - 1))) == 0) { // j 可用
                        p2_move = j;
                        break;
                    }
                }
                if (p2_move == -1) {
                    // 理论上不应发生，除非游戏已结束但 total 未达标
                    System.err.println("错误：在游戏结束前找不到 P2 的可用步骤！");
                    return null;
                }
                move = p2_move;
                // 不记录 P2 的步骤到 path
            }

            // 更新游戏状态
            currentTotal += move;
            currentMask |= (1 << (move - 1));

            // 切换玩家
            isPlayer1Turn = !isPlayer1Turn;
        }

        return path; // 返回 P1 的决策路径
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findOptimalPath(20, 62));
    }
}