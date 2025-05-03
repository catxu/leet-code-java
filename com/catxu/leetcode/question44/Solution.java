package com.catxu.leetcode.question44;

/**
 * 44. Wildcard Matching
 */
class Solution {

    // 使用 Integer 而不是 boolean，可以区分三种状态：null（未计算），1（true），0（false）
    private Integer[][] memo;
    private String s;
    private String p;

    public boolean isMatch(String s, String p) {
        this.s = s;
        this.p = p;
        this.memo = new Integer[s.length() + 1][p.length() + 1]; // i, j 最大为字符串长度，所以需要 + 1
        return doMatch(0, 0);
    }

    private boolean doMatch(int i, int j) {
        if (memo[i][j] != null) {
            return memo[i][j] == 1;
        }

        boolean ans;
        // 当 j == p.length() 时，表示模式串已经用完
        if (j == p.length()) {
            // 如果 s 也同时用完，则匹配成功
            ans = (i == s.length());
        } else {
            // 当前 p[j] 不是 '*'
            if (p.charAt(j) != '*') {
                // s 没用完，且当前字符匹配 (s[i] == p[j] or p[j] == '?')
                if (i < s.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                    // 递归匹配下一个状态
                    ans = doMatch(i + 1, j + 1);
                } else {
                    // 字符不匹配或者 s 已经用完
                    ans = false;
                }
            }
            // 当前 p[j] 是 '*'
            else {
                // '*' 匹配 0 个字符: 跳过 p 中的 '*'，s 指针 i 不动
                boolean matchZero = doMatch(i, j + 1);
                // '*' 匹配 1 个或多个字符:
                // 要求 s 还没用完， '*' 消耗 s[i]，然后 p 指针 j 不动 (继续用 '*' 匹配 s[i+1...])
                boolean matchOneOrMore = (i < s.length() && doMatch(i + 1, j));
                // 两种情况有一种成功即可
                ans = matchZero || matchOneOrMore;
            }
        }

        // 缓存结果
        memo[i][j] = ans ? 1 : 0;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isMatch("aa", "a"));
        System.out.println(new Solution().isMatch("a", "aa"));
        System.out.println(new Solution().isMatch("a", "a"));
        System.out.println(new Solution().isMatch("aa", "*"));
        System.out.println(new Solution().isMatch("cb", "?*?"));
        System.out.println(new Solution().isMatch("cb", "?****?***"));
        System.out.println(new Solution().isMatch("", ""));
    }
}
