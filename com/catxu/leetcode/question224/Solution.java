package com.catxu.leetcode.question224;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 224. Basic Calculator
 * <p>
 * Given a string s representing a valid expression, implement a basic calculator to evaluate it, and return the result of the evaluation.
 * <p>
 * Note: You are not allowed to use any built-in function which evaluates strings as mathematical expressions, such as eval().
 * <p>
 * Example 1:
 * <pre>
 * Input: s = "1 + 1"
 * Output: 2
 * </pre>
 * Example 2:
 * <pre>
 * Input: s = " 2-1 + 2 "
 * Output: 3
 * </pre>
 * Example 3:
 * <pre>
 * Input: s = "(1+(4+5+2)-3)+(6+8)"
 * Output: 23
 * </pre>
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 3 * 10<sup>5</sup>
 * <p>
 * s consists of digits, '+', '-', '(', ')', and ' '.
 * <p>
 * s represents a valid expression.
 * <p>
 * '+' is not used as a unary operation (i.e., "+1" and "+(2 + 3)" is invalid).
 * <p>
 * '-' could be used as a unary operation (i.e., "-1" and "-(2 + 3)" is valid).
 * <p>
 * There will be no two consecutive operators in the input.
 * <p>
 * Every number and running calculation will fit in a signed 32-bit integer.
 */
class Solution {

    public int calculate(String s) {
        s = s.replaceAll(" ", "");
        return evalRPN(infixToRPN(s));
    }

    private String infixToRPN(String infix) {
        StringBuilder rpn = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < infix.length(); i++) {
            char c = infix.charAt(i);

            if (Character.isDigit(c)) {
                rpn.append(c);
                while (i + 1 < infix.length() && Character.isDigit(infix.charAt(i + 1))) {
                    rpn.append(infix.charAt(++i));
                }
                rpn.append(" "); // Add space as a separator
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    rpn.append(stack.pop()).append(" ");
                }
                stack.pop(); // Pop the '('
            } else if (c == '+') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    rpn.append(stack.pop()).append(" ");
                }
                stack.push(c);
            } else if (c == '-') {
                if (i == 0 || infix.charAt(i - 1) == '(') {
                    rpn.append(0).append(" "); // Treat unary '-' as '0 -'
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    rpn.append(stack.pop()).append(" ");
                }
                stack.push(c);

            }
        }

        while (!stack.isEmpty()) {
            rpn.append(stack.pop()).append(" ");
        }

        return rpn.toString().trim();
    }

    private int evalRPN(String rpn) {
        Deque<Integer> stack = new ArrayDeque<>();
        String[] tokens = rpn.split("\\s+");

        for (String token : tokens) {
            if (token.matches("-?\\d+")) { // Check if it's a number
                stack.push(Integer.parseInt(token));
            } else {
                int operand2 = stack.pop();
                int operand1 = stack.pop();
                int result = 0;

                switch (token) {
                    case "+":
                        result = operand1 + operand2;
                        break;
                    case "-":
                        result = operand1 - operand2;
                        break;
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }


    public static void main(String[] args) {
        System.out.println(new Solution().calculate("(1+(4+5+2)-3)+(6+8)"));
        System.out.println(new Solution().calculate("-1-(2+3)+4"));
        System.out.println(new Solution().calculate("-1-(-2+3)+4"));
    }
}

