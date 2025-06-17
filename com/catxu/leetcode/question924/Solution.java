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
        int minInitial = initial[0];
        for (int x : initial) {
            isInitial[x] = true;
            minInitial = Math.min(minInitial, x);
        }
        int max = 0, ans = -1;
        for (int i : initial) {
            if (vis[i]) continue;
            nodeId = -1;
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
