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
        int[] bitCnt = new int[32];
        int orSum = 0, ans = Integer.MAX_VALUE, l = 0, r = 0;
        for (; r < nums.length; r++) {
            int val = nums[r];
            if (val >= k) {
                return 1;
            }
            orSum |= val;
            int position = 0;
            while (val > 0) {
                if ((val & 1) == 1) {
                    bitCnt[position]++;
                }
                val >>= 1;
                position++;
            }
            while (orSum >= k && l < r) {
                // shrink window
                ans = Math.min(ans, r - l + 1);
                position = 0;
                val = nums[l];
                while (val > 0) {
                    if ((val & 1) == 1) {
                        if (--bitCnt[position] == 0) {
                            orSum -= (int) Math.pow(2, position);
                        }
                    }
                    val >>= 1;
                    position++;
                }
                l++;
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
