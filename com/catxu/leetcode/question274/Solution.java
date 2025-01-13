package com.catxu.leetcode.question274;

/**
 * 274. H-Index
 * <p>
 * Given an array of integers citations where citations[i] is the number of citations a researcher received for their ith paper, return the researcher's h-index.
 * <p>
 * According to the definition of h-index on Wikipedia: The h-index is defined as the maximum value of h such that the given researcher has published at least h papers that have each been cited at least h times.
 * <p>
 * Example 1:
 * <pre>
 * Input: citations = [3,0,6,1,5]
 * Output: 3
 * Explanation: [3,0,6,1,5] means the researcher has 5 papers in total and each of them had received 3, 0, 6, 1, 5 citations respectively.
 * Since the researcher has 3 papers with at least 3 citations each and the remaining two with no more than 3 citations each, their h-index is 3.
 * </pre>
 * Example 2:
 * <pre>
 * Input: citations = [1,3,1]
 * Output: 1
 * </pre>
 * Constraints:
 * <p>
 * n == citations.length
 * <p>
 * 1 <= n <= 5000
 * <p>
 * 0 <= citations[i] <= 1000
 */
class Solution {
    public int hIndex(int[] citations) {
        quickSort(citations, 0, citations.length - 1);
        int count = 0;
        int ans = 0;
        for (int i = citations.length - 1; i >= 0 && citations[i] > 0; i--) {
            count++;
            ans = Math.max(ans, Math.min(count, citations[i]));
        }
        return ans;
    }

    private void quickSort(int[] nums, int start, int end) {
        if (end <= start) {
            return;
        }
        int pivot = partition(nums, start, end);
        quickSort(nums, start, pivot - 1);
        quickSort(nums, pivot + 1, end);
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (nums[j] < pivot) {
                i++;
                swap(nums, i, j);
            }
        }
        i++;
        swap(nums, i, end);
        return i;
    }

    private void swap(int[] nums, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hIndex(new int[]{3, 0, 6, 1, 5}));
        System.out.println(new Solution().hIndex(new int[]{1, 3, 3}));
        System.out.println(new Solution().hIndex(new int[]{0}));
    }
}
