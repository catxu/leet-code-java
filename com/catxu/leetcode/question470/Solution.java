package com.catxu.leetcode.question470;

import java.util.Random;

/**
 * 470. Implementing Rand10() Using Rand7()
 */
class Solution {
    public int rand10() {
        while (true) {
            // 拒绝采样（Rejection Sampling） 是一种通过某种已知的分布生成另一种目标分布的随机样本的通用方法。它的核心思想是：
            // 1. 生成更大的候选空间
            // 这本质上是在生成一个两位数的 "7进制" 数，其中 val1 = (rand7() - 1) * 7 是高位，val2 = (rand7() - 1) 是低位。
            // 一共有 7 * 7 = 49 种可能的 (val1, val2) 组合。例如：(0, 0), (0, 1), ..., (0, 6), (1, 0), ..., (6, 6)
            int ans = (rand7() - 1) * 7 + (rand7() - 1);
            // 2. 拒绝部分样本
            if (ans >= 1 && ans <= 40) {
                // 3. 映射到目标范围
                return ans % 10 + 1;
            }
        }
    }

    public int rand7() {
        return new Random().nextInt(7) + 1;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(new Solution().rand10());
        }
    }
}
