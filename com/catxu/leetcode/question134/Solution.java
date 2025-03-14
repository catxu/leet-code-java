package com.catxu.leetcode.question134;

/**
 * 134. Gas Station
 * <p>
 * There are n gas stations along a circular route, where the amount of gas at the i<sup>th</sup> station is gas[i].
 * <p>
 * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from the i<sup>th</sup> station to its next (i + 1)<sup>th</sup> station. You begin the journey with an empty tank at one of the gas stations.
 * <p>
 * Given two integer arrays gas and cost, return the starting gas station's index if you can travel around the circuit once in the clockwise direction, otherwise return -1. If there exists a solution, it is guaranteed to be unique.
 * <p>
 * Example 1:
 * <pre>
 * Input: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
 * Output: 3
 * Explanation:
 * Start at station 3 (index 3) and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 4. Your tank = 4 - 1 + 5 = 8
 * Travel to station 0. Your tank = 8 - 2 + 1 = 7
 * Travel to station 1. Your tank = 7 - 3 + 2 = 6
 * Travel to station 2. Your tank = 6 - 4 + 3 = 5
 * Travel to station 3. The cost is 5. Your gas is just enough to travel back to station 3.
 * Therefore, return 3 as the starting index.
 * </pre>
 * Example 2:
 * <pre>
 * Input: gas = [2,3,4], cost = [3,4,3]
 * Output: -1
 * Explanation:
 * You can't start at station 0 or 1, as there is not enough gas to travel to the next station.
 * Let's start at station 2 and fill up with 4 unit of gas. Your tank = 0 + 4 = 4
 * Travel to station 0. Your tank = 4 - 3 + 2 = 3
 * Travel to station 1. Your tank = 3 - 3 + 3 = 3
 * You cannot travel back to station 2, as it requires 4 unit of gas but you only have 3.
 * Therefore, you can't travel around the circuit once no matter where you start.
 * </pre>
 * <p>
 * Constraints:
 * <pre>
 * n == gas.length == cost.length
 * 1 <= n <= 10<sup>5</sup>
 * 0 <= gas[i], cost[i] <= 10<sup>4</sup>
 * </pre>
 */
class Solution {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int ans = 0;
        int minS = 0; // 最小油量
        int s = 0; // 油量
        for (int i = 0; i < gas.length; i++) {
            s += gas[i] - cost[i]; // 在 i 处加油，然后从 i 到 i+1
            if (s < minS) {
                minS = s; // 更新最小油量
                ans = i + 1; // 注意 s 减去 cost[i] 之后，汽车在 i+1 而不是 i
            }
        }
        // 循环结束后，s 即为 gas 之和减去 cost 之和
        return s < 0 ? -1 : ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));

        System.out.println(new Solution().canCompleteCircuit(new int[]{1, 3, 3, 4, 5}, new int[]{3, 3, 3, 5, 2}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{4, 3, 3, 4}, new int[]{3, 3, 3, 5}));
        System.out.println(new Solution().canCompleteCircuit(new int[]{2, 3, 4}, new int[]{3, 4, 3}));
    }
}
