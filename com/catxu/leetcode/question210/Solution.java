package com.catxu.leetcode.question210;

import java.util.*;

/**
 * 210. Course Schedule II
 */
class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] ans = new int[numCourses];
        // 建图建度
        Map<Integer, List<Integer>> graph = new HashMap<>();
        int[] inDegree = new int[numCourses];
        for (int[] edge : prerequisites) {
            int start = edge[1], end = edge[0];
            graph.computeIfAbsent(start, k -> new ArrayList<>()).add(end);
            ++inDegree[end];
        }
        // 找入口
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }
        // 拓扑排序
        int count = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            ans[count++] = course;
            List<Integer> neighbors = graph.get(course);
            if (neighbors == null || neighbors.isEmpty()) {
                continue;
            }
            for (int neighbor : neighbors) {
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }
        return numCourses == count ? ans : new int[0];
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(2, new int[][]{{1, 0}, {0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(4, new int[][]{{3, 0}, {0, 1}})));
        System.out.println(Arrays.toString(new Solution().findOrder(1, new int[][]{})));
    }
}
