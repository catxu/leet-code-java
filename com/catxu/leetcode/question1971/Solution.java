package com.catxu.leetcode.question1971;

import java.util.*;

/**
 * 1971. Find if Path Exists in Graph
 */
class Solution {
    // bfs
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        Map<Integer, List<Integer>> g = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            g.computeIfAbsent(u, k -> new LinkedList<>()).add(v);
            g.computeIfAbsent(v, k -> new LinkedList<>()).add(u);
        }
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        q.offer(source);
        while (!q.isEmpty()) {
            Integer v = q.poll();
            if (!visited[v]) {
                visited[v] = true;
                List<Integer> neighbors = g.get(v);
                if (neighbors != null) {
                    for (int nei : neighbors) {
                        if (nei == destination) return true;
                        q.offer(nei);
                    }
                }
            }
        }
        return false;
    }

    public boolean validPathII(int n, int[][] edges, int source, int destination) {
        UnionFind ds = new UnionFind(n);
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            ds.union(u, v);
        }
        return ds.isConnected(source, destination);
    }

    static class UnionFind {
        private final int[] parent;

        public UnionFind(int n) {
            this.parent = new int[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
            }
        }

        /**
         * 将高度最大为2的两个结点合并
         *
         * @param x 结点索引
         * @param y 结点索引
         */
        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
        }

        /**
         * 路径压缩
         *
         * @param nodeIndex 结点索引
         * @return 根结点的 id
         */
        public int find(int nodeIndex) {
            if (nodeIndex != parent[nodeIndex]) {
                parent[nodeIndex] = find(parent[nodeIndex]);
            }
            return parent[nodeIndex];
        }

        public boolean isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            return rootX == rootY;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.validPath(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
        System.out.println(s.validPathII(3, new int[][]{{0, 1}, {1, 2}, {2, 0}}, 0, 2));
    }
}