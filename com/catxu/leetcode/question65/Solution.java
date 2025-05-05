package com.catxu.leetcode.question65;

import java.util.Map;

/**
 * 65. Valid Number
 */
class Solution {
    public boolean isNumber(String s) {
        Automaton automaton = new Automaton();
        return automaton.verify(s);
    }

    static class Automaton {
        private String state = "start";
        // 0: sign
        // 1: number
        // 2: dot
        // 3: exponent
        boolean[] flag = new boolean[4];

        // DFA Deterministic finite automaton 确定有限状态机
        Map<String, String[]> table = Map.of(
                "start", new String[]{"sign", "number", "dot", "end", "end"},
                "sign", new String[]{"end", "number", "dot", "end", "end"},
                "number", new String[]{"end", "number", "dot", "exponent", "end"},
                "dot", new String[]{"end", "number", "end", "exponent", "end"},
                "exponent", new String[]{"sign", "number", "end", "end", "end"},
                "end", new String[]{"end", "end", "end", "end", "end"}
        );

        public boolean verify(String s) {
            for (int i = 0; i < s.length(); i++) {
                state = table.get(state)[getCol(s.charAt(i))];
                if (state.equals("end")) {
                    return false;
                }
                switch (state) {
                    case "sign":
                        if (flag[0]) return false;
                        flag[0] = true;
                        break;
                    case "number":
                        if (!flag[1] && (flag[2] && flag[3])) return false;
                        flag[1] = true;
                        break;
                    case "dot":
                        if (flag[2] || flag[3]) return false;
                        flag[2] = true;
                        break;
                    case "exponent":
                        if (flag[3]) return false;
                        flag[0] = false;
                        flag[3] = true;
                        break;
                    default:
                        break;
                }
            }
            return state.equals("dot") ? flag[1] : (!state.equals("exponent") && !state.equals("sign"));
        }

        private int getCol(char c) {
            if (c == '-' || c == '+') {
                return 0;
            } else if (c >= '0' && c <= '9') {
                return 1;
            } else if (c == '.') {
                return 2;
            } else if (c == 'e' || c == 'E') {
                return 3;
            } else {
                return 4;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isNumber("0089"));
        System.out.println(new Solution().isNumber("-0.1"));
        System.out.println(new Solution().isNumber("2"));
        System.out.println(new Solution().isNumber("+3.14"));
        System.out.println(new Solution().isNumber("4."));
        System.out.println(new Solution().isNumber("-.9"));
        System.out.println(new Solution().isNumber("2e10"));
        System.out.println(new Solution().isNumber("-90E3"));
        System.out.println(new Solution().isNumber("3e+7"));
        System.out.println(new Solution().isNumber("+6e-1"));
        System.out.println(new Solution().isNumber("53.5e93"));
        System.out.println(new Solution().isNumber("-123.456e789"));
        System.out.println(new Solution().isNumber("-1e-1"));
        System.out.println(new Solution().isNumber("1.e1"));


        System.out.println(new Solution().isNumber("a"));
        System.out.println(new Solution().isNumber("."));
        System.out.println(new Solution().isNumber(".e1"));
        System.out.println(new Solution().isNumber("1a"));
        System.out.println(new Solution().isNumber("1e"));
        System.out.println(new Solution().isNumber("-+3"));
        System.out.println(new Solution().isNumber("99e2.5"));
        System.out.println(new Solution().isNumber("-1e-")); //
        System.out.println(new Solution().isNumber("-1-"));
        System.out.println(new Solution().isNumber("95a54e53"));
    }
}
