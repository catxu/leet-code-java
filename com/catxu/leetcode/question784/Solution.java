package com.catxu.leetcode.question784;

import java.util.LinkedList;
import java.util.List;

/**
 * 784. Letter Case Permutation
 */
class Solution {

    public List<String> letterCasePermutationII(String S) {
        char[] s = S.toCharArray();
        dfs(0, s);
        return ans;
    }

    private void dfs(int start, char[] s) {
        if (start == s.length) {
            ans.add(new String(s));
            return;
        }
        char cur = s[start];
        if (Character.isDigit(cur)) dfs(start + 1, s);
        else {
            dfs(start + 1, s);
            char newCh;
            if (Character.isLowerCase(cur)) {
                newCh = Character.toUpperCase(cur);
            } else {
                newCh = Character.toLowerCase(cur);
            }
            s[start] = newCh;
            dfs(start + 1, s);
            s[start] = cur;
        }
    }

    List<String> ans = new LinkedList<>();

    public List<String> letterCasePermutation(String S) {
        char[] s = S.toCharArray();
        dfs(0, s.length, new StringBuilder(), s);
        return ans;
    }

    private void dfs(int start, int len, StringBuilder sb, char[] s) {
        if (start == len) {
            ans.add(sb.toString());
            return;
        }
        char c = s[start];
        sb.append(c);
        dfs(start + 1, len, sb, s);
        sb.deleteCharAt(sb.length() - 1);
        if (!Character.isDigit(c)) {
            char newCh;
            if (Character.isUpperCase(c)) {
                newCh = Character.toLowerCase(c);
            } else {
                newCh = Character.toUpperCase(c);
            }
            sb.append(newCh);
            dfs(start + 1, len, sb, s);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().letterCasePermutation("a1b2"));
        System.out.println(new Solution().letterCasePermutationII("a1b2"));
    }
}
