package com.catxu.leetcode.question743;

import java.util.*;

/**
 * 743. Network Delay Time
 */
class Solution {
    /**
     * 计算网络遍历时长
     *
     * @param times graph
     * @param n     total nodes
     * @param k     start node
     * @return delayTime or -1 which cannot cross all nodes
     */
    public int networkDelayTime(int[][] times, int n, int k) {
        final int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] graph = new List[n];
        Arrays.fill(graph, new ArrayList<>());
        for (int[] route : times) {
            // 0: source / 1: target / 2: weight
            int v = route[0] - 1, neighbor = route[1] - 1;
            graph[v].add(new int[]{neighbor, route[2]});
        }

        int[] distance = new int[n];
        Arrays.fill(distance, INF);
        // 从k出发
        distance[k - 1] = 0;
        // 0: weight / 1: v
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        minHeap.offer(new int[]{0, k - 1});
        while (!minHeap.isEmpty()) {
            int[] p = minHeap.poll();
            int w1 = p[0], v1 = p[1];
            // 贪心策略，如果当前路径比出队路径更小，没有必要去更新周围邻居的最短路的，因为前值在出队之后，就已经把邻居的最短路都更新过了
            if (distance[v1] < w1) {
                continue;
            }
            for (int[] neighbor : graph[v1]) {
                int v2 = neighbor[0], w2 = distance[v1] + neighbor[1];
                if (w2 < distance[v2]) {
                    distance[v2] = w2;
                    minHeap.offer(new int[]{w2, v2});
                }
            }
        }

        int ans = Arrays.stream(distance).max().getAsInt();
        return ans == INF ? -1 : ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        }, 4, 2));
    }
}
