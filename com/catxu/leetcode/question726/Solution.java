package com.catxu.leetcode.question726;

import java.util.Stack;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 726. Number of Atoms
 */
class Solution {
    public String countOfAtoms(String formula) {
        Matcher matcher = Pattern.compile("([A-Z][a-z]*)(\\d*)|(\\()|(\\))(\\d*)").matcher(formula);
        Stack<TreeMap<String, Integer>> stack = new Stack<>();
        stack.push(new TreeMap<>());
        while (matcher.find()) {
            String match = matcher.group();
            if (match.equals("(")) {
                stack.push(new TreeMap<>());
            } else if (match.startsWith(")")) {
                TreeMap<String, Integer> top = stack.pop();
                int multiplicity = match.length() > 1 ? Integer.parseInt(match.substring(1)) : 1;
                for (String name : top.keySet()) {
                    int originCnt = stack.peek().getOrDefault(name, 0);
                    stack.peek().put(name, originCnt + top.get(name) * multiplicity);
                }
            } else {
                int i = 1;
                while (i < match.length() && Character.isLowerCase(match.charAt(i))) {
                    i++;
                }
                String name = match.substring(0, i);
                int curCnt = i < match.length() ? Integer.parseInt(match.substring(i)) : 1;
                int originCnt = stack.peek().getOrDefault(name, 0);
                stack.peek().put(name, originCnt + curCnt);
            }
        }
        StringBuilder ans = new StringBuilder();
        TreeMap<String, Integer> top = stack.peek();
        for (String name : top.keySet()) {
            ans.append(name);
            int cnt = top.get(name);
            if (cnt > 1) ans.append(cnt);
        }
        return ans.toString();
    }
}
