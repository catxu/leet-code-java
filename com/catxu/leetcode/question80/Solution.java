package com.catxu.leetcode.question80;

/**
 * 80. Remove Duplicates from Sorted Array II
 * <p>
 * Given an integer array nums sorted in non-decreasing order, remove some duplicates in-place such that each unique element appears at most twice. The relative order of the elements should be kept the same.
 * <p>
 * Since it is impossible to change the length of the array in some languages, you must instead have the result be placed in the first part of the array nums. More formally, if there are k elements after removing the duplicates, then the first k elements of nums should hold the final result. It does not matter what you leave beyond the first k elements.
 * <p>
 * Return k after placing the final result in the first k slots of nums.
 * <p>
 * Do not allocate extra space for another array. You must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * Custom Judge:
 * <p>
 * The judge will test your solution with the following code:
 * <pre>
 *     {@code
 * int[] nums = [...]; // Input array
 * int[] expectedNums = [...]; // The expected answer with correct length
 * int k = removeDuplicates(nums); // Calls your implementation
 * assert k == expectedNums.length;
 * for (int i = 0; i < k; i++) {
 *     assert nums[i] == expectedNums[i];
 * }
 * }
 * </pre>
 * If all assertions pass, then your solution will be accepted.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3]
 * <p>
 * Output: 5, nums = [1,1,2,2,3,_]
 * <p>
 * Explanation: Your function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * <p>
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Example 2:
 * <p>
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * <p>
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * <p>
 * Explanation: Your function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * <p>
 * It does not matter what you leave beyond the returned k (hence they are underscores).
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 3 * 10<sup>4</sup>
 * <p>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * <p>
 * nums is sorted in non-decreasing order.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }

        int slow = 2;

        for (int fast = 2; fast < nums.length; fast++) {
            // 题目说明 non-decreasing order 非递减序列
            // 如果 nums[fast] == nums[slow - 2] 则说明 nums[slow - 2] == nums[slow - 1] == nums[fast]，即超过最多2个重复限制
            // 此时保持 slow 不动，向后移动 fast，直到 nums[fast] 和 nums[slow - 2] 不相等，将 nums[fast] 保留
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
        }
        return slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(s.removeDuplicates(new int[]{1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1}));
    }
}
