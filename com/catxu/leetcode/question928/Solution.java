package com.catxu.leetcode.question928;

/**
 * 928. Minimize Malware Spread II
 */
class Solution {

    private int nodeId, size;

    public int minMalwareSpread(int[][] graph, int[] initial) {
        int n = graph.length;
        boolean[] vis = new boolean[n];
        boolean[] isInitial = new boolean[n];
        int minInitial = initial[0];
        for (int i : initial) {
            minInitial = Math.min(minInitial, i);
            isInitial[i] = true;
        }
        int[] cnt = new int[n]; // 数组hash
        for (int i = 0; i < n; i++) {
            if (vis[i] || isInitial[i]) continue;
            nodeId = -1;
            size = 0;
            dfs(i, graph, vis, isInitial);
            if (nodeId >= 0) cnt[nodeId] += size;
        }
        int ans = 0, maxSize = 0;
        for (int i = 0; i < n; i++) {
            if (cnt[i] > maxSize) {
                maxSize = cnt[i];
                ans = i; // 从小到大遍历保证 ans 在相同 size 下为最小 nodeId
            }
        }
        return maxSize > 0 ? ans : minInitial;
    }

    private void dfs(int i, int[][] graph, boolean[] vis, boolean[] isInitial) {
        vis[i] = true;
        size++; // 对角线上全为 1，节点一定存在，但不一定跟其它节点连通
        for (int j = 0; j < graph[i].length; j++) {
            if (graph[i][j] == 0) continue;
            if (isInitial[j]) {
                if (nodeId != -2 && nodeId != j) {
                    nodeId = nodeId == -1 ? j : -2;
                }
            } else if (!vis[j]) {
                dfs(j, graph, vis, isInitial);
            }
        }
    }

    public static void main(String[] args) {
        int[][] graph = new int[][]{
                {1, 0, 0, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 0, 0},
                {0, 0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 1, 1}
        };
        int[] initial = new int[]{1, 2};
        System.out.println(new Solution().minMalwareSpread(graph, initial));
    }
}
