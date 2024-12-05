package com.catxu.leetcode.question58;

/**
 * 58. Length of Last Word
 * <p>
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * Given a string s consisting of words and spaces, return the length of the last word in the string.
 * <p>
 * A word is a maximal substring  consisting of non-space characters only.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "Hello World"
 * <p>
 * Output: 5
 * <p>
 * Explanation: The last word is "World" with length 5.
 * <p>
 * Example 2:
 * <p>
 * Input: s = "   fly me   to   the moon  "
 * <p>
 * Output: 4
 * <p>
 * Explanation: The last word is "moon" with length 4.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "luffy is still joyboy"
 * <p>
 * Output: 6
 * <p>
 * Explanation: The last word is "joyboy" with length 6.
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 10<sup>4</sup>
 * <p>
 * s consists of only English letters and spaces ' '.
 * <p>
 * There will be at least one word in s.
 */
class Solution {
    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        int end = s.length();
        while (chars[--end] == ' ') {
        }
        int start = end;
        while (start > 0 && chars[--start] != ' ') {
        }
        // end 之后没有 space
        return end - start + (chars[start] == ' ' ? 0 : 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(s.lengthOfLastWord("e"));
        System.out.println(s.lengthOfLastWord("e "));
        System.out.println(s.lengthOfLastWord(" e"));
    }
}

