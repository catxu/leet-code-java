package com.catxu.leetcode.question149;

import java.util.HashMap;
import java.util.Map;

/**
 * 149. Max Points on a Line
 */
class Solution {
    public int maxPoints(int[][] points) {
        int ans = 1;
        for (int i = 0; i < points.length; i++) {
            Map<Float, Integer> slopes = new HashMap<>();
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < points.length; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                float slope = Float.MAX_VALUE;
                // 非垂直
                if (x1 != x2) {
                    // 计算斜率slope
                    // IEEE 754  允许 float 类型存在 -0.0f
                    // 虽然 -0.0f == 0.0f 结果为 true，但他们的 hashcode 结果不同，故在 slopes map 中 key 不同
                    slope = y1 == y2 ? 0.0f : ((float) (y1 - y2)) / (x1 - x2);
                }
                slopes.merge(slope, 1, Integer::sum);
                ans = Math.max(ans, slopes.get(slope) + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxPoints(new int[][]{{2, 3}, {3, 3}, {-5, 3}}));
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {2, 2}, {3, 3}}));
        System.out.println(new Solution().maxPoints(new int[][]{{1, 1}, {3, 2}, {5, 3}, {4, 1}, {2, 3}, {1, 4}}));
    }
}
