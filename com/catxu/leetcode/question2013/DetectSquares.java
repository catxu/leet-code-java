package com.catxu.leetcode.question2013;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 2013. Detect Squares
 */
class DetectSquares {
    private Map<Integer, Map<Integer, Integer>> cnt;

    public DetectSquares() {
        cnt = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0], y = point[1];
        cnt.putIfAbsent(y, new HashMap<>());
        Map<Integer, Integer> yCnt = cnt.get(y);
        yCnt.merge(x, 1, Integer::sum);
    }

    public int count(int[] point) {
        int x = point[0], y = point[1];
        if (!cnt.containsKey(y)) {
            return 0;
        }
        int res = 0;
        Map<Integer, Integer> yCnt = cnt.get(y); // 跟当前point在同一行的所有的点（可能构成正方形的所有点）
        Set<Map.Entry<Integer, Map<Integer, Integer>>> entries = cnt.entrySet();
        for (Map.Entry<Integer, Map<Integer, Integer>> entry : entries) { // entry表示平面中的一行中的所有的点
            Integer col = entry.getKey(); // y 坐标
            Map<Integer, Integer> colCnt = entry.getValue();
            if (col != y) { // 和当前 point 不在同一行
                int d = y - col; // 计算边长
                res += colCnt.getOrDefault(x, 0)/*同一列*/ * yCnt.getOrDefault(x - d, 0)/*同一行*/ * colCnt.getOrDefault(x - d, 0)/*对角点*/;
                res += colCnt.getOrDefault(x, 0)/*同一列*/ * yCnt.getOrDefault(x + d, 0)/*同一行*/ * colCnt.getOrDefault(x + d, 0)/*对角点*/;
            }
        }
        return res;
    }
}

/*
 * Your DetectSquares object will be instantiated and called as such:
 * DetectSquares obj = new DetectSquares();
 * obj.add(point);
 * int param_2 = obj.count(point);
 */
