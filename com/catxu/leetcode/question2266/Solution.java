package com.catxu.leetcode.question2266;

/**
 * 2266. Count Number of Texts
 * <p>
 * Alice is texting Bob using her phone. The mapping of digits to letters is shown in the figure below.
 * <p>
 * <img src="./telephone-keypad.png"/>
 * <p>
 * In order to add a letter, Alice has to press the key of the corresponding digit i times, where i is the position of the letter in the key.
 * <p>
 * For example, to add the letter 's', Alice has to press '7' four times. Similarly, to add the letter 'k', Alice has to press '5' twice.
 * <p>
 * Note that the digits '0' and '1' do not map to any letters, so Alice does not use them.
 * <p>
 * However, due to an error in transmission, Bob did not receive Alice's text message but received a string of pressed keys instead.
 * <p>
 * For example, when Alice sent the message "bob", Bob received the string "2266622".
 * <p>
 * Given a string pressedKeys representing the string received by Bob, return the total number of possible text messages Alice could have sent.
 * <p>
 * Since the answer may be very large, return it modulo 10<sup>9</sup> + 7.
 * <p>
 * Example 1:
 * <pre>
 * Input: pressedKeys = "22233"
 * Output: 8
 * Explanation:
 * The possible text messages Alice could have sent are:
 * "aaadd", "abdd", "badd", "cdd", "aaae", "abe", "bae", and "ce".
 * Since there are 8 possible messages, we return 8.
 * </pre>
 * Example 2:
 * <pre>
 * Input: pressedKeys = "222222222222222222222222222222222222"
 * Output: 82876089
 * Explanation:
 * There are 2082876103 possible text messages Alice could have sent.
 * Since we need to return the answer modulo 10<sup>9</sup> + 7, we return 2082876103 % (10<sup>9</sup> + 7) = 82876089.
 * </pre>
 * Constraints:
 * <pre>
 * 1 <= pressedKeys.length <= 10<sup>5</sup>
 * pressedKeys only consists of digits from '2' - '9'.
 * </pre>
 */
class Solution {
    private static final int MOD = 1_000000007;

    public int countTexts(String pressedKeys) {
        long ans = 1;
        int prev = pressedKeys.charAt(0) - '0', cur = prev;
        int count = 1;
        for (int i = 1; i < pressedKeys.length(); i++) {
            cur = pressedKeys.charAt(i) - '0';
            if (prev == cur) {
                count++;
            } else {
                ans = (ans * getNum(prev, count)) % MOD;
                prev = cur;
                count = 1;
            }
        }
        // 更新最后一个按键序列
        ans = count == 1 ? ans : (ans * getNum(cur, count)) % MOD;
        return (int) ans;
    }

    public static long getNum(int n, int len) {
        if (len == 1) return 1;
        if (len == 2) return 2;
        if (len == 3) return 4;
        long[] dp = new long[len];
        dp[0] = 1;
        dp[1] = 2;
        dp[2] = 4;
        if (n == 7 || n == 9) {
            dp[3] = 8;
            for (int i = 4; i < len; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3] + dp[i - 4]) % MOD;
            }
        } else {
            for (int i = 3; i < len; i++) {
                dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 3]) % MOD;
            }
        }
        return dp[len - 1];
    }


    public static void main(String[] args) {
        System.out.println(new Solution().countTexts("22233"));
        System.out.println(new Solution().countTexts("222222222222222222222222222222222222"));
    }
}
