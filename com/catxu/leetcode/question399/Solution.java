package com.catxu.leetcode.question399;

import java.util.*;

/**
 * 399. Evaluate Division
 */
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Cell>> graph = new HashMap<>();
        int n = values.length;
        for (int i = 0; i < n; i++) {
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            graph.computeIfAbsent(s1, k -> new ArrayList<>()).add(new Cell(s2, values[i]));
            graph.computeIfAbsent(s2, k -> new ArrayList<>()).add(new Cell(s1, 1.0 / values[i]));
        }

        int len = queries.size();
        double[] ans = new double[len];
        Arrays.fill(ans, -1.0);

        for (int i = 0; i < len; i++) {
            Set<String> visited = new HashSet<>();
            dfs(queries.get(i).get(0), queries.get(i).get(1), 1.0, graph, ans, i, visited);
        }

        return ans;
    }

    private void dfs(String src, String dst, double res, Map<String, List<Cell>> graph, double[] ans, int i, Set<String> visited) {
        if (!visited.add(src)) {
            return;
        }
        if (src.equals(dst) && graph.containsKey(src)) {
            ans[i] = res;
            return;
        }
        for (Cell neighbor : graph.getOrDefault(src, new ArrayList<>())) {
            dfs(neighbor.node, dst, res * neighbor.weight, graph, ans, i, visited);
        }
    }

    static class Cell {
        String node;
        double weight;

        public Cell(String node, double weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        double[] ans = s.calcEquation(List.of(List.of("a", "b"), List.of("b", "c")), new double[]{2.0, 3.0}, List.of(List.of("a", "c"), List.of("b", "a"), List.of("a", "e"), List.of("a", "a"), List.of("x", "x")));
        System.out.println(Arrays.toString(ans));
    }
}
