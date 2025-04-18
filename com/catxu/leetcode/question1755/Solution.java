package com.catxu.leetcode.question1755;

import java.util.*;

/**
 * 1755. Closest Subsequence Sum
 * <p>
 * You are given an integer array nums and an integer goal.
 * <p>
 * You want to choose a subsequence of nums such that the sum of its elements is the closest possible to goal. That is, if the sum of the subsequence's elements is sum, then you want to minimize the absolute difference abs(sum - goal).
 * <p>
 * Return the minimum possible value of abs(sum - goal).
 * <p>
 * Note that a subsequence of an array is an array formed by removing some elements (possibly all or none) of the original array.
 * <p>
 * Example 1:
 * <pre>
 * Input: nums = [5,-7,3,5], goal = 6
 * Output: 0
 * Explanation: Choose the whole array as a subsequence, with a sum of 6.
 * This is equal to the goal, so the absolute difference is 0.
 * </pre>
 * Example 2:
 * <pre>
 * Input: nums = [7,-9,15,-2], goal = -5
 * Output: 1
 * Explanation: Choose the subsequence [7,-9,-2], with a sum of -4.
 * The absolute difference is abs(-4 - (-5)) = abs(1) = 1, which is the minimum.
 * </pre>
 * Example 3:
 * <pre>
 * Input: nums = [1,2,3], goal = -7
 * Output: 7
 * </pre>
 * Constraints:
 * <p>
 * 1 <= nums.length <= 40
 * <p>
 * -10<sup>7</sup> <= nums[i] <= 10<sup>7</sup>
 * <p>
 * -10<sup>9</sup> <= goal <= 10<sup>9</sup>
 */
class Solution {

    // 如果数组长度特别大，但是值小，我们可以使用背包问题的方式来解决，
    // 但是如果数组长度不大，但是数值特别大的话，使用DFS。
    // 而在这道题目当中，我们为什么需要拆分数组，2次dfs呢？
    // 涉及到暴力搜索(dfs)的时候需要遍历每个值（取或者不取），所以时间复杂度是：2 ^ (数组大小40)
    // 可能会超时，所以限制每次dfs的时候数组大小。
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        if (n == 0) {
            // 空数组，唯一子序列是空集，和为0
            return Math.abs(goal);
        }

        // 1. 分割数组
        int mid = n / 2;
        // 注意：copyOfRange 第二个参数是 exclusive
        int[] leftArr = Arrays.copyOfRange(nums, 0, mid);
        int[] rightArr = Arrays.copyOfRange(nums, mid, n);

        // 2. 生成两半的和列表
        List<Long> leftSumList = new ArrayList<>();
        generateSums(leftArr, 0, 0L, leftSumList); // 使用 long 避免溢出
        // 去重（可选，但推荐），HashSet构造器可接收List
        Set<Long> leftSumsSet = new HashSet<>(leftSumList);
        // 如果需要保持顺序或后续需要list操作，可以转回List
        // List<Long> uniqueLeftSums = new ArrayList<>(leftSumsSet);


        List<Long> rightSumsList = new ArrayList<>();
        generateSums(rightArr, 0, 0L, rightSumsList);
        Set<Long> rightSumsSet = new HashSet<>(rightSumsList);
        // 将右半部分的和放入一个可排序的列表中
        List<Long> uniqueRightSums = new ArrayList<>(rightSumsSet);

        // 3. 排序右半部分的和列表，为二分查找做准备
        Collections.sort(uniqueRightSums);

        long minDiff = Long.MAX_VALUE;

        // 4. 遍历左半部分的和 s1
        for (long s1 : leftSumsSet) { // 遍历Set即可，避免重复计算
            // 计算需要在右半部分查找的目标值
            long requiredS2 = goal - s1;

            // 5. 在 uniqueRightSums 中二分查找最接近 requiredS2 的值
            int idx = Collections.binarySearch(uniqueRightSums, requiredS2);

            if (idx >= 0) {
                // 精确找到了 requiredS2，意味着 s1 + s2 == target
                // 差值为 0，是最小可能值，直接返回
                return 0;
            } else {
                // 没有找到 requiredS2，idx = -(insertionPoint + 1)
                int insertionPoint = -(idx + 1);

                // 检查插入点右侧的元素（ceiling）
                if (insertionPoint < uniqueRightSums.size()) {
                    long s2Ceiling = uniqueRightSums.get(insertionPoint);
                    minDiff = Math.min(minDiff, Math.abs(s1 + s2Ceiling - goal));
                }

                // 检查插入点左侧的元素（floor）
                if (insertionPoint > 0) {
                    // insertionPoint 是索引，所以前一个元素是 insertionPoint - 1
                    long s2Floor = uniqueRightSums.get(insertionPoint - 1);
                    minDiff = Math.min(minDiff, Math.abs(s1 + s2Floor - goal));
                }
                // 如果minDiff已经是0，可以提前中断循环，但上面 idx>=0 的情况已处理
            }
        }

        // 初始的 minDiff 可能是 Long.MAX_VALUE，如果 nums 为空会是 Math.abs(target)
        // 如果 nums 非空，循环至少会执行一次（因为 leftSumsSet 至少包含 0）
        // 最终结果需要是 int 类型
        return (int) minDiff;
    }

    /**
     * 使用递归生成给定数组的所有子序列和。
     *
     * @param arr        输入数组（或数组的一半）
     * @param index      当前处理到的元素索引
     * @param currentSum 当前子序列的和
     * @param sums       存储所有子序列和的列表
     */
    private void generateSums(int[] arr, int index, long currentSum, List<Long> sums) {
        // Base case: 如果处理完所有元素，将当前和加入列表
        if (index == arr.length) {
            sums.add(currentSum);
            return;
        }

        // 递归分支 1: 不包含 arr[index]
        generateSums(arr, index + 1, currentSum, sums);

        // 递归分支 2: 包含 arr[index]
        generateSums(arr, index + 1, currentSum + arr[index], sums);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minAbsDifference(new int[]{5, -7, 3, 5}, 6));
        System.out.println(new Solution().minAbsDifference(new int[]{1, 2, 3}, -7));
    }
}
