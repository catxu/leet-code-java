package com.catxu.leetcode.question1135;

import java.util.*;

/**
 * 1135. Connecting Cities With Minimum Cost
 */
class Solution {
    // MST minimum spanning tree 最小生成树 Prim 算法
    public int minimumCost(int N, int[][] connections) {
        Map<Integer, List<int[]>> graph = new HashMap<>(N);
        for (int[] edge : connections) {
            int u = edge[0], v = edge[1], w = edge[2];
            graph.computeIfAbsent(u, (k) -> new ArrayList<>()).add(new int[]{v, w});
            graph.computeIfAbsent(v, (k) -> new ArrayList<>()).add(new int[]{u, w});
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[2]));
        pq.add(new int[]{1, 1, 0}); // 入队起点
        int cost = 0;
        Set<Integer> vis = new HashSet<>();
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int u = cur[0], v = cur[1], w = cur[2]; // u: source, v: target, w: wight
            if (vis.add(v)) {
                cost += w;
                for (int[] nei : graph.get(v)) {
                    pq.add(new int[]{v, nei[0], nei[1]});
                }
            }
        }
        return vis.size() == N ? cost : -1;
    }
}
