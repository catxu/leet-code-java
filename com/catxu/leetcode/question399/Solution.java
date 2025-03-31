package com.catxu.leetcode.question399;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 399. Evaluate Division
 */
class Solution {
    // 时间复杂度：O((N+Q)logA)
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = equations.size();
        UnionFind ds = new UnionFind(n * 2);
        Map<String, Integer> map = new HashMap<>();
        int id = 0;
        // 预处理，将变量的值与 id 进行映射，使得并查集的底层使用数组实现，方便编码
        for (int i = 0; i < n; i++) {
            String divisor = equations.get(i).get(0);
            String dividend = equations.get(i).get(1);
            if (!map.containsKey(divisor)) {
                map.put(divisor, id++);
            }
            if (!map.containsKey(dividend)) {
                map.put(dividend, id++);
            }
            ds.union(map.get(divisor), map.get(dividend), values[i]);
        }
        // 做查询
        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String divisor = queries.get(i).get(0);
            String dividend = queries.get(i).get(1);
            Integer divisorIdx = map.get(divisor);
            Integer dividendIdx = map.get(dividend);
            if (divisorIdx == null || dividendIdx == null) {
                ans[i] = -1.0d;
                continue;
            }
            ans[i] = ds.isConnected(divisorIdx, dividendIdx);
        }
        return ans;
    }

    static class UnionFind {
        private final int[] parent;
        /**
         * 指向的父结点的权值
         */
        private final double[] weight;

        public UnionFind(int n) {
            this.parent = new int[n];
            this.weight = new double[n];
            for (int i = 0; i < n; i++) {
                this.parent[i] = i;
                this.weight[i] = 1.0d;
            }
        }

        /**
         * 将高度最大为2的两个结点合并
         * <p>
         * <img src="./weight-union.png" />
         *
         * @param x   结点索引
         * @param y   结点索引
         * @param val 权重
         */
        public void union(int x, int y, double val) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX == rootY) {
                return;
            }
            parent[rootX] = rootY;
            weight[rootX] = val * weight[y] / weight[x];
        }

        /**
         * 路径压缩
         *
         * @param nodeIndex 结点索引
         * @return 根结点的 id
         */
        public int find(int nodeIndex) {
            if (nodeIndex != parent[nodeIndex]) {
                int originParent = parent[nodeIndex];
                parent[nodeIndex] = find(parent[nodeIndex]);
                weight[nodeIndex] *= weight[originParent];
            }
            return parent[nodeIndex];
        }

        public double isConnected(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                return -1.0d;
            }
            return weight[x] / weight[y];
        }
    }

    public static void main(String[] args) {
        Solution s1 = new Solution();
        double[] ans1 = s1.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("b", "c")
                ),
                new double[]{2.0, 3.0},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x")
                ));
        System.out.println(Arrays.toString(ans1));

        Solution s2 = new Solution();
        double[] ans2 = s2.calcEquation(List.of(
                        List.of("a", "b"),
                        List.of("d", "c"),
                        List.of("a", "d")),
                new double[]{3.0, 4.0, 6.0},
                List.of(
                        List.of("a", "c"),
                        List.of("b", "a"),
                        List.of("a", "e"),
                        List.of("a", "a"),
                        List.of("x", "x"))
        );
        System.out.println(Arrays.toString(ans2));
    }
}
