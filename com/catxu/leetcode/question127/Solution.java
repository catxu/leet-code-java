package com.catxu.leetcode.question127;

import java.util.*;

/**
 * 127. Word Ladder
 */
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // wordList = ["hot","dot","dog","lot","log","cog"]
        // shortest path = "hit" -> "hot" -> "dot" -> "dog" -> cog"
        // hit --> hot --> dot --> dog ------
        //          |       |       |       |
        //          |       |       |       |
        //          |       v       v       v
        //          -----> lot --> log --> cog

        // 如何建图？相邻字符间最多差一个字符
        // 图结构：Map<String, List<Cell>> Cell: Vertex, Weight -> 权重后续用于距离计算
        // 如何识别 neighbors？判断a-z每个字符
        // 如何做路径查找：Dijkstra

        int n = wordList.size();
        Map<String, Integer> dict = new HashMap<>();
        for (int i = 0; i < n; i++) {
            dict.put(wordList.get(i), i);
        }
        dict.putIfAbsent(beginWord, -1);

        // 建图
        Map<String, List<Cell>> graph = new HashMap<>();
        for (Map.Entry<String, Integer> entry : dict.entrySet()) {
            String start = entry.getKey();
            char[] chs = start.toCharArray();
            for (int i = 0; i < chs.length; i++) {
                char c = chs[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (c == j) {
                        continue;
                    }
                    chs[i] = j;
                    String neighbor = new String(chs);
                    // 裁剪掉出发点
                    if (beginWord.equals(neighbor)) {
                        continue;
                    }
                    Integer idx = dict.get(neighbor);
                    if (idx != null) {
                        graph.computeIfAbsent(start, key -> new ArrayList<>()).add(new Cell(neighbor, 1));
                    }
                }
                // 字符还原
                chs[i] = c;
            }
        }
        // Dijkstra 优先队列，按权重排序
        PriorityQueue<Cell> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a.weight));
        minHeap.offer(new Cell(beginWord, 0));
        int ans = Integer.MAX_VALUE;
        // source 出发到当前 node 的距离
        int[] distance = new int[n + 1];
        Arrays.fill(distance, n + 2);
        distance[0] = 0;
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            int cellIdx = dict.get(cell.vertex) + 1;
            if (distance[cellIdx] < cell.weight) {
                continue;
            }
            if (cell.vertex.equals(endWord)) {
                ans = Math.min(ans, cell.weight + 1);
                continue;
            }
            List<Cell> neighbors = graph.get(cell.vertex);
            if (neighbors == null) {
                continue;
            }
            for (Cell neighbor : neighbors) {
                int neighborIdx = dict.get(neighbor.vertex) + 1;
                int newWeight = neighbor.weight + cell.weight;
                if (newWeight < distance[neighborIdx]) {
                    distance[neighborIdx] = neighbor.weight = newWeight;
                    minHeap.offer(neighbor);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    static class Cell {
        private final String vertex;
        private int weight;

        public Cell(String vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log", "cog")));
        System.out.println(new Solution().ladderLength("hit", "cog", List.of("hot", "dot", "dog", "lot", "log")));
        System.out.println(new Solution().ladderLength("hot", "dog", List.of("hot", "dog", "dot")));
    }
}
