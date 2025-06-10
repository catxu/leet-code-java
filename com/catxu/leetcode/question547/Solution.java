package com.catxu.leetcode.question547;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 547. Number of Provinces
 */
class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    g.computeIfAbsent(i + 1, k -> new LinkedList<>());
                    continue;
                }
                if (isConnected[i][j] == 1) g.computeIfAbsent(i + 1, k -> new LinkedList<>()).add(j + 1);
            }
        }
        int ans = 0;
        boolean[] visited = new boolean[n + 1];
        for (Map.Entry<Integer, List<Integer>> entry : g.entrySet()) {
            int u = entry.getKey();
            if (!visited[u]) {
                ans++;
                dfs(g, u, visited);
            }
        }
        return ans;
    }

    private void dfs(Map<Integer, List<Integer>> g, int u, boolean[] visited) {
        if (visited[u]) return;
        visited[u] = true;
        for (int v : g.get(u)) {
            dfs(g, v, visited);
        }
    }


    private int[] parent;

    // 并查集
    public int findCircleNumII(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 1; i < n; i++) parent[i] = i;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) union(i, j);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            if (parent[i] == i) ans++;
        return ans;
    }

    private void union(int i, int j) {
        parent[find(i)] = find(j);
    }

    /**
     * 路径压缩
     *
     * @param index 节点下标
     * @return 连通分量的父节点
     */
    private int find(int index) {
        if (parent[index] != index)
            parent[index] = find(parent[index]);
        return parent[index];
    }
}
