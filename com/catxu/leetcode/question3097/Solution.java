package com.catxu.leetcode.question3097;

/**
 * 3097. Shortest Subarray With OR at Least K II
 * <p>
 * Constraints:
 * <pre>
 * 1 <= nums.length <= 2 * 10<sup>5</sup>
 * 0 <= nums[i] <= 10<sup>9</sup>
 * 0 <= k <= 10<sup>9</sup>
 * </pre>
 *
 * @see com.catxu.leetcode.question3095
 */
class Solution {
    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bitCnt = new int[32]; // 记录每个位上的 1 的计数
        int orSum = 0, ans = Integer.MAX_VALUE, l = 0;

        for (int r = 0; r < nums.length; r++) {
            int val = nums[r];

            // 如果当前元素本身 >= k，直接返回 1
            if (val >= k) {
                return 1;
            }

            // 更新窗口内的 OR 和以及 bitCnt
            orSum |= val;
            int position = 0;
            while (val > 0) {
                if ((val & 1) == 1) {
                    bitCnt[position]++;
                }
                val >>= 1; // 右移一位
                position++;
            }

            // 收缩窗口，直到 orSum < k
            while (orSum >= k) {
                ans = Math.min(ans, r - l + 1);

                // 移除 nums[l] 对窗口的贡献
                int leftVal = nums[l];
                position = 0;
                while (leftVal > 0) {
                    if ((leftVal & 1) == 1) {
                        if (--bitCnt[position] == 0) { // 当某一位 为 0 时，更新 orSum 值
                            orSum &= ~(1 << position); // 将第 position 位从 OR 和中移除
                        }
                    }
                    leftVal >>= 1; // 右移一位
                    position++;
                }
                l++; // 缩小窗口左边界
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }


    public static void main(String[] args) {
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2, 3}, 2));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{2, 1, 8}, 10));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{1, 2}, 0));
        System.out.println(new Solution().minimumSubarrayLength(new int[]{16, 1, 2, 20, 32}, 45));
    }
}
