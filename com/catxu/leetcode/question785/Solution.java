package com.catxu.leetcode.question785;

/**
 * 785. Is Graph Bipartite?
 */
class Solution {
    private static final int UN_COLORED = 0;
    private static final int RED = 1;
    private static final int GREEN = 2;

    private int[] color;
    private int[][] graph;
    private boolean valid = true;

    /**
     * 染色法判断二分图，相邻节点不同色
     *
     * @param graph
     * @return
     */
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        this.color = new int[n];
        this.graph = graph;
        for (int i = 0; valid && i < n; i++) {
            if (color[i] == UN_COLORED) dfs(i, RED, graph[i]);
        }
        return valid;
    }

    private void dfs(int i, int c, int[] vertices) {
        if (!valid) return;
        color[i] = c;
        int nextColor = c == RED ? GREEN : RED;
        for (int v : vertices) {
            if (color[v] == UN_COLORED) {
                dfs(v, nextColor, graph[v]);
            } else if (color[v] != nextColor) {
                valid = false;
                return;
            }
        }
    }
}
