package com.catxu.leetcode.question912;

import java.util.Arrays;

/**
 * 912. Sort an Array
 */
class Solution {
    public int[] sortArray(int[] nums) {
        heapSort(nums);
        return nums;
    }

    private void heapSort(int[] nums) {
        buildHeap(nums);
        int n = nums.length;
        for (int i = n - 1; i >= 0; i--) {
            swap(nums, i, 0);
            heapify(nums, i, 0);
        }
    }

    private void buildHeap(int[] nums) {
        int n = nums.length;
        for (int i = (n - 2) / 2; i >= 0; i--) {
            heapify(nums, n, i);
        }
    }

    private void heapify(int[] nums, int n, int i) {
        if (i >= n) {
            return;
        }
        int leftSon = 2 * i + 1;
        int rightSon = 2 * i + 2;
        int max = i;
        if (leftSon < n && nums[leftSon] > nums[max]) {
            max = leftSon;
        }
        if (rightSon < n && nums[rightSon] > nums[max]) {
            max = rightSon;
        }
        if (max != i) {
            swap(nums, max, i);
            heapify(nums, n, max);
        }
    }

//    public void heapSort(int[] nums) {
//        int len = nums.length - 1;
//        buildMaxHeap(nums, len);
//        for (int i = len; i >= 1; --i) {
//            swap(nums, i, 0);
//            len -= 1;
//            maxHeapify(nums, 0, len);
//        }
//    }
//
//    public void buildMaxHeap(int[] nums, int len) {
//        for (int i = len / 2; i >= 0; --i) {
//            maxHeapify(nums, i, len);
//        }
//    }
//
//    public void maxHeapify(int[] nums, int i, int len) {
//        for (; (i << 1) + 1 <= len; ) {
//            int lson = (i << 1) + 1;
//            int rson = (i << 1) + 2;
//            int large;
//            if (lson <= len && nums[lson] > nums[i]) {
//                large = lson;
//            } else {
//                large = i;
//            }
//            if (rson <= len && nums[rson] > nums[large]) {
//                large = rson;
//            }
//            if (large != i) {
//                swap(nums, i, large);
//                i = large;
//            } else {
//                break;
//            }
//        }
//    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] test1 = new int[]{4, 10, 3, 5, 1, 2, 7};
        new Solution().sortArray(test1);
        System.out.println(Arrays.toString(test1));


        int[] nums1 = new int[]{5, 2, 3, 1};
        new Solution().sortArray(nums1);
        System.out.println(Arrays.toString(nums1));
        int[] nums2 = new int[]{5, 1, 1, 2, 0, 0};
        new Solution().sortArray(nums2);
        System.out.println(Arrays.toString(nums2));
    }
}
