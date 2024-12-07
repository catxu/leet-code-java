package com.catxu.leetcode.question108;

import com.catxu.leetcode.question.TreeNode;

/**
 * 108. Convert Sorted Array to Binary Search Tree
 * <p>
 * Given an integer array nums where the elements are sorted in ascending order, convert it to a height-balanced binary search tree.
 * <p>
 * Example 1:
 * <p>
 * <img src="./btree1.png" />
 * <p>
 * Input: nums = [-10,-3,0,5,9]
 * <p>
 * Output: [0,-3,9,-10,null,5]
 * <p>
 * Explanation: [0,-10,5,null,-3,null,9] is also accepted:
 * <p>
 * <img src="./btree2.png" />
 * <p>
 * Example 2:
 * <p>
 * <img src="./btree3.png" />
 * <p>
 * Input: nums = [1,3]
 * <p>
 * Output: [3,1]
 * <p>
 * Explanation: [1,null,3] and [3,1] are both height-balanced BSTs.
 * <p>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 10<sup>4</sup>
 * <p>
 * -10<sup>4</sup> <= nums[i] <= 10<sup>4</sup>
 * <p>
 * nums is sorted in a strictly increasing order.
 */
class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    private TreeNode buildTree(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = buildTree(nums, left, mid - 1);
        root.right = buildTree(nums, mid + 1, right);
        return root;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode.printTree(s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9}));
        TreeNode.printTree(s.sortedArrayToBST(new int[]{1,3}));
    }
}
