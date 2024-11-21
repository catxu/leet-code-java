package com.catxu.leetcode.question9;

/**
 * 9. Palindrome Number
 * <p>
 * Given an integer x, return true if x is a palindrome, and false otherwise.
 * <p>
 * Example 1:
 * <p>
 * Input: x = 121
 * <p>
 * Output: true
 * <p>
 * Explanation: 121 reads as 121 from left to right and from right to left.
 * <p>
 * Example 2:
 * <p>
 * Input: x = -121
 * <p>
 * Output: false
 * <p>
 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * <p>
 * Input: x = 10
 * <p>
 * Output: false
 * <p>
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Constraints:
 * <p>
 * -2<sup>31</sup> <= x <= 2<sup>31</sup> - 1
 * <p>
 * Follow up: Could you solve it without converting the integer to a string?
 */
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverseNum = 0;
        while (reverseNum < x) {
            reverseNum = reverseNum * 10 + x % 10;
            x /= 10;
        }
        return x == reverseNum || x == reverseNum / 10;
    }
}
