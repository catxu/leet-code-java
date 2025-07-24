package com.catxu.leetcode.question3304;

/**
 * 3304. Find the K-th Character in String Game I
 */
class Solution {
    public char kthCharacter(int k) {
        int length = 1;
        int step = 0;

        // 找出最小step使长度 >= k
        while (length < k) {
            step++;
            length *= 2;
        }

        // 逆向回溯定位字符
        int pos = k;
        while (step > 0) {
            int half = length / 2;

            if (pos > half) {
                // 来自新追加部分，反推来源：pos - half，并转回上一步字符
                pos = pos - half;
                // next(char) = (char + 1) % 26 -> backtracking means -1
                // 所以我们不改变 pos 值，只是记得最终要往回推 step 次
            }

            length /= 2;
            step--;
        }

        // 初始字符为 'a'，再往前推 step 次，每次加一（mod 26）
        return (char) ('a' + (pos - 1) % 26);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().kthCharacter(5));
        System.out.println(new Solution().kthCharacter(2));
        System.out.println(new Solution().kthCharacter(3));
    }
}