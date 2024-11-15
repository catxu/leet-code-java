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
 * <p>
 * int[] nums = [...]; // Input array
 * <p>
 * int[] expectedNums = [...]; // The expected answer with correct length
 * <p>
 * int k = removeDuplicates(nums); // Calls your implementation
 * <p>
 * assert k == expectedNums.length;
 * <p>
 * for (int i = 0; i < k; i++) {
 * assert nums[i] == expectedNums[i];
 * }
 * <p>
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
 * 1 <= nums.length <= 3 * 10^4
 * <p>
 * -10^4 <= nums[i] <= 10^4
 * <p>
 * nums is sorted in non-decreasing order.
 */
class Solution {
    public int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        int threshold = 1;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
                threshold = 1;
            } else if (nums[slow] == nums[fast] && threshold < 2) {
                // 相同且重复小于2
                slow++;
                if (nums[slow] != nums[fast]) {
                    nums[slow] = nums[fast];
                }
                threshold++;
            } else {
                // 相同且重复大于2 向后匹配，直至数组末尾或下一个不同值
                while (fast < nums.length && nums[fast] == nums[slow]) {
                    fast++;
                }
                // 匹配到数组末尾 全部相同，直接返回 slow+1
                if (fast == nums.length) {
                    return ++slow;
                }
                slow++;
                nums[slow] = nums[fast];
                threshold = 1;
            }
            fast++;
        }
        return ++slow;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
        System.out.println(s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3}));
        System.out.println(s.removeDuplicates(new int[]{1}));
        System.out.println(s.removeDuplicates(new int[]{1, 1}));
    }
}
