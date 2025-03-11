package com.catxu.leetcode.question373;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * 373. Find K Pairs with Smallest Sums
 */
class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        List<List<Integer>> ans = new ArrayList<>();
        // (i, j) -> (i + 1, j) / (i, j + 1)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        for (int i = 0; i < Math.min(m, k); i++) {
            // i, 0
            minHeap.offer(new int[]{nums1[i] + nums2[0], i, 0});
        }

        while (k-- > 0 && !minHeap.isEmpty()) {
            int[] pair = minHeap.poll();
            int i = pair[1];
            int j = pair[2];
            ans.add(List.of(nums1[i], nums2[j]));
            if (j + 1 < n) {
                // i, j + 1
                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
            }
        }

        return ans;


//        Set<Pair> pairs = new HashSet<>();
//        minHeap.offer(new int[]{nums1[0] + nums2[0], 0, 0});
//        while (ans.size() < k) {
//            int[] pair = minHeap.poll();
//            int i = pair[1];
//            int j = pair[2];
//            ans.add(List.of(nums1[i], nums2[j]));
//            Pair p1 = new Pair(i, j + 1);
//            if (!pairs.contains(p1) && j + 1 < n) {
//                pairs.add(p1);
//                minHeap.offer(new int[]{nums1[i] + nums2[j + 1], i, j + 1});
//            }
//            Pair p2 = new Pair(i + 1, j);
//            if (!pairs.contains(p2) && i + 1 < m) {
//                pairs.add(p2);
//                minHeap.offer(new int[]{nums1[i + 1] + nums2[j], i + 1, j});
//            }
//        }
//        return ans;
    }

    static class Pair {
        private int i;
        private int j;

        public Pair(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }

        @Override
        public int hashCode() {
            return Integer.hashCode(i) & Integer.hashCode(j);
        }

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Pair) {
                return ((Pair) obj).getI() == this.i && ((Pair) obj).getJ() == this.j;
            }
            return false;
        }
    }


    public static void main(String[] args) {
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(new Solution().kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 5));
    }
}
