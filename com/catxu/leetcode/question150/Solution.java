package com.catxu.leetcode.question150;

import java.util.*;

/**
 * 150. Evaluate Reverse Polish Notation
 * <p>
 * You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.
 * <p>
 * Evaluate the expression. Return an integer that represents the value of the expression.
 * <p>
 * Note that:
 * <p>
 * The valid operators are '+', '-', '*', and '/'.
 * <p>
 * Each operand may be an integer or another expression.
 * <p>
 * The division between two integers always truncates toward zero.
 * <p>
 * There will not be any division by zero.
 * <p>
 * The input represents a valid arithmetic expression in a reverse polish notation.
 * <p>
 * The answer and all the intermediate calculations can be represented in a 32-bit integer.
 * <p>
 * Example 1:
 * <p>
 * Input: tokens = ["2","1","+","3","*"]
 * <p>
 * Output: 9
 * <p>
 * Explanation: ((2 + 1) * 3) = 9
 * <p>
 * Example 2:
 * <p>
 * Input: tokens = ["4","13","5","/","+"]
 * <p>
 * Output: 6
 * <p>
 * Explanation: (4 + (13 / 5)) = 6
 * <p>
 * Example 3:
 * <p>
 * Input: tokens = ["10","6","9","3","+","-11","*","/","*","17","+","5","+"]
 * <p>
 * Output: 22
 * <p>
 * Explanation: ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
 * <p>
 * = ((10 * (6 / (12 * -11))) + 17) + 5
 * <p>
 * = ((10 * (6 / -132)) + 17) + 5
 * <p>
 * = ((10 * 0) + 17) + 5
 * <p>
 * = (0 + 17) + 5
 * <p>
 * = 17 + 5
 * <p>
 * = 22
 * <p>
 * Constraints:
 * <p>
 * 1 <= tokens.length <= 10<sup>4</sup>
 * <p>
 * tokens[i] is either an operator: "+", "-", "*", or "/", or an integer in the range [-200, 200].
 */
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operator = Set.of("+", "-", "*", "/");
        for (String token : tokens) {
            if (operator.contains(token)) {
                int num1 = stack.pop();
                int num2 = stack.pop();
                switch (token) {
                    case "-" -> stack.push(num2 - num1);
                    case "+" -> stack.push(num2 + num1);
                    case "*" -> stack.push(num2 * num1);
                    case "/" -> stack.push(num2 / num1);
                }
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.evalRPN(new String[]{"2", "1", "+", "3", "*"}));
        System.out.println(s.evalRPN(new String[]{"4", "13", "5", "/", "+"}));
        System.out.println(s.evalRPN(new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"}));
    }
}