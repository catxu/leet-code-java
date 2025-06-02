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


    List<List<Integer>> adjacency;
    boolean valid = true;
    int[] visited;

    public boolean canFinishII(int N, int[][] prerequisites) {
        adjacency = new ArrayList<>();
        for (int i = 0; i < N; i++)
            adjacency.add(new ArrayList<>());
        for (int[] edge : prerequisites)
            adjacency.get(edge[1]).add(edge[0]);
        visited = new int[N]; // 0: unvisited, 1: inProgress, 2: visited 三色法 白色、灰色、黑色
        for (int i = 0; i < N; i++)
            if (valid && visited[i] == 0) dfs(i); // 如果当前点为unvisited白色，则对其进行dfs
        return valid;
    }

    private void dfs(int u) {
        visited[u] = 1; // 当前点标记为灰色
        for (int v : adjacency.get(u)) { // 遍历 neighbor:
            if (visited[v] == 0) dfs(v); // 遇到 0 继续dfs
            else if (visited[v] == 1) valid = false; // 灰色表示有环
        }
        visited[u] = 2; // 当前点标记为黑色
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}}));
        System.out.println(new Solution().canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(new Solution().canFinishII(2, new int[][]{{1, 0}, {0, 1}}));
    }
}
