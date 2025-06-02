package com.catxu.leetcode.question909;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 909. Snakes and Ladders
 */
class Solution {
    // 本质是 BFS 找环
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] visited = new boolean[n * n + 1];
        Queue<int[]> queue = new LinkedList<>();
        // 节点下标和step（到该节点的步数）
        queue.offer(new int[]{1, 0});
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int i = 1; i <= 6; ++i) {
                int next = cur[0] + i;
                if (next > n * n) { // 超出边界
                    break;
                }
                int[] rc = id2rc(next, n); // 得到下一步的行列
                if (board[rc[0]][rc[1]] > 0) { // 存在蛇或梯子
                    next = board[rc[0]][rc[1]];
                }
                if (next == n * n) { // 到达终点
                    return cur[1] + 1;
                }
                if (!visited[next]) {
                    visited[next] = true;
                    queue.offer(new int[]{next, cur[1] + 1}); // 扩展新状态
                }
            }
        }
        return -1;
    }

    /*
     * 7 8 9
     * 6 5 4
     * 1 2 3
     */
    public int[] id2rc(int index, int n) {
        // index = 4, n = 3
        // r = 1, c = 0
        // r = 1, c = 3 - 1 - 0 = 2
        int r = (index - 1) / n, c = (index - 1) % n;
        if (r % 2 == 1) {
            c = n - 1 - c;
        }
        return new int[]{n - 1 - r, c};
    }

    private int[] id2rcII(int id, int n) {
        int row = n - 1 - (id - 1) / n; // 从下往上填
        int offset = (id - 1) % n;
        int col;

        if ((n - 1 - row) % 2 == 0) {
            col = offset; // （0-based 从下往上数）偶数层：从左到右
        } else {
            col = n - 1 - offset; // 奇数层：从右到左
        }
        return new int[]{row, col};
    }
}
