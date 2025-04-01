package com.catxu.leetcode.question207;

import java.util.*;

/**
 * 207. Course Schedule
 */
class Solution {
    // O(V+E)
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // BFS入度表法(Kahn算法)
        // 1. 建图
        Map<Integer, List<Integer>> graph = new HashMap<>();
        // 2. 建入度
        int[] indegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int start = edge[1];
            int end = edge[0];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            indegree[end]++; // start --> end，所以 end 入度增加
        }
        Queue<Integer> queue = new ArrayDeque<>();
        // 3. 找入口
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int count = 0;
        // 4. bfs 拓扑排序
        while (!queue.isEmpty()) {
            int node = queue.poll();
            count++;
            List<Integer> neighbors = graph.get(node);
            if (neighbors == null || neighbors.isEmpty()) {
                continue;
            }
            for (int neighbor : neighbors) {
                if (--indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        return count == numCourses;
    }

    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjacency = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            adjacency.add(new ArrayList<>());
        int[] flags = new int[numCourses];
        for (int[] cp : prerequisites)
            adjacency.get(cp[1]).add(cp[0]);
        for (int i = 0; i < numCourses; i++)
            if (!dfs(adjacency, flags, i)) return false;
        return true;
    }*/

    private boolean dfs(List<List<Integer>> adjacency, int[] flags, int i) {
        if (flags[i] == 1) return false;
        if (flags[i] == -1) return true;
        flags[i] = 1;
        for (Integer j : adjacency.get(i))
            if (!dfs(adjacency, flags, j)) return false;
        flags[i] = -1;
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
