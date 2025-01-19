package com.catxu.leetcode.question2266;

/**
 * 2266. Count Number of Texts
 */
class Solution {
    private static final int MOD = 1000000007;
    private static final int[] KEYS = {0, 0, 3, 3, 3, 3, 3, 4, 3, 4}; // Number of letters per key

    public int countTexts(String pressedKeys) {
        long number = 1;
        int num = pressedKeys.charAt(0) - '0';
        int count = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            if (num != 0 && pressedKeys.charAt(i - 1) == pressedKeys.charAt(i)) {
                count++;
            } else {
                number = (number * getNum(num, count)) % MOD;
                num = pressedKeys.charAt(i) - '0';
                count = 1;
            }
        }
        // 更新最后一个按键序列
        number = (number * getNum(num, count)) % MOD;
        return (int) number;
    }

    public static long getNum(int n, int len) {
        if (len == 1) return 1;
        if (len == 2) return 2;
        if (len == 3) return 4;
        long[] arr = new long[len];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 4;
        if (n == 7 || n == 9) {
            arr[3] = 8;
            for (int i = 4; i < len; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3] + arr[i - 4]) % MOD;
            }
        } else {
            for (int i = 3; i < len; i++) {
                arr[i] = (arr[i - 1] + arr[i - 2] + arr[i - 3]) % MOD;
            }
        }
        return arr[len - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countTexts("22233"));
        System.out.println(new Solution().countTexts("222222222222222222222222222222222222"));
    }
}
