package com.catxu.leetcode.question20;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

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
