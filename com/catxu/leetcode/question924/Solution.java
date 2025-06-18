package com.catxu.leetcode.question924;

/**
 * 924. Minimize Malware Spread
 */
class Solution {

    private int size, nodeId;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int minInitial = initial[0]; // 可能答案之一 最小initial 节点 id
        for (int i : initial) {
            isInitial[i] = true;
            minInitial = Math.min(minInitial, i);
        }
        int max = 0, ans = -1;
        for (int i : initial) {
            if (vis[i]) continue;
            nodeId = -1; // nodeId 状态机：初始值：-1 -> 一个initial节点：initial节点id -> 多个initial节点：-2
            size = 0;
            dfs(i, graph, vis, isInitial);
            if (nodeId >= 0 && (size > max || size == max && nodeId < ans)) {
                ans = nodeId;
                max = size;
            }
        }
        return max > 0 ? ans : minInitial;
    }

    private void dfs(int i, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[i] = true;
        size++;
        // 按照状态机更新 nodeId
        if (nodeId != -2 && isInitial[i]) {
            nodeId = nodeId == -1 ? i : -2;
        }
        for (int j = 0; j < graph[i].length; j++) {
            if (graph[i][j] == 1 && !vis[j]) {
                dfs(j, graph, vis, isInitial);
            }
        }
    }
}
