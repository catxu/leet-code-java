package com.catxu.leetcode.question401;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 401. Binary Watch
 */
class Solution {
    // 打表逻辑，也可以放到本地做
    // 注意使用 static 修饰，确保打表数据只会被生成一次
    static Map<Integer, List<String>> map = new HashMap<>();

    static {
        for (int h = 0; h <= 11; h++) {
            for (int m = 0; m <= 59; m++) {
                // 提取所有有效组合时间的二进制表示的“1”的个数
                int popcount = getCnt(h) + getCnt(m);
                List<String> list = map.getOrDefault(popcount, new ArrayList<>());
                list.add(h + ":" + (m <= 9 ? "0" + m : m));
                map.put(popcount, list);
            }
        }
    }

    /**
     * 本方法的作用是计算并返回输入整数 x 的二进制表示中包含的 '1' 的个数。
     * 这个数量也被称为汉明权重 (Hamming Weight) 或 位计数 (Population Count / popcount)。
     *
     * @param x
     * @return
     */
    static int getCnt(int x) {
        int ans = 0;
        // 妙啊 i - lowbit 用于移除最低位的 1
        for (int i = x; i > 0; i -= lowbit(i)) ans++;
        return ans;
    }

    /**
     * 提取最低位1
     * 6 ->     0000 0110
     * -6 ->    1111 1001 + 1 (所有位取反再 + 1）
     * = 1111 1010
     * 6 & -6 = 0000 0010 = 2
     *
     * @param x
     * @return
     */
    static int lowbit(int x) {
        return x & -x;
    }

    public List<String> readBinaryWatch(int t) {
        return map.getOrDefault(t, new ArrayList<>());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().readBinaryWatch(9));
    }
}