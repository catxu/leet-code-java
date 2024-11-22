package com.catxu.leetcode.question43;

/**
 * 43. Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * <p>
 * Output: "6"
 * <p>
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * <p>
 * Output: "56088"
 * <p>
 * Constraints:
 * <p>
 * 1 <= num1.length, num2.length <= 200
 * <p>
 * num1 and num2 consist of digits only.
 * <p>
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 */
class Solution {

    public static void main(String[] args) {
        String num1 = "2";
        String num2 = "3";
        Solution solution = new Solution();
        System.out.println(solution.multiply(num1, num2));
    }

    public String multiply(String num1, String num2) {
        // Reverse the strings for easier processing
        num1 = new StringBuilder(num1).reverse().toString();
        num2 = new StringBuilder(num2).reverse().toString();

        // Initialize an array to store the result
        int[] result = new int[num1.length() + num2.length()];

        // Perform multiplication
        for (int i = 0; i < num1.length(); i++) {
            for (int j = 0; j < num2.length(); j++) {
                result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] += result[i + j] / 10;
                result[i + j] %= 10;
            }
        }

        // Convert the result array to a string
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]);
        }

        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        // Reverse the string to get the final result
        return sb.reverse().toString();
    }

}
