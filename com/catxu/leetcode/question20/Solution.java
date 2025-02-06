package com.catxu.leetcode.question20;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * <p>
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 * <p>
 * An input string is valid if:
 * <pre>
 * 1. Open brackets must be closed by the same type of brackets.
 * 2. Open brackets must be closed in the correct order.
 * 3. Every close bracket has a corresponding open bracket of the same type.
 * </pre>
 * <pre>
 * Example 1:
 * Input: s = "()"
 * Output: true
 * </pre>
 * <pre>
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 * </pre>
 * <pre>
 * Example 3:
 * Input: s = "(]"
 * Output: false
 * </pre>
 * <pre>
 * Example 4:
 * Input: s = "([])"
 * Output: true
 * </pre>
 * Constraints:
 * <pre>
 * · 1 <= s.length <= 10<sup>4</sup>
 * · s consists of parentheses only '()[]{}'.
 * </pre>
 */
class Solution {
    public boolean isValid(String s) {
        Set<Character> openBrackets = new HashSet<>();
        openBrackets.add('{');
        openBrackets.add('(');
        openBrackets.add('[');
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            if (openBrackets.contains(ch)) {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                Character prevOpenBracket = stack.pop();
                switch (ch) {
                    case ']':
                        if (prevOpenBracket != '[') {
                            return false;
                        }
                        break;
                    case '}':
                        if (prevOpenBracket != '{') {
                            return false;
                        }
                        break;
                    case ')':
                        if (prevOpenBracket != '(') {
                            return false;
                        }
                        break;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.isValid("()"));
//        System.out.println(s.isValid("()[]{}"));
//        System.out.println(s.isValid("(]"));
//        System.out.println(s.isValid("]"));
//        System.out.println(s.isValid("(){}}{"));
        System.out.println(s.isValid("{}{{{(}){{}}{}}}"));
    }
}
