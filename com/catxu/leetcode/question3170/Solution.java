package com.catxu.leetcode.question3170;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 3170. Lexicographically Minimum String After Removing Stars
 */
class Solution {
    public String clearStars(String s) {
        List<Integer>[] stacks = new ArrayList[26];
        char[] S = s.toCharArray();
        int n = S.length;
        Arrays.setAll(stacks, e -> new ArrayList<>());
        // 贪心：从左往右，每次看到'*'，删掉左侧字典序最小且距离'*'最近的那个字母
        for (int i = 0; i < n; i++) {
            if (S[i] != '*') {
                stacks[S[i] - 'a'].add(i);
                continue;
            }
            for (i = 0; i < 26; i++) {
                if (!stacks[i].isEmpty()) {
                    S[stacks[i].removeLast()] = '*';
                    break;
                }
            }
        }
        int slow = 0;
        for (int f = 0; f < n; f++) {
            if (S[f] != '*') {
                S[slow++] = S[f];
            }
        }
        return new String(S, 0, slow);

//        String ans = new String(S);
//        ans = ans.replaceAll("\\*", "");
//        return ans;
    }
}
