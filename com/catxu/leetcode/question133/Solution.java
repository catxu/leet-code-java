package com.catxu.leetcode.question133;

import java.util.*;

/**
 * 133. Clone Graph
 */
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }
        Map<Node, Node> map = new HashMap<>();
        map.put(node, new Node(node.val, new ArrayList<>()));
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(node);
        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            for (Node neighbor : cur.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    queue.offer(neighbor);
                }
                map.get(cur).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    Map<Node, Node> visited = new HashMap<>();

    public Node cloneGraphOptimized(Node node) {
        // DFS time: O(V + E)

        if (node == null) return null;
        // if the node was already visited before
        // return the clone from the visited map
        if (visited.containsKey(node)) {
            return visited.get(node);
        }
        // create a clone for the given node
        // note that we do not have cloned neighbors as of now, hence[]
        Node clone = new Node(node.val, new ArrayList<>());
        // the key is the original node and value is the clone node
        visited.put(node, clone);
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(cloneGraph(neighbor));
        }
        return clone;

        // BFS
        // if (node == null) return node;
        // visited = new HashMap<>();
        // Queue<Node> q = new LinkedList<>();
        // q.add(node);
        // visited.put(node, new Node(node.val, new ArrayList<Node>()));
        // while (!q.isEmpty()) {
        //     int size = q.size();
        //     for (int i = 0; i < size; i++) {
        //         Node curr = q.remove();
        //         for (Node neighbor: curr.neighbors) {
        //             if (!visited.containsKey(neighbor)) {
        //                 visited.put(neighbor, new Node(neighbor.val, new ArrayList<Node>()));
        //                 q.add(neighbor);
        //             }
        //             visited.get(curr).neighbors.add(visited.get(neighbor));
        //         }
        //     }
        // }
        // return visited.get(node);

    }


    static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public static void printGraph(Node node) {
            if (node == null) {
                return;
            }

            Set<Node> visited = new HashSet<>();
            printGraphHelper(node, visited);
        }

        private static void printGraphHelper(Node node, Set<Node> visited) {
            if (node == null || visited.contains(node)) {
                return;
            }

            visited.add(node);
            System.out.print("Node " + node.val + ": ");

            for (Node neighbor : node.neighbors) {
                System.out.print(neighbor.val + " ");
            }
            System.out.println();

            for (Node neighbor : node.neighbors) {
                printGraphHelper(neighbor, visited);
            }
        }

        public static Node[] buildGraph(int[][] adjacencyMatrix) {
            if (adjacencyMatrix == null || adjacencyMatrix.length == 0 || adjacencyMatrix.length != adjacencyMatrix[0].length) {
                return new Node[0]; // 返回空数组表示无效的邻接矩阵
            }

            int n = adjacencyMatrix.length;
            Node[] nodes = new Node[n];

            // 创建节点
            for (int i = 0; i < n; i++) {
                nodes[i] = new Node(i + 1); // 节点的值从1开始，与矩阵索引对应
            }

            // 构建邻接关系
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (adjacencyMatrix[i][j] == 1) {
                        nodes[i].neighbors.add(nodes[j]);
                    }
                }
            }

            return nodes;
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {0, 1, 0, 1},
                {1, 0, 1, 0},
                {0, 1, 0, 1},
                {1, 0, 1, 0}
        };
        Node[] nodes = Node.buildGraph(matrix);
        Solution s = new Solution();
        Node copied = s.cloneGraph(nodes[0]);
        Node.printGraph(copied);
    }
}
