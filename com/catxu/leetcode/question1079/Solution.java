package com.catxu.leetcode.question1079;

/**
 * 1079. Letter Tile Possibilities
 */
class Solution {
    private int ans = 0;

    public int numTilePossibilities(String tiles) {
        char[] s = tiles.toCharArray();
        int[] cnt = new int[26];
        for (char c : s) cnt[c - 'A']++;
        dfs(cnt);
        return ans;
    }

    private void dfs(int[] cnt) {
        for (int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 0) continue;
            cnt[i]--; // 选择当前字符，对应数量减1
            ans++; // 增加计数器，表示找到了一个新组合
            dfs(cnt);
            cnt[i]++;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numTilePossibilities("AAB"));
        System.out.println(new Solution().numTilePossibilities("AAABBC"));
    }
}
