package com.catxu.leetcode.question841;

import java.util.LinkedList;
import java.util.List;

/**
 * 841. Keys and Rooms
 */
class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms, 0, visited);
        for (boolean vis : visited)
            if (!vis) return false;
        return true;
    }

    private void dfs(List<List<Integer>> rooms, int start, boolean[] visited) {
        if (visited[start]) return;
        visited[start] = true;
        for (Integer key : rooms.get(start)) dfs(rooms, key, visited);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> rooms = new LinkedList<>();
        rooms.add(List.of(1, 3));
        rooms.add(List.of(1, 3, 0));
        rooms.add(List.of(2));
        rooms.add(List.of(0));
        System.out.println(s.canVisitAllRooms(rooms));
    }
}
