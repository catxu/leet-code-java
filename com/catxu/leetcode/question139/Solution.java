package com.catxu.leetcode.question139;

import java.util.*;

/**
 * 139. Word Break
 * <p>
 * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
 * <p>
 * Note that the same word in the dictionary may be reused multiple times in the segmentation.
 * <p>
 * Example 1:
 * <p>
 * Input: s = "leetcode", wordDict = ["leet","code"]
 * <p>
 * Output: true
 * <p>
 * Explanation: Return true because "leetcode" can be segmented as "leet code".
 * <p>
 * Example 2:
 * <p>
 * Input: s = "applepenapple", wordDict = ["apple","pen"]
 * <p>
 * Output: true
 * <p>
 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple". Note that you are allowed to reuse a dictionary word.
 * <p>
 * Example 3:
 * <p>
 * Input: s = "catsandog", wordDict = ["cats","dog","sand","and","cat"]
 * <p>
 * Output: false
 * <p>
 * Constraints:
 * <p>
 * 1 <= s.length <= 300
 * <p>
 * 1 <= wordDict.length <= 1000
 * <p>
 * 1 <= wordDict[i].length <= 20
 * <p>
 * s and wordDict[i] consist of only lowercase English letters.
 * <p>
 * All the strings of wordDict are unique.
 */
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        boolean[] visited = new boolean[s.length()];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while (!queue.isEmpty()) {
            int start = queue.poll();
            if (visited[start]) {
                continue;
            }
            visited[start] = true;
            for (int end = start + 1; end <= s.length(); end++) {
                if (dict.contains(s.substring(start, end))) {
                    if (end == s.length()) {
                        return true;
                    }
                    queue.offer(end);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
//        System.out.println(s.wordBreak("leetcode", Arrays.asList("leet", "code")));
//        System.out.println(s.wordBreak("applepenapple", Arrays.asList("apple", "pen")));
//        System.out.println(s.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat")));
        System.out.println(s.wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList("a", "aa", "aaa", "aaaa")));
    }
}
