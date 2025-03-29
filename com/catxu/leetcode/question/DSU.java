package com.catxu.leetcode.question;

/**
 * Disjoint Set Union
 */
public class DSU {
    int[] parent;
    int[] rank;

    public DSU(int n) {
        this.parent = new int[n];
        this.rank = new int[n];
        for (int i = 0; i < n; i++) {
            this.parent[i] = i;
            this.rank[i] = 1;
        }
    }

    public int find(int i) {
        // 无路径压缩
        /*while (parent[i] != i) {
            i = parent[i];
        }
        return parent[i];*/

        // path-compression
        if (parent[i] != i) {
            // 递归查找根节点，并将路径中的节点直接指向根节点
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int i, int j) {
        int rootI = find(i);
        int rootJ = find(j);
        if (rootI == rootJ) {
            return;
        }
        if (rank[rootI] > rank[rootJ]) {
            // 将较小的set加入大的set中
            parent[rootJ] = rootI;
        } else if (rank[rootI] < rank[rootJ]) {
            parent[rootI] = rootJ;
        } else {
            // 选rootI为新root -> parent[rootJ] 指向 rootI
            parent[rootJ] = rootI;
            // rank 相等，merge之后导致新的root的rank增加
            rank[rootI]++;
        }
    }
}
