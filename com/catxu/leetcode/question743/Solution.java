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
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] time : times) {
            // 0: node
            // 1: neighbor
            // 2: weight
            graph.merge(time[0],
                    new ArrayList<>(List.of(new int[]{time[1], time[2]})),
                    (oldList, newList) -> {
                        oldList.addAll(newList);
                        return oldList;
                    }
            );
        }
        Set<Integer> visited = new HashSet<>();
        int t = 0;
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        minHeap.offer(new int[]{k, 0});
        while (!minHeap.isEmpty()) {
            int[] node = minHeap.poll();
            int v = node[0], weight = node[1];
            if (visited.contains(v)) {
                continue;
            }
            t = Math.max(t, weight);
            visited.add(v);
            List<int[]> neighbors = graph.get(v);
            if (neighbors == null) {
                continue;
            }
            for (int[] neighbor : neighbors) {
                if (visited.contains(neighbor[0])) {
                    continue;
                }
                minHeap.offer(new int[]{neighbor[0], weight + neighbor[1]});
            }
        }
        return visited.size() == n ? t : -1;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().networkDelayTime(new int[][]{
                {2, 1, 1},
                {2, 3, 1},
                {3, 4, 1}
        }, 4, 2));
    }
}
